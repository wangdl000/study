CREATE OR REPLACE PROCEDURE ZSK0040B
/********************************************************
 *  機能概要：
 *    回収予定データに対する回収状況のチェックを行う。
 *  引数１   ：伝票種別（入力）
 *  引数２   ：発生元伝票番号（入力）
 *  引数３   ：発生元伝票追番（入力）
 *  引数４   ：発生元伝票追加キー（入力）
 *  引数５   ：グローバル情報.ユーザコード
 *  引数６   ：グローバル情報.プログラムID
 *  引数７   ：グローバル情報.端末名
 *  引数８   ：処理結果（0:正常終了、1:異常終了）
 *  引数９   ：エラーメッセージ（出力）
 *  引数１０ ：埋め込み文字（出力）
 *  引数１１ ：回収状況（出力）
 *  引数１２ ：回収済金額（出力）
 *  引数１３ ：前受金使用額（出力）
 *******************************************************/
(
  --伝票種別
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
  -- 変数宣言部
  ERR_PARAM_NM            VARCHAR2(14);                                -- 設定されていない引数名
  WK_DELETE_FLG           CHAR(1);                                     -- 削除フラグ
  WK_BILL_FIX_FLG         F_COL_SCHED_H.BILL_FIX_FLG%TYPE;             -- 回収予定ヘッダ.請求確定フラグ
  WK_SINSEICHU_FLG        F_COL_SCHED_H.SINSEICHU_FLG%TYPE;            -- 回収予定ヘッダ.申請中フラグ
  WK_HAVE_SINSEI_FLG      CHAR(1);                                     -- 取消申請の入金実績申請（未確定）のデータ存在フラグ(0：存在なし、1:存在)
  WK_COLTD_AMOUNT         F_COL_SCHED_M.COLTD_AMOUNT%TYPE;             -- 回収済金額
  WK_PRE_REC_USE_AMOUNT   F_COL_SCHED_M.PRE_REC_USE_AMOUNT%TYPE;       -- 前受金使用額
  WK_HAVE_HIST_FLG        CHAR(1);                                     -- 回収予定入金履歴のデータ存在フラグ（0：存在なし、1：存在）
  WK_SUM_REC_AMOUNT       F_COL_SCHED_REC_HIST.REC_AMOUNT%TYPE;        -- 回収予定入金履歴.回収金額合計
  WK_COL_COMP_FLG         F_COL_SCHED_M.COL_COMP_FLG%TYPE;             -- 回収予定明細.回収完了フラグ
  --ADD BY DTT AT 2009/09/21 START
  SyoriResult             NUMBER;
  ERRLOGGER_EXCEPT        EXCEPTION;
  --ADD BY DTT AT 2009/09/21 END

--回収予定入金履歴のデータ存在フラグと回収予定入金履歴の回収金額合計を取得する
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
--回収予定データレコードの配列
TYPE T_SUM_REC_AMOUNT IS TABLE OF GET_SUM_REC_AMOUNT%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_SUM_REC_AMOUNT_TBL       T_SUM_REC_AMOUNT;
--回収予定データレコード配列の添え字
N_SUM_REC_AMOUNT_IDX    INTEGER(10);
--回収予定データレコードの１レコード分エリア
R_SUM_REC_AMOUNT_TBL    GET_SUM_REC_AMOUNT%ROWTYPE;

--回収済金額 前受金使用額を取得する
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


--回収予定データを取得する
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
    FRRS.MNG_NO AS FRRSMNG_NO --回収予定入金履歴.管理番号
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
    AND FRRS.SINSEI_KBN = '3' --「取消申請」
    AND FRRS.SYORI_STAT_CODE <> '05' --「確定済」
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
--回収予定データレコードの配列
TYPE T_F_COL_SCHED IS TABLE OF GET_F_COL_SCHED%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_F_COL_SCHED       T_F_COL_SCHED;
--回収予定データレコード配列の添え字
N_F_COL_SCHED_IDX    INTEGER(10);
--回収予定データレコードの１レコード分エリア
R_F_COL_SCHED_TBL    GET_F_COL_SCHED%ROWTYPE;

/**********************************************************
*** 機能名称：引数必須設定チェック処理
*** 引数１  ：処理結果
**********************************************************/
PROCEDURE SP_CHK_PARAM
(
  RETURN_CODE OUT CHAR
) IS
BEGIN
  --設定されていない引数名の初期化
  ERR_PARAM_NM := '';

  RETURN_CODE := '0';
  
  --必須入力チェック
  IF I_DENPYO_TYPE IS NULL THEN
    ERR_PARAM_NM := '伝票種別';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --    P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
  END IF;
  IF I_ORIG_DENPYO_NO IS NULL THEN
    ERR_PARAM_NM := '発生元伝票番号';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --    P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
  --UPDATE BY DTT AT 2009/09/21 END
  END IF;
  IF I_ORIG_DENPYO_ADD_NO IS NULL THEN
    ERR_PARAM_NM := '発生元伝票追番';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --    P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
  END IF;
  
  --一つでも設定されていない場合
  IF ERR_PARAM_NM IS NOT NULL THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '回収状況チェック関数にて引数エラーが発生しました。';
    RETURN;
  END IF;
  
END SP_CHK_PARAM;


BEGIN
--主処理ーS
  --出力初期化
  RETURN_CODE := '0';
  ERR_MSG_ID := '';
  ERR_MSG_CHR := '';
  --COL_STATUS := '';
  --COLTD_AMOUNT :=0;
  --PRE_REC_USE_AMOUNT := 0;

  --1. 引数必須設定チェック
  SP_CHK_PARAM(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;
  
  --2. 回収予定データ検索
  --回収予定入金履歴のデータ存在フラグと回収予定入金履歴の回収金額合計を取得する
  N_SUM_REC_AMOUNT_IDX := 1;
  --回収予定入金履歴の回収金額合計レコード配列の初期化
  WK_SUM_REC_AMOUNT_TBL.DELETE;  

  OPEN GET_SUM_REC_AMOUNT;
  LOOP
  FETCH GET_SUM_REC_AMOUNT INTO WK_SUM_REC_AMOUNT_TBL(N_SUM_REC_AMOUNT_IDX);

  --最終レコードの場合終了
  EXIT WHEN GET_SUM_REC_AMOUNT%NOTFOUND;
  N_SUM_REC_AMOUNT_IDX := N_SUM_REC_AMOUNT_IDX + 1;

  END LOOP;
  CLOSE GET_SUM_REC_AMOUNT;
  
    --データが取得できない場合
  IF WK_SUM_REC_AMOUNT_TBL IS NULL OR WK_SUM_REC_AMOUNT_TBL.COUNT = 0 THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '回収状況チェック関数にてエラーが発生しました。（対象の回収予定データが存在しません。）';
    RETURN;      
  END IF; 

  --回収済金額 前受金使用額を取得する
  OPEN GET_SUM_MEISEI_AMOUNT;
  FETCH GET_SUM_MEISEI_AMOUNT INTO
    WK_COLTD_AMOUNT,
    WK_PRE_REC_USE_AMOUNT
  ;
  CLOSE GET_SUM_MEISEI_AMOUNT;  
  
  N_F_COL_SCHED_IDX := 1;
  --回収予定データレコード配列の初期化
  WK_F_COL_SCHED.DELETE;
  
  --回収予定データ検索
  OPEN GET_F_COL_SCHED;
  LOOP
    FETCH GET_F_COL_SCHED INTO WK_F_COL_SCHED(N_F_COL_SCHED_IDX);
    --最終レコードの場合終了
    EXIT WHEN GET_F_COL_SCHED%NOTFOUND;
    N_F_COL_SCHED_IDX := N_F_COL_SCHED_IDX + 1;
  END LOOP;
  CLOSE GET_F_COL_SCHED;

  IF WK_F_COL_SCHED IS NULL OR WK_F_COL_SCHED.COUNT = 0 THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '回収状況チェック関数にてエラーが発生しました。（対象の回収予定データが存在しません。）';
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

  --判定用項目値を設定する。
  --回収完了フラグ初期化
  WK_COL_COMP_FLG := '1';
  
  FOR PAT_IDX IN 1 .. WK_F_COL_SCHED.COUNT LOOP
    R_F_COL_SCHED_TBL := WK_F_COL_SCHED(PAT_IDX);
    
    --削除フラグ
    IF R_F_COL_SCHED_TBL.DELETE_FLG = '1' THEN
      WK_DELETE_FLG := '1';
    END IF;
    
    --回収完了フラグ
    IF R_F_COL_SCHED_TBL.COL_COMP_FLG <> '1' THEN
      WK_COL_COMP_FLG := '0';
    END IF;
    
    --取消申請の入金実績申請（未確定）のデータ存在フラグ
    IF R_F_COL_SCHED_TBL.FRRSMNG_NO IS NOT NULL THEN
      WK_HAVE_SINSEI_FLG := '1';
    END IF;
    
  END LOOP;  

  --回収予定ヘッダ、または回収予定明細の削除フラグが"1"の場合
  IF WK_DELETE_FLG = '1' THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '回収状況チェック関数にてエラーが発生しました。（対象の回収予定データが削除されています。）';       
    RETURN;
  END IF;
  
  -- 回収予定ヘッダ.請求確定フラグがOFF、且つ回収予定ヘッダ.申請中フラグがOFFの場合
  IF WK_BILL_FIX_FLG = '0' AND WK_SINSEICHU_FLG = '0' THEN
    COL_STATUS := '7'; --「請求未確定」
    COLTD_AMOUNT := 0;
    PRE_REC_USE_AMOUNT := 0;
    RETURN;
  END IF;
  
  --取消申請の入金実績申請（未確定）のデータが存在する場合
  IF WK_HAVE_SINSEI_FLG = '1' THEN
    COL_STATUS := '6';  --「入金実績取消中」
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  -- 回収予定入金履歴のデータが存在し、
  -- 回収予定明細.回収済金額と回収予定入金履歴の回収金額合計が一致しない場合、
  IF WK_HAVE_HIST_FLG = '1' AND NVL(WK_COLTD_AMOUNT, 0) <> NVL(WK_SUM_REC_AMOUNT, 0) THEN
    COL_STATUS := '5'; --「入金処理中」
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  -- 回収予定ヘッダ.申請中フラグがONの場合
  IF WK_SINSEICHU_FLG = '1' THEN
    COL_STATUS := '4'; -- 「回収予定訂正中」
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  -- 回収予定明細.回収完了フラグがONの場合
  IF WK_COL_COMP_FLG = '1' THEN
    COL_STATUS := '3'; -- 「回収完了」
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  --回収予定明細.回収完了フラグがOFF、且つ回収予定入金履歴の回収金額合計が０以外の場合、
  IF WK_COL_COMP_FLG = '0' AND NVL(WK_SUM_REC_AMOUNT, 0) <> 0 THEN
    COL_STATUS := '2'; -- 「部回収済」
    COLTD_AMOUNT := WK_COLTD_AMOUNT;
    PRE_REC_USE_AMOUNT := WK_PRE_REC_USE_AMOUNT;
    RETURN;
  END IF;
  
  --回収予定明細.回収完了フラグがOFF、且つ回収予定入金履歴の回収金額合計が０の場合
  IF WK_COL_COMP_FLG = '0' AND NVL(WK_SUM_REC_AMOUNT, 0) = 0 THEN
    COL_STATUS := '1'; -- 「未回収」
    COLTD_AMOUNT := 0;
    PRE_REC_USE_AMOUNT := 0;
    RETURN;
  END IF;
  
  EXCEPTION
    WHEN OTHERS THEN

      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '回収状況チェック関数にてシステム例外エラーが発生しました。';
      
      --ADD BY DTT AT 2009/09/21 START
      IF SyoriResult = -1 THEN
        RETURN;
      END IF;
      --ADD BY DTT AT 2009/09/21 END
      --エラーログ出力
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
--主処理ーE
END ZSK0040B;
/
