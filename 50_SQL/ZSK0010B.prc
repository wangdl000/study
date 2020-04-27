CREATE OR REPLACE PROCEDURE ZSK0010B
/***********************************************
 *  機能概要：引数情報より、
 *  回収予定データ（締め請求分）の作成処理を行う。
 *  引数１ 　：処理年月（入力）
 *  引数２ 　：締日区分（入力）
 *  引数３　 ：営業部門コード（入力）
 *  引数４　 ：取引先コード（入力）
 *  引数５ 　：窓口コード（入力）
 *  引数６ 　：作成者（入力）
 *  引数７   ：グローバル情報.所属部門コード
 *  引数８   ：グローバル情報.ユーザコード
 *  引数９ 　：グローバル情報.プログラムID
 *  引数１０ ：グローバル情報.端末名
 *  引数１１ ：処理結果（0:正常終了、1:異常終了、2:警告終了）
 *  引数１２ ：エラーメッセージ（出力）
 *  引数１３ ：埋め込み文字（出力）
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
  --処理結果
  RETURN_CODE OUT CHAR,
  --エラーメッセージ
  ERR_MSG_ID OUT VARCHAR2,
  --埋め込み文字
  ERR_MSG_CHR OUT VARCHAR2
) IS

  -- 変数宣言部

  WK_COL_SCHED_NO          CHAR(13);                                   -- 回収予定番号
  WK_COL_SHCED_M_NO        F_COL_SCHED_M.COL_SCHED_M_NO%TYPE;          -- 回収予定明細番号
  WK_REC_SHEET_NO	         F_REC_SHEET_M.REC_SHEET_NO%TYPE;      -- 領収書番号 (FK)

  WK_SUM_AMOUNT            F_COL_SCHED_S_M.LINE_AMOUNT%TYPE;       -- 金額合計値
  WK_SUM_AMOUNT_EN         F_COL_SCHED_S_M.LINE_AMOUNT%TYPE;       -- 金額合計値（円貨に計算する）
  WK_AMOUNT                F_COL_SCHED_S_M.LINE_AMOUNT%TYPE;       -- 金額
  WK_CUR_CODE              V_URIAGE.CUR_CODE%TYPE;           --通貨コード
  WK_JGYBNR_DAI_CODE       V_URIAGE.JGYBNR_DAI_CODE%TYPE;    --事業大分類コード
  WK_JGYBNR_CHU_CODE       V_URIAGE.JGYBNR_CHU_CODE%TYPE;    --事業中分類コード
  
  WK_COL_DRAFT_YMD         F_COL_SCHED_S_M.COL_DRAFT_YMD%TYPE;         -- 回収起算日
  WK_MNG_M_NO              NUMBER(3);                                  -- 管理明細番号
  
  WK_BASE_YMD              DATE;                                       -- 導出基準日
  WK_SHORI_DATE            DATE;                                       -- 引数.処理年月の引数.締日区分の日付（締日区分が99の場合、月末日）

  WK_SUM_JP_CONV_AMOUNT    NUMBER := 0;                                -- 邦貨換算額合計値
  WK_JP_CONV_AMOUNT        NUMBER(11) := 0;                            -- 邦貨換算額
  WK_SEQUENCE_NO           F_COL_SCHED_S_H.MNG_NO%TYPE;                -- オラクルシーケンスにて採番した管理番号      
  WK_OLD_WK_CUR_CODE       V_URIAGE.CUR_CODE%TYPE;                      --通貨コード比較用

  WK_SYS_UNYO_YM1          CHAR(6);                                    -- システム運用年月
  WK_KINSYU_KBN1           CHAR(1);                                    -- 金種１
  WK_SCHED_YMD1            DATE;                                       --回収・支払予定日１
  WK_YAK_AMOUNT1           NUMBER(13);                                 --金額１
  WK_TGT_LIMIT_YMD1        DATE;                                       --手形期日１
  WK_KINSYU_KBN2           CHAR(1);                                    --金種２
  WK_SCHED_YMD2            DATE;                                       --回収・支払予定日２
  WK_YAK_AMOUNT2           NUMBER(13);                                 --金額２
  WK_TGT_LIMIT_YMD2        DATE;                                       --手形期日２
  WK_SHIME_KBN             NUMBER;                                     --締日区分
  ERR_PARAM_NM             VARCHAR2(14);                               -- 設定されていない引数名
  NOWAIT_RESOURCE_LOCKED   EXCEPTION;                                  --行ロック異常
  PRAGMA EXCEPTION_INIT(NOWAIT_RESOURCE_LOCKED, -54);
  ERR_CNT                  NUMBER;
  RETURN_CODE_REC_SHEET    CHAR;                                       --発行済み領収書の論理削除処理結果
  --ADD BY DTT AT 2009/09/21 START
  SyoriResult             NUMBER;
  ERRLOGGER_EXCEPT        EXCEPTION;
  --ADD BY DTT AT 2009/09/21 END

--取引先データ取得
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
--取引先データレコード配列の添え字
N_M_TORI_BMN_IDX    INTEGER(10);
--取引先データレコードの１レコード分エリア
R_M_TORI_BMN_TBL    GET_M_TORI_BMN%ROWTYPE;

--回収予定データ取得
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
--回収予定データレコード配列の添え字
N_F_COL_SCHED_IDX    INTEGER(10);
--回収予定データレコードの１レコード分エリア
R_F_COL_SCHED_TBL    GET_F_COL_SCHED%ROWTYPE;

--領収書番号取得
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
--売上データの売上金額合計値を取得する。
CURSOR GET_V_URIAGE_AMOUNT
(
  I_WK_TORI_CODE IN V_URIAGE.TORI_CODE%TYPE,
  I_WK_TORI_MADO_CODE IN V_URIAGE.TORI_MADO_CODE%TYPE
) IS
  SELECT
    CUR_CODE,           --通貨コード
    JGYBNR_DAI_CODE,    --事業大分類コード
    JGYBNR_CHU_CODE,    --事業中分類コード
    --※通貨コードが「邦貨」の場合、売上本体金額（円貨）＋売上消費税額（円貨）を使用。
    --※通貨コードが「邦貨」以外の場合、売上本体金額（外貨）＋売上消費税額（外貨）を使用。
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

--売上データ取得
CURSOR GET_V_URIAGE
(
  I_WK_TORI_CODE       IN V_URIAGE.TORI_CODE%TYPE,
  I_WK_TORI_MADO_CODE  IN V_URIAGE.TORI_MADO_CODE%TYPE,
  I_WK_CUR_CODE        IN V_URIAGE.CUR_CODE%TYPE,           --通貨コード
  I_WK_JGYBNR_DAI_CODE IN V_URIAGE.JGYBNR_DAI_CODE%TYPE,    --事業大分類コード
  I_WK_JGYBNR_CHU_CODE IN V_URIAGE.JGYBNR_CHU_CODE%TYPE     --事業中分類コード
) IS
  SELECT
    URI_NO,             --売上番号
    URI_ADD_NO,         --売上番号追番
    BMN_CODE,           --部門コード
    TORI_CODE,          --取引先コード
    TORI_MADO_CODE,     --取引先窓口コード
    JGYBNR_DAI_CODE,    --事業大分類コード
    JGYBNR_CHU_CODE,    --事業中分類コード
    URI_YMD,            --売上日
    CUR_CODE,           --通貨コード
    KAWASE_RATE,        --為替レート
    CLAIM_NO,           --クレーム管理番号
    URI_Y_AMOUNT,       --売上本体金額（円貨）
    URI_Y_TAX,          --売上消費税額（円貨）
    URI_AMOUNT,         --売上本体金額（外貨）
    URI_TAX             --売上消費税額（外貨）
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
  --通貨コード、事業大分類コード、事業中分類コード、売上番号、売上番号追番の昇順
  ORDER BY CUR_CODE,JGYBNR_DAI_CODE,JGYBNR_CHU_CODE,URI_NO,URI_ADD_NO ASC
;
TYPE T_V_URIAGE IS TABLE OF GET_V_URIAGE%ROWTYPE
  INDEX BY BINARY_INTEGER;
--回収予定データレコード配列の添え字
N_V_URIAGE_IDX    INTEGER(10);

WK_V_URIAGE_TBL T_V_URIAGE;
--売上データレコードの１レコード分エリア
R_V_URIAGE_TBL    GET_V_URIAGE%ROWTYPE;

/*********************************************************
* 機能名称：回収予定申請ヘッダ、回収予定ヘッダ作成処理
* 引数１  ：オラクルシーケンスにて採番した番号（入力）
* 引数２  ：回収予定番号（入力）
* 引数３  ：得意先コード（入力）
* 引数４  ：得意先窓口コード（入力）
* 引数５  ：通貨コード（入力）
* 引数６  ：部門コード（入力）
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

  --回収予定申請ヘッダ作成処理
  INSERT INTO F_COL_SCHED_S_H
    (
      MNG_NO,                  --管理番号
      SINSEI_NO,               --申請番号
      SINSEI_TYPE,             --申請種別
      SINSEI_SYORI_TYPE,       --申請処理種別
      SINSEI_KBN,              --申請区分
      COL_SCHED_NO,            --回収予定番号
      COL_SCHED_ADD_NO,        --回収予定追番
      DENPYO_TYPE,             --伝票種別
      BIGIN_MNG_NO,            --初期管理番号
      LATEST_FLG,              --最新フラグ
      TOKUI_CODE,              --得意先コード
      TOKUI_MADO_CODE,         --得意先窓口コード
      SYORI_YM,                --処理年月
      SHIME_KBN,               --締日区分
      CUR_CODE,                --通貨コード
      SYORI_STAT_CODE,         --処理ステータス
      SINSEI_BMN_CODE,         --申請部門コード
      SINSEI_USR_CODE,         --申請者コード
      NEXT_SYORI_BMN_CODE,     --次処理部門コード
      NEXT_SYORI_USR_CODE,     --次処理者コード
      BEF_SYORI_USR_CODE,      --前処理者コード
      BILL_FIX_FLG,            --請求確定フラグ
      SYORI_USR_CMNT,          --処理者コメント
      EIGYO_BMN_CODE,          --営業部門コード
      MAKE_TIME,               --作成日時
      MAKE_USR_CODE,           --作成ユーザーコード
      UPDATE_TIME,             --更新日時
      UPDATE_USR_CODE,         --更新ユーザーコード
      DELETE_TIME,             --削除日時
      DELETE_USR_CODE,         --削除ユーザーコード
      DELETE_FLG               --削除フラグ
    ) VALUES
    (
     I_WK_SEQUENCE_NO,         --管理番号
     '',                       --申請番号
     '',                       --申請種別
     '',                       --申請処理種別
     '',                       --申請区分
     I_WK_COL_SCHED_NO,        --回収予定番号 共通関数にて採番
     '00',                     --回収予定追番
     '40',                     --伝票種別(回収予定番号)
     I_WK_SEQUENCE_NO,         --初期管理番号
     '1',                      --最新フラグ「最新」
     I_WK_TORI_CODE,           --得意先コード
     I_WK_TORI_MADO_CODE,      --得意先窓口コード
     I_SYORI_YM,               --処理年月
     I_SHIME_KBN,              --締日区分
     I_WK_CUR_CODE,            --通貨コード
     '04',                     --処理ステータス「確定済」
     I_G_BMN_CODE,             --申請部門コード グローバル情報  所属部門コード
     I_G_USR_CODE,        --申請者コード  -- ユーザーコード 
     '',                       --次処理部門コード
     '',                       --次処理者コード
     I_G_USR_CODE,        --前処理者コード ユーザーコード
     '0',                      --請求確定フラグ「未確定」
     '',                       --処理者コメント
     I_WK_BMN_CODE,            --営業部門コード ＜補足説明＞2.1.の取得値
     SYSTIMESTAMP,                  --作成日時
     I_G_USR_CODE,        --作成ユーザーコード グローバル情報 ユーザーコード
     SYSTIMESTAMP,             --更新日時
     I_G_USR_CODE,        --更新ユーザーコード グローバル情報ユーザーコード
     '',                       --削除日時
     '',                       --削除ユーザーコード
     '0'                       --削除フラグ「未削除」
      );

  --回収予定ヘッダ作成処理
  INSERT INTO F_COL_SCHED_H
    (
      COL_SCHED_NO,            --回収予定番号
      COL_SCHED_ADD_NO,        --回収予定追番
      DENPYO_TYPE,             --伝票種別
      SYORI_KBN,               --処理区分
      SINSEICHU_FLG,           --申請中フラグ
      BILL_FIX_FLG,            --請求確定フラグ
      TOKUI_CODE,              --得意先コード
      TOKUI_MADO_CODE,         --得意先窓口コード
      EIGYO_BMN_CODE,          --営業部門コード
      SYORI_YM,                --処理年月
      SHIME_KBN,               --締日区分
      CUR_CODE,                --通貨コード
      MAKE_TIME,               --作成日時
      MAKE_USR_CODE,           --作成ユーザーコード
      UPDATE_TIME,             --更新日時
      UPDATE_USR_CODE,         --更新ユーザーコード
      DELETE_TIME,             --削除日時
      DELETE_USR_CODE,         --削除ユーザーコード
      DELETE_FLG               --削除フラグ
    ) VALUES
    (
      I_WK_COL_SCHED_NO,       --回収予定番号  共通関数にて採番
      '00',                    --回収予定追番
      '40',                    --伝票種別「回収予定」
      '0',                     --処理区分「新規」
      '0',                     --申請中フラグ「非申請中」
      '1',                     --請求確定フラグ「確定済」
      I_WK_TORI_CODE,          --得意先コード
      I_WK_TORI_MADO_CODE,     --得意先窓口コード
      I_WK_BMN_CODE,           --営業部門コード
      WK_SYS_UNYO_YM1,         --処理年月 システム運用年月
      I_SHIME_KBN,             --締日区分
      I_WK_CUR_CODE,           --通貨コード
      SYSTIMESTAMP,            --作成日時
      I_G_USR_CODE,            --作成ユーザーコード ユーザーコード 
      SYSTIMESTAMP,            --更新日時
      I_G_USR_CODE,            --更新ユーザーコード ユーザーコード 
      '',                      --削除日時
      '',                      --削除ユーザーコード
      '0'                      --削除フラグ「非削除」
    );     

END SP_INS_H;

/******************************************************************
*** 機能名称：管理明細番号取得処理(管理番号における、1からの連番)
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
*** 機能名称：回収予定申請明細、回収予定明細作成処理
* 引数１  ：オラクルシーケンスにて採番した番号（入力）
* 引数２  ：回収予定番号(売上番号)（入力）
* 引数３  ：回収予定明細番号(売上番号追番)（入力）
* 引数４  ：管理明細番号（入力）
* 引数５  ：金種（入力）
* 引数６  ：回収・支払予定日（入力）
* 引数７  ：金額（入力）
* 引数８  ：手形期日（入力）
* 引数９  ：回収起算日（出力）
* 引数１０：邦貨換算額（出力）
* 引数１１：売上データレコードの１レコード分エリア（出力）
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
   
  --明細金額設定値×為替レートの小数部切捨て
  --明細分割登録時に合計額が売上金額（円貨）と一致しない場合は、差額を１つ目の明細に加算する。
  INSERT INTO F_COL_SCHED_S_M 
  (
      MNG_NO,                  --管理番号
      MNG_M_NO,                --管理明細番号
      INIT_MNG_NO,             --初期管理番号
      INIT_MNG_M_NO,           --初期管理明細番号
      COL_SCHED_NO,            --回収予定番号
      COL_SCHED_ADD_NO,        --回収予定追番
      COL_SCHED_M_NO,          --回収予定明細番号
      COL_SCHED_YMD,           --回収予定日
      KINSYU_KBN,              --金種
      LINE_AMOUNT,             --明細金額
      CUR_CODE,                --通貨コード
      RATE,                    --レート
      JP_CONV_AMOUNT,          --邦貨換算額
      CLAIM_NO,                --クレーム番号
      COL_DRAFT_YMD,           --回収起算日
      TGT_LIMIT_YMD,           --手形期日
      KOJI_NO,                 --工事番号
      KOJI_SUB_NO,             --工事番号枝番
      RMKS,                    --備考
      HOLD_FLG,                --保留フラグ
      COL_KBN,                 --回収区分
      ORIG_DENPYO_TYPE,        --発生元伝票種別
      ORIG_DENPYO_NO,          --発生元伝票番号
      ORIG_DENPYO_ADD_NO,      --発生元伝票追番
      ORIG_DENPYO_ADD_KEY,     --発生元伝票追加キー
      JGYBNR_DAI_CODE,         --事業大分類コード
      JGYBNR_CHU_CODE,         --事業中分類コード
      EXAMINE_CONTACT_FLG,     --審査室連絡フラグ
      MAKE_TIME,               --作成日時
      MAKE_USR_CODE,           --作成ユーザーコード
      UPDATE_TIME,             --更新日時
      UPDATE_USR_CODE,         --更新ユーザーコード
      DELETE_TIME,             --削除日時
      DELETE_USR_CODE,         --削除ユーザーコード
      DELETE_FLG               --削除フラグ    
    ) VALUES
    (
      I_WK_SEQUENCE_NO,        --管理番号
      I_WK_MNG_M_NO,           --管理明細番号
      I_WK_SEQUENCE_NO,        --初期管理番号 管理番号と同値
      I_WK_MNG_M_NO,           --初期管理明細番号  管理明細番号と同値
      I_WK_COL_SCHED_NO,       --回収予定番号 共通関数にて採番
      '00',                    --回収予定追番
      I_WK_COL_SHCED_M_NO,     --回収予定明細番号  "001"からの連番
      I_WK_SCHED_YMD,          --回収予定日 回収・支払予定日１，２ 
      I_WK_KINSYU_KBN,           --金種 金種１，２
      I_WK_YAK_AMOUNT,           --明細金額 売上金額１，２
      R_V_URIAGE_TBL.CUR_CODE,   --通貨コード
      R_V_URIAGE_TBL.KAWASE_RATE, --レート
      I_WK_JP_CONV_AMOUNT,       --邦貨換算額
      R_V_URIAGE_TBL.CLAIM_NO,   --クレーム番号
      I_WK_COL_DRAFT_YMD,        --回収起算日
      I_WK_TGT_LIMIT_YMD,        --手形期日
      '',                        --工事番号
      '',                        --工事番号枝番
      '',                        --備考
      '0',                       --保留フラグ 「保留なし」
      '01',                      --回収区分「売上」
      '13',                      --発生元伝票種別「売上」
      R_V_URIAGE_TBL.URI_NO,     --発生元伝票番号
      R_V_URIAGE_TBL.URI_ADD_NO, --発生元伝票追番
      '',                        --発生元伝票追加キー
      R_V_URIAGE_TBL.JGYBNR_DAI_CODE,        --事業大分類コード
      R_V_URIAGE_TBL.JGYBNR_CHU_CODE,        --事業中分類コード
      '0',                       --審査室連絡フラグ「非対象」
      SYSTIMESTAMP,              --作成日時
      I_G_USR_CODE,              --作成ユーザーコード グローバル情報
      SYSTIMESTAMP,              --更新日時
      I_G_USR_CODE,              --更新ユーザーコード グローバル情報
      '',                        --削除日時
      '',                        --削除ユーザーコード
      '0'                        --削除フラグ 固定値「未削除」
    );

  --回収予定明細作成
  INSERT INTO F_COL_SCHED_M
   (
      COL_SCHED_NO,               --回収予定番号
      COL_SCHED_ADD_NO,           --回収予定追番
      COL_SCHED_M_NO,             --回収予定明細番号  "001"からの連番
      SYORI_KBN,                  --処理区分
      COL_SCHED_YMD,              --回収予定日 回収・支払予定日１，２
      KINSYU_KBN,                 --金種
      LINE_AMOUNT,                --明細金額
      CUR_CODE,                   --通貨コード
      RATE,                       --レート
      JP_CONV_AMOUNT,             --邦貨換算額
      COLTD_AMOUNT,               --回収済金額
      PRE_REC_USE_AMOUNT,         --前受金使用額
      CLAIM_NO,                   --クレーム番号
      COL_COMP_FLG,               --回収完了フラグ
      COL_COMP_YMD,               --回収完了日
      COL_DRAFT_YMD,              --回収起算日
      TGT_LIMIT_YMD,              --手形期日
      JGYBNR_DAI_CODE,            --事業大分類コード
      JGYBNR_CHU_CODE,            --事業中分類コード
      COL_KBN,                    --回収区分
      ORIG_DENPYO_TYPE,           --発生元伝票種別
      ORIG_DENPYO_NO,             --発生元伝票番号
      ORIG_DENPYO_ADD_NO,         --発生元伝票追番
      ORIG_DENPYO_ADD_KEY,        --発生元伝票追加キー
      KOJI_NO,                    --工事番号
      KOJI_SUB_NO,                --工事番号枝番
      RMKS,                       --備考
      REC_SHEET_ISSUE_KBN,        --領収書発行区分
      HOLD_FLG,                   --保留フラグ
      EXAMINE_CONTACT_FLG,        --審査室連絡フラグ
      MAKE_TIME,                  --作成日時
      MAKE_USR_CODE,              --作成ユーザーコード
      UPDATE_TIME,                --更新日時
      UPDATE_USR_CODE,            --更新ユーザーコード
      DELETE_TIME,                --削除日時
      DELETE_USR_CODE,            --削除ユーザーコード
      DELETE_FLG                  --削除フラグ
    ) VALUES
    (
      I_WK_COL_SCHED_NO,          --回収予定番号  共通関数にて採番
      '00',                       --回収予定追番
      I_WK_COL_SHCED_M_NO,        --回収予定明細番号
      '0',                        --処理区分「新規」
      I_WK_SCHED_YMD,             --回収予定日 回収・支払予定日１，２
      I_WK_KINSYU_KBN,            --金種
      I_WK_YAK_AMOUNT,            --明細金額
      R_V_URIAGE_TBL.CUR_CODE,    --通貨コード
      R_V_URIAGE_TBL.KAWASE_RATE, --レート
      I_WK_JP_CONV_AMOUNT,        --邦貨換算額
      -- wang-dangl
      I_WK_YAK_AMOUNT,            --回収済金額 明細金額
      I_WK_YAK_AMOUNT,            --前受金使用額 明細金額
      --wang-dangl
      R_V_URIAGE_TBL.CLAIM_NO,    --クレーム番号
      '0',                        --回収完了フラグ
      '',                         --回収完了日
      I_WK_COL_DRAFT_YMD,           --回収起算日
      I_WK_TGT_LIMIT_YMD,           --手形期日
      R_V_URIAGE_TBL.JGYBNR_DAI_CODE,         --事業大分類コード
      R_V_URIAGE_TBL.JGYBNR_CHU_CODE,         --事業中分類コード
      '01',                       --回収区分「売上」
      '13',                       --発生元伝票種別「売上」
      R_V_URIAGE_TBL.URI_NO,      --発生元伝票番号
      R_V_URIAGE_TBL.URI_ADD_NO,  --発生元伝票追番
      '',                         --発生元伝票追加キー
      '',                         --工事番号
      '',                         --工事番号枝番
      '',                         --備考
      '',                         --領収書発行区分
      '0',                        --保留フラグ
      '0',                        --審査室連絡フラグ
      SYSTIMESTAMP,               --作成日時
      I_G_USR_CODE,               --作成ユーザーコード ユーザーコード 
      SYSTIMESTAMP,               --更新日時
      I_G_USR_CODE,               --更新ユーザーコード ユーザーコード 
      '',                         --削除日時
      '',                         --削除ユーザーコード
      '0'                         --削除フラグ「非削除」
    );

END SP_INS_M;

/**********************************************************
*** 機能名称：売上データ取得処理
**********************************************************/
PROCEDURE SP_GET_V_URIAGE
(
  R_M_TORI_BMN_TBL IN GET_M_TORI_BMN%ROWTYPE,
  RETURN_CODE          IN OUT CHAR

) IS
BEGIN
  --導出基準日
  WK_BASE_YMD := WK_SHORI_DATE;
  --回収起算日
  WK_COL_DRAFT_YMD := WK_SHORI_DATE;
  
  OPEN GET_V_URIAGE_AMOUNT(R_M_TORI_BMN_TBL.TORI_CODE, R_M_TORI_BMN_TBL.TORI_MADO_CODE);
  IF GET_V_URIAGE_AMOUNT%NOTFOUND THEN
    RETURN;
  END IF;
  --売上データのレコード数分、繰り返す
  LOOP
    --回収予定データのレコード数分、繰り返す
    FETCH GET_V_URIAGE_AMOUNT INTO 
      WK_CUR_CODE,           --通貨コード
      WK_JGYBNR_DAI_CODE,    --事業大分類コード
      WK_JGYBNR_CHU_CODE,    --事業中分類コード
      WK_SUM_AMOUNT          --売上金額合計値
    ;
    --最終レコードの場合終了
    EXIT WHEN GET_V_URIAGE_AMOUNT%NOTFOUND;
    
    --約定情報取得 _S        
    BEGIN
      --約定導出処理を行う
      ZSK0060B(
        R_M_TORI_BMN_TBL.TORI_CODE,                   --取引先コード
        R_M_TORI_BMN_TBL.TORI_MADO_CODE,              --窓口コード
        R_M_TORI_BMN_TBL.BMN_CODE,                    --部門コード
        '1',                              --取引区分"1"
        WK_JGYBNR_DAI_CODE,               --事業大分類コード
        WK_JGYBNR_CHU_CODE,               --事業中分類コード
        '',                               --諸掛コード  ""
        '1',                              --回収・支払区分"1"
        WK_BASE_YMD,                      --導出基準日
        WK_CUR_CODE,                      --通貨コード
        WK_SUM_AMOUNT,                    --金額
        I_G_USR_CODE,                     --グローバル情報.ユーザコード
        I_G_TERM_NAME,                    --グローバル情報.端末名
        I_G_FUNC_ID,                      --グローバル情報.プログラムID
              
        RETURN_CODE,                      --処理結果
        ERR_MSG_ID,                       --エラーメッセージ
        ERR_MSG_CHR,                      --埋め込み文字
        WK_SHIME_KBN,                     --締日区分
        WK_KINSYU_KBN1,                   --金種１
        WK_SCHED_YMD1,                    --回収・支払予定日１
        WK_YAK_AMOUNT1,                   --金額１
        WK_TGT_LIMIT_YMD1,                --手形期日１
                    
        WK_KINSYU_KBN2,                   --金種２
        WK_SCHED_YMD2,                    --回収・支払予定日２
        WK_YAK_AMOUNT2,                   --金額２
        WK_TGT_LIMIT_YMD2                 --手形期日２
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
    --約定情報取得 _E
    IF NVL(WK_YAK_AMOUNT1, 0) <= 0 AND NVL(WK_YAK_AMOUNT2, 0) <= 0 THEN
      RETURN;
    END IF;
    WK_V_URIAGE_TBL.DELETE;
    N_V_URIAGE_IDX := 1;
   --4.1  2.で取得したデータ毎に売上データ（売上ビュー）にてデータを取得する。
    OPEN GET_V_URIAGE(R_M_TORI_BMN_TBL.TORI_CODE,
                      R_M_TORI_BMN_TBL.TORI_MADO_CODE,
                      WK_CUR_CODE,           --通貨コード
                      WK_JGYBNR_DAI_CODE,    --事業大分類コード
                      WK_JGYBNR_CHU_CODE    --事業中分類コード
    );    
    --売上データのレコード数分、繰り返す
    LOOP
      --回収予定データのレコード数分、繰り返す
      FETCH GET_V_URIAGE INTO WK_V_URIAGE_TBL(N_V_URIAGE_IDX);
      --最終レコードの場合終了
      EXIT WHEN GET_V_URIAGE%NOTFOUND;
      N_V_URIAGE_IDX := N_V_URIAGE_IDX + 1;
    END LOOP;  
    --カーソルクローズ
    CLOSE GET_V_URIAGE;

    --通貨コード比較用
    WK_OLD_WK_CUR_CODE := '';
    --回収予定申請明細.回収予定明細番号(初期化)
    WK_COL_SHCED_M_NO := '000';

    --共通関数にて採番で回収予定番号を取得する。
    --UPDATE BY DTT AT 2009/09/21 START
    --P_KK_GETDENNO('13',  --伝票種別「売上」
    --              I_EIGYO_BMN_CODE,  --部門コード
    --              SUBSTR(WK_SYS_UNYO_YM1, 1, 4), --年度
    --              NVL(I_G_USR_CODE, '999999'),    --ユーザーコード(省略時初期値:999999)
    --              I_G_FUNC_ID,
    --              I_G_TERM_NAME,
    --              WK_COL_SCHED_NO);
    WK_COL_SCHED_NO := P_KK_GETDENNO('13',  --伝票種別「売上」
                  I_EIGYO_BMN_CODE,  --部門コード
                  SUBSTR(WK_SYS_UNYO_YM1, 1, 4), --年度
                  NVL(I_G_USR_CODE, '999999'),    --ユーザーコード(省略時初期値:999999)
                  I_G_TERM_NAME);
    --UPDATE BY DTT AT 2009/09/21 END
    
    IF WK_COL_SCHED_NO = '-1' OR WK_COL_SCHED_NO = '-2'
      OR WK_COL_SCHED_NO = '-3' OR WK_COL_SCHED_NO = '-8' OR WK_COL_SCHED_NO = '-9' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := 'システムエラーが発生しました。';
      RETURN;
    END IF;
    
    WK_SUM_JP_CONV_AMOUNT := 0;
    WK_SUM_AMOUNT_EN := 0;
    FOR PAT_IDX IN 1 .. WK_V_URIAGE_TBL.COUNT LOOP
      R_V_URIAGE_TBL := WK_V_URIAGE_TBL(PAT_IDX);
            
      --回収予定申請ヘッダ（登録）、回収予定ヘッダ（登録）-S
      IF WK_OLD_WK_CUR_CODE <> R_V_URIAGE_TBL.CUR_CODE THEN
        --通貨コード
        WK_OLD_WK_CUR_CODE := R_V_URIAGE_TBL.CUR_CODE;

        --オラクルシーケンスにて採番し、番号を取得する。
        SELECT S_SK_COLSCHED_S_MNG_NO.NEXTVAL INTO WK_SEQUENCE_NO FROM DUAL;
        
        --同一の通貨コードにおいては、回収予定申請ヘッダ、回収予定ヘッダは１レコードのみ登録する。
        --回収予定申請ヘッダ（登録）、回収予定ヘッダ（登録）
        SP_INS_H(WK_SEQUENCE_NO,
                 WK_COL_SCHED_NO,
                 R_M_TORI_BMN_TBL.TORI_CODE,
                 R_M_TORI_BMN_TBL.TORI_MADO_CODE,
                 R_V_URIAGE_TBL.CUR_CODE,
                 R_M_TORI_BMN_TBL.BMN_CODE);
      END IF;
      --回収予定申請ヘッダ（登録）、回収予定ヘッダ（登録）-E

      --回収予定申請明細（登録）、回収予定明細（登録）-S
      BEGIN
        -- 金額を取得する。 
        WK_AMOUNT := 0;
        IF R_V_URIAGE_TBL.CUR_CODE = '01' THEN
          --※通貨コードが「邦貨」の場合、売上本体金額（円貨）＋売上消費税額（円貨）を使用。
          WK_AMOUNT := NVL(R_V_URIAGE_TBL.URI_Y_AMOUNT, 0) + NVL(R_V_URIAGE_TBL.URI_Y_TAX, 0);
          WK_SUM_AMOUNT_EN := WK_SUM_AMOUNT_EN + WK_AMOUNT;
        ELSE
          --※通貨コードが「邦貨」以外の場合、売上本体金額（外貨）＋売上消費税額（外貨）を使用。
          WK_AMOUNT := NVL(R_V_URIAGE_TBL.URI_AMOUNT, 0) + NVL(R_V_URIAGE_TBL.URI_TAX, 0);
          WK_SUM_AMOUNT_EN := WK_SUM_AMOUNT_EN + WK_AMOUNT * R_V_URIAGE_TBL.KAWASE_RATE;
        END IF;
        
        IF NVL(WK_YAK_AMOUNT1, 0) = 0 THEN
          IF NVL(WK_YAK_AMOUNT2, 0) > 0 THEN
            -- 管理番号における、1からの連番処理
            SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);        
            --回収予定申請明細.回収予定明細番号( "001"からの連番)
            WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');           
            --邦貨換算額を計算する。
            WK_JP_CONV_AMOUNT := TRUNC(NVL(WK_AMOUNT, 0) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
            WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;      
            --回収予定申請明細（登録）、回収予定明細（登録）
            SP_INS_M(WK_SEQUENCE_NO,
                     WK_COL_SCHED_NO,
                     WK_COL_SHCED_M_NO,
                     WK_MNG_M_NO,
                     WK_KINSYU_KBN2,             --金種２
                     WK_SCHED_YMD2,              --回収・支払予定日２
                     NVL(WK_AMOUNT, 0),          --金額２
                     WK_TGT_LIMIT_YMD2,          --手形期日２
                     WK_COL_DRAFT_YMD,           --回収起算日
                     WK_JP_CONV_AMOUNT,          --邦貨換算額
                     R_V_URIAGE_TBL              -- 売上データレコードの１レコード分エリア
                     );

          END IF;
        ELSE
          IF NVL(WK_YAK_AMOUNT1, 0) < NVL(WK_AMOUNT, 0) THEN          
            -- 管理番号における、1からの連番処理
            SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);         
            --回収予定申請明細.回収予定明細番号( "001"からの連番)
            WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');          
            --邦貨換算額を計算する。
            WK_JP_CONV_AMOUNT := TRUNC(NVL(WK_YAK_AMOUNT1, 0) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
            WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;
            
            --回収予定申請明細（登録）、回収予定明細（登録）
            SP_INS_M(WK_SEQUENCE_NO,
                     WK_COL_SCHED_NO,
                     WK_COL_SHCED_M_NO,
                     WK_MNG_M_NO,
                     WK_KINSYU_KBN1,             --金種１
                     WK_SCHED_YMD1,              --回収・支払予定日１
                     NVL(WK_YAK_AMOUNT1, 0),     --金額１
                     WK_TGT_LIMIT_YMD1,          --手形期日１
                     WK_COL_DRAFT_YMD,           --回収起算日
                     WK_JP_CONV_AMOUNT,          --邦貨換算額
                     R_V_URIAGE_TBL              -- 売上データレコードの１レコード分エリア
                     );
            IF NVL(WK_YAK_AMOUNT2, 0) > 0 THEN
              -- 管理番号における、1からの連番処理
              SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);        
               --回収予定申請明細.回収予定明細番号( "001"からの連番)
               WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');           
              --邦貨換算額を計算する。
              WK_JP_CONV_AMOUNT := TRUNC((NVL(WK_AMOUNT, 0) - NVL(WK_YAK_AMOUNT1, 0)) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
              WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;      
              --回収予定申請明細（登録）、回収予定明細（登録）
              SP_INS_M(WK_SEQUENCE_NO,
                       WK_COL_SCHED_NO,
                       WK_COL_SHCED_M_NO,
                       WK_MNG_M_NO,
                       WK_KINSYU_KBN2,             --金種２
                       WK_SCHED_YMD2,              --回収・支払予定日２
                       NVL(WK_AMOUNT, 0) - NVL(WK_YAK_AMOUNT1, 0),             --金額２
                       WK_TGT_LIMIT_YMD2,          --手形期日２
                       WK_COL_DRAFT_YMD,           --回収起算日
                       WK_JP_CONV_AMOUNT,          --邦貨換算額
                       R_V_URIAGE_TBL              -- 売上データレコードの１レコード分エリア
                       );
            END IF;
            WK_YAK_AMOUNT1 :=  NVL(WK_AMOUNT, 0) - NVL(WK_YAK_AMOUNT1, 0);                    
          ELSE
            IF NVL(WK_YAK_AMOUNT1, 0) > NVL(WK_AMOUNT, 0) THEN
              -- 管理番号における、1からの連番処理
              SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);           
              --回収予定申請明細.回収予定明細番号( "001"からの連番)
              WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');            
              --邦貨換算額を計算する。
              WK_JP_CONV_AMOUNT := TRUNC(NVL(WK_AMOUNT, 0) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
              WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;
              
              --回収予定申請明細（登録）、回収予定明細（登録）
              SP_INS_M(WK_SEQUENCE_NO,
                       WK_COL_SCHED_NO,
                       WK_COL_SHCED_M_NO,
                       WK_MNG_M_NO,
                       WK_KINSYU_KBN1,             --金種１
                       WK_SCHED_YMD1,              --回収・支払予定日１
                       NVL(WK_AMOUNT, 0), --金額１
                       WK_TGT_LIMIT_YMD1,          --手形期日１
                       WK_COL_DRAFT_YMD,           --回収起算日
                       WK_JP_CONV_AMOUNT,          --邦貨換算額
                       R_V_URIAGE_TBL              -- 売上データレコードの１レコード分エリア
                       );
                WK_YAK_AMOUNT1 :=  NVL(WK_YAK_AMOUNT1, 0) - NVL(WK_AMOUNT, 0);        
            ELSE
            --同じの場合
              -- 管理番号における、1からの連番処理
              SP_GET_RENBN(WK_SEQUENCE_NO, WK_MNG_M_NO);
             
              --回収予定申請明細.回収予定明細番号( "001"からの連番)
              WK_COL_SHCED_M_NO := TO_CHAR(TO_NUMBER(NVL(WK_COL_SHCED_M_NO, 0)) + 1, 'FM000');
              
              --邦貨換算額を計算する。
              WK_JP_CONV_AMOUNT := TRUNC(NVL(WK_AMOUNT, 0) * NVL(R_V_URIAGE_TBL.KAWASE_RATE, 0), 0);
              WK_SUM_JP_CONV_AMOUNT := WK_SUM_JP_CONV_AMOUNT + WK_JP_CONV_AMOUNT;
              
              --回収予定申請明細（登録）、回収予定明細（登録）
              SP_INS_M(WK_SEQUENCE_NO,
                       WK_COL_SCHED_NO,
                       WK_COL_SHCED_M_NO,
                       WK_MNG_M_NO,
                       WK_KINSYU_KBN1,             --金種１
                       WK_SCHED_YMD1,              --回収・支払予定日１
                       NVL(WK_AMOUNT, 0), --金額１
                       WK_TGT_LIMIT_YMD1,          --手形期日１
                       WK_COL_DRAFT_YMD,           --回収起算日
                       WK_JP_CONV_AMOUNT,          --邦貨換算額
                       R_V_URIAGE_TBL              -- 売上データレコードの１レコード分エリア
                       );
              WK_YAK_AMOUNT1 := 0;
            END IF;
            
          END IF;
      
        END IF;
      END;
      --約定情報取得し、回収予定申請明細（登録）、回収予定明細（登録）-E
    END LOOP;
    --邦貨換算額の差額を計算する。
    IF 0 < WK_SUM_AMOUNT_EN - WK_SUM_JP_CONV_AMOUNT THEN
      --明細分割登録時に合計額が売上金額（円貨）と一致しない場合は、差額を１つ目の明細に加算する。
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
*** 機能名称：回収予定データ論理削除処理
**********************************************************/
PROCEDURE SP_DEL_F_COL_SCHED
(
  I_WK_COL_SCHED_NO      IN  F_COL_SCHED_H.COL_SCHED_NO%TYPE,
  I_WK_COL_SCHED_ADD_NO  IN  F_COL_SCHED_H.COL_SCHED_ADD_NO%TYPE
) IS

BEGIN

  --回収予定申請ヘッダ（論理削除）
  UPDATE F_COL_SCHED_S_H
    SET 
      DELETE_TIME = SYSTIMESTAMP, --削除日時
      DELETE_USR_CODE = I_G_USR_CODE, --削除ユーザーコード
      DELETE_FLG = '1' --削除フラグ
    WHERE 
       COL_SCHED_NO = I_WK_COL_SCHED_NO
       AND COL_SCHED_ADD_NO = I_WK_COL_SCHED_ADD_NO;

  --回収予定申請明細（論理削除）
  UPDATE F_COL_SCHED_S_M
    SET 
      DELETE_TIME = SYSTIMESTAMP, --削除日時
      DELETE_USR_CODE = I_G_USR_CODE, --削除ユーザーコード
      DELETE_FLG = '1' --削除フラグ
    WHERE 
       COL_SCHED_NO = I_WK_COL_SCHED_NO
       AND COL_SCHED_ADD_NO = I_WK_COL_SCHED_ADD_NO;

  --回収予定ヘッダ（論理削除）
  UPDATE F_COL_SCHED_H
    SET 
      DELETE_TIME = SYSTIMESTAMP, --削除日時
      DELETE_USR_CODE = I_G_USR_CODE, --削除ユーザーコード
      DELETE_FLG = '1' --削除フラグ
    WHERE 
       COL_SCHED_NO = I_WK_COL_SCHED_NO
       AND COL_SCHED_ADD_NO = I_WK_COL_SCHED_ADD_NO;

  --回収予定明細（論理削除）
  UPDATE F_COL_SCHED_M
    SET 
      DELETE_TIME = SYSTIMESTAMP, --削除日時
      DELETE_USR_CODE = I_G_USR_CODE, --削除ユーザーコード
      DELETE_FLG = '1' --削除フラグ
    WHERE 
       COL_SCHED_NO = I_WK_COL_SCHED_NO
       AND COL_SCHED_ADD_NO = I_WK_COL_SCHED_ADD_NO;

END SP_DEL_F_COL_SCHED;

/**********************************************************
*** 機能名称：発行済み領収書の論理削除処理
**********************************************************/
PROCEDURE SP_DEL_F_REC_SHEET
(
  I_WK_REC_SHEET_NO IN   F_REC_SHEET_M.REC_SHEET_NO%TYPE,
  RETURN_CODE     OUT  CHAR
)IS
BEGIN
  ERR_CNT := 0;
  --領収書（論理削除）
  UPDATE F_REC_SHEET_H
  SET 
    DELETE_TIME = SYSTIMESTAMP, --削除日時
    DELETE_USR_CODE = I_G_USR_CODE, --削除ユーザーコード
    DELETE_FLG = '1' --削除フラグ
  WHERE 
     REC_SHEET_NO = I_WK_REC_SHEET_NO
     AND DELETE_FLG = '0';
  IF SQL%ROWCOUNT > 0 THEN
    ERR_CNT := ERR_CNT + 1;
  END IF;

  --領収書明細（論理削除）
  UPDATE F_REC_SHEET_M
  SET 
    DELETE_TIME = SYSTIMESTAMP, --削除日時
    DELETE_USR_CODE = I_G_USR_CODE, --削除ユーザーコード
    DELETE_FLG = '1' --削除フラグ
  WHERE 
     REC_SHEET_NO = I_WK_REC_SHEET_NO
     AND DELETE_FLG = '0';
  IF SQL%ROWCOUNT > 0 THEN
    ERR_CNT := ERR_CNT + 1;
  END IF;
  
  IF 0 < ERR_CNT THEN
    RETURN_CODE := '2';
    RETURN_CODE_REC_SHEET := '2';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --    P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '領収書が無効となりました。（'|| I_WK_REC_SHEET_NO || '）');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '領収書が無効となりました。（' || I_WK_REC_SHEET_NO || '）',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
    RETURN;
  END IF;

END SP_DEL_F_REC_SHEET;

/**********************************************************
*** 機能名称：前回作成分の回収予定データ削除処理
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
  
    --回収予定データのレコード数分、繰り返す
    LOOP
      -- 回収予定データ取得
      FETCH GET_F_COL_SCHED INTO WK_F_COL_SCHED_TBL(N_F_COL_SCHED_IDX);
        --最終レコードの場合終了
      EXIT WHEN GET_F_COL_SCHED%NOTFOUND;
      N_F_COL_SCHED_IDX := N_F_COL_SCHED_IDX + 1;
    END LOOP;
    --カーソルクローズ
    CLOSE GET_F_COL_SCHED;
    
    EXCEPTION
      WHEN NOWAIT_RESOURCE_LOCKED THEN
        RETURN_CODE := '1';
        ERR_MSG_ID := 'ENM00001';
        ERR_MSG_CHR := '回収予定データ（締め請求）作成関数にてＤＢエラーが発生しました。'
            || '（前回登録データが他のユーザにより、処理中です。）';
        RETURN;
      WHEN OTHERS THEN
        RAISE;
  END;
  
  --データが取得されない場合、2の次データについて検索を行う。
  IF WK_F_COL_SCHED_TBL IS NULL OR WK_F_COL_SCHED_TBL.COUNT = 0 THEN
    RETURN;
  END IF;
 
  FOR PAT_IDX IN 1 .. WK_F_COL_SCHED_TBL.COUNT LOOP
    R_F_COL_SCHED_TBL := WK_F_COL_SCHED_TBL(PAT_IDX);
    BEGIN
      --申請中フラグが"1"の場合
      IF R_F_COL_SCHED_TBL.SINSEICHU_FLG = '1' THEN
        RETURN_CODE := '1';
        ERR_MSG_ID := 'ENM00001';
        ERR_MSG_CHR := '回収予定データ（締め請求）作成関数にてＤＢエラーが発生しました。'
          || '（前回登録データが決裁申請中のため、処理できません。（回収予定番号：'
          || R_F_COL_SCHED_TBL.COL_SCHED_NO || '））';
        
        RETURN;
      END IF;
      
      --請求確定フラグが"1"の場合
      IF R_F_COL_SCHED_TBL.BILL_FIX_FLG = '1' THEN
        RETURN_CODE := '1';
        ERR_MSG_ID := 'ENM00001';
        ERR_MSG_CHR := '回収予定データ（締め請求）作成関数にてＤＢエラーが発生しました。'
          || '（前回登録データが請求確定済みのため、処理できません。（回収予定番号：'
          || R_F_COL_SCHED_TBL.COL_SCHED_NO || '））';

        RETURN;
      END IF;

      --回収予定明細.領収書発行区分が「発行済み」の場合
      IF R_F_COL_SCHED_TBL.REC_SHEET_ISSUE_KBN = '1' THEN
        --3.5. 領収書明細の取得を行う
        OPEN GET_REC_SHEET_NO(R_F_COL_SCHED_TBL.COL_SCHED_NO, R_F_COL_SCHED_TBL.COL_SCHED_M_NO);
        LOOP
          -- 領収書番号取得
          FETCH GET_REC_SHEET_NO INTO WK_REC_SHEET_NO;
          --最終レコードの場合終了
          EXIT WHEN GET_REC_SHEET_NO%NOTFOUND;
          
          --3.6. 発行済み領収書の論理削除
          SP_DEL_F_REC_SHEET(WK_REC_SHEET_NO, RETURN_CODE);
        END LOOP;
        CLOSE GET_REC_SHEET_NO;
      END IF;
      
      --3.7. 回収予定データ論理削除
      SP_DEL_F_COL_SCHED(R_F_COL_SCHED_TBL.COL_SCHED_NO, R_F_COL_SCHED_TBL.COL_SCHED_ADD_NO);
    END;
    
  END LOOP;  

END SP_GET_F_COL_SCHED_DATA;

/**********************************************************
*** 機能名称：引数必須設定チェック処理
**********************************************************/
PROCEDURE SP_CHK_PARAM
(
  RETURN_CODE OUT CHAR
) IS
BEGIN
  
  RETURN_CODE := '0';

  --設定されていない引数名の初期化
  ERR_PARAM_NM := '';
  --必須入力チェック
  IF I_SYORI_YM IS NULL THEN
    ERR_PARAM_NM := '処理年月';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
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
  IF I_SHIME_KBN IS NULL THEN
    ERR_PARAM_NM := '締日区分';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
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
  IF I_EIGYO_BMN_CODE IS NULL THEN
    ERR_PARAM_NM := '営業部門コード';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
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
  IF I_CREATE_USR_CODE IS NULL THEN
    ERR_PARAM_NM := '作成者';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
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
    ERR_MSG_CHR := '回収予定データ（締め請求）作成関数にて引数エラーが発生しました。';
    RETURN;
  END IF;

  --引数.締日区分が0の場合
  IF I_SHIME_KBN = 0 THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '回収予定データ（締め請求）作成関数にて引数エラーが発生しました。';
    --エラーログ出力
    --UPDATE BY DTT AT 2009/09/21 START
    --P_LOG_ERROR(I_G_USR_CODE,
    --            I_G_TERM_NAME,
    --            I_G_FUNC_ID,
    --            '都度請求データの処理は本処理では実施できません。');
    ERRLOGGER_WRITE(I_G_USR_CODE,
                I_G_TERM_NAME,
                I_G_FUNC_ID,
                '都度請求データの処理は本処理では実施できません。',
                SyoriResult);
    IF SyoriResult <> 0 THEN
      RAISE ERRLOGGER_EXCEPT;
    END IF;
    --UPDATE BY DTT AT 2009/09/21 END
    RETURN;    
  END IF;

END SP_CHK_PARAM;

BEGIN
--主処理ーS
  RETURN_CODE := '0';
  ERR_MSG_ID := '';
  ERR_MSG_CHR := '';
  
  --1. 引数必須設定チェック
  SP_CHK_PARAM(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;

  N_M_TORI_BMN_IDX := 1;
  --取引先データレコード配列の初期化
  WK_M_TORI_BMN_TBL.DELETE;
  -- 2. 取引先データ取得
  OPEN GET_M_TORI_BMN;
  LOOP
    FETCH GET_M_TORI_BMN INTO WK_M_TORI_BMN_TBL(N_M_TORI_BMN_IDX);
    EXIT WHEN GET_M_TORI_BMN%NOTFOUND;
    N_M_TORI_BMN_IDX := N_M_TORI_BMN_IDX + 1;
  END LOOP;
  CLOSE GET_M_TORI_BMN;

  --対象データが存在しない場合
  IF WK_M_TORI_BMN_TBL IS NULL OR WK_M_TORI_BMN_TBL.COUNT = 0 THEN
    RETURN_CODE := '0';
    ERR_MSG_ID := '';
    ERR_MSG_CHR := '';
    RETURN;
  END IF;

  --システム運用年月取得 
  SELECT TO_CHAR(SYS_UNYO_YM1, 'YYYYMM') INTO WK_SYS_UNYO_YM1
  FROM
    M_CONTROL
  WHERE
    SYS_KEY = '1';

  --引数.処理年月の引数.締日区分の日付（締日区分が99の場合、月末日）
  IF I_SHIME_KBN = 99 THEN
    WK_SHORI_DATE := LAST_DAY(TO_DATE(I_SYORI_YM || '01', 'RRRR/MM/DD'));
  ELSE
    IF I_SHIME_KBN < 10 THEN
      WK_SHORI_DATE := TO_DATE(I_SYORI_YM || '0' || I_SHIME_KBN, 'RRRR/MM/DD');
    ELSE
      WK_SHORI_DATE := TO_DATE(I_SYORI_YM || I_SHIME_KBN, 'RRRR/MM/DD');
    END IF;
  END IF;

  --回収予定データレコードの配列数分、繰り返す
  FOR PAT_IDX IN 1 .. WK_M_TORI_BMN_TBL.COUNT LOOP
    R_M_TORI_BMN_TBL := WK_M_TORI_BMN_TBL(PAT_IDX);
    
    -- 前回作成分の回収予定データ削除
    SP_GET_F_COL_SCHED_DATA(R_M_TORI_BMN_TBL, RETURN_CODE);
    IF RETURN_CODE = '1' THEN
      RETURN;
    END IF;
    --売上データ取得 
    SP_GET_V_URIAGE(R_M_TORI_BMN_TBL,
                    RETURN_CODE);
    IF RETURN_CODE = '1' THEN
      RETURN;
    END IF;
  END LOOP;

  IF RETURN_CODE_REC_SHEET = '2' THEN
    RETURN_CODE := '2';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '回収予定データ（締め請求）作成関数にて前回登録したデータにて出力した領収書は無効となりました。';
  END IF;

  EXCEPTION
    WHEN OTHERS THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '回収予定データ（締め請求）作成関数にてシステム例外エラーが発生しました。';
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
END ZSK0010B;
/
