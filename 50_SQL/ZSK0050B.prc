CREATE OR REPLACE PROCEDURE ZSK0050B
/***************************************************************
 *  機能概要：引数情報より、
 *  対象の回収予定に対する前受金残高を更新する。
 *  引数１   ：伝票種別（入力）
 *  引数２   ：発生元伝票番号（入力）
 *  引数３   ：発生元伝票追番（入力）
 *  引数４   ：発生元伝票追加キー（入力）
 *  引数５   ：前受金使用額（入力）
 *  引数６   ：前受金使用日（入力）
 *  引数７   ：前受金回収完了フラグ（入力）
 *  引数８   ：グローバル情報.所属部門コード
 *  引数９   ：グローバル情報.ユーザコード
 *  引数１０ ：グローバル情報.プログラムID
 *  引数１１ ：グローバル情報.端末名
 *  引数１２ ：処理結果（0:正常終了、1:異常終了、2:警告終了）
 *  引数１３ ：エラーメッセージ（出力）
 *  引数１４ ：埋め込み文字（出力）
 *  引数１５ ：前受金残高（出力）
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

  -- 変数宣言部
  
  ERR_PARAM_NM            VARCHAR2(20);                             -- 設定されていない引数名
  WK_COLTD_AMOUNT         NUMBER;                                   -- 回収済金額
  WK_PRE_REC_USE_AMOUNT   NUMBER;                                   -- 前受金使用額
  WK_COL_STATUS           CHAR;                                     -- 回収状況
  WK_SEQUENCE_NO          F_COL_SCHED_S_H.MNG_NO%TYPE;              -- オラクルシーケンスにて採番した番号
  WK_TOKUI_CODE           F_COL_SCHED_H.TOKUI_CODE%TYPE;            --得意先コード
  WK_TOKUI_MADO_CODE      F_COL_SCHED_H.TOKUI_MADO_CODE%TYPE;       --得意先窓口コード
  WK_EIGYO_BMN_CODE       F_COL_SCHED_H.EIGYO_BMN_CODE%TYPE;        --営業部門コード
  WK_CUR_CODE             F_COL_SCHED_H.CUR_CODE%TYPE;              --通貨コード
  WK_COL_SCHED_NO         F_COL_SCHED_H.COL_SCHED_NO%TYPE;          -- 回収予定番号
  WK_SYS_UNYO_YM1         CHAR(6);                                  -- システム運用年月
  NOWAIT_RESOURCE_LOCKED  EXCEPTION;                               --行ロック異常
  PRAGMA EXCEPTION_INIT(NOWAIT_RESOURCE_LOCKED, -54);
  --ADD BY DTT AT 2009/09/21 START
  SyoriResult             NUMBER;
  ERRLOGGER_EXCEPT        EXCEPTION;
  --ADD BY DTT AT 2009/09/21 END

--回収予定データ取得
CURSOR GET_F_COL_SCHED IS
  SELECT
    COL_SCHED_NO,
    COL_SCHED_ADD_NO,
    CUR_CODE,                                                --通貨コード
    KINSYU_KBN,                                              --金種
    RATE,                                                    --レート
    COL_KBN,                                                 --回収区分
    ORIG_DENPYO_TYPE,                                        --発生元伝票種別
    ORIG_DENPYO_NO,                                          --発生元伝票番号
    ORIG_DENPYO_ADD_NO,                                      --発生元伝票追番
    JGYBNR_DAI_CODE,                                         --事業大分類コード
    JGYBNR_CHU_CODE,                                         --事業中分類コード
    PRE_REC_USE_AMOUNT,                                      --前受金使用額
    COLTD_AMOUNT,                                            --回収済金額
    LINE_AMOUNT,                                             --明細金額
    KOJI_NO,                                                 --工事番号
    KOJI_SUB_NO                                              --工事番号枝番
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
--回収予定データレコードの配列
TYPE T_F_COL_SCHED IS TABLE OF GET_F_COL_SCHED%ROWTYPE
  INDEX BY BINARY_INTEGER;
WK_F_COL_SCHED       T_F_COL_SCHED;
--回収予定データレコード配列の添え字
N_F_COL_SCHED_IDX    INTEGER(10);
--回収予定データレコードの１レコード分エリア
R_F_COL_SCHED_TBL    GET_F_COL_SCHED%ROWTYPE;

/**********************************************************
*** 機能名称：回収予定申請ヘッダの登録処理
*** 引数１  ：管理番号（入力）
*** 引数２  ：回収予定番号（入力）
*** 引数３  ：得意先コード（入力）
*** 引数４  ：得意先窓口コード（入力）
*** 引数５  ：通貨コード（入力）
*** 引数６  ：所属部門コード（入力）
*** 引数７  ：処理年月（入力）
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
     I_WK_TOKUI_CODE,          --得意先コード
     I_WK_TOKUI_MADO_CODE,     --得意先窓口コード
     I_WK_SYS_UNYO_YM1,        --処理年月
     '0',                      --締日区分「都度」
     I_WK_CUR_CODE,            --通貨コード
     '04',                     --処理ステータス「確定済」
     I_G_BMN_CODE,             --申請部門コード グローバル情報  所属部門コード 
     I_G_USR_CODE,             --申請者コード  -- ユーザーコード
     '',                       --次処理部門コード
     '',                       --次処理者コード
     I_G_USR_CODE,             --前処理者コード ユーザーコード
     '1',                      --請求確定フラグ「確定済」
     '',                       --処理者コメント
     I_WK_BMN_CODE,            --営業部門コード ＜補足説明＞2.1.の取得値
     SYSTIMESTAMP,             --作成日時
     I_G_USR_CODE,             --作成ユーザーコード グローバル情報 ユーザーコード
     SYSTIMESTAMP,             --更新日時
     I_G_USR_CODE,             --更新ユーザーコード グローバル情報ユーザーコード
     '',                       --削除日時
     '',                       --削除ユーザーコード
     '0'                       --削除フラグ「非削除」
      );
 END SP_INS_F_COL_SCHED_S_H;
 
/**********************************************************
*** 機能名称：回収予定申請明細の登録処理
*** 引数１  ：管理番号（入力）
*** 引数２  ：回収予定番号（入力）
*** 引数３  ：回収予定データレコードの１レコード分エリア（入力）
**********************************************************/
PROCEDURE SP_INS_F_COL_SCHED_S_M
(
  I_WK_SEQUENCE_NO     IN  F_COL_SCHED_S_M.MNG_NO%TYPE,
  I_WK_COL_SCHED_NO    IN  F_COL_SCHED_S_M.COL_SCHED_NO%TYPE,
  R_F_COL_SCHED_TBL    IN  GET_F_COL_SCHED%ROWTYPE  --回収予定データレコードの１レコード分エリア
) IS

BEGIN
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
        --ORIG_DENPYO_ADD_KEY,     --発生元伝票追加キー
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
        I_WK_SEQUENCE_NO,                       --管理番号
        1,                                      --管理明細番号
        I_WK_SEQUENCE_NO,                       --初期管理番号 管理番号と同値
        1,                                      --初期管理明細番号  管理明細番号と同値
        I_WK_COL_SCHED_NO,                      --回収予定番号 共通関数にて採番
        '00',                                   --回収予定追番
        '001',                                  --回収予定明細番号  "001"
        I_PRE_REC_USE_YMD,                      --回収予定日 前受金使用日
        R_F_COL_SCHED_TBL.KINSYU_KBN,           --金種 金種
        --UPDATE BY DTT AT 2009/10/09 START
        --NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) - NVL(R_F_COL_SCHED_TBL.COLTD_AMOUNT, 0),  --明細金額   前受金使用額－回収済金額
        NVL(R_F_COL_SCHED_TBL.LINE_AMOUNT, 0) - NVL(WK_COLTD_AMOUNT, 0),--＜補足説明＞3. 回収状況チェック処理の戻り値（回収済み金額）－ ＜補足説明＞2.1.で取得した明細金額
        --UPDATE BY DTT AT 2009/10/09 END
        R_F_COL_SCHED_TBL.CUR_CODE,             --通貨コード
        R_F_COL_SCHED_TBL.RATE,                 --レート
        TRUNC(R_F_COL_SCHED_TBL.LINE_AMOUNT * NVL(R_F_COL_SCHED_TBL.RATE, 0), 0 ), --邦貨換算額  金額×レート（小数部切捨て）
        '',                                     --クレーム番号
        I_PRE_REC_USE_YMD,                      --回収起算日  前受金使用日
        '',                                     --手形期日
        R_F_COL_SCHED_TBL.KOJI_NO,              --工事番号
        R_F_COL_SCHED_TBL.KOJI_SUB_NO,          --工事番号枝番
        '前受金残高更新での自動作成',           --備考
        '0',                                    --保留フラグ 「保留なし」
        R_F_COL_SCHED_TBL.COL_KBN,              --回収区分
        R_F_COL_SCHED_TBL.ORIG_DENPYO_TYPE,     --発生元伝票種別
        R_F_COL_SCHED_TBL.ORIG_DENPYO_NO,       --発生元伝票番号
        R_F_COL_SCHED_TBL.ORIG_DENPYO_ADD_NO,   --発生元伝票追番
       -- R_F_COL_SCHED_TBL.ORIG_DENPYO_ADD_KEY,  --発生元伝票追加キー
        R_F_COL_SCHED_TBL.JGYBNR_DAI_CODE,      --事業大分類コード
        R_F_COL_SCHED_TBL.JGYBNR_CHU_CODE,      --事業中分類コード
        '0',                                    --審査室連絡フラグ「非対象」
        SYSTIMESTAMP,                           --作成日時
        I_G_USR_CODE,                           --作成ユーザーコード グローバル情報
        SYSTIMESTAMP,                           --更新日時
        I_G_USR_CODE,                           --更新ユーザーコード グローバル情報
        '',                                     --削除日時
        '',                                     --削除ユーザーコード
        '0'                                     --削除フラグ 固定値「非削除」
      );

 END SP_INS_F_COL_SCHED_S_M;
 
 /**********************************************************
*** 機能名称：回収予定ヘッダの登録処理
*** 引数１  ：回収予定番号（入力）
*** 引数２  ：得意先コード（入力）
*** 引数３  ：得意先窓口コード（入力）
*** 引数４  ：通貨コード（入力）
*** 引数５  ：営業部門コード（入力）
*** 引数６  ：処理年月（入力）
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
        I_WK_TOKUI_CODE,         --得意先コード
        I_WK_TOKUI_MADO_CODE,    --得意先窓口コード
        I_WK_BMN_CODE,           --営業部門コード
        I_WK_SYS_UNYO_YM1,       --処理年月 システム運用年月
        '0',                     --締日区分 「都度」
        I_WK_CUR_CODE,           --通貨コード
        SYSTIMESTAMP,            --作成日時
        I_G_USR_CODE,            --作成ユーザーコード ユーザーコード
        SYSTIMESTAMP,            --更新日時
        I_G_USR_CODE,            --更新ユーザーコード ユーザーコード
        '',                      --削除日時
        '',                      --削除ユーザーコード
        '0'                      --削除フラグ「非削除」
      );

 END SP_INS_F_COL_SCHED_H;

 /**********************************************************
*** 機能名称：回収予定明細の登録処理
*** 引数１  ：回収予定番号（入力）
*** 引数２  ：回収予定データレコードの１レコード分エリア（入力）
**********************************************************/
PROCEDURE SP_INS_F_COL_SCHED_M
(
  I_WK_COL_SCHED_NO    IN  F_COL_SCHED_S_M.COL_SCHED_NO%TYPE,
  R_F_COL_SCHED_TBL    IN  GET_F_COL_SCHED%ROWTYPE  --回収予定データレコードの１レコード分エリア
) IS

BEGIN
    
    INSERT INTO F_COL_SCHED_M
     (
        COL_SCHED_NO,               --回収予定番号
        COL_SCHED_ADD_NO,           --回収予定追番
        --UPDATE BY DTT AT 2009/09/21 START
        --COL_SHCED_M_NO,          --回収予定明細番号
        COL_SCHED_M_NO,          --回収予定明細番号
        --UPDATE BY DTT AT 2009/09/21 END
        SYORI_KBN,                  --処理区分
        COL_SCHED_YMD,              --回収予定日
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
        --ORIG_DENPYO_ADD_KEY,        --発生元伝票追加キー
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
        I_WK_COL_SCHED_NO,                         --回収予定番号  共通関数にて採番
        '00',                                      --回収予定追番
        1,                                         --回収予定明細番号
        '0',                                       --処理区分「新規」
        I_PRE_REC_USE_YMD,                         --回収予定日 前受金使用日
        R_F_COL_SCHED_TBL.KINSYU_KBN,              --金種
        --UPDATE BY DTT AT 2009/10/09 START
        --NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) - NVL(R_F_COL_SCHED_TBL.COLTD_AMOUNT, 0),  --明細金額 回収予定申請明細登録時と同値
        NVL(R_F_COL_SCHED_TBL.LINE_AMOUNT, 0) - NVL(WK_COLTD_AMOUNT, 0),--明細金額 回収予定申請明細登録時と同値
        --UPDATE BY DTT AT 2009/10/09 END
        R_F_COL_SCHED_TBL.CUR_CODE,                --通貨コード
        R_F_COL_SCHED_TBL.RATE,                    --レート
        TRUNC(R_F_COL_SCHED_TBL.LINE_AMOUNT * NVL(R_F_COL_SCHED_TBL.RATE, 0), 0 ), --邦貨換算額
        NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) - NVL(R_F_COL_SCHED_TBL.COLTD_AMOUNT, 0), --回収済金額 明細金額
        NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) - NVL(R_F_COL_SCHED_TBL.COLTD_AMOUNT, 0), --前受金使用額 明細金額
        '',                                        --クレーム番号
        '1',                                       --回収完了フラグ
        I_PRE_REC_USE_YMD,                         --回収完了日
        I_PRE_REC_USE_YMD,                         --回収起算日
        '',                                        --手形期日
        R_F_COL_SCHED_TBL.JGYBNR_DAI_CODE,         --事業大分類コード
        R_F_COL_SCHED_TBL.JGYBNR_CHU_CODE,         --事業中分類コード
        R_F_COL_SCHED_TBL.COL_KBN,                 --回収区分
        R_F_COL_SCHED_TBL.ORIG_DENPYO_TYPE,        --発生元伝票種別
        R_F_COL_SCHED_TBL.ORIG_DENPYO_NO,          --発生元伝票番号
        R_F_COL_SCHED_TBL.ORIG_DENPYO_ADD_NO,      --発生元伝票追番
        --'',                                        --発生元伝票追加キー
        R_F_COL_SCHED_TBL.KOJI_NO,                 --工事番号
        R_F_COL_SCHED_TBL.KOJI_SUB_NO,             --工事番号枝番
        '前受金残高更新での自動作成',              --備考
        '',                                        --領収書発行区分
        '0',                                       --保留フラグ
        '0',                                       --審査室連絡フラグ
        SYSTIMESTAMP,                              --作成日時
        I_G_USR_CODE,                              --作成ユーザーコード ユーザーコード
        SYSTIMESTAMP,                              --更新日時
        I_G_USR_CODE,                              --更新ユーザーコード ユーザーコード
        '',                                        --削除日時
        '',                                        --削除ユーザーコード
        '0'                                        --削除フラグ「非削除」
      );

END SP_INS_F_COL_SCHED_M;

/**********************************************************
*** 機能名称：回収予定データの登録処理
*** 引数１  ：得意先コード（入力）
*** 引数２  ：得意先窓口コード （入力）
*** 引数３  ：営業部門コード（入力）
*** 引数４  ：通貨コード（入力）
*** 引数５  ：回収予定データレコードの１レコード分エリア（入力）
**********************************************************/
PROCEDURE SP_INS_F_COL_SCHED
(
  I_WK_TOKUI_CODE            F_COL_SCHED_H.TOKUI_CODE%TYPE,
  I_WK_TOKUI_MADO_CODE       F_COL_SCHED_H.TOKUI_MADO_CODE%TYPE,
  I_WK_EIGYO_BMN_CODE        F_COL_SCHED_H.EIGYO_BMN_CODE%TYPE,
  I_WK_CUR_CODE              F_COL_SCHED_H.CUR_CODE%TYPE,

  R_F_COL_SCHED_TBL IN  GET_F_COL_SCHED%ROWTYPE  --回収予定データレコードの１レコード分エリア
) IS
BEGIN
  --オラクルシーケンスにて採番し、番号を取得する。
  SELECT S_SK_COLSCHED_S_MNG_NO.NEXTVAL INTO WK_SEQUENCE_NO FROM DUAL;

  --システム運用年月取得 
  SELECT TO_CHAR(SYS_UNYO_YM1, 'YYYYMM') INTO WK_SYS_UNYO_YM1
  FROM
    M_CONTROL
  WHERE
    SYS_KEY = '1';
    
    --共通関数にて採番で回収予定番号を取得する。
    ----UPDATE BY DTT AT 2009/09/21 START
    /*
    P_KK_GETDENNO(I_ORIG_DENPYO_TYPE,  --伝票種別
                  I_WK_EIGYO_BMN_CODE,  --部門コード
                  SUBSTR(WK_SYS_UNYO_YM1, 1, 4), --年度
                  NVL(I_G_USR_CODE, '999999'),    --ユーザーコード(省略時初期値:999999)
                  I_G_FUNC_ID,
                  I_G_TERM_NAME,
                  WK_COL_SCHED_NO);
    */
    WK_COL_SCHED_NO := P_KK_GETDENNO(I_ORIG_DENPYO_TYPE,  --伝票種別
                  I_WK_EIGYO_BMN_CODE,  --部門コード
                  SUBSTR(WK_SYS_UNYO_YM1, 1, 4), --年度
                  NVL(I_G_USR_CODE, '999999'),    --ユーザーコード(省略時初期値:999999)
                  I_G_TERM_NAME);
    ----UPDATE BY DTT AT 2009/09/21 END
    IF WK_COL_SCHED_NO = '-1' OR WK_COL_SCHED_NO = '-2'
       OR WK_COL_SCHED_NO = '-3' OR WK_COL_SCHED_NO = '-8' OR WK_COL_SCHED_NO = '-9' THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := 'システムエラーが発生しました。';
      RETURN;
    END IF;

    --回収予定申請ヘッダの登録処理
    SP_INS_F_COL_SCHED_S_H(
      WK_SEQUENCE_NO,
      WK_COL_SCHED_NO,    --回収予定番号
      I_WK_TOKUI_CODE,
      I_WK_TOKUI_MADO_CODE,
      I_WK_CUR_CODE,
      I_WK_EIGYO_BMN_CODE,
      WK_SYS_UNYO_YM1
    );
    --回収予定申請明細の登録処理
    SP_INS_F_COL_SCHED_S_M(
      WK_SEQUENCE_NO,
      WK_COL_SCHED_NO,    --回収予定番号
      R_F_COL_SCHED_TBL
    );

    --回収予定ヘッダの登録処理
    SP_INS_F_COL_SCHED_H(
      WK_COL_SCHED_NO,    --回収予定番号
      I_WK_TOKUI_CODE,
      I_WK_TOKUI_MADO_CODE,
      I_WK_CUR_CODE,
      I_WK_EIGYO_BMN_CODE,
      WK_SYS_UNYO_YM1
    );

    --回収予定明細の登録処理
    SP_INS_F_COL_SCHED_M(
      WK_COL_SCHED_NO,    --回収予定番号
      R_F_COL_SCHED_TBL
    );

END SP_INS_F_COL_SCHED;

/**********************************************************
*** 機能名称：回収予定明細更新処理
*** 引数１  ：回収予定データレコードの１レコード分エリア（入力）
**********************************************************/
PROCEDURE SP_UPDATE_F_COL_SCHED
(
  R_F_COL_SCHED_TBL IN GET_F_COL_SCHED%ROWTYPE
) IS
BEGIN

  IF I_COL_COMP_FLG = '0' THEN
  --引数.前受金回収完了フラグが"0"の場合
    BEGIN
      UPDATE F_COL_SCHED_M
      SET                                                     
        PRE_REC_USE_AMOUNT =  NVL(R_F_COL_SCHED_TBL.PRE_REC_USE_AMOUNT, 0) + NVL(I_PRE_REC_USE_AMOUNT, 0), --前受金使用額
        PRE_REC_USE_YMD = I_PRE_REC_USE_YMD,                            --前受金使用日
        UPDATE_TIME = SYSTIMESTAMP,                                     --更新日時
        UPDATE_USR_CODE = I_G_USR_CODE                                  --更新ユーザーコード 
      WHERE                                                                       
        ORIG_DENPYO_TYPE = I_ORIG_DENPYO_TYPE                            --発生元伝票種別
        AND ORIG_DENPYO_NO = I_ORIG_DENPYO_NO                            --発生元伝票番号
        AND ORIG_DENPYO_ADD_NO = I_ORIG_DENPYO_ADD_NO                    --発生元伝票追番
        AND (ORIG_DENPYO_ADD_KEY LIKE NVL(I_ORIG_DENPYO_ADD_KEY , '%')
            OR (ORIG_DENPYO_ADD_KEY IS NULL AND I_ORIG_DENPYO_ADD_KEY IS NULL))    --発生元伝票追加キー
      ;
    END;
  
  ELSE
    IF I_COL_COMP_FLG = '1' THEN
  --引数.前受金回収完了フラグが"1"の場合
      BEGIN
        UPDATE F_COL_SCHED_M
        SET
          COLTD_AMOUNT = R_F_COL_SCHED_TBL.LINE_AMOUNT,                  --回収済金額
          PRE_REC_USE_AMOUNT = R_F_COL_SCHED_TBL.LINE_AMOUNT,            --前受金使用額
          COL_COMP_FLG = '1',                                            --回収完了フラグ
          COL_COMP_YMD = PRE_REC_USE_YMD,                                --回収完了日
          PRE_REC_USE_YMD = PRE_REC_USE_YMD,                             --前受金使用日
          UPDATE_TIME = SYSTIMESTAMP,                                    --更新日時
          UPDATE_USR_CODE = I_G_USR_CODE                                 --更新ユーザーコード
        WHERE                                                                       
          ORIG_DENPYO_TYPE = I_ORIG_DENPYO_TYPE                           --発生元伝票種別
          AND ORIG_DENPYO_NO = I_ORIG_DENPYO_NO                           --発生元伝票番号
          AND ORIG_DENPYO_ADD_NO = I_ORIG_DENPYO_ADD_NO                   --発生元伝票追番
          AND (ORIG_DENPYO_ADD_KEY LIKE NVL(I_ORIG_DENPYO_ADD_KEY , '%')
              OR (ORIG_DENPYO_ADD_KEY IS NULL AND I_ORIG_DENPYO_ADD_KEY IS NULL))   --発生元伝票追加キー 
        ;
      END;
    END IF;
  END IF;

END SP_UPDATE_F_COL_SCHED;

/**********************************************************
*** 機能名称：回収予定データ取得処理
*** 引数１  ：処理結果（0:正常終了、1:異常終了）
**********************************************************/
PROCEDURE SP_GET_F_COL_SCHED
(
  RETURN_CODE OUT CHAR
) IS
BEGIN
  BEGIN
    N_F_COL_SCHED_IDX := 1;
    --回収予定データワークレコード配列の初期化
    WK_F_COL_SCHED.DELETE;
  
    OPEN GET_F_COL_SCHED;
    LOOP
      --回収予定データ取得
      FETCH GET_F_COL_SCHED INTO WK_F_COL_SCHED(N_F_COL_SCHED_IDX);
      --最終レコードの場合終了
      EXIT WHEN GET_F_COL_SCHED%NOTFOUND;
      N_F_COL_SCHED_IDX := N_F_COL_SCHED_IDX + 1;
    END LOOP;
    CLOSE GET_F_COL_SCHED;
    
    EXCEPTION
      WHEN NOWAIT_RESOURCE_LOCKED THEN
        RETURN_CODE := '1';
        ERR_MSG_ID := 'ENM00001';
        ERR_MSG_CHR := '前受金残高更新関数にてＤＢエラーが発生しました。'
            || '（対象の回収予定データが他のユーザにより、処理中です。）';
        RETURN;
      WHEN OTHERS THEN
        RAISE;

  END;
    --取得できない場合
    IF WK_F_COL_SCHED IS NULL OR WK_F_COL_SCHED.COUNT = 0 THEN
      RETURN_CODE := '1';
      ERR_MSG_ID := 'ENM00001';
      ERR_MSG_CHR := '前受金残高更新関数にてＤＢエラーが発生しました。（対象の回収予定データが存在しません。）';
      RETURN;
    END IF;

END SP_GET_F_COL_SCHED;

/**********************************************************
*** 機能名称：引数必須設定チェック処理
*** 引数１  ：処理結果（0:正常終了、1:異常終了）
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
  IF I_ORIG_DENPYO_TYPE IS NULL THEN
    ERR_PARAM_NM := '伝票種別';
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
  IF I_ORIG_DENPYO_NO IS NULL THEN
    ERR_PARAM_NM := '発生元伝票番号';
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
  IF I_ORIG_DENPYO_ADD_NO IS NULL THEN
    ERR_PARAM_NM := '発生元伝票追番';
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
  IF I_PRE_REC_USE_AMOUNT IS NULL THEN
    ERR_PARAM_NM := '前受金使用額';
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
  IF I_PRE_REC_USE_YMD IS NULL THEN
    ERR_PARAM_NM := '前受金使用日';
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
  IF I_COL_COMP_FLG IS NULL THEN
    ERR_PARAM_NM := '前受金回収完了フラグ';
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
    ERR_MSG_CHR := '前受金残高更新関数にて引数エラーが発生しました。';
    RETURN;
  END IF;
  
END SP_CHK_PARAM;

BEGIN
--主処理ーS
  --出力初期化
  RETURN_CODE := '0';
  ERR_MSG_ID := '';
  ERR_MSG_CHR := '';

  --1. 引数必須設定チェック
  SP_CHK_PARAM(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;
  
  --回収予定データワークレコード配列の添え字を初期化
  N_F_COL_SCHED_IDX := 0;
  -- 2. 回収予定データ取得
  SP_GET_F_COL_SCHED(RETURN_CODE);
  IF RETURN_CODE = '1' THEN
    RETURN;
  END IF;
  --3. 回収状況チェック処理を実施する。
  --3.1. ＜編集条件＞1. 回収状況チェック処理に従い、共通関数を実行する。
  ZSK0040B(I_ORIG_DENPYO_TYPE,    --伝票種別
           I_ORIG_DENPYO_NO,      --発生元伝票番号
           I_ORIG_DENPYO_ADD_NO,  --発生元伝票追番
           I_ORIG_DENPYO_ADD_KEY, --発生元伝票追加キー
           I_G_USR_CODE,          --グローバル情報.ユーザコード
           I_G_FUNC_ID,           --グローバル情報.プログラムID
           I_G_TERM_NAME,         --グローバル情報.端末名
           RETURN_CODE,           --処理結果
           ERR_MSG_ID,            --エラーメッセージ
           ERR_MSG_CHR,           --埋め込み文字
           WK_COL_STATUS,         --回収状況
           WK_COLTD_AMOUNT,       --回収済金額
           WK_PRE_REC_USE_AMOUNT  --前受金使用額
   );
  --3.2. 回収状況チェック処理の戻り値（処理結果）が"1"「異常終了」の場合   
  IF RETURN_CODE = '1' THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := ERR_MSG_ID;
    ERR_MSG_CHR := ERR_MSG_CHR;
    RETURN; 
  END IF;
  --3.3. 回収予定状況チェック処理の戻り値（処理結果）が"0"「正常終了」だが、
  --    戻り値の回収状況が「1：未回収」、「2：一部回収済」、
  --    「3：回収完了」以外の場合
  IF RETURN_CODE = '0'
    AND WK_COL_STATUS NOT IN ('1' , '2', '3')  THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '前受金残高更新関数にて整合性エラーが発生しました。（対象の回収予定データが更新可能な状態にありません。）';
    RETURN;
  END IF;
  --3.4. 回収状況チェック処理の戻り値（回収済金額－前受金使用額）－引数.前受金使用額が負数となる場合
  IF (NVL(WK_COLTD_AMOUNT, 0) - NVL(WK_PRE_REC_USE_AMOUNT, 0) - NVL(I_PRE_REC_USE_AMOUNT, 0)) < 0 THEN
    RETURN_CODE := '1';
    ERR_MSG_ID := 'ENM00001';
    ERR_MSG_CHR := '前受金残高更新関数にて整合性エラーが発生しました。（前受金残高以上の金額を使用することはできません。）';
    RETURN;
  END IF;
 
  --4. 回収予定明細更新
  --仕訳パターンワークレコードの配列数分、繰り返す
  FOR PAT_IDX IN 1 .. WK_F_COL_SCHED.COUNT LOOP
    R_F_COL_SCHED_TBL := WK_F_COL_SCHED(PAT_IDX);
    --回収予定明細更新処理
    SP_UPDATE_F_COL_SCHED(R_F_COL_SCHED_TBL);
    
  END LOOP;
  
  --5. 回収予定差分データ作成
  --UPDATE BY DTT AT 2009/10/09 START
  --引数.前受金回収完了フラグが"1"、
  --  且つ回収状況チェック戻り値（回収済金額－前受金使用額）－引数.前受金使用額が1以上の場合
  --IF I_COL_COMP_FLG = '1'
  --  AND 1 <= (NVL(WK_COLTD_AMOUNT, 0) - NVL(WK_PRE_REC_USE_AMOUNT, 0) - NVL(I_PRE_REC_USE_AMOUNT, 0)) THEN
  
  --  FOR PAT_IDX IN 1 .. WK_F_COL_SCHED.COUNT LOOP
  --    R_F_COL_SCHED_TBL := WK_F_COL_SCHED(PAT_IDX);
  --引数.前受金回収完了フラグが"1"、
  --  且つ2.1.で取得した回収予定明細の明細金額－回収状況チェック戻り値（回収済金額）が1以上の場合
  R_F_COL_SCHED_TBL := WK_F_COL_SCHED(1);
  IF I_COL_COMP_FLG = '1'
    AND 1 <= NVL(R_F_COL_SCHED_TBL.LINE_AMOUNT, 0) - NVL(WK_COLTD_AMOUNT, 0) THEN
      --回収予定ヘッダ情報取得 TODO
      SELECT
        TOKUI_CODE,       --得意先コード
        TOKUI_MADO_CODE,  --得意先窓口コード
        EIGYO_BMN_CODE,   --営業部門コード
        CUR_CODE          --通貨コード
        
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
      --回収予定データの登録を行う。
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
  --6. 戻り値設定
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
      ERR_MSG_CHR := '回収予定データ（都度請求）作成関数にてシステム例外エラーが発生しました。';
      
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
END ZSK0050B;
/
