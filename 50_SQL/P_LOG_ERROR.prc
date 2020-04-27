CREATE OR REPLACE PROCEDURE P_LOG_ERROR
/********************************************************
 *  プロシージャ：
 *    エラーログ出力
 *  機能概要：
 *    エラーログ出力を行う。
 *  引数1       ：ユーザコード(入力、ログ用)
 *  引数2       ：端末名(入力、ログ用)
 *  引数3       ：プログラムID(入力、ログ用)
 *  引数4       ：エラー内容(入力、ログ用)
*******************************************************/
(
    I_USR_CODE    IN CHAR,
    I_TERM_NAME   IN VARCHAR2,
    I_FUNC_ID     IN CHAR,
    I_ERROR_NAIYO IN T_LOG_ERROR.ERROR_NAIYO%TYPE
) IS
    --自律型トランザクションを宣言する
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
        S_KK_LOG_ERROR.NEXTVAL,                 --システム連番
        SYSTIMESTAMP,                           --処理日時
        I_USR_CODE,                             --ユーザーコード
        I_TERM_NAME,                            --処理端末名
        I_FUNC_ID,                              --機能ID
        SUBSTRB(I_ERROR_NAIYO, 0, 2000),        --エラー内容
        SYSTIMESTAMP,                           --作成日時
        I_USR_CODE                              --作成ユーザーコード
    );

    COMMIT;
END;
/
