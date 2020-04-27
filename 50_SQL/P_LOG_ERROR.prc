CREATE OR REPLACE PROCEDURE P_LOG_ERROR
/********************************************************
 *  �v���V�[�W���F
 *    �G���[���O�o��
 *  �@�\�T�v�F
 *    �G���[���O�o�͂��s���B
 *  ����1       �F���[�U�R�[�h(���́A���O�p)
 *  ����2       �F�[����(���́A���O�p)
 *  ����3       �F�v���O����ID(���́A���O�p)
 *  ����4       �F�G���[���e(���́A���O�p)
*******************************************************/
(
    I_USR_CODE    IN CHAR,
    I_TERM_NAME   IN VARCHAR2,
    I_FUNC_ID     IN CHAR,
    I_ERROR_NAIYO IN T_LOG_ERROR.ERROR_NAIYO%TYPE
) IS
    --�����^�g�����U�N�V������錾����
    PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN

    INSERT INTO
        T_LOG_ERROR
    (
        SYS_NO,
        SYORI_TIME,
        USR_CODE,
        TERMINAL_NAME,
        FUNC_ID,
        ERROR_NAIYO,
        MAKE_TIME,
        MAKE_USR_CODE
    ) VALUES (
        S_KK_LOG_ERROR.NEXTVAL,                 --�V�X�e���A��
        SYSTIMESTAMP,                           --��������
        I_USR_CODE,                             --���[�U�[�R�[�h
        I_TERM_NAME,                            --�����[����
        I_FUNC_ID,                              --�@�\ID
        SUBSTRB(I_ERROR_NAIYO, 0, 2000),        --�G���[���e
        SYSTIMESTAMP,                           --�쐬����
        I_USR_CODE                              --�쐬���[�U�[�R�[�h
    );

    COMMIT;
END;
/
