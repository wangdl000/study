CREATE OR REPLACE PROCEDURE ZSK0040B
/********************************************************
 *  �@�\�T�v�F
 *    ����\��f�[�^�ɑ΂������󋵂̃`�F�b�N���s���B
 *  �����P   �F�`�[��ʁi���́j
 *  �����Q   �F�������`�[�ԍ��i���́j
 *  �����R   �F�������`�[�ǔԁi���́j
 *  �����S   �F�������`�[�ǉ��L�[�i���́j
 *  �����T   �F�O���[�o�����.���[�U�R�[�h
 *  �����U   �F�O���[�o�����.�v���O����ID
 *  �����V   �F�O���[�o�����.�[����
 *  �����W   �F�������ʁi0:����I���A1:�ُ�I���j
 *  �����X   �F�G���[���b�Z�[�W�i�o�́j
 *  �����P�O �F���ߍ��ݕ����i�o�́j
 *  �����P�P �F����󋵁i�o�́j
 *  �����P�Q �F����ϋ��z�i�o�́j
 *  �����P�R �F�O����g�p�z�i�o�́j
 *******************************************************/
(
  --�`�[���
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
  COL_STATUS            OUT  CHAR,
  COLTD_AMOUNT          OUT  NUMBER,
  PRE_REC_USE_AMOUNT    OUT  NUMBER

) IS
  -- �ϐ��錾��
  ERR_PARAM_NM            VARCHAR2(14);                                -- �ݒ肳��Ă��Ȃ�������
  WK_DELETE_FLG           CHAR(1);                                     -- �폜�t���O
  WK_BILL_FIX_FLG         F_COL_SCHED_H.BILL_FIX_FLG%TYPE;             -- ����\��w�b�_.�����m��t���O
  WK_SINSEICHU_FLG        F_COL_SCHED_H.SINSEICHU_FLG%TYPE;            -- ����\��w�b�_.�\�����t���O
  WK_HAVE_SINSEI_FLG      CHAR(1);                                     -- ����\���̓������ѐ\���i���m��j�̃f�[�^���݃t���O(0�F���݂Ȃ��A1:����)
  WK_COLTD_AMOUNT         F_COL_SCHED_M.COLTD_AMOUNT%TYPE;             -- ����ϋ��z
  WK_PRE_REC_USE_AMOUNT   F_COL_SCHED_M.PRE_REC_USE_AMOUNT%TYPE;       -- �O����g�p�z
  WK_HAVE_HIST_FLG        CHAR(1);                                     -- ����\����������̃f�[�^���݃t���O�i0�F���݂Ȃ��A1�F���݁j
  WK_SUM_REC_AMOUNT       F_COL_SCHED_REC_HIST.REC_AMOUNT%TYPE;        -- ����\���������.������z���v
  WK_COL_COMP_FLG         F_COL_SCHED_M.COL_COMP_FLG%TYPE;             -- ����\�薾��.��������t���O
  --ADD BY DTT AT 2009/09/21 START
  SyoriResult             NUMBER;
  ERRLOGGER_EXCEPT        EXCEPTION;
  --ADD BY DTT AT 2009/09/21 END

--����\����������̃f�[�^���݃t���O�Ɖ���\����������̉�����z���v���擾����
CURSOR GET_SUM_REC_AMOUNT
IS
  SELECT
    FCSM.COL_SCHED_NO,
    FCSM.COL_SCHED_ADD_NO,
    FCSH.BILL_FIX_FLG,
    FCSH.SINSEICHU_FLG,
    CASE WHEN SUM(FCSRH.REC_AMOUNT) IS NULL THEN '0' ELSE '1' END AS HAVE_HIST_FLG,
    SUM(NVL(FCSRH.REC_AMOUNT, 0)) AS REC_AMOUT
  FROM F_COL_SCHED_M FCSM
    INNER JOIN F_COL_SCHED_H FCSH 
    ON FCSH.COL_SCHED_NO = FCSM.COL_SCHED_NO
    AND FCSH.COL_SCHED_ADD_NO = FCSM.COL_SCHED_ADD_NO
    LEFT JOIN F_COL_SCHED_REC_HIST FCSRH
    ON FCSRH.COL_SCHED_NO  = FCSM.COL_SCHED_NO
    AND FCSRH.COL_SCHED_ADD_NO = FCSM.COL_SCHED_ADD_NO
    --UPDATE BY DTT AT 2009/09/21 START
    --AND FCSRH.COL_SCHED_M_NO = FCSM.COL_SHCED_M_NO
    AND FCSRH.COL_SCHED_M_NO = FCSM.COL_SCHED_M_NO
    --UPDATE BY DTT AT 2009/09/21 END
    AND FCSRH.DELETE_FLG = '0'
  WHERE
    FCSM.ORIG_DENPYO_TYPE = I_DENPYO_TYPE
    AND FCSM.ORIG_DENPYO_NO = I_ORIG_DENPYO_NO
    AND FCSM.ORIG_DENPYO_ADD_NO = I_ORIG_DENPYO_ADD_NO
    AND (FCSM.ORIG_DENPYO_ADD_KEY LIKE NVL(I_ORIG_DENPYO_ADD_KEY, '%')
         OR (FCSM.ORIG_DENPYO_ADD_KEY IS NULL AND I_ORIG_DENPYO_ADD_KEY IS NULL))
  GROUP BY FCSM.COL_SCHED_NO,
    FCSM.COL_SCHED_ADD_NO,
    FCSH.BILL_FIX_FLG,
    FCSH.SINSEICHU_FLG
;
--����\��f�[�^���R�[�h�̔z��
TYPE T_SUM_REC_AMOUNT IS TABLE OF GET_SUM_REC_AMOUNT%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_SUM_REC_AMOUNT_TBL       T_SUM_REC_AMOUNT;
--����\��f�[�^���R�[�h�z��̓Y����
N_SUM_REC_AMOUNT_IDX    INTEGER(10);
--����\��f�[�^���R�[�h�̂P���R�[�h���G���A
R_SUM_REC_AMOUNT_TBL    GET_SUM_REC_AMOUNT%ROWTYPE;

--����ϋ��z �O����g�p�z���擾����
CURSOR GET_SUM_MEISEI_AMOUNT
 IS
  SELECT
    SUM(FCSM.COLTD_AMOUNT) AS COLTD_AMOUNT,
    SUM(FCSM.PRE_REC_USE_AMOUNT) AS PRE_REC_USE_AMOUNT
  FROM F_COL_SCHED_M FCSM
    INNER JOIN F_COL_SCHED_H FCSH 
    ON FCSH.COL_SCHED_NO = FCSM.COL_SCHED_NO
    AND FCSH.COL_SCHED_ADD_NO = FCSM.COL_SCHED_ADD_NO
  WHERE
    FCSM.ORIG_DENPYO_TYPE = I_DENPYO_TYPE
    AND FCSM.ORIG_DENPYO_NO = I_ORIG_DENPYO_NO
    AND FCSM.ORIG_DENPYO_ADD_NO = I_ORIG_DENPYO_ADD_NO
    AND (FCSM.ORIG_DENPYO_ADD_KEY LIKE NVL(I_ORIG_DENPYO_ADD_KEY, '%')
         OR (FCSM.ORIG_DENPYO_ADD_KEY IS NULL AND I_ORIG_DENPYO_ADD_KEY IS NULL))
;


--����\��f�[�^���擾����
CURSOR GET_F_COL_SCHED
IS
  SELECT
    FCSM.COL_SCHED_NO,
    FCSM.COL_SCHED_ADD_NO,
    --UPDATE BY DTT AT 2009/09/21 START
    --FCSM.COL_SHCED_M_NO,
    FCSM.COL_SCHED_M_NO,
    --UPDATE BY DTT AT 2009/09/21 END
    CASE WHEN FCSH.DELETE_FLG = '1' OR FCSM.DELETE_FLG = '1' THEN
      '1'
    ELSE
      '0'
    END AS DELETE_FLG,
    FCSM.COL_COMP_FLG,
    FRRS.MNG_NO AS FRRSMNG_NO --����\���������.�Ǘ��ԍ�
  FROM F_COL_SCHED_M FCSM
    INNER JOIN F_COL_SCHED_H FCSH 
    ON FCSH.COL_SCHED_NO = FCSM.COL_SCHED_NO
    AND FCSH.COL_SCHED_ADD_NO = FCSM.COL_SCHED_ADD_NO
    LEFT JOIN F_COL_SCHED_REC_HIST FCSRH
    ON FCSRH.COL_SCHED_NO  = FCSM.COL_SCHED_NO
    AND FCSRH.COL_SCHED_ADD_NO = FCSM.COL_SCHED_ADD_NO
    --UPDATE BY DTT AT 2009/09/21 START
    --AND FCSRH.COL_SCHED_M_NO = FCSM.COL_SHCED_M_NO
    AND FCSRH.COL_SCHED_M_NO = FCSM.COL_SCHED_M_NO
    --UPDATE BY DTT AT 2009/09/21 END
    AND FCSRH.DELETE_FLG = '0'
    LEFT JOIN F_REC_RSLT_S FRRS
    ON FRRS.REC_RSLT_NO = FCSRH.REC_RSLT_NO
    AND FRRS.SINSEI_KBN = '3' --�u����\���v
    AND FRRS.SYORI_STAT_CODE <> '05' --�u�m��ρv
    AND FRRS.DELETE_FLG = '0'
    LEFT JOIN F_REC_RSLT FRR
    ON FRR.REC_RSLT_NO = FCSRH.REC_RSLT_NO
  WHERE
    FCSM.ORIG_DENPYO_TYPE = I_DENPYO_TYPE
    AND FCSM.ORIG_DENPYO_NO = I_ORIG_DENPYO_NO
    AND FCSM.ORIG_DENPYO_ADD_NO = I_ORIG_DENPYO_ADD_NO
    AND (FCSM.ORIG_DENPYO_ADD_KEY LIKE NVL(I_ORIG_DENPYO_ADD_KEY, '%')
         OR (FCSM.ORIG_DENPYO_ADD_KEY IS NULL AND I_ORIG_DENPYO_ADD_KEY IS NULL))
;
--����\��f�[�^���R�[�h�̔z��
TYPE T_F_COL_SCHED IS TABLE OF GET_F_COL_SCHED%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_F_COL_SCHED       T_F_COL_SCHED;
--����\��f�[�^���R�[�h�z��̓Y����
N_F_COL_SCHED_IDX    INTEGER(10);
--����\��f�[�^���R�[�h�̂P���R�[�h���G���A
R_F_COL_SCHED_TBL    GET_F_COL_SCHED%ROWTYPE;

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
    --UPDATE BY DTT AT 2009/09/21 START
    --    P_LOG_ERROR(I_G_USR_CODE,
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
    --    P_LOG_ERROR(I_G_USR_CODE,
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
    --    P_LOG_ERROR(I_G_USR_CODE,
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
    ERR_MSG_CHR := '����󋵃`�F�b�N�֐��ɂĈ����G���[���������܂����B';
    RETURN;
  END IF;
  
END SP_CHK_PARAM;


BEGIN
--�又���[S
  --�o�͏�����
  RETURN_CODE := '0';
  ERR_MSG_ID := '';
  ERR_MSG_CHR := '';
  --COL_STATUS := '';
  --COLTD_AMOUNT :=0;
  --PRE_REC_USE_AMOUNT := 0;

  --1. �����K�{�ݒ�`�F�b�N
  SP_CHK_PARAM(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;
  
  --2. ����\��f�[�^����
  --����\����������̃f�[�^���݃t���O�Ɖ���\����������̉�����z���v���擾����
  N_SUM_REC_AMOUNT_IDX := 1;
  --����\����������̉�����z���v���R�[�h�z��̏�����
  WK_SUM_REC_AMOUNT_TBL.DELETE;  

  OPEN GET_SUM_REC_AMOUNT;
  LOOP
  FETCH GET_SUM_REC_AMOUNT INTO WK_SUM_REC_AMOUNT_TBL(N_SUM_REC_AMOUNT_IDX);

  --�ŏI���R�[�h�̏ꍇ�I��
  EXIT WHEN GET_SUM_REC_AMOUNT%NOTFOUND;
  N_SUM_REC_AMOUNT_IDX := N_SUM_REC_AMOUNT_IDX + 1;

  END LOOP;
  CLOSE GET_SUM_REC_AMOUNT;
  
    --�f�[�^���擾�ł��Ȃ��ꍇ
  IF WK_SUM_REC_AMOUNT_TBL IS NULL OR WK_SUM_REC_AMOUNT_TBL.COUNT = 0 THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '����󋵃`�F�b�N�֐��ɂăG���[���������܂����B�i�Ώۂ̉���\��f�[�^�����݂��܂���B�j';
    RETURN;      
  END IF; 

  --����ϋ��z �O����g�p�z���擾����
  OPEN GET_SUM_MEISEI_AMOUNT;
  FETCH GET_SUM_MEISEI_AMOUNT INTO
    WK_COLTD_AMOUNT,
    WK_PRE_REC_USE_AMOUNT
  ;
  CLOSE GET_SUM_MEISEI_AMOUNT;  
  
  N_F_COL_SCHED_IDX := 1;
  --����\��f�[�^���R�[�h�z��̏�����
  WK_F_COL_SCHED.DELETE;
  
  --����\��f�[�^����
  OPEN GET_F_COL_SCHED;
  LOOP
    FETCH GET_F_COL_SCHED INTO WK_F_COL_SCHED(N_F_COL_SCHED_IDX);
    --�ŏI���R�[�h�̏ꍇ�I��
    EXIT WHEN GET_F_COL_SCHED%NOTFOUND;
    N_F_COL_SCHED_IDX := N_F_COL_SCHED_IDX + 1;
  END LOOP;
  CLOSE GET_F_COL_SCHED;

  IF WK_F_COL_SCHED IS NULL OR WK_F_COL_SCHED.COUNT = 0 THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '����󋵃`�F�b�N�֐��ɂăG���[���������܂����B�i�Ώۂ̉���\��f�[�^�����݂��܂���B�j';
    RETURN;      
  END IF;
  
  WK_SUM_REC_AMOUNT := 0;
  WK_HAVE_HIST_FLG := '0';
  FOR PAT_IDX IN 1 .. WK_SUM_REC_AMOUNT_TBL.COUNT LOOP
    R_SUM_REC_AMOUNT_TBL := WK_SUM_REC_AMOUNT_TBL(PAT_IDX);
    
    WK_SUM_REC_AMOUNT := WK_SUM_REC_AMOUNT + R_SUM_REC_AMOUNT_TBL.REC_AMOUT;
    IF R_SUM_REC_AMOUNT_TBL.HAVE_HIST_FLG = '1' THEN
      WK_HAVE_HIST_FLG := '1';
    END IF;
    
    IF R_SUM_REC_AMOUNT_TBL.BILL_FIX_FLG = '0' THEN
      WK_BILL_FIX_FLG := '0';
    END IF;
    
    IF R_SUM_REC_AMOUNT_TBL.SINSEICHU_FLG = '0' THEN
      WK_SINSEICHU_FLG := '0';
    END IF;
    
  END LOOP;  

  --����p���ڒl��ݒ肷��B
  --��������t���O������
  WK_COL_COMP_FLG := '1';
  
  FOR PAT_IDX IN 1 .. WK_F_COL_SCHED.COUNT LOOP
    R_F_COL_SCHED_TBL := WK_F_COL_SCHED(PAT_IDX);
    
    --�폜�t���O
    IF R_F_COL_SCHED_TBL.DELETE_FLG = '1' THEN
      WK_DELETE_FLG := '1';
    END IF;
    
    --��������t���O
    IF R_F_COL_SCHED_TBL.COL_COMP_FLG <> '1' THEN
      WK_COL_COMP_FLG := '0';
    END IF;
    
    --����\���̓������ѐ\���i���m��j�̃f�[�^���݃t���O
    IF R_F_COL_SCHED_TBL.FRRSMNG_NO IS NOT NULL THEN
      WK_HAVE_SINSEI_FLG := '1';
    END IF;
    
  END LOOP;  

  --����\��w�b�_�A�܂��͉���\�薾�ׂ̍폜�t���O��"1"�̏ꍇ
  IF WK_DELETE_FLG = '1' THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '����󋵃`�F�b�N�֐��ɂăG���[���������܂����B�i�Ώۂ̉���\��f�[�^���폜����Ă��܂��B�j';       
    RETURN;
  END IF;
  
  -- ����\��w�b�_.�����m��t���O��OFF�A������\��w�b�_.�\�����t���O��OFF�̏ꍇ
  IF WK_BILL_FIX_FLG = '0' AND WK_SINSEICHU_FLG = '0' THEN
    COL_STATUS := '7'; --�u�������m��v
    COLTD_AMOUNT := 0;
    PRE_REC_USE_AMOUNT := 0;
    RETURN;
  END IF;
  
  --����\���̓������ѐ\���i���m��j�̃f�[�^�����݂���ꍇ
  IF WK_HAVE_SINSEI_FLG = '1' THEN
    COL_STATUS := '6';  --�u�������ю�����v
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  -- ����\����������̃f�[�^�����݂��A
  -- ����\�薾��.����ϋ��z�Ɖ���\����������̉�����z���v����v���Ȃ��ꍇ�A
  IF WK_HAVE_HIST_FLG = '1' AND NVL(WK_COLTD_AMOUNT, 0) <> NVL(WK_SUM_REC_AMOUNT, 0) THEN
    COL_STATUS := '5'; --�u�����������v
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  -- ����\��w�b�_.�\�����t���O��ON�̏ꍇ
  IF WK_SINSEICHU_FLG = '1' THEN
    COL_STATUS := '4'; -- �u����\��������v
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  -- ����\�薾��.��������t���O��ON�̏ꍇ
  IF WK_COL_COMP_FLG = '1' THEN
    COL_STATUS := '3'; -- �u��������v
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  --����\�薾��.��������t���O��OFF�A������\����������̉�����z���v���O�ȊO�̏ꍇ�A
  IF WK_COL_COMP_FLG = '0' AND NVL(WK_SUM_REC_AMOUNT, 0) <> 0 THEN
    COL_STATUS := '2'; -- �u������ρv
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  --����\�薾��.��������t���O��OFF�A������\����������̉�����z���v���O�̏ꍇ
  IF WK_COL_COMP_FLG = '0' AND NVL(WK_SUM_REC_AMOUNT, 0) = 0 THEN
    COL_STATUS := '1'; -- �u������v
    COLTD_AMOUNT := 0;
    PRE_REC_USE_AMOUNT := 0;
    RETURN;
  END IF;
  
  EXCEPTION
    WHEN OTHERS THEN

      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '����󋵃`�F�b�N�֐��ɂăV�X�e����O�G���[���������܂����B';
      
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
END ZSK0040B;
/
