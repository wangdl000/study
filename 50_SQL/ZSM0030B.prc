CREATE OR REPLACE PROCEDURE ZSM0030B
/********************************************************
 *  �@�\�T�v�F
 *    �x���v���f�[�^�ɑ΂���x���󋵂̃`�F�b�N���s���B
 *  �����P   �F�`�[��ʁi���́j
 *  �����Q   �F�������`�[�ԍ��i���́j
 *  �����R   �F�������`�[�ǔԁi���́j
 *  �����S   �F�������`�[�ǉ��L�[�i���́j
 *  �����T   �F�O���[�o�����.��������R�[�h
 *  �����U   �F�O���[�o�����.���[�U�R�[�h
 *  �����V   �F�O���[�o�����.�v���O����ID
 *  �����W   �F�O���[�o�����.�[����
 *  �����X   �F�������ʁi0:����I���A1:�ُ�I���A2:�x���I���j
 *  �����P�O �F�G���[���b�Z�[�W�i�o�́j
 *  �����P�P �F���ߍ��ݕ����i�o�́j
 *  �����P�Q �F�x���󋵁i�o�́j
 *  �����P�R �F�x���ϋ��z�i�o�́j
 *******************************************************/
(
  I_DENPYO_TYPE         IN   CHAR,
  I_ORIG_DENPYO_NO      IN   CHAR,
  I_ORIG_DENPYO_ADD_NO  IN   CHAR,
  I_ORIG_DENPYO_ADD_KEY IN   CHAR,
  I_G_USR_CODE          IN   CHAR,
  I_G_FUNC_ID           IN   CHAR,
  I_G_TERM_NAME         IN   VARCHAR2,
  RETURN_CODE           OUT  CHAR,
  ERR_MSG_ID            OUT  VARCHAR2,
  ERR_MSG_CHR           OUT  VARCHAR2,
  SIHARAI_STATE         OUT  CHAR,
  SIHARAI_KG            OUT  NUMBER

) IS

  -- �ϐ��錾��
  ERR_PARAM_NM            VARCHAR2(14);                            -- �ݒ肳��Ă��Ȃ�������
  WK_MNG_NO               F_PAY_REQ_S_M.MNG_NO%TYPE;               -- �Ǘ��ԍ� (FK)
  WK_DELETE_FLG           CHAR(1);                                 -- �폜�t���O�i0�F�폜�Ȃ��A1�F�폜����j
  WK_SYORI_STAT_CODE      F_PAY_REQ_S_H.SYORI_STAT_CODE%TYPE;      -- �����X�e�[�^�X
  WK_PAY_COMP_FLG         F_PAY_REQ_M.PAY_COMP_FLG%TYPE;           -- �x�������t���O
  WK_PAID_AMOUNT          F_PAY_REQ_M.PAID_AMOUNT%TYPE;            -- �x���ϋ��z�̍��v�l

--�x���ϋ��z�̍��v�l���擾����
CURSOR GET_SUM_PAYD_AMOUNT
(
   --�`�[���
  iORIG_DENPYO_TYPE  IN  F_PAY_REQ_S_M.ORIG_DENPYO_TYPE%TYPE,
  --�������`�[�ԍ�
  iORIG_SLIP_NO      IN  F_PAY_REQ_S_M.ORIG_SLIP_NO%TYPE,
  --�������`�[�ǔ�
  iORIG_SLIP_ADD_NO  IN  F_PAY_REQ_S_M.ORIG_SLIP_ADD_NO%TYPE,
  --�������`�[�ǉ��L�[
  iORIG_SLIP_ADD_KEY IN  F_PAY_REQ_S_M.ORIG_SLIP_ADD_KEY%TYPE
) IS
  SELECT
    FPRSM.MNG_NO,
    NVL(SUM(PAID_AMOUNT),0)

  FROM F_PAY_REQ_S_M FPRSM
  
    INNER JOIN F_PAY_REQ_S_H FPRSH
    ON FPRSH.MNG_NO = FPRSM.MNG_NO
    AND FPRSH.LATEST_FLG = '1'
    LEFT JOIN F_PAY_REQ_M FPRM
    
    ON FPRM.PAY_REQ_NO = FPRSM.PAY_REQ_NO
    AND FPRM.PAY_REQ_ADD_NO = FPRSM.PAY_REQ_ADD_NO
    AND FPRM.PAY_REQ_L_NO = FPRSM.PAY_REQ_L_NO
    AND FPRM.DELETE_FLG = '0'
  WHERE
    FPRSM.ORIG_DENPYO_TYPE = iORIG_DENPYO_TYPE
    AND FPRSM.ORIG_SLIP_NO = iORIG_SLIP_NO
    AND FPRSM.ORIG_SLIP_ADD_NO = iORIG_SLIP_ADD_NO
    AND FPRSM.ORIG_SLIP_ADD_KEY LIKE NVL(iORIG_SLIP_ADD_KEY, '%')
    GROUP BY FPRSM.MNG_NO
;

--�x���v���f�[�^����
CURSOR GET_PAY_REQ
(
  --�Ǘ��ԍ� (FK)
  iWK_MNG_NO     IN   F_PAY_REQ_M.PAY_REQ_NO%TYPE
) IS
  SELECT
    FPRSM.MNG_NO,
    FPRSM.MNG_L_NO,
    CASE WHEN FPRSH.DELETE_FLG = '1' OR FPRSM.DELETE_FLG = '1' THEN
      '1'
    ELSE
      '0'
    END AS DELETE_FLG,
    FPRSH.SYORI_STAT_CODE,
    FPRM.PAY_COMP_FLG

  FROM F_PAY_REQ_S_M FPRSM
  
    INNER JOIN F_PAY_REQ_S_H FPRSH
    ON FPRSH.MNG_NO = FPRSM.MNG_NO
    AND FPRSH.LATEST_FLG = '1'
    LEFT JOIN F_PAY_REQ_M FPRM
    
    ON FPRM.PAY_REQ_NO = FPRSM.PAY_REQ_NO
    AND FPRM.PAY_REQ_ADD_NO = FPRSM.PAY_REQ_ADD_NO
    AND FPRM.PAY_REQ_L_NO = FPRSM.PAY_REQ_L_NO
    AND FPRM.DELETE_FLG = '0'
  WHERE
    FPRSM.MNG_NO = iWK_MNG_NO
;
--�x���v���f�[�^���R�[�h�̔z��
TYPE T_PAY_REQ IS TABLE OF GET_PAY_REQ%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_PAY_REQ       T_PAY_REQ;
--�x���v���f�[�^���R�[�h�z��̓Y����
N_PAY_REQ_IDX    INTEGER(10);
--�x���v���f�[�^���R�[�h�̂P���R�[�h���G���A
R_PAY_REQ_TBL    GET_PAY_REQ%ROWTYPE;

/**********************************************************
*** �@�\���́F�����K�{�ݒ�`�F�b�N����
*** �����P  �F��������
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
  IF I_DENPYO_TYPE IS NULL THEN
    ERR_PARAM_NM := '�`�[���';
    --�G���[���O�o��
    P_LOG_ERROR(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j');

  END IF;
  IF I_ORIG_DENPYO_NO IS NULL THEN
    ERR_PARAM_NM := '�������`�[�ԍ�';
    --�G���[���O�o��
    P_LOG_ERROR(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j');
  END IF;
  IF I_ORIG_DENPYO_ADD_NO IS NULL THEN
    ERR_PARAM_NM := '�������`�[�ǔ�';
    --�G���[���O�o��
    P_LOG_ERROR(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�K�{�̈������ݒ肳��Ă��܂���B�i'|| ERR_PARAM_NM || '�j');
  END IF;
  
  --��ł��ݒ肳��Ă��Ȃ��ꍇ
  IF ERR_PARAM_NM IS NOT NULL THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '�x���󋵃`�F�b�N�֐��ɂĈ����G���[���������܂����B';
    RETURN;
  END IF;
  
END SP_CHK_PARAM;


BEGIN
--�又���[S

  --�o�͏�����
  RETURN_CODE := '0';
  ERR_MSG_ID := '';
  ERR_MSG_CHR := '';
  SIHARAI_STATE := '';
  SIHARAI_KG :=0;

  --1. �����K�{�ݒ�`�F�b�N
  SP_CHK_PARAM(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;
  
  BEGIN

    --2. �x���ϋ��z�̍��v�l���擾����
    OPEN GET_SUM_PAYD_AMOUNT(I_DENPYO_TYPE,
                             I_ORIG_DENPYO_NO,
                             I_ORIG_DENPYO_ADD_NO,
                             I_ORIG_DENPYO_ADD_KEY);

    FETCH GET_SUM_PAYD_AMOUNT INTO
      WK_MNG_NO,
      WK_PAID_AMOUNT
    ;
    CLOSE GET_SUM_PAYD_AMOUNT;

    --�f�[�^���擾�ł��Ȃ��ꍇ
    IF WK_MNG_NO IS NULL THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '�Ώۂ̎x���v���\���f�[�^���쐬����Ă��܂���B';
      SIHARAI_STATE := '';
      SIHARAI_KG := 0;
      RETURN;      
    END IF;

    N_PAY_REQ_IDX := 1;
    --�x���v���f�[�^���R�[�h�z��̏�����
    WK_PAY_REQ.DELETE;

    --�x���v���f�[�^����
    OPEN GET_PAY_REQ(WK_MNG_NO);
    LOOP
      FETCH GET_PAY_REQ INTO WK_PAY_REQ(N_PAY_REQ_IDX);

      --�ŏI���R�[�h�̏ꍇ�I��
      EXIT WHEN GET_PAY_REQ%NOTFOUND;
      N_PAY_REQ_IDX := N_PAY_REQ_IDX + 1;
    END LOOP;
    CLOSE GET_PAY_REQ;
    
    --�擾�ł��Ȃ��ꍇ
    IF WK_PAY_REQ IS NULL OR WK_PAY_REQ.COUNT = 0 THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '�Ώۂ̎x���v���\���f�[�^���쐬����Ă��܂���B';
      SIHARAI_STATE := '';
      SIHARAI_KG := 0;
      RETURN;
    END IF;

    --������
    WK_PAY_COMP_FLG := '1';
    
    FOR PAT_IDX IN 1 .. WK_PAY_REQ.COUNT LOOP
      R_PAY_REQ_TBL := WK_PAY_REQ(PAT_IDX);
      
      --�x���v���\���w�b�_.�����X�e�[�^�X
      WK_SYORI_STAT_CODE := R_PAY_REQ_TBL.SYORI_STAT_CODE;
      
      --�폜�t���O
      IF R_PAY_REQ_TBL.DELETE_FLG = '1' THEN
        WK_DELETE_FLG := '1';
      END IF;
      
      --�x���v�����ׁD�x�������t���O
      IF R_PAY_REQ_TBL.PAY_COMP_FLG = '0' THEN
        WK_PAY_COMP_FLG := '0';
      END IF;
      
    END LOOP;

        
    --����\��w�b�_�A�܂��͉���\�薾�ׂ̍폜�t���O��"1"�̏ꍇ
    IF WK_DELETE_FLG = '1' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '�Ώۂ̎x���v���\���f�[�^���폜����Ă��܂��B';       
      SIHARAI_STATE := '';
      SIHARAI_KG := 0;
      RETURN;
    END IF;
    
    --�x���v���\���w�b�_.�����X�e�[�^�X���쐬�ς̏ꍇ�A
    IF WK_SYORI_STAT_CODE = '00' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '1'; --�u�\���O�v
      SIHARAI_KG := 0;
      RETURN;
    END IF;

    --�x���v���\���w�b�_.�����X�e�[�^�X���㒷���ّҁA���咷���ّҁA���ٍρA���߂��̏ꍇ�A
    IF WK_SYORI_STAT_CODE = '01'
       OR WK_SYORI_STAT_CODE = '02'
       OR WK_SYORI_STAT_CODE = '03'
       OR WK_SYORI_STAT_CODE = '05' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '2'; --�u�\���ρv
      SIHARAI_KG := 0;
      RETURN;
    END IF;

    --�x���v���\���w�b�_.�����X�e�[�^�X����v��t�ρA���A�x���v�����ׁD�x�������t���O��OFF�A
    --���x���v������.�x���ϋ��z�̍��v�l��0�̏ꍇ�A
    IF WK_SYORI_STAT_CODE = '04'
       AND WK_PAY_COMP_FLG = '0'
       AND WK_PAID_AMOUNT = 0 THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '3'; --�u���x���v
      SIHARAI_KG := WK_PAID_AMOUNT;
      RETURN;
    END IF;

    --�x���v���\���w�b�_.�����X�e�[�^�X����v��t�ρA���A�x���v�����ׁD�x�������t���O��OFF�A
    --���x���v������.�x���ϋ��z�̍��v�l��0�ȊO�̏ꍇ�A
    IF WK_SYORI_STAT_CODE = '04'
       AND WK_PAY_COMP_FLG = '0'
       AND WK_PAID_AMOUNT <> 0 THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '4'; --�u�ꕔ�x���ρv
      SIHARAI_KG := WK_PAID_AMOUNT;
      RETURN;
    END IF;
    
    --�x���v���\���w�b�_.�����X�e�[�^�X����v��t�ρA���A�x���v�����ׁD�x�������t���O��ON�̏ꍇ�A
    IF WK_SYORI_STAT_CODE = '04'
       AND WK_PAY_COMP_FLG = '1' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '5'; --�u�x�������v
      SIHARAI_KG := WK_PAID_AMOUNT;
      RETURN;
    END IF;
    
  END;
  
  EXCEPTION
    WHEN OTHERS THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '�x���󋵃`�F�b�N�֐��ɂăV�X�e����O�G���[���������܂����B';
      --�G���[���O�o��
      BEGIN
      
        P_LOG_ERROR(I_G_USR_CODE,
              I_G_TERM_NAME,
              I_G_FUNC_ID,
              SQLERRM);
        EXCEPTION

            WHEN OTHERS THEN
                NULL;
      END;
--�又���[E
END ZSM0030B;
/
