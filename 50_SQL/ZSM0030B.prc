CREATE OR REPLACE PROCEDURE ZSM0030B
/********************************************************
 *  機能概要：
 *    支払要請データに対する支払状況のチェックを行う。
 *  引数１   ：伝票種別（入力）
 *  引数２   ：発生元伝票番号（入力）
 *  引数３   ：発生元伝票追番（入力）
 *  引数４   ：発生元伝票追加キー（入力）
 *  引数５   ：グローバル情報.所属部門コード
 *  引数６   ：グローバル情報.ユーザコード
 *  引数７   ：グローバル情報.プログラムID
 *  引数８   ：グローバル情報.端末名
 *  引数９   ：処理結果（0:正常終了、1:異常終了、2:警告終了）
 *  引数１０ ：エラーメッセージ（出力）
 *  引数１１ ：埋め込み文字（出力）
 *  引数１２ ：支払状況（出力）
 *  引数１３ ：支払済金額（出力）
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

  -- 変数宣言部
  ERR_PARAM_NM            VARCHAR2(14);                            -- 設定されていない引数名
  WK_MNG_NO               F_PAY_REQ_S_M.MNG_NO%TYPE;               -- 管理番号 (FK)
  WK_DELETE_FLG           CHAR(1);                                 -- 削除フラグ（0：削除なし、1：削除する）
  WK_SYORI_STAT_CODE      F_PAY_REQ_S_H.SYORI_STAT_CODE%TYPE;      -- 処理ステータス
  WK_PAY_COMP_FLG         F_PAY_REQ_M.PAY_COMP_FLG%TYPE;           -- 支払完了フラグ
  WK_PAID_AMOUNT          F_PAY_REQ_M.PAID_AMOUNT%TYPE;            -- 支払済金額の合計値

--支払済金額の合計値を取得する
CURSOR GET_SUM_PAYD_AMOUNT
(
   --伝票種別
  iORIG_DENPYO_TYPE  IN  F_PAY_REQ_S_M.ORIG_DENPYO_TYPE%TYPE,
  --発生元伝票番号
  iORIG_SLIP_NO      IN  F_PAY_REQ_S_M.ORIG_SLIP_NO%TYPE,
  --発生元伝票追番
  iORIG_SLIP_ADD_NO  IN  F_PAY_REQ_S_M.ORIG_SLIP_ADD_NO%TYPE,
  --発生元伝票追加キー
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

--支払要請データ検索
CURSOR GET_PAY_REQ
(
  --管理番号 (FK)
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
--支払要請データレコードの配列
TYPE T_PAY_REQ IS TABLE OF GET_PAY_REQ%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_PAY_REQ       T_PAY_REQ;
--支払要請データレコード配列の添え字
N_PAY_REQ_IDX    INTEGER(10);
--支払要請データレコードの１レコード分エリア
R_PAY_REQ_TBL    GET_PAY_REQ%ROWTYPE;

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
    P_LOG_ERROR(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）');

  END IF;
  IF I_ORIG_DENPYO_NO IS NULL THEN
    ERR_PARAM_NM := '発生元伝票番号';
    --エラーログ出力
    P_LOG_ERROR(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）');
  END IF;
  IF I_ORIG_DENPYO_ADD_NO IS NULL THEN
    ERR_PARAM_NM := '発生元伝票追番';
    --エラーログ出力
    P_LOG_ERROR(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '必須の引数が設定されていません。（'|| ERR_PARAM_NM || '）');
  END IF;
  
  --一つでも設定されていない場合
  IF ERR_PARAM_NM IS NOT NULL THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '支払状況チェック関数にて引数エラーが発生しました。';
    RETURN;
  END IF;
  
END SP_CHK_PARAM;


BEGIN
--主処理ーS

  --出力初期化
  RETURN_CODE := '0';
  ERR_MSG_ID := '';
  ERR_MSG_CHR := '';
  SIHARAI_STATE := '';
  SIHARAI_KG :=0;

  --1. 引数必須設定チェック
  SP_CHK_PARAM(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;
  
  BEGIN

    --2. 支払済金額の合計値を取得する
    OPEN GET_SUM_PAYD_AMOUNT(I_DENPYO_TYPE,
                             I_ORIG_DENPYO_NO,
                             I_ORIG_DENPYO_ADD_NO,
                             I_ORIG_DENPYO_ADD_KEY);

    FETCH GET_SUM_PAYD_AMOUNT INTO
      WK_MNG_NO,
      WK_PAID_AMOUNT
    ;
    CLOSE GET_SUM_PAYD_AMOUNT;

    --データが取得できない場合
    IF WK_MNG_NO IS NULL THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '対象の支払要請申請データが作成されていません。';
      SIHARAI_STATE := '';
      SIHARAI_KG := 0;
      RETURN;      
    END IF;

    N_PAY_REQ_IDX := 1;
    --支払要請データレコード配列の初期化
    WK_PAY_REQ.DELETE;

    --支払要請データ検索
    OPEN GET_PAY_REQ(WK_MNG_NO);
    LOOP
      FETCH GET_PAY_REQ INTO WK_PAY_REQ(N_PAY_REQ_IDX);

      --最終レコードの場合終了
      EXIT WHEN GET_PAY_REQ%NOTFOUND;
      N_PAY_REQ_IDX := N_PAY_REQ_IDX + 1;
    END LOOP;
    CLOSE GET_PAY_REQ;
    
    --取得できない場合
    IF WK_PAY_REQ IS NULL OR WK_PAY_REQ.COUNT = 0 THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '対象の支払要請申請データが作成されていません。';
      SIHARAI_STATE := '';
      SIHARAI_KG := 0;
      RETURN;
    END IF;

    --初期化
    WK_PAY_COMP_FLG := '1';
    
    FOR PAT_IDX IN 1 .. WK_PAY_REQ.COUNT LOOP
      R_PAY_REQ_TBL := WK_PAY_REQ(PAT_IDX);
      
      --支払要請申請ヘッダ.処理ステータス
      WK_SYORI_STAT_CODE := R_PAY_REQ_TBL.SYORI_STAT_CODE;
      
      --削除フラグ
      IF R_PAY_REQ_TBL.DELETE_FLG = '1' THEN
        WK_DELETE_FLG := '1';
      END IF;
      
      --支払要請明細．支払完了フラグ
      IF R_PAY_REQ_TBL.PAY_COMP_FLG = '0' THEN
        WK_PAY_COMP_FLG := '0';
      END IF;
      
    END LOOP;

        
    --回収予定ヘッダ、または回収予定明細の削除フラグが"1"の場合
    IF WK_DELETE_FLG = '1' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '対象の支払要請申請データが削除されています。';       
      SIHARAI_STATE := '';
      SIHARAI_KG := 0;
      RETURN;
    END IF;
    
    --支払要請申請ヘッダ.処理ステータスが作成済の場合、
    IF WK_SYORI_STAT_CODE = '00' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '1'; --「申請前」
      SIHARAI_KG := 0;
      RETURN;
    END IF;

    --支払要請申請ヘッダ.処理ステータスが上長決裁待、部門長決裁待、決裁済、差戻しの場合、
    IF WK_SYORI_STAT_CODE = '01'
       OR WK_SYORI_STAT_CODE = '02'
       OR WK_SYORI_STAT_CODE = '03'
       OR WK_SYORI_STAT_CODE = '05' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '2'; --「申請済」
      SIHARAI_KG := 0;
      RETURN;
    END IF;

    --支払要請申請ヘッダ.処理ステータスが会計受付済、かつ、支払要請明細．支払完了フラグがOFF、
    --かつ支払要請明細.支払済金額の合計値が0の場合、
    IF WK_SYORI_STAT_CODE = '04'
       AND WK_PAY_COMP_FLG = '0'
       AND WK_PAID_AMOUNT = 0 THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '3'; --「未支払」
      SIHARAI_KG := WK_PAID_AMOUNT;
      RETURN;
    END IF;

    --支払要請申請ヘッダ.処理ステータスが会計受付済、かつ、支払要請明細．支払完了フラグがOFF、
    --かつ支払要請明細.支払済金額の合計値が0以外の場合、
    IF WK_SYORI_STAT_CODE = '04'
       AND WK_PAY_COMP_FLG = '0'
       AND WK_PAID_AMOUNT <> 0 THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '4'; --「一部支払済」
      SIHARAI_KG := WK_PAID_AMOUNT;
      RETURN;
    END IF;
    
    --支払要請申請ヘッダ.処理ステータスが会計受付済、かつ、支払要請明細．支払完了フラグがONの場合、
    IF WK_SYORI_STAT_CODE = '04'
       AND WK_PAY_COMP_FLG = '1' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := '';
      ERR_MSG_CHR := '';
      SIHARAI_STATE := '5'; --「支払完了」
      SIHARAI_KG := WK_PAID_AMOUNT;
      RETURN;
    END IF;
    
  END;
  
  EXCEPTION
    WHEN OTHERS THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '支払状況チェック関数にてシステム例外エラーが発生しました。';
      --エラーログ出力
      BEGIN
      
        P_LOG_ERROR(I_G_USR_CODE,
              I_G_TERM_NAME,
              I_G_FUNC_ID,
              SQLERRM);
        EXCEPTION

            WHEN OTHERS THEN
                NULL;
      END;
--主処理ーE
END ZSM0030B;
/
