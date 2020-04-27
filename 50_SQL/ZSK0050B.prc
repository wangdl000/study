CREATE OR REPLACE PROCEDURE ZSK0050B
/***************************************************************
 *  �@�\�T�v�F���������A
 *  �Ώۂ̉���\��ɑ΂���O����c�����X�V����B
 *  �����P   �F�`�[��ʁi���́j
 *  �����Q   �F�������`�[�ԍ��i���́j
 *  �����R   �F�������`�[�ǔԁi���́j
 *  �����S   �F�������`�[�ǉ��L�[�i���́j
 *  �����T   �F�O����g�p�z�i���́j
 *  �����U   �F�O����g�p���i���́j
 *  �����V   �F�O�����������t���O�i���́j
 *  �����W   �F�O���[�o�����.��������R�[�h
 *  �����X   �F�O���[�o�����.���[�U�R�[�h
 *  �����P�O �F�O���[�o�����.�v���O����ID
 *  �����P�P �F�O���[�o�����.�[����
 *  �����P�Q �F�������ʁi0:����I���A1:�ُ�I���A2:�x���I���j
 *  �����P�R �F�G���[���b�Z�[�W�i�o�́j
 *  �����P�S �F���ߍ��ݕ����i�o�́j
 *  �����P�T �F�O����c���i�o�́j
 **************************************************************/

(
  I_ORIG_DENPYO_TYPE     IN    CHAR,
  I_ORIG_DENPYO_NO       IN    CHAR,
  I_ORIG_DENPYO_ADD_NO   IN    CHAR,
  I_ORIG_DENPYO_ADD_KEY  IN    VARCHAR2,
  I_PRE_REC_USE_AMOUNT   IN    NUMBER,
  I_PRE_REC_USE_YMD      IN    DATE,
  I_COL_COMP_FLG         IN    CHAR,
  I_G_BMN_CODE           IN    CHAR,
  I_G_USR_CODE           IN    CHAR,
  I_G_FUNC_ID            IN    CHAR,
  I_G_TERM_NAME          IN    VARCHAR2,
  RETURN_CODE            OUT   CHAR,
  ERR_MSG_ID             OUT   VARCHAR2,
  ERR_MSG_CHR            OUT   VARCHAR2,
  PRE_REC_AMOUNT         OUT   NUMBER
) IS

  -- �ϐ��錾��
  
  ERR_PARAM_NM            VARCHAR2(20);                             -- �ݒ肳��Ă��Ȃ�������
  WK_COLTD_AMOUNT         NUMBER;                                   -- ����ϋ��z
  WK_PRE_REC_USE_AMOUNT   NUMBER;                                   -- �O����g�p�z
  WK_COL_STATUS           CHAR;                                     -- �����
  WK_SEQUENCE_NO          F_COL_SCHED_S_H.MNG_NO%TYPE;              -- �I���N���V�[�P���X�ɂč̔Ԃ����ԍ�
  WK_TOKUI_CODE           F_COL_SCHED_H.TOKUI_CODE%TYPE;            --���Ӑ�R�[�h
  WK_TOKUI_MADO_CODE      F_COL_SCHED_H.TOKUI_MADO_CODE%TYPE;       --���Ӑ摋���R�[�h
  WK_EIGYO_BMN_CODE       F_COL_SCHED_H.EIGYO_BMN_CODE%TYPE;        --�c�ƕ���R�[�h
  WK_CUR_CODE             F_COL_SCHED_H.CUR_CODE%TYPE;              --�ʉ݃R�[�h
  WK_COL_SCHED_NO         F_COL_SCHED_H.COL_SCHED_NO%TYPE;          -- ����\��ԍ�
  WK_SYS_UNYO_YM1         CHAR(6);                                  -- �V�X�e���^�p�N��
  NOWAIT_RESOURCE_LOCKED  EXCEPTION;                               --�s���b�N�ُ�
  PRAGMA EXCEPTION_INIT(NOWAIT_RESOURCE_LOCKED, -54);
  --ADD BY DTT AT 2009/09/21 START
  SyoriResult             NUMBER;
  ERRLOGGER_EXCEPT        EXCEPTION;
  --ADD BY DTT AT 2009/09/21 END

--����\��f�[�^�擾
CURSOR GET_F_COL_SCHED IS
  SELECT
    COL_SCHED_NO,
    COL_SCHED_ADD_NO,
    CUR_CODE,                                                --�ʉ݃R�[�h
    KINSYU_KBN,                                              --����
    RATE,                                                    --���[�g
    COL_KBN,                                                 --����敪
    ORIG_DENPYO_TYPE,                                        --�������`�[���
    ORIG_DENPYO_NO,                                          --�������`�[�ԍ�
    ORIG_DENPYO_ADD_NO,                                      --�������`�[�ǔ�
    JGYBNR_DAI_CODE,                                         --���Ƒ啪�ރR�[�h
    JGYBNR_CHU_CODE,                                         --���ƒ����ރR�[�h
    PRE_REC_USE_AMOUNT,                                      --�O����g�p�z
    COLTD_AMOUNT,                                            --����ϋ��z
    LINE_AMOUNT,                                             --���׋��z
    KOJI_NO,                                                 --�H���ԍ�
    KOJI_SUB_NO                                              --�H���ԍ��}��
  FROM
    F_COL_SCHED_M
  WHERE

    ORIG_DENPYO_TYPE = I_ORIG_DENPYO_TYPE
    AND ORIG_DENPYO_NO = I_ORIG_DENPYO_NO
    AND ORIG_DENPYO_ADD_NO = I_ORIG_DENPYO_ADD_NO
    AND (ORIG_DENPYO_ADD_KEY LIKE NVL(I_ORIG_DENPYO_ADD_KEY, '%')
        OR (ORIG_DENPYO_ADD_KEY IS NULL AND I_ORIG_DENPYO_ADD_KEY IS NULL))
    AND DELETE_FLG = '0'
FOR UPDATE NOWAIT;
--����\��f�[�^���R�[�h�̔z��
TYPE T_F_COL_SCHED IS TABLE OF GET_F_COL_SCHED%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_F_COL_SCHED       T_F_COL_SCHED;
--����\��f�[�^���R�[�h�z��̓Y����
N_F_COL_SCHED_IDX    INTEGER(10);
--����\��f�[�^���R�[�h�̂P���R�[�h���G���A
R_F_COL_SCHED_TBL    GET_F_COL_SCHED%ROWTYPE;

/**********************************************************
*** �@�\���́F����\��\���w�b�_�̓o�^����
*** �����P  �F�Ǘ��ԍ��i���́j
*** �����Q  �F����\��ԍ��i���́j
*** �����R  �F���Ӑ�R�[�h�i���́j
*** �����S  �F���Ӑ摋���R�[�h�i���́j
*** �����T  �F�ʉ݃R�[�h�i���́j
*** �����U  �F��������R�[�h�i���́j
*** �����V  �F�����N���i���́j
**********************************************************/
PROCEDURE SP_INS_F_COL_SCHED_S_H
(
  I_WK_SEQUENCE_NO     IN  F_COL_SCHED_S_H.MNG_NO%TYPE,
  I_WK_COL_SCHED_NO    IN  F_COL_SCHED_S_H.COL_SCHED_NO%TYPE,
  I_WK_TOKUI_CODE      IN  F_COL_SCHED_S_H.TOKUI_CODE%TYPE,
  I_WK_TOKUI_MADO_CODE IN  F_COL_SCHED_S_H.TOKUI_MADO_CODE%TYPE,
  I_WK_CUR_CODE        IN  F_COL_SCHED_S_H.CUR_CODE%TYPE,
  I_WK_BMN_CODE        IN  F_COL_SCHED_S_H.EIGYO_BMN_CODE%TYPE,
  I_WK_SYS_UNYO_YM1    IN  F_COL_SCHED_S_H.SYORI_YM%TYPE
) IS

BEGIN
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
     I_WK_TOKUI_CODE,          --���Ӑ�R�[�h
     I_WK_TOKUI_MADO_CODE,     --���Ӑ摋���R�[�h
     I_WK_SYS_UNYO_YM1,        --�����N��
     '0',                      --�����敪�u�s�x�v
     I_WK_CUR_CODE,            --�ʉ݃R�[�h
     '04',                     --�����X�e�[�^�X�u�m��ρv
     I_G_BMN_CODE,             --�\������R�[�h �O���[�o�����  ��������R�[�h 
     I_G_USR_CODE,             --�\���҃R�[�h  -- ���[�U�[�R�[�h
     '',                       --����������R�[�h
     '',                       --�������҃R�[�h
     I_G_USR_CODE,             --�O�����҃R�[�h ���[�U�[�R�[�h
     '1',                      --�����m��t���O�u�m��ρv
     '',                       --�����҃R�����g
     I_WK_BMN_CODE,            --�c�ƕ���R�[�h ���⑫������2.1.�̎擾�l
     SYSTIMESTAMP,             --�쐬����
     I_G_USR_CODE,             --�쐬���[�U�[�R�[�h �O���[�o����� ���[�U�[�R�[�h
     SYSTIMESTAMP,             --�X�V����
     I_G_USR_CODE,             --�X�V���[�U�[�R�[�h �O���[�o����񃆁[�U�[�R�[�h
     '',                       --�폜����
     '',                       --�폜���[�U�[�R�[�h
     '0'                       --�폜�t���O�u��폜�v
      );
 END SP_INS_F_COL_SCHED_S_H;
 
/**********************************************************
*** �@�\���́F����\��\�����ׂ̓o�^����
*** �����P  �F�Ǘ��ԍ��i���́j
*** �����Q  �F����\��ԍ��i���́j
*** �����R  �F����\��f�[�^���R�[�h�̂P���R�[�h���G���A�i���́j
**********************************************************/
PROCEDURE SP_INS_F_COL_SCHED_S_M
(
  I_WK_SEQUENCE_NO     IN  F_COL_SCHED_S_M.MNG_NO%TYPE,
  I_WK_COL_SCHED_NO    IN  F_COL_SCHED_S_M.COL_SCHED_NO%TYPE,
  R_F_COL_SCHED_TBL    IN  GET_F_COL_SCHED%ROWTYPE  --����\��f�[�^���R�[�h�̂P���R�[�h���G���A
) IS

BEGIN
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
        --ORIG_DENPYO_ADD_KEY,     --�������`�[�ǉ��L�[
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
        I_WK_SEQUENCE_NO,                       --�Ǘ��ԍ�
        1,                                      --�Ǘ����הԍ�
        I_WK_SEQUENCE_NO,                       --�����Ǘ��ԍ� �Ǘ��ԍ��Ɠ��l
        1,                                      --�����Ǘ����הԍ�  �Ǘ����הԍ��Ɠ��l
        I_WK_COL_SCHED_NO,                      --����\��ԍ� ���ʊ֐��ɂč̔�
        '00',                                   --����\��ǔ�
        '001',                                  --����\�薾�הԍ�  "001"
        I_PRE_REC_USE_YMD,                      --����\��� �O����g�p��
        R_F_COL_SCHED_TBL.KINSYU_KBN,           --���� ����
        --UPDATE BY DTT AT 2009/10/09 START
        --NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) - NVL(R_F_COL_SCHED_TBL.COLTD_AMOUNT, 0),  --���׋��z   �O����g�p�z�|����ϋ��z
        NVL(R_F_COL_SCHED_TBL.LINE_AMOUNT, 0) - NVL(WK_COLTD_AMOUNT, 0),--���⑫������3. ����󋵃`�F�b�N�����̖߂�l�i����ς݋��z�j�| ���⑫������2.1.�Ŏ擾�������׋��z
        --UPDATE BY DTT AT 2009/10/09 END
        R_F_COL_SCHED_TBL.CUR_CODE,             --�ʉ݃R�[�h
        R_F_COL_SCHED_TBL.RATE,                 --���[�g
        TRUNC(R_F_COL_SCHED_TBL.LINE_AMOUNT * NVL(R_F_COL_SCHED_TBL.RATE, 0), 0 ), --�M�݊��Z�z  ���z�~���[�g�i�������؎̂āj
        '',                                     --�N���[���ԍ�
        I_PRE_REC_USE_YMD,                      --����N�Z��  �O����g�p��
        '',                                     --��`����
        R_F_COL_SCHED_TBL.KOJI_NO,              --�H���ԍ�
        R_F_COL_SCHED_TBL.KOJI_SUB_NO,          --�H���ԍ��}��
        '�O����c���X�V�ł̎����쐬',           --���l
        '0',                                    --�ۗ��t���O �u�ۗ��Ȃ��v
        R_F_COL_SCHED_TBL.COL_KBN,              --����敪
        R_F_COL_SCHED_TBL.ORIG_DENPYO_TYPE,     --�������`�[���
        R_F_COL_SCHED_TBL.ORIG_DENPYO_NO,       --�������`�[�ԍ�
        R_F_COL_SCHED_TBL.ORIG_DENPYO_ADD_NO,   --�������`�[�ǔ�
       -- R_F_COL_SCHED_TBL.ORIG_DENPYO_ADD_KEY,  --�������`�[�ǉ��L�[
        R_F_COL_SCHED_TBL.JGYBNR_DAI_CODE,      --���Ƒ啪�ރR�[�h
        R_F_COL_SCHED_TBL.JGYBNR_CHU_CODE,      --���ƒ����ރR�[�h
        '0',                                    --�R�����A���t���O�u��Ώہv
        SYSTIMESTAMP,                           --�쐬����
        I_G_USR_CODE,                           --�쐬���[�U�[�R�[�h �O���[�o�����
        SYSTIMESTAMP,                           --�X�V����
        I_G_USR_CODE,                           --�X�V���[�U�[�R�[�h �O���[�o�����
        '',                                     --�폜����
        '',                                     --�폜���[�U�[�R�[�h
        '0'                                     --�폜�t���O �Œ�l�u��폜�v
      );

 END SP_INS_F_COL_SCHED_S_M;
 
 /**********************************************************
*** �@�\���́F����\��w�b�_�̓o�^����
*** �����P  �F����\��ԍ��i���́j
*** �����Q  �F���Ӑ�R�[�h�i���́j
*** �����R  �F���Ӑ摋���R�[�h�i���́j
*** �����S  �F�ʉ݃R�[�h�i���́j
*** �����T  �F�c�ƕ���R�[�h�i���́j
*** �����U  �F�����N���i���́j
**********************************************************/
PROCEDURE SP_INS_F_COL_SCHED_H
(
  I_WK_COL_SCHED_NO    IN  F_COL_SCHED_S_H.COL_SCHED_NO%TYPE,
  I_WK_TOKUI_CODE      IN  F_COL_SCHED_S_H.TOKUI_CODE%TYPE,
  I_WK_TOKUI_MADO_CODE IN  F_COL_SCHED_S_H.TOKUI_MADO_CODE%TYPE,
  I_WK_CUR_CODE        IN  F_COL_SCHED_S_H.CUR_CODE%TYPE,
  I_WK_BMN_CODE        IN  F_COL_SCHED_S_H.EIGYO_BMN_CODE%TYPE,
  I_WK_SYS_UNYO_YM1    IN  F_COL_SCHED_S_H.SYORI_YM%TYPE
) IS

BEGIN
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
        I_WK_TOKUI_CODE,         --���Ӑ�R�[�h
        I_WK_TOKUI_MADO_CODE,    --���Ӑ摋���R�[�h
        I_WK_BMN_CODE,           --�c�ƕ���R�[�h
        I_WK_SYS_UNYO_YM1,       --�����N�� �V�X�e���^�p�N��
        '0',                     --�����敪 �u�s�x�v
        I_WK_CUR_CODE,           --�ʉ݃R�[�h
        SYSTIMESTAMP,            --�쐬����
        I_G_USR_CODE,            --�쐬���[�U�[�R�[�h ���[�U�[�R�[�h
        SYSTIMESTAMP,            --�X�V����
        I_G_USR_CODE,            --�X�V���[�U�[�R�[�h ���[�U�[�R�[�h
        '',                      --�폜����
        '',                      --�폜���[�U�[�R�[�h
        '0'                      --�폜�t���O�u��폜�v
      );

 END SP_INS_F_COL_SCHED_H;

 /**********************************************************
*** �@�\���́F����\�薾�ׂ̓o�^����
*** �����P  �F����\��ԍ��i���́j
*** �����Q  �F����\��f�[�^���R�[�h�̂P���R�[�h���G���A�i���́j
**********************************************************/
PROCEDURE SP_INS_F_COL_SCHED_M
(
  I_WK_COL_SCHED_NO    IN  F_COL_SCHED_S_M.COL_SCHED_NO%TYPE,
  R_F_COL_SCHED_TBL    IN  GET_F_COL_SCHED%ROWTYPE  --����\��f�[�^���R�[�h�̂P���R�[�h���G���A
) IS

BEGIN
    
    INSERT INTO F_COL_SCHED_M
     (
        COL_SCHED_NO,               --����\��ԍ�
        COL_SCHED_ADD_NO,           --����\��ǔ�
        --UPDATE BY DTT AT 2009/09/21 START
        --COL_SHCED_M_NO,          --����\�薾�הԍ�
        COL_SCHED_M_NO,          --����\�薾�הԍ�
        --UPDATE BY DTT AT 2009/09/21 END
        SYORI_KBN,                  --�����敪
        COL_SCHED_YMD,              --����\���
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
        --ORIG_DENPYO_ADD_KEY,        --�������`�[�ǉ��L�[
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
        I_WK_COL_SCHED_NO,                         --����\��ԍ�  ���ʊ֐��ɂč̔�
        '00',                                      --����\��ǔ�
        1,                                         --����\�薾�הԍ�
        '0',                                       --�����敪�u�V�K�v
        I_PRE_REC_USE_YMD,                         --����\��� �O����g�p��
        R_F_COL_SCHED_TBL.KINSYU_KBN,              --����
        --UPDATE BY DTT AT 2009/10/09 START
        --NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) - NVL(R_F_COL_SCHED_TBL.COLTD_AMOUNT, 0),  --���׋��z ����\��\�����דo�^���Ɠ��l
        NVL(R_F_COL_SCHED_TBL.LINE_AMOUNT, 0) - NVL(WK_COLTD_AMOUNT, 0),--���׋��z ����\��\�����דo�^���Ɠ��l
        --UPDATE BY DTT AT 2009/10/09 END
        R_F_COL_SCHED_TBL.CUR_CODE,                --�ʉ݃R�[�h
        R_F_COL_SCHED_TBL.RATE,                    --���[�g
        TRUNC(R_F_COL_SCHED_TBL.LINE_AMOUNT * NVL(R_F_COL_SCHED_TBL.RATE, 0), 0 ), --�M�݊��Z�z
        NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) - NVL(R_F_COL_SCHED_TBL.COLTD_AMOUNT, 0), --����ϋ��z ���׋��z
        NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) - NVL(R_F_COL_SCHED_TBL.COLTD_AMOUNT, 0), --�O����g�p�z ���׋��z
        '',                                        --�N���[���ԍ�
        '1',                                       --��������t���O
        I_PRE_REC_USE_YMD,                         --���������
        I_PRE_REC_USE_YMD,                         --����N�Z��
        '',                                        --��`����
        R_F_COL_SCHED_TBL.JGYBNR_DAI_CODE,         --���Ƒ啪�ރR�[�h
        R_F_COL_SCHED_TBL.JGYBNR_CHU_CODE,         --���ƒ����ރR�[�h
        R_F_COL_SCHED_TBL.COL_KBN,                 --����敪
        R_F_COL_SCHED_TBL.ORIG_DENPYO_TYPE,        --�������`�[���
        R_F_COL_SCHED_TBL.ORIG_DENPYO_NO,          --�������`�[�ԍ�
        R_F_COL_SCHED_TBL.ORIG_DENPYO_ADD_NO,      --�������`�[�ǔ�
        --'',                                        --�������`�[�ǉ��L�[
        R_F_COL_SCHED_TBL.KOJI_NO,                 --�H���ԍ�
        R_F_COL_SCHED_TBL.KOJI_SUB_NO,             --�H���ԍ��}��
        '�O����c���X�V�ł̎����쐬',              --���l
        '',                                        --�̎������s�敪
        '0',                                       --�ۗ��t���O
        '0',                                       --�R�����A���t���O
        SYSTIMESTAMP,                              --�쐬����
        I_G_USR_CODE,                              --�쐬���[�U�[�R�[�h ���[�U�[�R�[�h
        SYSTIMESTAMP,                              --�X�V����
        I_G_USR_CODE,                              --�X�V���[�U�[�R�[�h ���[�U�[�R�[�h
        '',                                        --�폜����
        '',                                        --�폜���[�U�[�R�[�h
        '0'                                        --�폜�t���O�u��폜�v
      );

END SP_INS_F_COL_SCHED_M;

/**********************************************************
*** �@�\���́F����\��f�[�^�̓o�^����
*** �����P  �F���Ӑ�R�[�h�i���́j
*** �����Q  �F���Ӑ摋���R�[�h �i���́j
*** �����R  �F�c�ƕ���R�[�h�i���́j
*** �����S  �F�ʉ݃R�[�h�i���́j
*** �����T  �F����\��f�[�^���R�[�h�̂P���R�[�h���G���A�i���́j
**********************************************************/
PROCEDURE SP_INS_F_COL_SCHED
(
  I_WK_TOKUI_CODE            F_COL_SCHED_H.TOKUI_CODE%TYPE,
  I_WK_TOKUI_MADO_CODE       F_COL_SCHED_H.TOKUI_MADO_CODE%TYPE,
  I_WK_EIGYO_BMN_CODE        F_COL_SCHED_H.EIGYO_BMN_CODE%TYPE,
  I_WK_CUR_CODE              F_COL_SCHED_H.CUR_CODE%TYPE,

  R_F_COL_SCHED_TBL IN  GET_F_COL_SCHED%ROWTYPE  --����\��f�[�^���R�[�h�̂P���R�[�h���G���A
) IS
BEGIN
  --�I���N���V�[�P���X�ɂč̔Ԃ��A�ԍ����擾����B
  SELECT S_SK_COLSCHED_S_MNG_NO.NEXTVAL INTO WK_SEQUENCE_NO FROM DUAL;

  --�V�X�e���^�p�N���擾 
  SELECT TO_CHAR(SYS_UNYO_YM1, 'YYYYMM') INTO WK_SYS_UNYO_YM1
  FROM
    M_CONTROL
  WHERE
    SYS_KEY = '1';
    
    --���ʊ֐��ɂč̔Ԃŉ���\��ԍ����擾����B
    ----UPDATE BY DTT AT 2009/09/21 START
    /*
    P_KK_GETDENNO(I_ORIG_DENPYO_TYPE,  --�`�[���
                  I_WK_EIGYO_BMN_CODE,  --����R�[�h
                  SUBSTR(WK_SYS_UNYO_YM1, 1, 4), --�N�x
                  NVL(I_G_USR_CODE, '999999'),    --���[�U�[�R�[�h(�ȗ��������l:999999)
                  I_G_FUNC_ID,
                  I_G_TERM_NAME,
                  WK_COL_SCHED_NO);
    */
    WK_COL_SCHED_NO := P_KK_GETDENNO(I_ORIG_DENPYO_TYPE,  --�`�[���
                  I_WK_EIGYO_BMN_CODE,  --����R�[�h
                  SUBSTR(WK_SYS_UNYO_YM1, 1, 4), --�N�x
                  NVL(I_G_USR_CODE, '999999'),    --���[�U�[�R�[�h(�ȗ��������l:999999)
                  I_G_TERM_NAME);
    ----UPDATE BY DTT AT 2009/09/21 END
    IF WK_COL_SCHED_NO = '-1' OR WK_COL_SCHED_NO = '-2'
       OR WK_COL_SCHED_NO = '-3' OR WK_COL_SCHED_NO = '-8' OR WK_COL_SCHED_NO = '-9' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '�V�X�e���G���[���������܂����B';
      RETURN;
    END IF;

    --����\��\���w�b�_�̓o�^����
    SP_INS_F_COL_SCHED_S_H(
      WK_SEQUENCE_NO,
      WK_COL_SCHED_NO,    --����\��ԍ�
      I_WK_TOKUI_CODE,
      I_WK_TOKUI_MADO_CODE,
      I_WK_CUR_CODE,
      I_WK_EIGYO_BMN_CODE,
      WK_SYS_UNYO_YM1
    );
    --����\��\�����ׂ̓o�^����
    SP_INS_F_COL_SCHED_S_M(
      WK_SEQUENCE_NO,
      WK_COL_SCHED_NO,    --����\��ԍ�
      R_F_COL_SCHED_TBL
    );

    --����\��w�b�_�̓o�^����
    SP_INS_F_COL_SCHED_H(
      WK_COL_SCHED_NO,    --����\��ԍ�
      I_WK_TOKUI_CODE,
      I_WK_TOKUI_MADO_CODE,
      I_WK_CUR_CODE,
      I_WK_EIGYO_BMN_CODE,
      WK_SYS_UNYO_YM1
    );

    --����\�薾�ׂ̓o�^����
    SP_INS_F_COL_SCHED_M(
      WK_COL_SCHED_NO,    --����\��ԍ�
      R_F_COL_SCHED_TBL
    );

END SP_INS_F_COL_SCHED;

/**********************************************************
*** �@�\���́F����\�薾�׍X�V����
*** �����P  �F����\��f�[�^���R�[�h�̂P���R�[�h���G���A�i���́j
**********************************************************/
PROCEDURE SP_UPDATE_F_COL_SCHED
(
  R_F_COL_SCHED_TBL IN GET_F_COL_SCHED%ROWTYPE
) IS
BEGIN

  IF I_COL_COMP_FLG = '0' THEN
  --����.�O�����������t���O��"0"�̏ꍇ
    BEGIN
      UPDATE F_COL_SCHED_M
      SET                                                     
        PRE_REC_USE_AMOUNT =  NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) + NVL(I_PRE_REC_USE_AMOUNT, 0), --�O����g�p�z
        PRE_REC_USE_YMD = I_PRE_REC_USE_YMD,                            --�O����g�p��
        UPDATE_TIME = SYSTIMESTAMP,                                     --�X�V����
        UPDATE_USR_CODE = I_G_USR_CODE                                  --�X�V���[�U�[�R�[�h 
      WHERE                                                                       
        ORIG_DENPYO_TYPE = I_ORIG_DENPYO_TYPE                            --�������`�[���
        AND ORIG_DENPYO_NO = I_ORIG_DENPYO_NO                            --�������`�[�ԍ�
        AND ORIG_DENPYO_ADD_NO = I_ORIG_DENPYO_ADD_NO                    --�������`�[�ǔ�
        AND (ORIG_DENPYO_ADD_KEY LIKE NVL(I_ORIG_DENPYO_ADD_KEY , '%')
            OR (ORIG_DENPYO_ADD_KEY IS NULL AND I_ORIG_DENPYO_ADD_KEY IS NULL))    --�������`�[�ǉ��L�[
      ;
    END;
  
  ELSE
    IF I_COL_COMP_FLG = '1' THEN
  --����.�O�����������t���O��"1"�̏ꍇ
      BEGIN
        UPDATE F_COL_SCHED_M
        SET
          COLTD_AMOUNT = R_F_COL_SCHED_TBL.LINE_AMOUNT,                  --����ϋ��z
          PRE_REC_USE_AMOUNT = R_F_COL_SCHED_TBL.LINE_AMOUNT,            --�O����g�p�z
          COL_COMP_FLG = '1',                                            --��������t���O
          COL_COMP_YMD = PRE_REC_USE_YMD,                                --���������
          PRE_REC_USE_YMD = PRE_REC_USE_YMD,                             --�O����g�p��
          UPDATE_TIME = SYSTIMESTAMP,                                    --�X�V����
          UPDATE_USR_CODE = I_G_USR_CODE                                 --�X�V���[�U�[�R�[�h
        WHERE                                                                       
          ORIG_DENPYO_TYPE = I_ORIG_DENPYO_TYPE                           --�������`�[���
          AND ORIG_DENPYO_NO = I_ORIG_DENPYO_NO                           --�������`�[�ԍ�
          AND ORIG_DENPYO_ADD_NO = I_ORIG_DENPYO_ADD_NO                   --�������`�[�ǔ�
          AND (ORIG_DENPYO_ADD_KEY LIKE NVL(I_ORIG_DENPYO_ADD_KEY , '%')
              OR (ORIG_DENPYO_ADD_KEY IS NULL AND I_ORIG_DENPYO_ADD_KEY IS NULL))   --�������`�[�ǉ��L�[ 
        ;
      END;
    END IF;
  END IF;

END SP_UPDATE_F_COL_SCHED;

/**********************************************************
*** �@�\���́F����\��f�[�^�擾����
*** �����P  �F�������ʁi0:����I���A1:�ُ�I���j
**********************************************************/
PROCEDURE SP_GET_F_COL_SCHED
(
  RETURN_CODE OUT CHAR
) IS
BEGIN
  BEGIN
    N_F_COL_SCHED_IDX := 1;
    --����\��f�[�^���[�N���R�[�h�z��̏�����
    WK_F_COL_SCHED.DELETE;
  
    OPEN GET_F_COL_SCHED;
    LOOP
      --����\��f�[�^�擾
      FETCH GET_F_COL_SCHED INTO WK_F_COL_SCHED(N_F_COL_SCHED_IDX);
      --�ŏI���R�[�h�̏ꍇ�I��
      EXIT WHEN GET_F_COL_SCHED%NOTFOUND;
      N_F_COL_SCHED_IDX := N_F_COL_SCHED_IDX + 1;
    END LOOP;
    CLOSE GET_F_COL_SCHED;
    
    EXCEPTION
      WHEN NOWAIT_RESOURCE_LOCKED THEN
        RETURN_CODE := '1';
        ERR_MSG_ID := 'ENM00001';
        ERR_MSG_CHR := '�O����c���X�V�֐��ɂĂc�a�G���[���������܂����B'
            || '�i�Ώۂ̉���\��f�[�^�����̃��[�U�ɂ��A�������ł��B�j';
        RETURN;
      WHEN OTHERS THEN
        RAISE;

  END;
    --�擾�ł��Ȃ��ꍇ
    IF WK_F_COL_SCHED IS NULL OR WK_F_COL_SCHED.COUNT = 0 THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '�O����c���X�V�֐��ɂĂc�a�G���[���������܂����B�i�Ώۂ̉���\��f�[�^�����݂��܂���B�j';
      RETURN;
    END IF;

END SP_GET_F_COL_SCHED;

/**********************************************************
*** �@�\���́F�����K�{�ݒ�`�F�b�N����
*** �����P  �F�������ʁi0:����I���A1:�ُ�I���j
**********************************************************/
PROCEDURE SP_CHK_PARAM
(
  RETURN_CODE OUT CHAR
) IS
BEGIN
  --�ݒ肳��Ă��Ȃ��������̏�����
  ERR_PARAM_NM := '';
  RETURN_CODE := '0';
  
  --�K�{���̓`�F�b�N
  IF I_ORIG_DENPYO_TYPE IS NULL THEN
    ERR_PARAM_NM := '�`�[���';
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
  IF I_ORIG_DENPYO_NO IS NULL THEN
    ERR_PARAM_NM := '�������`�[�ԍ�';
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
  IF I_ORIG_DENPYO_ADD_NO IS NULL THEN
    ERR_PARAM_NM := '�������`�[�ǔ�';
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
  IF I_PRE_REC_USE_AMOUNT IS NULL THEN
    ERR_PARAM_NM := '�O����g�p�z';
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
  IF I_PRE_REC_USE_YMD IS NULL THEN
    ERR_PARAM_NM := '�O����g�p��';
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
  IF I_COL_COMP_FLG IS NULL THEN
    ERR_PARAM_NM := '�O�����������t���O';
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
    ERR_MSG_CHR := '�O����c���X�V�֐��ɂĈ����G���[���������܂����B';
    RETURN;
  END IF;
  
END SP_CHK_PARAM;

BEGIN
--�又���[S
  --�o�͏�����
  RETURN_CODE := '0';
  ERR_MSG_ID := '';
  ERR_MSG_CHR := '';

  --1. �����K�{�ݒ�`�F�b�N
  SP_CHK_PARAM(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;
  
  --����\��f�[�^���[�N���R�[�h�z��̓Y������������
  N_F_COL_SCHED_IDX := 0;
  -- 2. ����\��f�[�^�擾
  SP_GET_F_COL_SCHED(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;
  --3. ����󋵃`�F�b�N���������{����B
  --3.1. ���ҏW������1. ����󋵃`�F�b�N�����ɏ]���A���ʊ֐������s����B
  ZSK0040B(I_ORIG_DENPYO_TYPE,    --�`�[���
           I_ORIG_DENPYO_NO,      --�������`�[�ԍ�
           I_ORIG_DENPYO_ADD_NO,  --�������`�[�ǔ�
           I_ORIG_DENPYO_ADD_KEY, --�������`�[�ǉ��L�[
           I_G_USR_CODE,          --�O���[�o�����.���[�U�R�[�h
           I_G_FUNC_ID,           --�O���[�o�����.�v���O����ID
           I_G_TERM_NAME,         --�O���[�o�����.�[����
           RETURN_CODE,           --��������
           ERR_MSG_ID,            --�G���[���b�Z�[�W
           ERR_MSG_CHR,           --���ߍ��ݕ���
           WK_COL_STATUS,         --�����
           WK_COLTD_AMOUNT,       --����ϋ��z
           WK_PRE_REC_USE_AMOUNT  --�O����g�p�z
   );
  --3.2. ����󋵃`�F�b�N�����̖߂�l�i�������ʁj��"1"�u�ُ�I���v�̏ꍇ   
  IF RETURN_CODE = '1' THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := ERR_MSG_ID;
    ERR_MSG_CHR := ERR_MSG_CHR;
    RETURN; 
  END IF;
  --3.3. ����\��󋵃`�F�b�N�����̖߂�l�i�������ʁj��"0"�u����I���v�����A
  --    �߂�l�̉���󋵂��u1�F������v�A�u2�F�ꕔ����ρv�A
  --    �u3�F��������v�ȊO�̏ꍇ
  IF RETURN_CODE = '0'
    AND WK_COL_STATUS NOT IN ('1' , '2', '3')  THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '�O����c���X�V�֐��ɂĐ������G���[���������܂����B�i�Ώۂ̉���\��f�[�^���X�V�\�ȏ�Ԃɂ���܂���B�j';
    RETURN;
  END IF;
  --3.4. ����󋵃`�F�b�N�����̖߂�l�i����ϋ��z�|�O����g�p�z�j�|����.�O����g�p�z�������ƂȂ�ꍇ
  IF (NVL(WK_COLTD_AMOUNT, 0) - NVL(WK_PRE_REC_USE_AMOUNT, 0) - NVL(I_PRE_REC_USE_AMOUNT, 0)) < 0 THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '�O����c���X�V�֐��ɂĐ������G���[���������܂����B�i�O����c���ȏ�̋��z���g�p���邱�Ƃ͂ł��܂���B�j';
    RETURN;
  END IF;
 
  --4. ����\�薾�׍X�V
  --�d��p�^�[�����[�N���R�[�h�̔z�񐔕��A�J��Ԃ�
  FOR PAT_IDX IN 1 .. WK_F_COL_SCHED.COUNT LOOP
    R_F_COL_SCHED_TBL := WK_F_COL_SCHED(PAT_IDX);
    --����\�薾�׍X�V����
    SP_UPDATE_F_COL_SCHED(R_F_COL_SCHED_TBL);
    
  END LOOP;
  
  --5. ����\�荷���f�[�^�쐬
  --UPDATE BY DTT AT 2009/10/09 START
  --����.�O�����������t���O��"1"�A
  --  ������󋵃`�F�b�N�߂�l�i����ϋ��z�|�O����g�p�z�j�|����.�O����g�p�z��1�ȏ�̏ꍇ
  --IF I_COL_COMP_FLG = '1'
  --  AND 1 <= (NVL(WK_COLTD_AMOUNT, 0) - NVL(WK_PRE_REC_USE_AMOUNT, 0) - NVL(I_PRE_REC_USE_AMOUNT, 0)) THEN
  
  --  FOR PAT_IDX IN 1 .. WK_F_COL_SCHED.COUNT LOOP
  --    R_F_COL_SCHED_TBL := WK_F_COL_SCHED(PAT_IDX);
  --����.�O�����������t���O��"1"�A
  --  ����2.1.�Ŏ擾��������\�薾�ׂ̖��׋��z�|����󋵃`�F�b�N�߂�l�i����ϋ��z�j��1�ȏ�̏ꍇ
  R_F_COL_SCHED_TBL := WK_F_COL_SCHED(1);
  IF I_COL_COMP_FLG = '1'
    AND 1 <= NVL(R_F_COL_SCHED_TBL.LINE_AMOUNT, 0) - NVL(WK_COLTD_AMOUNT, 0) THEN
      --����\��w�b�_���擾 TODO
      SELECT
        TOKUI_CODE,       --���Ӑ�R�[�h
        TOKUI_MADO_CODE,  --���Ӑ摋���R�[�h
        EIGYO_BMN_CODE,   --�c�ƕ���R�[�h
        CUR_CODE          --�ʉ݃R�[�h
        
      INTO
        WK_TOKUI_CODE,
        WK_TOKUI_MADO_CODE,
        WK_EIGYO_BMN_CODE,
        WK_CUR_CODE  
      FROM
        F_COL_SCHED_H
      WHERE
        COL_SCHED_NO = R_F_COL_SCHED_TBL.COL_SCHED_NO
        AND COL_SCHED_ADD_NO = R_F_COL_SCHED_TBL.COL_SCHED_ADD_NO
      ;
      --����\��f�[�^�̓o�^���s���B
      SP_INS_F_COL_SCHED(
        WK_TOKUI_CODE,
        WK_TOKUI_MADO_CODE,
        WK_EIGYO_BMN_CODE,
        WK_CUR_CODE,  
        R_F_COL_SCHED_TBL
      );
    --END LOOP;
  END IF;
  --UPDATE BY DTT AT 2009/10/09 END
  --6. �߂�l�ݒ�
  IF I_COL_COMP_FLG = '1' THEN
    PRE_REC_AMOUNT := 0;
  ELSE 
    IF I_COL_COMP_FLG = '0' THEN
      PRE_REC_AMOUNT := NVL(WK_COLTD_AMOUNT, 0) - NVL(WK_PRE_REC_USE_AMOUNT, 0) - NVL(I_PRE_REC_USE_AMOUNT, 0);
    END IF;
  END IF;

  EXCEPTION
    WHEN OTHERS THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '����\��f�[�^�i�s�x�����j�쐬�֐��ɂăV�X�e����O�G���[���������܂����B';
      
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
END ZSK0050B;
/
