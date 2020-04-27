CREATE OR REPLACE PROCEDURE P_KK_GETDENNO
/********************************************************
 *  �@�\�T�v�F
 *    �`�[�ԍ��̔Ԋ֐�
 *  �����P   �F�`�[��ʁi���́j
 *  �����Q   �F����R�[�h�i���́j
 *  �����R   �F�N�x�i���́j
 *  �����S   �F���[�U�[�R�[�h�i���́j
 *  �����T �@�F�O���[�o�����.�v���O����ID
 *  �����U   �F�O���[�o�����.�[����
 *  �����V   �F�`�[�ԍ��i�o�́j
 *******************************************************/
(
  I_DENPYO_TYPE   IN    CHAR,
  I_BMN_CODE      IN    CHAR,
  I_NENDO         IN    CHAR,
  I_USR_CODE      IN    CHAR,
  I_G_FUNC_ID     IN    CHAR,
  I_G_TERM_NAME   IN    VARCHAR2,
  O_DEN_NO        OUT   VARCHAR2
) IS

  -- �ϐ��錾��
  WK_DENPYO_TYPE     M_DENBAN.DENPYO_TYPE%TYPE;   --�`�[���
  WK_BMN_CODE        M_DENBAN.BMN_CODE%TYPE;      --����R�[�h
  WK_NENDO           M_DENBAN.NENDO%TYPE;         --�N�x
  WK_DENPYO_REN      M_DENBAN.DENPYO_REN%TYPE;    --�`�[�ԍ�
  WK_DENPYO_START    M_DENBAN.DENPYO_START%TYPE;  --�`�[�ԍ��J�n
  WK_DENPYO_END      M_DENBAN.DENPYO_END%TYPE;    --�`�[�ԍ��I��

       
PROCEDURE P_UPD_DENNO IS
BEGIN
  UPDATE M_DENBAN 
     SET 
         DENPYO_REN    = WK_DENPYO_REN
        ,MAKE_TIME     = SYSTIMESTAMP
        ,MAKE_USR_CODE = NVL(I_USR_CODE, '999999')
   WHERE DENPYO_TYPE = I_DENPYO_TYPE 
     AND BMN_CODE = I_BMN_CODE 
     AND NENDO = I_NENDO;
  EXCEPTION
    WHEN OTHERS THEN
      O_DEN_NO := '-9';
      P_LOG_ERROR(I_USR_CODE,
                  I_G_TERM_NAME,
                  I_G_FUNC_ID,
                  '�`�[�ԍ��̍X�V�ŃG���[���������܂����B');
      RETURN;

END P_UPD_DENNO;

BEGIN
  BEGIN
    SELECT
       DENPYO_TYPE 
      ,BMN_CODE 
      ,NENDO 
      ,DENPYO_REN 
      ,DENPYO_START 
      ,DENPYO_END
        
    INTO
      WK_DENPYO_TYPE,
      WK_BMN_CODE,
      WK_NENDO,
      WK_DENPYO_REN,
      WK_DENPYO_START,
      WK_DENPYO_END
    FROM M_DENBAN 
    WHERE DENPYO_TYPE = I_DENPYO_TYPE 
      AND BMN_CODE = I_BMN_CODE 
      AND NENDO = I_NENDO 
      AND DELETE_FLG = '0' 
    FOR UPDATE NOWAIT;
    
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        O_DEN_NO := '-1';
        P_LOG_ERROR(I_USR_CODE,
                    I_G_TERM_NAME,
                    I_G_FUNC_ID,
                    '�`�[�ԍ��}�X�^�[�ɊY���f�[�^������܂���B');
        RETURN;
      WHEN OTHERS THEN
        O_DEN_NO := '-8';
        RETURN;
    
  END;
  --DENPYO_REN >= .DENPYO_END�̏ꍇ
  IF WK_DENPYO_REN >= WK_DENPYO_END THEN
    O_DEN_NO := '-2';
    P_LOG_ERROR(I_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�`�[�ԍ����ő�ԍ����傫���ł��B');
    RETURN;
  END IF;
  
  --DENPYO_REN < .DENPYO_START - 1�̏ꍇ 
  IF WK_DENPYO_REN < WK_DENPYO_START -1 THEN
    O_DEN_NO := '-3';
    P_LOG_ERROR(I_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '�`�[�ԍ����ŏ��ԍ���菬�����ł��B');
    RETURN;
  END IF;
  
  --�ϐ�@DENPYO_REN    = 1�Ŏ擾����DENPYO_REN�{�P
  WK_DENPYO_REN := WK_DENPYO_REN + 1;
  
  -- �`�[�ԍ��X�V����
  P_UPD_DENNO;
  IF O_DEN_NO = '-9' THEN
    RETURN;
  END IF;
  --�`�[��ʂ�50�i�d��ԍ��j�̏ꍇ
  IF I_DENPYO_TYPE = '50' THEN
    O_DEN_NO := I_BMN_CODE || SUBSTR(I_NENDO, 3, 4) || TO_CHAR(WK_DENPYO_REN, 'FM0000000');
  ELSE
    O_DEN_NO := I_BMN_CODE || SUBSTR(I_NENDO, 3, 4) || TO_CHAR(WK_DENPYO_REN, 'FM000000');
  END IF;
  
END;
/
