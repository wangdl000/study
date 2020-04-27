CREATE OR REPLACE PROCEDURE ZSK0010B
/***********************************************
 *  �@�\�T�v�F���������A
 *  ����\��f�[�^�i���ߐ������j�̍쐬�������s���B
 *  �����P �@�F�����N���i���́j
 *  �����Q �@�F�����敪�i���́j
 *  �����R�@ �F�c�ƕ���R�[�h�i���́j
 *  �����S�@ �F�����R�[�h�i���́j
 *  �����T �@�F�����R�[�h�i���́j
 *  �����U �@�F�쐬�ҁi���́j
 *  �����V   �F�O���[�o�����.��������R�[�h
 *  �����W   �F�O���[�o�����.���[�U�R�[�h
 *  �����X �@�F�O���[�o�����.�v���O����ID
 *  �����P�O �F�O���[�o�����.�[����
 *  �����P�P �F�������ʁi0:����I���A1:�ُ�I���A2:�x���I���j
 *  �����P�Q �F�G���[���b�Z�[�W�i�o�́j
 *  �����P�R �F���ߍ��ݕ����i�o�́j
 **********************************************/
(
  I_SYORI_YM             IN    CHAR,
  I_SHIME_KBN            IN    NUMBER,
  I_EIGYO_BMN_CODE       IN    CHAR,
  I_TORI_CODE            IN    CHAR,
  I_TORI_MADO_CODE       IN    CHAR,
  I_CREATE_USR_CODE      IN    CHAR,
  I_G_BMN_CODE           IN    CHAR,
  I_G_USR_CODE           IN    CHAR,
  I_G_FUNC_ID            IN    CHAR,
  I_G_TERM_NAME          IN    VARCHAR2,
  --��������
  RETURN_CODE OUT CHAR,
  --�G���[���b�Z�[�W
  ERR_MSG_ID OUT VARCHAR2,
  --���ߍ��ݕ���
  ERR_MSG_CHR OUT VARCHAR2
) IS

  -- �ϐ��錾��

  WK_COL_SCHED_NO          CHAR(13);                                   -- ����\��ԍ�
  WK_COL_SHCED_M_NO        F_COL_SCHED_M.COL_SCHED_M_NO%TYPE;          -- ����\�薾�הԍ�
  WK_REC_SHEET_NO	         F_REC_SHEET_M.REC_SHEET_NO%TYPE;      -- �̎����ԍ� (FK)

  WK_SUM_AMOUNT            F_COL_SCHED_S_M.LINE_AMOUNT%TYPE;       -- ���z���v�l
  WK_SUM_AMOUNT_EN         F_COL_SCHED_S_M.LINE_AMOUNT%TYPE;       -- ���z���v�l�i�~�݂Ɍv�Z����j
  WK_AMOUNT                F_COL_SCHED_S_M.LINE_AMOUNT%TYPE;       -- ���z
  WK_CUR_CODE              V_URIAGE.CUR_CODE%TYPE;           --�ʉ݃R�[�h
  WK_JGYBNR_DAI_CODE       V_URIAGE.JGYBNR_DAI_CODE%TYPE;    --���Ƒ啪�ރR�[�h
  WK_JGYBNR_CHU_CODE       V_URIAGE.JGYBNR_CHU_CODE%TYPE;    --���ƒ����ރR�[�h
  
  WK_COL_DRAFT_YMD         F_COL_SCHED_S_M.COL_DRAFT_YMD%TYPE;         -- ����N�Z��
  WK_MNG_M_NO              NUMBER(3);                                  -- �Ǘ����הԍ�
  
  WK_BASE_YMD              DATE;                                       -- ���o���
  WK_SHORI_DATE            DATE;                                       -- ����.�����N���̈���.�����敪�̓��t�i�����敪��99�̏ꍇ�A�������j

  WK_SUM_JP_CONV_AMOUNT    NUMBER := 0;                                -- �M�݊��Z�z���v�l
  WK_JP_CONV_AMOUNT        NUMBER(11) := 0;                            -- �M�݊��Z�z
  WK_SEQUENCE_NO           F_COL_SCHED_S_H.MNG_NO%TYPE;                -- �I���N���V�[�P���X�ɂč̔Ԃ����Ǘ��ԍ�      
  WK_OLD_WK_CUR_CODE       V_URIAGE.CUR_CODE%TYPE;                      --�ʉ݃R�[�h��r�p

  WK_SYS_UNYO_YM1          CHAR(6);                                    -- �V�X�e���^�p�N��
  WK_KINSYU_KBN1           CHAR(1);                                    -- ����P
  WK_SCHED_YMD1            DATE;                                       --����E�x���\����P
  WK_YAK_AMOUNT1           NUMBER(13);                                 --���z�P
  WK_TGT_LIMIT_YMD1        DATE;                                       --��`�����P
  WK_KINSYU_KBN2           CHAR(1);                                    --����Q
  WK_SCHED_YMD2            DATE;                                       --����E�x���\����Q
  WK_YAK_AMOUNT2           NUMBER(13);                                 --���z�Q
  WK_TGT_LIMIT_YMD2        DATE;                                       --��`�����Q
  WK_SHIME_KBN             NUMBER;                                     --�����敪
  ERR_PARAM_NM             VARCHAR2(14);                               -- �ݒ肳��Ă��Ȃ�������
  NOWAIT_RESOURCE_LOCKED   EXCEPTION;                                  --�s���b�N�ُ�
  PRAGMA EXCEPTION_INIT(NOWAIT_RESOURCE_LOCKED, -54);
  ERR_CNT                  NUMBER;
  RETURN_CODE_REC_SHEET    CHAR;                                       --���s�ςݗ̎����̘_���폜��������
  --ADD BY DTT AT 2009/09/21 START
  SyoriResult             NUMBER;
  ERRLOGGER_EXCEPT        EXCEPTION;
  --ADD BY DTT AT 2009/09/21 END

--�����f�[�^�擾
CURSOR GET_M_TORI_BMN IS
  SELECT
    TORI_CODE,
    TORI_MADO_CODE,
    BMN_CODE
  FROM
    M_TORI_BMN
  WHERE
    (TORI_CODE LIKE NVL(I_TORI_CODE, '%')
     OR (TORI_CODE IS NULL AND I_TORI_CODE IS NULL))
    AND (TORI_MADO_CODE LIKE NVL(I_TORI_MADO_CODE, '%')
        OR (TORI_MADO_CODE IS NULL AND I_TORI_MADO_CODE IS NULL))
    AND BMN_CODE = I_EIGYO_BMN_CODE
    AND KS_SHIME_KBN = I_SHIME_KBN
    AND DELETE_FLG = '0'
    AND TORI_MADO_KBN1 = '1'
;
TYPE T_M_TORI_BMN IS TABLE OF GET_M_TORI_BMN%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_M_TORI_BMN_TBL T_M_TORI_BMN;
--�����f�[�^���R�[�h�z��̓Y����
N_M_TORI_BMN_IDX    INTEGER(10);
--�����f�[�^���R�[�h�̂P���R�[�h���G���A
R_M_TORI_BMN_TBL    GET_M_TORI_BMN%ROWTYPE;

--����\��f�[�^�擾
CURSOR GET_F_COL_SCHED(
  I_WK_TORI_CODE IN F_COL_SCHED_H.TOKUI_CODE%TYPE,
  I_WK_TORI_MADO_CODE IN F_COL_SCHED_H.TOKUI_MADO_CODE%TYPE
) IS
  SELECT
    F_COL_SCHED_H.SINSEICHU_FLG,
    F_COL_SCHED_H.COL_SCHED_ADD_NO,
    F_COL_SCHED_H.COL_SCHED_NO,
    F_COL_SCHED_H.BILL_FIX_FLG,
    F_COL_SCHED_M.REC_SHEET_ISSUE_KBN,
    F_COL_SCHED_M.COL_SCHED_M_NO
  FROM
    F_COL_SCHED_H
    INNER JOIN F_COL_SCHED_M
    ON F_COL_SCHED_M.COL_SCHED_NO = F_COL_SCHED_H.COL_SCHED_NO
    AND F_COL_SCHED_M.COL_SCHED_ADD_NO = F_COL_SCHED_H.COL_SCHED_ADD_NO
  WHERE
    F_COL_SCHED_H.SYORI_YM = I_SYORI_YM
    AND F_COL_SCHED_H.SHIME_KBN = I_SHIME_KBN
    AND F_COL_SCHED_H.EIGYO_BMN_CODE = I_EIGYO_BMN_CODE
    AND F_COL_SCHED_H.TOKUI_CODE = I_WK_TORI_CODE
    AND F_COL_SCHED_H.TOKUI_MADO_CODE = I_WK_TORI_MADO_CODE
    AND F_COL_SCHED_H.DELETE_FLG = '0'
    AND F_COL_SCHED_M.DELETE_FLG = '0'
FOR UPDATE NOWAIT;

TYPE T_F_COL_SCHED IS TABLE OF GET_F_COL_SCHED%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_F_COL_SCHED_TBL T_F_COL_SCHED;
--����\��f�[�^���R�[�h�z��̓Y����
N_F_COL_SCHED_IDX    INTEGER(10);
--����\��f�[�^���R�[�h�̂P���R�[�h���G���A
R_F_COL_SCHED_TBL    GET_F_COL_SCHED%ROWTYPE;

--�̎����ԍ��擾
CURSOR GET_REC_SHEET_NO
(
  I_WK_COL_SCHED_NO IN F_REC_SHEET_M.COL_SCHED_NO%TYPE,
  I_WK_COL_SHCED_M_NO IN F_REC_SHEET_M.COL_SCHED_M_NO%TYPE
) IS
  SELECT DISTINCT
    REC_SHEET_NO
  FROM
    F_REC_SHEET_M
  WHERE
    COL_SCHED_NO = I_WK_COL_SCHED_NO
    AND COL_SCHED_M_NO = I_WK_COL_SHCED_M_NO
    AND DELETE_FLG = '0'
;
--����f�[�^�̔�����z���v�l���擾����B
CURSOR GET_V_URIAGE_AMOUNT
(
  I_WK_TORI_CODE IN V_URIAGE.TORI_CODE%TYPE,
  I_WK_TORI_MADO_CODE IN V_URIAGE.TORI_MADO_CODE%TYPE
) IS
  SELECT
    CUR_CODE,           --�ʉ݃R�[�h
    JGYBNR_DAI_CODE,    --���Ƒ啪�ރR�[�h
    JGYBNR_CHU_CODE,    --���ƒ����ރR�[�h
    --���ʉ݃R�[�h���u�M�݁v�̏ꍇ�A����{�̋��z�i�~�݁j�{�������Ŋz�i�~�݁j���g�p�B
    --���ʉ݃R�[�h���u�M�݁v�ȊO�̏ꍇ�A����{�̋��z�i�O�݁j�{�������Ŋz�i�O�݁j���g�p�B
    DECODE(CUR_CODE, '01', NVL(SUM(URI_Y_AMOUNT), 0) + NVL(SUM(URI_Y_TAX), 0),
            NVL(SUM(URI_AMOUNT), 0) + NVL(SUM(URI_TAX), 0)) AS SUM_AMOUNT
  FROM
    V_URIAGE
  WHERE
    TORI_CODE = I_WK_TORI_CODE
    AND TORI_MADO_CODE = I_WK_TORI_MADO_CODE
    AND BMN_CODE = I_EIGYO_BMN_CODE
    AND TO_CHAR(URI_YMD, 'YYYYMMDD') <= TO_CHAR(WK_SHORI_DATE, 'YYYYMMDD')
  GROUP BY CUR_CODE,JGYBNR_DAI_CODE,JGYBNR_CHU_CODE
;

--����f�[�^�擾
CURSOR GET_V_URIAGE
(
  I_WK_TORI_CODE       IN V_URIAGE.TORI_CODE%TYPE,
  I_WK_TORI_MADO_CODE  IN V_URIAGE.TORI_MADO_CODE%TYPE,
  I_WK_CUR_CODE        IN V_URIAGE.CUR_CODE%TYPE,           --�ʉ݃R�[�h
  I_WK_JGYBNR_DAI_CODE IN V_URIAGE.JGYBNR_DAI_CODE%TYPE,    --���Ƒ啪�ރR�[�h
  I_WK_JGYBNR_CHU_CODE IN V_URIAGE.JGYBNR_CHU_CODE%TYPE     --���ƒ����ރR�[�h
) IS
  SELECT
    URI_NO,             --����ԍ�
    URI_ADD_NO,         --����ԍ��ǔ�
    BMN_CODE,           --����R�[�h
    TORI_CODE,          --�����R�[�h
    TORI_MADO_CODE,     --����摋���R�[�h
    JGYBNR_DAI_CODE,    --���Ƒ啪�ރR�[�h
    JGYBNR_CHU_CODE,    --���ƒ����ރR�[�h
    URI_YMD,            --�����
    CUR_CODE,           --�ʉ݃R�[�h
    KAWASE_RATE,        --�בփ��[�g
    CLAIM_NO,           --�N���[���Ǘ��ԍ�
    URI_Y_AMOUNT,       --����{�̋��z�i�~�݁j
    URI_Y_TAX,          --�������Ŋz�i�~�݁j
    URI_AMOUNT,         --����{�̋��z�i�O�݁j
    URI_TAX             --�������Ŋz�i�O�݁j
  FROM
    V_URIAGE
  WHERE
    TORI_CODE = I_WK_TORI_CODE
    AND TORI_MADO_CODE = I_WK_TORI_MADO_CODE
    AND BMN_CODE = I_EIGYO_BMN_CODE
    AND TO_CHAR(URI_YMD, 'YYYYMMDD') <= TO_CHAR(WK_SHORI_DATE, 'YYYYMMDD')
    AND CUR_CODE = I_WK_CUR_CODE
    AND JGYBNR_DAI_CODE = I_WK_JGYBNR_DAI_CODE
    AND JGYBNR_CHU_CODE = I_WK_JGYBNR_CHU_CODE
  --�ʉ݃R�[�h�A���Ƒ啪�ރR�[�h�A���ƒ����ރR�[�h�A����ԍ��A����ԍ��ǔԂ̏���
  ORDER BY CUR_CODE,JGYBNR_DAI_CODE,JGYBNR_CHU_CODE,URI_NO,URI_ADD_NO ASC
;
TYPE T_V_URIAGE IS TABLE OF GET_V_URIAGE%ROWTYPE
  INDEX BY BINARY_INTEGER;
--����\��f�[�^���R�[�h�z��̓Y����
N_V_URIAGE_IDX    INTEGER(10);

WK_V_URIAGE_TBL T_V_URIAGE;
--����f�[�^���R�[�h�̂P���R�[�h���G���A
R_V_URIAGE_TBL    GET_V_URIAGE%ROWTYPE;

/*********************************************************
* �@�\���́F����\��\���w�b�_�A����\��w�b�_�쐬����
* �����P  �F�I���N���V�[�P���X�ɂč̔Ԃ����ԍ��i���́j
* �����Q  �F����\��ԍ��i���́j
* �����R  �F���Ӑ�R�[�h�i���́j
* �����S  �F���Ӑ摋���R�[�h�i���́j
* �����T  �F�ʉ݃R�[�h�i���́j
* �����U  �F����R�[�h�i���́j
*********************************************************/
PROCEDURE SP_INS_H
(
  I_WK_SEQUENCE_NO    IN  F_COL_SCHED_S_H.MNG_NO%TYPE,
  I_WK_COL_SCHED_NO   IN  F_COL_SCHED_S_H.COL_SCHED_NO%TYPE,
  I_WK_TORI_CODE      IN  F_COL_SCHED_S_H.TOKUI_CODE%TYPE,
  I_WK_TORI_MADO_CODE IN  F_COL_SCHED_S_H.TOKUI_MADO_CODE%TYPE,
  I_WK_CUR_CODE       IN  F_COL_SCHED_S_H.CUR_CODE%TYPE,
  I_WK_BMN_CODE       IN  F_COL_SCHED_S_H.EIGYO_BMN_CODE%TYPE
)IS
BEGIN

  --����\��\���w�b�_�쐬����
  INSERT INTO F_COL_SCHED_S_H
    (
      MNG_NO,                  --�Ǘ��ԍ�
      SINSEI_NO,               --�\���ԍ�
      SINSEI_TYPE,             --�\�����
      SINSEI_SYORI_TYPE,       --�\���������
      SINSEI_KBN,              --�\���敪
      COL_SCHED_NO,            --����\��ԍ�
      COL_SCHED_ADD_NO,        --����\��ǔ�
      DENPYO_TYPE,             --�`�[���
      BIGIN_MNG_NO,            --�����Ǘ��ԍ�
      LATEST_FLG,              --�ŐV�t���O
      TOKUI_CODE,              --���Ӑ�R�[�h
      TOKUI_MADO_CODE,         --���Ӑ摋���R�[�h
      SYORI_YM,                --�����N��
      SHIME_KBN,               --�����敪
      CUR_CODE,                --�ʉ݃R�[�h
      SYORI_STAT_CODE,         --�����X�e�[�^�X
      SINSEI_BMN_CODE,         --�\������R�[�h
      SINSEI_USR_CODE,         --�\���҃R�[�h
      NEXT_SYORI_BMN_CODE,     --����������R�[�h
      NEXT_SYORI_USR_CODE,     --�������҃R�[�h
      BEF_SYORI_USR_CODE,      --�O�����҃R�[�h
      BILL_FIX_FLG,            --�����m��t���O
      SYORI_USR_CMNT,          --�����҃R�����g
      EIGYO_BMN_CODE,          --�c�ƕ���R�[�h
      MAKE_TIME,               --�쐬����
      MAKE_USR_CODE,           --�쐬���[�U�[�R�[�h
      UPDATE_TIME,             --�X�V����
      UPDATE_USR_CODE,         --�X�V���[�U�[�R�[�h
      DELETE_TIME,             --�폜����
      DELETE_USR_CODE,         --�폜���[�U�[�R�[�h
      DELETE_FLG               --�폜�t���O
    ) VALUES
    (
     I_WK_SEQUENCE_NO,         --�Ǘ��ԍ�
     '',                       --�\���ԍ�
     '',                       --�\�����
     '',                       --�\���������
     '',                       --�\���敪
     I_WK_COL_SCHED_NO,        --����\��ԍ� ���ʊ֐��ɂč̔�
     '00',                     --����\��ǔ�
     '40',                     --�`�[���(����\��ԍ�)
     I_WK_SEQUENCE_NO,         --�����Ǘ��ԍ�
     '1',                      --�ŐV�t���O�u�ŐV�v
     I_WK_TORI_CODE,           --���Ӑ�R�[�h
     I_WK_TORI_MADO_CODE,      --���Ӑ摋���R�[�h
     I_SYORI_YM,               --�����N��
     I_SHIME_KBN,              --�����敪
     I_WK_CUR_CODE,            --�ʉ݃R�[�h
     '04',                     --�����X�e�[�^�X�u�m��ρv
     I_G_BMN_CODE,             --�\������R�[�h �O���[�o�����  ��������R�[�h
     I_G_USR_CODE,        --�\���҃R�[�h  -- ���[�U�[�R�[�h 
     '',                       --����������R�[�h
     '',                       --�������҃R�[�h
     I_G_USR_CODE,        --�O�����҃R�[�h ���[�U�[�R�[�h
     '0',                      --�����m��t���O�u���m��v
     '',                       --�����҃R�����g
     I_WK_BMN_CODE,            --�c�ƕ���R�[�h ���⑫������2.1.�̎擾�l
     SYSTIMESTAMP,                  --�쐬����
     I_G_USR_CODE,        --�쐬���[�U�[�R�[�h �O���[�o����� ���[�U�[�R�[�h
     SYSTIMESTAMP,             --�X�V����
     I_G_USR_CODE,        --�X�V���[�U�[�R�[�h �O���[�o����񃆁[�U�[�R�[�h
     '',                       --�폜����
     '',                       --�폜���[�U�[�R�[�h
     '0'                       --�폜�t���O�u���폜�v
      );

  --����\��w�b�_�쐬����
  INSERT INTO F_COL_SCHED_H
    (
      COL_SCHED_NO,            --����\��ԍ�
      COL_SCHED_ADD_NO,        --����\��ǔ�
      DENPYO_TYPE,             --�`�[���
      SYORI_KBN,               --�����敪
      SINSEICHU_FLG,           --�\�����t���O
      BILL_FIX_FLG,            --�����m��t���O
      TOKUI_CODE,              --���Ӑ�R�[�h
      TOKUI_MADO_CODE,         --���Ӑ摋���R�[�h
      EIGYO_BMN_CODE,          --�c�ƕ���R�[�h
      SYORI_YM,                --�����N��
      SHIME_KBN,               --�����敪
      CUR_CODE,                --�ʉ݃R�[�h
      MAKE_TIME,               --�쐬����
      MAKE_USR_CODE,           --�쐬���[�U�[�R�[�h
      UPDATE_TIME,             --�X�V����
      UPDATE_USR_CODE,         --�X�V���[�U�[�R�[�h
      DELETE_TIME,             --�폜����
      DELETE_USR_CODE,         --�폜���[�U�[�R�[�h
      DELETE_FLG               --�폜�t���O
    ) VALUES
    (
      I_WK_COL_SCHED_NO,       --����\��ԍ�  ���ʊ֐��ɂč̔�
      '00',                    --����\��ǔ�
      '40',                    --�`�[��ʁu����\��v
      '0',                     --�����敪�u�V�K�v
      '0',                     --�\�����t���O�u��\�����v
      '1',                     --�����m��t���O�u�m��ρv
      I_WK_TORI_CODE,          --���Ӑ�R�[�h
      I_WK_TORI_MADO_CODE,     --���Ӑ摋���R�[�h
      I_WK_BMN_CODE,           --�c�ƕ���R�[�h
      WK_SYS_UNYO_YM1,         --�����N�� �V�X�e���^�p�N��
      I_SHIME_KBN,             --�����敪
      I_WK_CUR_CODE,           --�ʉ݃R�[�h
      SYSTIMESTAMP,            --�쐬����
      I_G_USR_CODE,            --�쐬���[�U�[�R�[�h ���[�U�[�R�[�h 
      SYSTIMESTAMP,            --�X�V����
      I_G_USR_CODE,            --�X�V���[�U�[�R�[�h ���[�U�[�R�[�h 
      '',                      --�폜����
      '',                      --�폜���[�U�[�R�[�h
      '0'                      --�폜�t���O�u��폜�v
    );     

END SP_INS_H;

/******************************************************************
*** �@�\���́F�Ǘ����הԍ��擾����(�Ǘ��ԍ��ɂ�����A1����̘A��)
******************************************************************/
PROCEDURE SP_GET_RENBN
(
  I_WK_MNG_NO   IN  F_COL_SCHED_S_M.MNG_NO%TYPE,
  WK_MNG_M_NO   OUT F_COL_SCHED_S_M.MNG_M_NO%TYPE
)IS
BEGIN
  SELECT
    TO_NUMBER(NVL(MAX(MNG_M_NO), 0))
  INTO WK_MNG_M_NO
  FROM
    F_COL_SCHED_S_M
  WHERE
    MNG_NO = I_WK_MNG_NO;
  WK_MNG_M_NO := WK_MNG_M_NO + 1;
END SP_GET_RENBN;


/**********************************************************
*** �@�\���́F����\��\�����ׁA����\�薾�׍쐬����
* �����P  �F�I���N���V�[�P���X�ɂč̔Ԃ����ԍ��i���́j
* �����Q  �F����\��ԍ�(����ԍ�)�i���́j
* �����R  �F����\�薾�הԍ�(����ԍ��ǔ�)�i���́j
* �����S  �F�Ǘ����הԍ��i���́j
* �����T  �F����i���́j
* �����U  �F����E�x���\����i���́j
* �����V  �F���z�i���́j
* �����W  �F��`�����i���́j
* �����X  �F����N�Z���i�o�́j
* �����P�O�F�M�݊��Z�z�i�o�́j
* �����P�P�F����f�[�^���R�[�h�̂P���R�[�h���G���A�i�o�́j
**********************************************************/
PROCEDURE SP_INS_M
(
  I_WK_SEQUENCE_NO        IN  F_COL_SCHED_S_M.MNG_NO%TYPE,
  I_WK_COL_SCHED_NO       IN  F_COL_SCHED_S_M.COL_SCHED_NO%TYPE,
  I_WK_COL_SHCED_M_NO     IN  F_COL_SCHED_S_M.COL_SCHED_M_NO%TYPE,
  I_WK_MNG_M_NO           IN  F_COL_SCHED_S_M.MNG_M_NO%TYPE,
  I_WK_KINSYU_KBN         IN  F_COL_SCHED_S_M.KINSYU_KBN%TYPE,
  I_WK_SCHED_YMD          IN  F_COL_SCHED_S_M.COL_SCHED_YMD%TYPE,
  I_WK_YAK_AMOUNT         IN  F_COL_SCHED_S_M.LINE_AMOUNT%TYPE,
  I_WK_TGT_LIMIT_YMD      IN  F_COL_SCHED_S_M.TGT_LIMIT_YMD%TYPE,
  I_WK_COL_DRAFT_YMD      IN  F_COL_SCHED_S_M.COL_DRAFT_YMD%TYPE,
  I_WK_JP_CONV_AMOUNT     IN  F_COL_SCHED_S_M.JP_CONV_AMOUNT%TYPE,
  
  R_V_URIAGE_TBL          IN  GET_V_URIAGE%ROWTYPE
) IS
BEGIN
   
  --���׋��z�ݒ�l�~�בփ��[�g�̏������؎̂�
  --���ו����o�^���ɍ��v�z��������z�i�~�݁j�ƈ�v���Ȃ��ꍇ�́A���z���P�ڂ̖��ׂɉ��Z����B
  INSERT INTO F_COL_SCHED_S_M 
  (
      MNG_NO,                  --�Ǘ��ԍ�
      MNG_M_NO,                --�Ǘ����הԍ�
      INIT_MNG_NO,             --�����Ǘ��ԍ�
      INIT_MNG_M_NO,           --�����Ǘ����הԍ�
      COL_SCHED_NO,            --����\��ԍ�
      COL_SCHED_ADD_NO,        --����\��ǔ�
      COL_SCHED_M_NO,          --����\�薾�הԍ�
      COL_SCHED_YMD,           --����\���
      KINSYU_KBN,              --����
      LINE_AMOUNT,             --���׋��z
      CUR_CODE,                --�ʉ݃R�[�h
      RATE,                    --���[�g
      JP_CONV_AMOUNT,          --�M�݊��Z�z
      CLAIM_NO,                --�N���[���ԍ�
      COL_DRAFT_YMD,           --����N�Z��
      TGT_LIMIT_YMD,           --��`����
      KOJI_NO,                 --�H���ԍ�
      KOJI_SUB_NO,             --�H���ԍ��}��
      RMKS,                    --���l
      HOLD_FLG,                --�ۗ��t���O
      COL_KBN,                 --����敪
      ORIG_DENPYO_TYPE,        --�������`�[���
      ORIG_DENPYO_NO,          --�������`�[�ԍ�
      ORIG_DENPYO_ADD_NO,      --�������`�[�ǔ�
      ORIG_DENPYO_ADD_KEY,     --�������`�[�ǉ��L�[
      JGYBNR_DAI_CODE,         --���Ƒ啪�ރR�[�h
      JGYBNR_CHU_CODE,         --���ƒ����ރR�[�h
      EXAMINE_CONTACT_FLG,     --�R�����A���t���O
      MAKE_TIME,               --�쐬����
      MAKE_USR_CODE,           --�쐬���[�U�[�R�[�h
      UPDATE_TIME,             --�X�V����
      UPDATE_USR_CODE,         --�X�V���[�U�[�R�[�h
      DELETE_TIME,             --�폜����
      DELETE_USR_CODE,         --�폜���[�U�[�R�[�h
      DELETE_FLG               --�폜�t���O    
    ) VALUES
    (
      I_WK_SEQUENCE_NO,        --�Ǘ��ԍ�
      I_WK_MNG_M_NO,           --�Ǘ����הԍ�
      I_WK_SEQUENCE_NO,        --�����Ǘ��ԍ� �Ǘ��ԍ��Ɠ��l
      I_WK_MNG_M_NO,           --�����Ǘ����הԍ�  �Ǘ����הԍ��Ɠ��l
      I_WK_COL_SCHED_NO,       --����\��ԍ� ���ʊ֐��ɂč̔�
      '00',                    --����\��ǔ�
      I_WK_COL_SHCED_M_NO,     --����\�薾�הԍ�  "001"����̘A��
      I_WK_SCHED_YMD,          --����\��� ����E�x���\����P�C�Q 
      I_WK_KINSYU_KBN,           --���� ����P�C�Q
      I_WK_YAK_AMOUNT,           --���׋��z ������z�P�C�Q
      R_V_URIAGE_TBL.CUR_CODE,   --�ʉ݃R�[�h
      R_V_URIAGE_TBL.KAWASE_RATE, --���[�g
      I_WK_JP_CONV_AMOUNT,       --�M�݊��Z�z
      R_V_URIAGE_TBL.CLAIM_NO,   --�N���[���ԍ�
      I_WK_COL_DRAFT_YMD,        --����N�Z��
      I_WK_TGT_LIMIT_YMD,        --��`����
      '',                        --�H���ԍ�
      '',                        --�H���ԍ��}��
      '',                        --���l
      '0',                       --�ۗ��t���O �u�ۗ��Ȃ��v
      '01',                      --����敪�u����v
      '13',                      --�������`�[��ʁu����v
      R_V_URIAGE_TBL.URI_NO,     --�������`�[�ԍ�
      R_V_URIAGE_TBL.URI_ADD_NO, --�������`�[�ǔ�
      '',                        --�������`�[�ǉ��L�[
      R_V_URIAGE_TBL.JGYBNR_DAI_CODE,        --���Ƒ啪�ރR�[�h
      R_V_URIAGE_TBL.JGYBNR_CHU_CODE,        --���ƒ����ރR�[�h
      '0',                       --�R�����A���t���O�u��Ώہv
      SYSTIMESTAMP,              --�쐬����
      I_G_USR_CODE,              --�쐬���[�U�[�R�[�h �O���[�o�����
      SYSTIMESTAMP,              --�X�V����
      I_G_USR_CODE,              --�X�V���[�U�[�R�[�h �O���[�o�����
      '',                        --�폜����
      '',                        --�폜���[�U�[�R�[�h
      '0'                        --�폜�t���O �Œ�l�u���폜�v
    );

  --����\�薾�׍쐬
  INSERT INTO F_COL_SCHED_M
   (
      COL_SCHED_NO,               --����\��ԍ�
      COL_SCHED_ADD_NO,           --����\��ǔ�
      COL_SCHED_M_NO,             --����\�薾�הԍ�  "001"����̘A��
      SYORI_KBN,                  --�����敪
      COL_SCHED_YMD,              --����\��� ����E�x���\����P�C�Q
      KINSYU_KBN,                 --����
      LINE_AMOUNT,                --���׋��z
      CUR_CODE,                   --�ʉ݃R�[�h
      RATE,                       --���[�g
      JP_CONV_AMOUNT,             --�M�݊��Z�z
      COLTD_AMOUNT,               --����ϋ��z
      PRE_REC_USE_AMOUNT,         --�O����g�p�z
      CLAIM_NO,                   --�N���[���ԍ�
      COL_COMP_FLG,               --��������t���O
      COL_COMP_YMD,               --���������
      COL_DRAFT_YMD,              --����N�Z��
      TGT_LIMIT_YMD,              --��`����
      JGYBNR_DAI_CODE,            --���Ƒ啪�ރR�[�h
      JGYBNR_CHU_CODE,            --���ƒ����ރR�[�h
      COL_KBN,                    --����敪
      ORIG_DENPYO_TYPE,           --�������`�[���
      ORIG_DENPYO_NO,             --�������`�[�ԍ�
      ORIG_DENPYO_ADD_NO,         --�������`�[�ǔ�
      ORIG_DENPYO_ADD_KEY,        --�������`�[�ǉ��L�[
      KOJI_NO,                    --�H���ԍ�
      KOJI_SUB_NO,                --�H���ԍ��}��
      RMKS,                       --���l
      REC_SHEET_ISSUE_KBN,        --�̎������s�敪
      HOLD_FLG,                   --�ۗ��t���O
      EXAMINE_CONTACT_FLG,        --�R�����A���t���O
      MAKE_TIME,                  --�쐬����
      MAKE_USR_CODE,              --�쐬���[�U�[�R�[�h
      UPDATE_TIME,                --�X�V����
      UPDATE_USR_CODE,            --�X�V���[�U�[�R�[�h
      DELETE_TIME,                --�폜����
      DELETE_USR_CODE,            --�폜���[�U�[�R�[�h
      DELETE_FLG                  --�폜�t���O
    ) VALUES
    (
      I_WK_COL_SCHED_NO,          --����\��ԍ�  ���ʊ֐��ɂč̔�
      '00',                       --����\��ǔ�
      I_WK_COL_SHCED_M_NO,        --����\�薾�הԍ�
      '0',                        --�����敪�u�V�K�v
      I_WK_SCHED_YMD,             --����\��� ����E�x���\����P�C�Q
      I_WK_KINSYU_KBN,            --����
      I_WK_YAK_AMOUNT,            --���׋��z
      R_V_URIAGE_TBL.CUR_CODE,    --�ʉ݃R�[�h
      R_V_URIAGE_TBL.KAWASE_RATE, --���[�g
      I_WK_JP_CONV_AMOUNT,        --�M�݊��Z�z
      -- wang-dangl
      I_WK_YAK_AMOUNT,            --����ϋ��z ���׋��z
      I_WK_YAK_AMOUNT,            --�O����g�p�z ���׋��z
      --wang-dangl
      R_V_URIAGE_TBL.CLAIM_NO,    --�N���[���ԍ�
      '0',                        --��������t���O
      '',                         --���������
      I_WK_COL_DRAFT_YMD,           --����N�Z��
      I_WK_TGT_LIMIT_YMD,           --��`����
      R_V_URIAGE_TBL.JGYBNR_DAI_CODE,         --���Ƒ啪�ރR�[�h
      R_V_URIAGE_TBL.JGYBNR_CHU_CODE,         --���ƒ����ރR�[�h
      '01',                       --����敪�u����v
      '13',                       --�������`�[��ʁu����v
      R_V_URIAGE_TBL.URI_NO,      --�������`�[�ԍ�
      R_V_URIAGE_TBL.URI_ADD_NO,  --�������`�[�ǔ�
      '',                         --�������`�[�ǉ��L�[
      '',                         --�H���ԍ�
      '',                         --�H���ԍ��}��
      '',                         --���l
      '',                         --�̎������s�敪
      '0',                        --�ۗ��t���O
      '0',                        --�R�����A���t���O
      SYSTIMESTAMP,               --�쐬����
      I_G_USR_CODE,               --�쐬���[�U�[�R�[�h ���[�U�[�R�[�h 
      SYSTIMESTAMP,               --�X�V����
      I_G_USR_CODE,               --�X�V���[�U�[�R�[�h ���[�U�[�R�[�h 
      '',                         --�폜����
      '',                         --�폜���[�U�[�R�[�h
      '0'                         --�폜�t���O�u��폜�v
    );

END SP_INS_M;

/**********************************************************
*** �@�\���́F����f�[�^�擾����
**********************************************************/
PROCEDURE SP_GET_V_URIAGE
(
  R_M_TORI_BMN_TBL IN GET_M_TORI_BMN%ROWTYPE,
  RETURN_CODE          IN OUT CHAR

) IS
BEGIN
  --���o���
  WK_BASE_YMD := WK_SHORI_DATE;
  --����N�Z��
  WK_COL_DRAFT_YMD := WK_SHORI_DATE;
  
  OPEN GET_V_URIAGE_AMOUNT(R_M_TORI_BMN_TBL.TORI_CODE, R_M_TORI_BMN_TBL.TORI_MADO_CODE);
  IF GET_V_URIAGE_AMOUNT%NOTFOUND THEN
    RETURN;
  END IF;
  --����f�[�^�̃��R�[�h�����A�J��Ԃ�
  LOOP
    --����\��f�[�^�̃��R�[�h�����A�J��Ԃ�
    FETCH GET_V_URIAGE_AMOUNT INTO 
      WK_CUR_CODE,           --�ʉ݃R�[�h
      WK_JGYBNR_DAI_CODE,    --���Ƒ啪�ރR�[�h
      WK_JGYBNR_CHU_CODE,    --���ƒ����ރR�[�h
      WK_SUM_AMOUNT          --������z���v�l
    ;
    --�ŏI���R�[�h�̏ꍇ�I��
    EXIT WHEN GET_V_URIAGE_AMOUNT%NOTFOUND;
    
    --�����擾 _S        
    BEGIN
      --��蓱�o�������s��
      ZSK0060B(
        R_M_TORI_BMN_TBL.TORI_CODE,                   --�����R�[�h
        R_M_TORI_BMN_TBL.TORI_MADO_CODE,              --�����R�[�h
        R_M_TORI_BMN_TBL.BMN_CODE,                    --����R�[�h
        '1',                              --����敪"1"
        WK_JGYBNR_DAI_CODE,               --���Ƒ啪�ރR�[�h
        WK_JGYBNR_CHU_CODE,               --���ƒ����ރR�[�h
        '',                               --���|�R�[�h  ""
        '1',                              --����E�x���敪"1"
        WK_BASE_YMD,                      --���o���
        WK_CUR_CODE,                      --�ʉ݃R�[�h
        WK_SUM_AMOUNT,                    --���z
        I_G_USR_CODE,                     --�O���[�o�����.���[�U�R�[�h
        I_G_TERM_NAME,                    --�O���[�o�����.�[����
        I_G_FUNC_ID,                      --�O���[�o�����.�v���O����ID
              
        RETURN_CODE,                      --��������
        ERR_MSG_ID,                       --�G���[���b�Z�[�W
        ERR_MSG_CHR,                      --���ߍ��ݕ���
        WK_SHIME_KBN,                     --�����敪
        WK_KINSYU_KBN1,                   --����P
        WK_SCHED_YMD1,                    --����E�x���\����P
        WK_YAK_AMOUNT1,                   --���z�P
        WK_TGT_LIMIT_YMD1,                --��`�����P
                    
        WK_KINSYU_KBN2,                   --����Q
        WK_SCHED_YMD2,                    --����E�x���\����Q
        WK_YAK_AMOUNT2,                   --���z�Q
        WK_TGT_LIMIT_YMD2                 --��`�����Q
      );
      IF RETURN_CODE = '1' THEN
          RETURN_CODE := '1';
          ERR_MSG_ID := ERR_MSG_ID;
          ERR_MSG_CHR := ERR_MSG_CHR;
          RETURN;
      END IF;
      EXCEPTION
        WHEN OTHERS THEN
          RETURN_CODE := '1';
          ERR_MSG_ID := ERR_MSG_ID;
          ERR_MSG_CHR := ERR_MSG_CHR;
          RETURN;
    END;
    --�����擾 _E
    IF NVL(WK_YAK_AMOUNT1, 0) <= 0 AND NVL(WK_YAK_AMOUNT2, 0) <= 0 THEN
      RETURN;
    END IF;
    WK_V_URIAGE_TBL.DELETE;
    N_V_URIAGE_IDX := 1;
   --4.1  2.�Ŏ擾�����f�[�^���ɔ���f�[�^�i����r���[�j�ɂăf�[�^���擾����B
    OPEN GET_V_URIAGE(R_M_TORI_BMN_TBL.TORI_CODE,
                      R_M_TORI_BMN_TBL.TORI_MADO_CODE,
                      WK_CUR_CODE,           --�ʉ݃R�[�h
                      WK_JGYBNR_DAI_CODE,    --���Ƒ啪�ރR�[�h
                      WK_JGYBNR_CHU_CODE    --���ƒ����ރR�[�h
    );    
    --����f�[�^�̃��R�[�h�����A�J��Ԃ�
    LOOP
      --����\��f�[�^�̃��R�[�h�����A�J��Ԃ�
      FETCH GET_V_URIAGE INTO WK_V_URIAGE_TBL(N_V_URIAGE_IDX);
      --�ŏI���R�[�h�̏ꍇ�I��
      EXIT WHEN GET_V_URIAGE%NOTFOUND;
      N_V_URIAGE_IDX := N_V_URIAGE_IDX + 1;
    END LOOP;  
    --�J�[�\���N���[�Y
    CLOSE GET_V_URIAGE;

    --�ʉ݃R�[�h��r�p
    WK_OLD_WK_CUR_CODE := '';
    --����\��\������.����\�薾�הԍ�(������)
    WK_COL_SHCED_M_NO := '000';

    --���ʊ֐��ɂč̔Ԃŉ���\��ԍ����擾����B
    --UPDATE BY DTT AT 2009/09/21 START
    --P_KK_GETDENNO('13',  --�`�[��ʁu����v
    --              I_EIGYO_BMN_CODE,  --����R�[�h
    --              SUBSTR(WK_SYS_UNYO_YM1, 1, 4), --�N�x
    --              NVL(I_G_USR_CODE, '999999'),    --���[�U�[�R�[�h(�ȗ��������l:999999)
    --              I_G_FUNC_ID,
    --              I_G_TERM_NAME,
    --              WK_COL_SCHED_NO);
    WK_COL_SCHED_NO := P_KK_GETDENNO('13',  --�`�[��ʁu����v
                  I_EIGYO_BMN_CODE,  --����R�[�h
                  SUBSTR(WK_SYS_UNYO_YM1, 1, 4), --�N�x
                  NVL(I_G_USR_CODE, '999999'),    --���[�U�[�R�[�h(�ȗ��������l:999999)
                  I_G_TERM_NAME);
    --UPDATE BY DTT AT 2009/09/21 END
    
    IF WK_COL_SCHED_NO = '-1' OR WK_COL_SCHED_NO = '-2'
      OR WK_COL_SCHED_NO = '-3' OR WK_COL_SCHED_NO = '-8' OR WK_COL_SCHED_NO = '-9' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '�V�X�e���G���[���������܂����B';
      RETURN;
    END IF;
    
    WK_SUM_JP_CONV_AMOUNT := 0;
    WK_SUM_AMOUNT_EN := 0;
    FOR PAT_IDX IN 1 .. WK_V_URIAGE_TBL.COUNT LOOP
      R_V_URIAGE_TBL := WK_V_URIAGE_TBL(PAT_IDX);
            
      --����\��\���w�b�_�i�o�^�j�A����\��w�b�_�i�o�^�j-S
      IF WK_OLD_WK_CUR_CODE <> R_V_URIAGE_TBL.CUR_CODE THEN
        --�ʉ݃R�[�h
        WK_OLD_WK_CUR_CODE := R_V_URIAGE_TBL.CUR_CODE;

        --�I���N���V�[�P���X�ɂč̔Ԃ��A�ԍ����擾����B
        SELECT S_SK_COLSCHED_S_MNG_NO.NEXTVAL INTO WK_SEQUENCE_NO FROM DUAL;
        
        --����̒ʉ݃R�[�h�ɂ����ẮA����\��\���w�b�_�A����\��w�b�_�͂P���R�[�h�̂ݓo�^����B
        --����\��\���w�b�_�i�o�^�j�A����\��w�b�_�i�o�^�j
        SP_INS_H(WK_SEQUENCE_NO,
                 WK_COL_SCHED_NO,
                 R_M_TORI_BMN_TBL.TORI_CODE,
                 R_M_TORI_BMN_TBL.TORI_MADO_CODE,
                 R_V_URIAGE_TBL.CUR_CODE,
                 R_M_TORI_BMN_TBL.BMN_CODE);
      END IF;
      --����\��\���w�b�_�i�o�^�j�A����\��w�b�_�i�o�^�j-E

      --����\��\�����ׁi�o�^�j�A����\�薾�ׁi�o�^�j-S
      BEGIN
        -- ���z���擾����B 
        WK_AMOUNT := 0;
        IF R_V_URIAGE_TBL.CUR_CODE = '01' THEN
          --���ʉ݃R�[�h���u�M�݁v�̏ꍇ�A����{�̋��z�i�~�݁j�{�������Ŋz�i�~�݁j���g�p�B
          WK_AMOUNT := NVL(R_V_URIAGE_TBL.URI_Y_AMOUNT, 0) + NVL(R_V_URIAGE_TBL.URI_Y_TAX, 0);
          WK_SUM_AMOUNT_EN := WK_SUM_AMOUNT_EN + WK_AMOUNT;
        ELSE
          --���ʉ݃R�[�h���u�M�݁v�ȊO�̏ꍇ�A����{�̋��z�i�O�݁j�{�������Ŋz�i�O�݁j���g�p�B
          WK_AMOUNT := NVL(R_V_URIAGE_TBL.URI_AMOUNT, 0) + NVL(R_V_URIAGE_TBL.URI_TAX, 0);
          WK_SUM_AMOUNT_EN := WK_SUM_AMOUNT_EN + WK_AMOUNT * R_V_URIAGE_TBL.KAWASE_RATE;
        END IF;
        
        IF NVL(WK_YAK_AMOUNT1, 0) = 0 THEN
          IF NVL(WK_YAK_AMOUNT2, 0) > 0 THEN
            -- �Ǘ��ԍ��ɂ�����A1����̘A�ԏ���
            SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);        
            --����\��\������.����\�薾�הԍ�( "001"����̘A��)
            WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');           
            --�M�݊��Z�z���v�Z����B
            WK_JP_CONV_AMOUNT := TRUNC(NVL(WK_AMOUNT, 0) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
            WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;      
            --����\��\�����ׁi�o�^�j�A����\�薾�ׁi�o�^�j
            SP_INS_M(WK_SEQUENCE_NO,
                     WK_COL_SCHED_NO,
                     WK_COL_SHCED_M_NO,
                     WK_MNG_M_NO,
                     WK_KINSYU_KBN2,             --����Q
                     WK_SCHED_YMD2,              --����E�x���\����Q
                     NVL(WK_AMOUNT, 0),          --���z�Q
                     WK_TGT_LIMIT_YMD2,          --��`�����Q
                     WK_COL_DRAFT_YMD,           --����N�Z��
                     WK_JP_CONV_AMOUNT,          --�M�݊��Z�z
                     R_V_URIAGE_TBL              -- ����f�[�^���R�[�h�̂P���R�[�h���G���A
                     );

          END IF;
        ELSE
          IF NVL(WK_YAK_AMOUNT1, 0) < NVL(WK_AMOUNT, 0) THEN          
            -- �Ǘ��ԍ��ɂ�����A1����̘A�ԏ���
            SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);         
            --����\��\������.����\�薾�הԍ�( "001"����̘A��)
            WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');          
            --�M�݊��Z�z���v�Z����B
            WK_JP_CONV_AMOUNT := TRUNC(NVL(WK_YAK_AMOUNT1, 0) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
            WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;
            
            --����\��\�����ׁi�o�^�j�A����\�薾�ׁi�o�^�j
            SP_INS_M(WK_SEQUENCE_NO,
                     WK_COL_SCHED_NO,
                     WK_COL_SHCED_M_NO,
                     WK_MNG_M_NO,
                     WK_KINSYU_KBN1,             --����P
                     WK_SCHED_YMD1,              --����E�x���\����P
                     NVL(WK_YAK_AMOUNT1, 0),     --���z�P
                     WK_TGT_LIMIT_YMD1,          --��`�����P
                     WK_COL_DRAFT_YMD,           --����N�Z��
                     WK_JP_CONV_AMOUNT,          --�M�݊��Z�z
                     R_V_URIAGE_TBL              -- ����f�[�^���R�[�h�̂P���R�[�h���G���A
                     );
            IF NVL(WK_YAK_AMOUNT2, 0) > 0 THEN
              -- �Ǘ��ԍ��ɂ�����A1����̘A�ԏ���
              SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);        
               --����\��\������.����\�薾�הԍ�( "001"����̘A��)
               WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');           
              --�M�݊��Z�z���v�Z����B
              WK_JP_CONV_AMOUNT := TRUNC((NVL(WK_AMOUNT, 0) - NVL(WK_YAK_AMOUNT1, 0)) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
              WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;      
              --����\��\�����ׁi�o�^�j�A����\�薾�ׁi�o�^�j
              SP_INS_M(WK_SEQUENCE_NO,
                       WK_COL_SCHED_NO,
                       WK_COL_SHCED_M_NO,
                       WK_MNG_M_NO,
                       WK_KINSYU_KBN2,             --����Q
                       WK_SCHED_YMD2,              --����E�x���\����Q
                       NVL(WK_AMOUNT, 0) - NVL(WK_YAK_AMOUNT1, 0),             --���z�Q
                       WK_TGT_LIMIT_YMD2,          --��`�����Q
                       WK_COL_DRAFT_YMD,           --����N�Z��
                       WK_JP_CONV_AMOUNT,          --�M�݊��Z�z
                       R_V_URIAGE_TBL              -- ����f�[�^���R�[�h�̂P���R�[�h���G���A
                       );
            END IF;
            WK_YAK_AMOUNT1 :=  NVL(WK_AMOUNT, 0) - NVL(WK_YAK_AMOUNT1, 0);                    
          ELSE
            IF NVL(WK_YAK_AMOUNT1, 0) > NVL(WK_AMOUNT, 0) THEN
              -- �Ǘ��ԍ��ɂ�����A1����̘A�ԏ���
              SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);           
              --����\��\������.����\�薾�הԍ�( "001"����̘A��)
              WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');            
              --�M�݊��Z�z���v�Z����B
              WK_JP_CONV_AMOUNT := TRUNC(NVL(WK_AMOUNT, 0) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
              WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;
              
              --����\��\�����ׁi�o�^�j�A����\�薾�ׁi�o�^�j
              SP_INS_M(WK_SEQUENCE_NO,
                       WK_COL_SCHED_NO,
                       WK_COL_SHCED_M_NO,
                       WK_MNG_M_NO,
                       WK_KINSYU_KBN1,             --����P
                       WK_SCHED_YMD1,              --����E�x���\����P
                       NVL(WK_AMOUNT, 0), --���z�P
                       WK_TGT_LIMIT_YMD1,          --��`�����P
                       WK_COL_DRAFT_YMD,           --����N�Z��
                       WK_JP_CONV_AMOUNT,          --�M�݊��Z�z
                       R_V_URIAGE_TBL              -- ����f�[�^���R�[�h�̂P���R�[�h���G���A
                       );
                WK_YAK_AMOUNT1 :=  NVL(WK_YAK_AMOUNT1, 0) - NVL(WK_AMOUNT, 0);        
            ELSE
            --�����̏ꍇ
              -- �Ǘ��ԍ��ɂ�����A1����̘A�ԏ���
              SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);
             
              --����\��\������.����\�薾�הԍ�( "001"����̘A��)
              WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');
              
              --�M�݊��Z�z���v�Z����B
              WK_JP_CONV_AMOUNT := TRUNC(NVL(WK_AMOUNT, 0) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
              WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;
              
              --����\��\�����ׁi�o�^�j�A����\�薾�ׁi�o�^�j
              SP_INS_M(WK_SEQUENCE_NO,
                       WK_COL_SCHED_NO,
                       WK_COL_SHCED_M_NO,
                       WK_MNG_M_NO,
                       WK_KINSYU_KBN1,             --����P
                       WK_SCHED_YMD1,              --����E�x���\����P
                       NVL(WK_AMOUNT, 0), --���z�P
                       WK_TGT_LIMIT_YMD1,          --��`�����P
                       WK_COL_DRAFT_YMD,           --����N�Z��
                       WK_JP_CONV_AMOUNT,          --�M�݊��Z�z
                       R_V_URIAGE_TBL              -- ����f�[�^���R�[�h�̂P���R�[�h���G���A
                       );
              WK_YAK_AMOUNT1 := 0;
            END IF;
            
          END IF;
      
        END IF;
      END;
      --�����擾���A����\��\�����ׁi�o�^�j�A����\�薾�ׁi�o�^�j-E
    END LOOP;
    --�M�݊��Z�z�̍��z���v�Z����B
    IF 0 < WK_SUM_AMOUNT_EN - WK_SUM_JP_CONV_AMOUNT THEN
      --���ו����o�^���ɍ��v�z��������z�i�~�݁j�ƈ�v���Ȃ��ꍇ�́A���z���P�ڂ̖��ׂɉ��Z����B
      UPDATE
        F_COL_SCHED_S_M
      SET
        JP_CONV_AMOUNT = JP_CONV_AMOUNT + (WK_SUM_AMOUNT_EN - WK_SUM_JP_CONV_AMOUNT)
      WHERE
        COL_SCHED_NO = WK_COL_SCHED_NO
        AND COL_SCHED_ADD_NO = '00'
        AND COL_SCHED_M_NO = '001';
      
      UPDATE
        F_COL_SCHED_M
      SET
        JP_CONV_AMOUNT = JP_CONV_AMOUNT + (WK_SUM_AMOUNT_EN - WK_SUM_JP_CONV_AMOUNT)
      WHERE
        COL_SCHED_NO = WK_COL_SCHED_NO
        AND COL_SCHED_ADD_NO = '00'
        AND COL_SCHED_M_NO = '001';          
    END IF;
    
  END LOOP;
  CLOSE GET_V_URIAGE_AMOUNT;

END SP_GET_V_URIAGE;

/**********************************************************
*** �@�\���́F����\��f�[�^�_���폜����
**********************************************************/
PROCEDURE SP_DEL_F_COL_SCHED
(
  I_WK_COL_SCHED_NO      IN  F_COL_SCHED_H.COL_SCHED_NO%TYPE,
  I_WK_COL_SCHED_ADD_NO  IN  F_COL_SCHED_H.COL_SCHED_ADD_NO%TYPE
) IS

BEGIN

  --����\��\���w�b�_�i�_���폜�j
  UPDATE F_COL_SCHED_S_H
    SET 
      DELETE_TIME = SYSTIMESTAMP, --�폜����
      DELETE_USR_CODE = I_G_USR_CODE, --�폜���[�U�[�R�[�h
      DELETE_FLG = '1' --�폜�t���O
    WHERE 
       COL_SCHED_NO = I_WK_COL_SCHED_NO
       AND COL_SCHED_ADD_NO = I_WK_COL_SCHED_ADD_NO;

  --����\��\�����ׁi�_���폜�j
  UPDATE F_COL_SCHED_S_M
    SET 
      DELETE_TIME = SYSTIMESTAMP, --�폜����
      DELETE_USR_CODE = I_G_USR_CODE, --�폜���[�U�[�R�[�h
      DELETE_FLG = '1' --�폜�t���O
    WHERE 
       COL_SCHED_NO = I_WK_COL_SCHED_NO
       AND COL_SCHED_ADD_NO = I_WK_COL_SCHED_ADD_NO;

  --����\��w�b�_�i�_���폜�j
  UPDATE F_COL_SCHED_H
    SET 
      DELETE_TIME = SYSTIMESTAMP, --�폜����
      DELETE_USR_CODE = I_G_USR_CODE, --�폜���[�U�[�R�[�h
      DELETE_FLG = '1' --�폜�t���O
    WHERE 
       COL_SCHED_NO = I_WK_COL_SCHED_NO
       AND COL_SCHED_ADD_NO = I_WK_COL_SCHED_ADD_NO;

  --����\�薾�ׁi�_���폜�j
  UPDATE F_COL_SCHED_M
    SET 
      DELETE_TIME = SYSTIMESTAMP, --�폜����
      DELETE_USR_CODE = I_G_USR_CODE, --�폜���[�U�[�R�[�h
      DELETE_FLG = '1' --�폜�t���O
    WHERE 
       COL_SCHED_NO = I_WK_COL_SCHED_NO
       AND COL_SCHED_ADD_NO = I_WK_COL_SCHED_ADD_NO;

END SP_DEL_F_COL_SCHED;

/**********************************************************
*** �@�\���́F���s�ςݗ̎����̘_���폜����
**********************************************************/
PROCEDURE SP_DEL_F_REC_SHEET
(
  I_WK_REC_SHEET_NO IN   F_REC_SHEET_M.REC_SHEET_NO%TYPE,
  RETURN_CODE     OUT  CHAR
)IS
BEGIN
  ERR_CNT := 0;
  --�̎����i�_���폜�j
  UPDATE F_REC_SHEET_H
  SET 
    DELETE_TIME = SYSTIMESTAMP, --�폜����
    DELETE_USR_CODE = I_G_USR_CODE, --�폜���[�U�[�R�[�h
    DELETE_FLG = '1' --�폜�t���O
  WHERE 
     REC_SHEET_NO = I_WK_REC_SHEET_NO
     AND DELETE_FLG = '0';
  IF SQL%ROWCOUNT > 0 THEN
    ERR_CNT := ERR_CNT + 1;
  END IF;

  --�̎������ׁi�_���폜�j
  UPDATE F_REC_SHEET_M
  SET 
    DELETE_TIME = SYSTIMESTAMP, --�폜����
    DELETE_USR_CODE = I_G_USR_CODE, --�폜���[�U�[�R�[�h
    DELETE_FLG = '1' --�폜�t���O
  WHERE 
     REC_SHEET_NO = I_WK_REC_SHEET_NO
     AND DELETE_FLG = '0';
  IF SQL%ROWCOUNT > 0 THEN
    ERR_CNT := ERR_CNT + 1;
  END IF;
  
  IF 0 < ERR_CNT THEN
    RETURN_CODE := '2';
    RETURN_CODE_REC_SHEET := '2';
    --�G���[���O�o��
    --UPDATE BY DTT AT 2009/09/21 START
    --    P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '�̎����������ƂȂ�܂����B�i'|| I_WK_REC_SHEET_NO || '�j');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�̎����������ƂȂ�܂����B�i' || I_WK_REC_SHEET_NO || '�j',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
    RETURN;
  END IF;

END SP_DEL_F_REC_SHEET;

/**********************************************************
*** �@�\���́F�O��쐬���̉���\��f�[�^�폜����
**********************************************************/
PROCEDURE SP_GET_F_COL_SCHED_DATA
(
  R_M_TORI_BMN_TBL IN GET_M_TORI_BMN%ROWTYPE,
  RETURN_CODE      IN  OUT    CHAR
) IS
BEGIN

  BEGIN
    N_F_COL_SCHED_IDX := 1;
    OPEN GET_F_COL_SCHED(R_M_TORI_BMN_TBL.TORI_CODE, R_M_TORI_BMN_TBL.TORI_MADO_CODE);
  
    --����\��f�[�^�̃��R�[�h�����A�J��Ԃ�
    LOOP
      -- ����\��f�[�^�擾
      FETCH GET_F_COL_SCHED INTO WK_F_COL_SCHED_TBL(N_F_COL_SCHED_IDX);
        --�ŏI���R�[�h�̏ꍇ�I��
      EXIT WHEN GET_F_COL_SCHED%NOTFOUND;
      N_F_COL_SCHED_IDX := N_F_COL_SCHED_IDX + 1;
    END LOOP;
    --�J�[�\���N���[�Y
    CLOSE GET_F_COL_SCHED;
    
    EXCEPTION
      WHEN NOWAIT_RESOURCE_LOCKED THEN
        RETURN_CODE := '1';
        ERR_MSG_ID := 'ENM00001';
        ERR_MSG_CHR := '����\��f�[�^�i���ߐ����j�쐬�֐��ɂĂc�a�G���[���������܂����B'
            || '�i�O��o�^�f�[�^�����̃��[�U�ɂ��A�������ł��B�j';
        RETURN;
      WHEN OTHERS THEN
        RAISE;
  END;
  
  --�f�[�^���擾����Ȃ��ꍇ�A2�̎��f�[�^�ɂ��Č������s���B
  IF WK_F_COL_SCHED_TBL IS NULL OR WK_F_COL_SCHED_TBL.COUNT = 0 THEN
    RETURN;
  END IF;
 
  FOR PAT_IDX IN 1 .. WK_F_COL_SCHED_TBL.COUNT LOOP
    R_F_COL_SCHED_TBL := WK_F_COL_SCHED_TBL(PAT_IDX);
    BEGIN
      --�\�����t���O��"1"�̏ꍇ
      IF R_F_COL_SCHED_TBL.SINSEICHU_FLG = '1' THEN
        RETURN_CODE := '1';
        ERR_MSG_ID := 'ENM00001';
        ERR_MSG_CHR := '����\��f�[�^�i���ߐ����j�쐬�֐��ɂĂc�a�G���[���������܂����B'
          || '�i�O��o�^�f�[�^�����ِ\�����̂��߁A�����ł��܂���B�i����\��ԍ��F'
          || R_F_COL_SCHED_TBL.COL_SCHED_NO || '�j�j';
        
        RETURN;
      END IF;
      
      --�����m��t���O��"1"�̏ꍇ
      IF R_F_COL_SCHED_TBL.BILL_FIX_FLG = '1' THEN
        RETURN_CODE := '1';
        ERR_MSG_ID := 'ENM00001';
        ERR_MSG_CHR := '����\��f�[�^�i���ߐ����j�쐬�֐��ɂĂc�a�G���[���������܂����B'
          || '�i�O��o�^�f�[�^�������m��ς݂̂��߁A�����ł��܂���B�i����\��ԍ��F'
          || R_F_COL_SCHED_TBL.COL_SCHED_NO || '�j�j';

        RETURN;
      END IF;

      --����\�薾��.�̎������s�敪���u���s�ς݁v�̏ꍇ
      IF R_F_COL_SCHED_TBL.REC_SHEET_ISSUE_KBN = '1' THEN
        --3.5. �̎������ׂ̎擾���s��
        OPEN GET_REC_SHEET_NO(R_F_COL_SCHED_TBL.COL_SCHED_NO, R_F_COL_SCHED_TBL.COL_SCHED_M_NO);
        LOOP
          -- �̎����ԍ��擾
          FETCH GET_REC_SHEET_NO INTO WK_REC_SHEET_NO;
          --�ŏI���R�[�h�̏ꍇ�I��
          EXIT WHEN GET_REC_SHEET_NO%NOTFOUND;
          
          --3.6. ���s�ςݗ̎����̘_���폜
          SP_DEL_F_REC_SHEET(WK_REC_SHEET_NO, RETURN_CODE);
        END LOOP;
        CLOSE GET_REC_SHEET_NO;
      END IF;
      
      --3.7. ����\��f�[�^�_���폜
      SP_DEL_F_COL_SCHED(R_F_COL_SCHED_TBL.COL_SCHED_NO, R_F_COL_SCHED_TBL.COL_SCHED_ADD_NO);
    END;
    
  END LOOP;  

END SP_GET_F_COL_SCHED_DATA;

/**********************************************************
*** �@�\���́F�����K�{�ݒ�`�F�b�N����
**********************************************************/
PROCEDURE SP_CHK_PARAM
(
  RETURN_CODE OUT CHAR
) IS
BEGIN
  
  RETURN_CODE := '0';

  --�ݒ肳��Ă��Ȃ��������̏�����
  ERR_PARAM_NM := '';
  --�K�{���̓`�F�b�N
  IF I_SYORI_YM IS NULL THEN
    ERR_PARAM_NM := '�����N��';
    --�G���[���O�o��
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
  END IF;
  IF I_SHIME_KBN IS NULL THEN
    ERR_PARAM_NM := '�����敪';
    --�G���[���O�o��
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
  END IF;
  IF I_EIGYO_BMN_CODE IS NULL THEN
    ERR_PARAM_NM := '�c�ƕ���R�[�h';
    --�G���[���O�o��
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
    
  END IF;
  IF I_CREATE_USR_CODE IS NULL THEN
    ERR_PARAM_NM := '�쐬��';
    --�G���[���O�o��
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
  END IF;
  --��ł��ݒ肳��Ă��Ȃ��ꍇ
  IF ERR_PARAM_NM IS NOT NULL THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '����\��f�[�^�i���ߐ����j�쐬�֐��ɂĈ����G���[���������܂����B';
    RETURN;
  END IF;

  --����.�����敪��0�̏ꍇ
  IF I_SHIME_KBN = 0 THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '����\��f�[�^�i���ߐ����j�쐬�֐��ɂĈ����G���[���������܂����B';
    --�G���[���O�o��
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '�s�x�����f�[�^�̏����͖{�����ł͎��{�ł��܂���B');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�s�x�����f�[�^�̏����͖{�����ł͎��{�ł��܂���B',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
    RETURN;    
  END IF;

END SP_CHK_PARAM;

BEGIN
--�又���[S
  RETURN_CODE := '0';
  ERR_MSG_ID := '';
  ERR_MSG_CHR := '';
  
  --1. �����K�{�ݒ�`�F�b�N
  SP_CHK_PARAM(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;

  N_M_TORI_BMN_IDX := 1;
  --�����f�[�^���R�[�h�z��̏�����
  WK_M_TORI_BMN_TBL.DELETE;
  -- 2. �����f�[�^�擾
  OPEN GET_M_TORI_BMN;
  LOOP
    FETCH GET_M_TORI_BMN INTO WK_M_TORI_BMN_TBL(N_M_TORI_BMN_IDX);
    EXIT WHEN GET_M_TORI_BMN%NOTFOUND;
    N_M_TORI_BMN_IDX := N_M_TORI_BMN_IDX + 1;
  END LOOP;
  CLOSE GET_M_TORI_BMN;

  --�Ώۃf�[�^�����݂��Ȃ��ꍇ
  IF WK_M_TORI_BMN_TBL IS NULL OR WK_M_TORI_BMN_TBL.COUNT = 0 THEN
    RETURN_CODE := '0';
    ERR_MSG_ID := '';
    ERR_MSG_CHR := '';
    RETURN;
  END IF;

  --�V�X�e���^�p�N���擾 
  SELECT TO_CHAR(SYS_UNYO_YM1, 'YYYYMM') INTO WK_SYS_UNYO_YM1
  FROM
    M_CONTROL
  WHERE
    SYS_KEY = '1';

  --����.�����N���̈���.�����敪�̓��t�i�����敪��99�̏ꍇ�A�������j
  IF I_SHIME_KBN = 99 THEN
    WK_SHORI_DATE := LAST_DAY(TO_DATE(I_SYORI_YM || '01', 'RRRR/MM/DD'));
  ELSE
    IF I_SHIME_KBN < 10 THEN
      WK_SHORI_DATE := TO_DATE(I_SYORI_YM || '0' || I_SHIME_KBN, 'RRRR/MM/DD');
    ELSE
      WK_SHORI_DATE := TO_DATE(I_SYORI_YM || I_SHIME_KBN, 'RRRR/MM/DD');
    END IF;
  END IF;

  --����\��f�[�^���R�[�h�̔z�񐔕��A�J��Ԃ�
  FOR PAT_IDX IN 1 .. WK_M_TORI_BMN_TBL.COUNT LOOP
    R_M_TORI_BMN_TBL := WK_M_TORI_BMN_TBL(PAT_IDX);
    
    -- �O��쐬���̉���\��f�[�^�폜
    SP_GET_F_COL_SCHED_DATA(R_M_TORI_BMN_TBL, RETURN_CODE);
    IF RETURN_CODE = '1' THEN
      RETURN;
    END IF;
    --����f�[�^�擾 
    SP_GET_V_URIAGE(R_M_TORI_BMN_TBL,
                    RETURN_CODE);
    IF RETURN_CODE = '1' THEN
      RETURN;
    END IF;
  END LOOP;

  IF RETURN_CODE_REC_SHEET = '2' THEN
    RETURN_CODE := '2';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '����\��f�[�^�i���ߐ����j�쐬�֐��ɂđO��o�^�����f�[�^�ɂďo�͂����̎����͖����ƂȂ�܂����B';
  END IF;

  EXCEPTION
    WHEN OTHERS THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '����\��f�[�^�i���ߐ����j�쐬�֐��ɂăV�X�e����O�G���[���������܂����B';
      --ADD BY DTT AT 2009/09/21 START
      IF SyoriResult = -1 THEN
        RETURN;
      END IF;
      --ADD BY DTT AT 2009/09/21 END
      --�G���[���O�o��
      BEGIN
      
        --UPDATE BY DTT AT 2009/09/21 START
        --P_LOG_ERROR(I_G_USR_CODE,
        --      I_G_TERM_NAME,
        --      I_G_FUNC_ID,
        --      SQLERRM);
        ERRLOGGER_WRITE(I_G_USR_CODE,
              I_G_TERM_NAME,
              I_G_FUNC_ID,
              SQLERRM,
              SyoriResult);
        
        --UPDATE BY DTT AT 2009/09/21 END
        EXCEPTION

            WHEN OTHERS THEN
                NULL;
      END;

--�又���[E
END ZSK0010B;
/
