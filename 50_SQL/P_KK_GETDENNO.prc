CREATE OR REPLACE PROCEDURE P_KK_GETDENNO
/********************************************************
 *  機能概要：
 *    伝票番号採番関数
 *  引数１   ：伝票種別（入力）
 *  引数２   ：部門コード（入力）
 *  引数３   ：年度（入力）
 *  引数４   ：ユーザーコード（入力）
 *  引数５ 　：グローバル情報.プログラムID
 *  引数６   ：グローバル情報.端末名
 *  引数７   ：伝票番号（出力）
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

  -- 変数宣言部
  WK_DENPYO_TYPE     M_DENBAN.DENPYO_TYPE%TYPE;   --伝票種別
  WK_BMN_CODE        M_DENBAN.BMN_CODE%TYPE;      --部門コード
  WK_NENDO           M_DENBAN.NENDO%TYPE;         --年度
  WK_DENPYO_REN      M_DENBAN.DENPYO_REN%TYPE;    --伝票番号
  WK_DENPYO_START    M_DENBAN.DENPYO_START%TYPE;  --伝票番号開始
  WK_DENPYO_END      M_DENBAN.DENPYO_END%TYPE;    --伝票番号終了

       
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
                  '伝票番号の更新でエラーが発生しました。');
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
                    '伝票番号マスターに該当データがありません。');
        RETURN;
      WHEN OTHERS THEN
        O_DEN_NO := '-8';
        RETURN;
    
  END;
  --DENPYO_REN >= .DENPYO_ENDの場合
  IF WK_DENPYO_REN >= WK_DENPYO_END THEN
    O_DEN_NO := '-2';
    P_LOG_ERROR(I_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '伝票番号が最大番号より大きいです。');
    RETURN;
  END IF;
  
  --DENPYO_REN < .DENPYO_START - 1の場合 
  IF WK_DENPYO_REN < WK_DENPYO_START -1 THEN
    O_DEN_NO := '-3';
    P_LOG_ERROR(I_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '伝票番号が最小番号より小さいです。');
    RETURN;
  END IF;
  
  --変数@DENPYO_REN    = 1で取得したDENPYO_REN＋１
  WK_DENPYO_REN := WK_DENPYO_REN + 1;
  
  -- 伝票番号更新処理
  P_UPD_DENNO;
  IF O_DEN_NO = '-9' THEN
    RETURN;
  END IF;
  --伝票種別が50（仕訳番号）の場合
  IF I_DENPYO_TYPE = '50' THEN
    O_DEN_NO := I_BMN_CODE || SUBSTR(I_NENDO, 3, 4) || TO_CHAR(WK_DENPYO_REN, 'FM0000000');
  ELSE
    O_DEN_NO := I_BMN_CODE || SUBSTR(I_NENDO, 3, 4) || TO_CHAR(WK_DENPYO_REN, 'FM000000');
  END IF;
  
END;
/
