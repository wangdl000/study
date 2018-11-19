<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="package" var="packageInfo" />

<!-- ##Page:ログイン## -->
<fmt:message bundle="${packageInfo}" var="label_field_id" key="web.login.field.id" /><!-- 受付番号 -->
<fmt:message bundle="${packageInfo}" var="label_field_password" key="web.login.field.password" /><!-- パスワード -->
<!-- ##Page:a管理画面項目定義## -->
<!-- ##Page:共通## -->
<fmt:message bundle="${packageInfo}" var="label_company_name" key="web.admin.common.company.name" /><!-- GEL研究所株式会社 -->
<fmt:message bundle="${packageInfo}" var="label_system_name" key="web.admin.common.system.name" /><!-- 商品受注管理システム -->
<!-- ##Page:ページング## -->
<fmt:message bundle="${packageInfo}" var="label_paging_countText" key="web.admin.common.paging.countText" /><!-- {0}&nbsp;～&nbsp;{1}件／全{2}件 -->
<fmt:message bundle="${packageInfo}" var="label_paging_link_prev" key="web.admin.common.paging.link.prev" /><!-- &lt;&lt;前へ -->
<fmt:message bundle="${packageInfo}" var="label_paging_link_next" key="web.admin.common.paging.link.next" /><!-- 次へ&gt;&gt; -->
<fmt:message bundle="${packageInfo}" var="label_paging_link_number" key="web.admin.common.paging.link.number" /><!-- [{0}] -->
<!-- ##Page:ヘッダー## -->
<fmt:message bundle="${packageInfo}" var="label_button_logout" key="web.admin.header.button.logout" /><!-- ログアウト -->
<fmt:message bundle="${packageInfo}" var="label_text_userNameSuffix" key="web.admin.header.text.userNameSuffix" /><!-- 　様 -->
<!-- ##Page:フッター## -->
<fmt:message bundle="${packageInfo}" var="label_copyright" key="web.admin.footer.text.copyright" /><!-- Copyright©2009-2018GEL研究所株式会社Allrightsreserved. -->
<fmt:message bundle="${packageInfo}" var="label_copyright_year" key="web.admin.footer.text.copyright.year" /><!-- 2018 -->
<!-- ##Page:サイドメニュー -->
<fmt:message bundle="${packageInfo}" var="label_button_top" key="web.admin.menu.button.top" /><!-- トップ -->
<fmt:message bundle="${packageInfo}" var="label_button_item" key="web.admin.menu.button.item" /><!-- 商品管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_code" key="web.admin.menu.button.code" /><!-- マスター管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_comment" key="web.admin.menu.button.comment" /><!-- お知らせ管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_catalog" key="web.admin.menu.button.catalog" /><!-- カタログ管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_user" key="web.admin.menu.button.user" /><!-- ユーザ管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_itemImport" key="web.admin.menu.button.itemImport" /><!-- 商品情報一括取り込み -->
<!-- ##Page:管理画面ログイン## -->
<fmt:message bundle="${packageInfo}" var="label_login_title" key="web.admin.content.login.title" /><!-- 管理画面ログイン -->
<fmt:message bundle="${packageInfo}" var="label_login_field_kanriUserId" key="web.admin.content.login.field.kanriUserId" /><!-- ログインID -->
<fmt:message bundle="${packageInfo}" var="label_login_field_kanriUserPassword" key="web.admin.content.login.field.kanriUserPassword" /><!-- パスワード -->
<fmt:message bundle="${packageInfo}" var="label_login_field_kikakuCd" key="web.admin.content.login.field.kikakuCd" /><!-- 企画名 -->
<fmt:message bundle="${packageInfo}" var="label_login_button_login" key="web.admin.content.login.button.login" /><!-- ログイン -->
<!-- ##Page:管理画面トップページ## -->
<fmt:message bundle="${packageInfo}" var="label_web_admin_content_top_title" key="web.admin.content.top.title" /><!-- 管理画面トップページ -->
<!-- ##Page:商品情報一覧## -->
<fmt:message bundle="${packageInfo}" var="label_item_list_title" key="web.admin.content.item.list.title" /><!-- 商品情報一覧・検索 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_catalogId" key="web.admin.content.item.list.field.catalogId" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_catalogId_headerKey" key="web.admin.content.user.list.field.catalogId.headerKey" /><!--  -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_catalogId_headerValue" key="web.admin.content.user.list.field.catalogId.headerValue" /><!-- すべて -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_hagakiSyouhinCd" key="web.admin.content.item.list.field.hagakiSyouhinCd" /><!-- カタログ商品番号 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_syouhinHyoujiName" key="web.admin.content.item.list.field.syouhinHyoujiName" /><!-- 商品名 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_itemKeisaiKbn" key="web.admin.content.item.list.field.itemKeisaiKbn" /><!-- 掲載区分 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_itemKeisaiKbn_headerKey" key="web.admin.content.item.list.field.itemKeisaiKbn.headerKey" /><!--  -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_itemKeisaiKbn_headerValue" key="web.admin.content.item.list.field.itemKeisaiKbn.headerValue" /><!-- すべて -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_genreNo" key="web.admin.content.item.list.field.genreNo" /><!-- カテゴリ -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_genreNoheaderKey" key="web.admin.content.item.list.field.genreNoheaderKey" /><!--  -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_headerValue" key="web.admin.content.item.list.field.headerValue" /><!-- すべて -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_pageIndex" key="web.admin.content.item.list.field.pageIndex" /><!-- ページ番号 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_sortItem" key="web.admin.content.item.list.field.sortItem" /><!-- 並び順 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_field_listCnt" key="web.admin.content.item.list.field.listCnt" /><!-- 表示件数 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_button_search" key="web.admin.content.item.list.button.search" /><!-- 検　索 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_result_body_hagakiSyouhinCd" key="web.admin.content.item.list.result.body.hagakiSyouhinCd" /><!-- 商品番号 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_result_body_catalogName" key="web.admin.content.item.list.result.body.catalogName" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_result_body_allGenre" key="web.admin.content.item.list.result.body.allGenre" /><!-- カテゴリ名 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_result_body_syouhinHyoujiName" key="web.admin.content.item.list.result.body.syouhinHyoujiName" /><!-- 商品名 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_result_body_itemKeisaiName" key="web.admin.content.item.list.result.body.itemKeisaiName" /><!-- 掲載区分 -->
<fmt:message bundle="${packageInfo}" var="label_item_list_result_body_link_edit" key="web.admin.content.item.list.result.body.link.edit" /><!-- 編集 -->
<!-- ##Page:商品詳細説明入力## -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_title" key="web.admin.content.item.edit.title" /><!-- 商品詳細説明入力 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_catalogName" key="web.admin.content.item.edit.field.catalogName" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_hagakiSyouhinCd" key="web.admin.content.item.edit.field.hagakiSyouhinCd" /><!-- 商品番号 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_genreList" key="web.admin.content.item.edit.field.genreList" /><!-- カテゴリ -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_limitedList" key="web.admin.content.item.edit.field.limitedList" /><!-- おすすめ・限定品 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_itemKeisaiKbn" key="web.admin.content.item.edit.field.itemKeisaiKbn" /><!-- 掲載区分 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_kikanGenteiFlg" key="web.admin.content.item.edit.field.kikanGenteiFlg" /><!-- 期間限定 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_kikanGenteiFlg_comment" key="web.admin.content.item.edit.field.kikanGenteiFlg.comment" /><!-- 期間限定品 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_dispGenteiKikan" key="web.admin.content.item.edit.field.dispGenteiKikan" /><!-- 掲載期間 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinHyoujiName" key="web.admin.content.item.edit.field.syouhinHyoujiName" /><!-- 商品名 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_catchCopy" key="web.admin.content.item.edit.field.catchCopy" /><!-- キャッチコピー -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_itemSyosai" key="web.admin.content.item.edit.field.itemSyosai" /><!-- 商品詳細説明 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_itemNaiyou" key="web.admin.content.item.edit.field.itemNaiyou" /><!-- 入数・内容量 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_itemSanti" key="web.admin.content.item.edit.field.itemSanti" /><!-- 産地情報 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_itemKigen" key="web.admin.content.item.edit.field.itemKigen" /><!-- 賞味・消費期限 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_arerugiJoho" key="web.admin.content.item.edit.field.arerugiJoho" /><!-- アレルギー情報 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_allergieTamagoFlg" key="web.admin.content.item.edit.field.allergieTamagoFlg" /><!-- 卵 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_allergieMilkFlg" key="web.admin.content.item.edit.field.allergieMilkFlg" /><!-- 乳 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_allergieKomugiFlg" key="web.admin.content.item.edit.field.allergieKomugiFlg" /><!-- 小麦 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_allergiePeanutFlg" key="web.admin.content.item.edit.field.allergiePeanutFlg" /><!-- 落花生 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_allergieSobaFlg" key="web.admin.content.item.edit.field.allergieSobaFlg" /><!-- そば -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_allergieEbiFlg" key="web.admin.content.item.edit.field.allergieEbiFlg" /><!-- えび -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_allergieKaniFlg" key="web.admin.content.item.edit.field.allergieKaniFlg" /><!-- かに -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_allergieEtcText" key="web.admin.content.item.edit.field.allergieEtcText" /><!-- 特定原材料に準ずるもの： -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_itemHaisouHouhou" key="web.admin.content.item.edit.field.itemHaisouHouhou" /><!-- 配送方法 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_catalogKeisaiPageNo" key="web.admin.content.item.edit.field.catalogKeisaiPageNo" /><!-- カタログ掲載ページ -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_sortOrder" key="web.admin.content.item.edit.field.sortOrder" /><!-- 表示順 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_sortOrder_comment" key="web.admin.content.item.edit.field.sortOrder.comment" /><!-- ※未入力の場合、カタログ掲載ページ、商品番号の昇順となります。 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_todokeBiSiteiFukaFlg" key="web.admin.content.item.edit.field.todokeBiSiteiFukaFlg" /><!-- 届け日指定 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImage1" key="web.admin.content.item.edit.field.syouhinImage1" /><!-- 画像１（メイン） -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImage1_comment" key="web.admin.content.item.edit.field.syouhinImage1.comment" /><!-- 画像ファイルを選択してください。 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImageDelFlg1" key="web.admin.content.item.edit.field.syouhinImageDelFlg1" /><!-- 削除 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImage2" key="web.admin.content.item.edit.field.syouhinImage2" /><!-- 画像２ -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImage2_comment" key="web.admin.content.item.edit.field.syouhinImage2.comment" /><!-- 画像ファイルを選択してください。 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImageDelFlg2" key="web.admin.content.item.edit.field.syouhinImageDelFlg2" /><!-- 削除 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImage3" key="web.admin.content.item.edit.field.syouhinImage3" /><!-- 画像３ -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImage3_comment" key="web.admin.content.item.edit.field.syouhinImage3.comment" /><!-- 画像ファイルを選択してください。 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_syouhinImageDelFlg3" key="web.admin.content.item.edit.field.syouhinImageDelFlg3" /><!-- 削除 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_field_webSyouhinBikou" key="web.admin.content.item.edit.field.webSyouhinBikou" /><!-- 備考 -->
<fmt:message bundle="${packageInfo}" var="label_item_edit_button_update" key="web.admin.content.item.edit.button.update" /><!-- 更　新 -->
<!-- ##Page:ユーザ管理（検索・一覧表示）## -->
<fmt:message bundle="${packageInfo}" var="label_user_list_title" key="web.admin.content.user.list.title" /><!-- ユーザ管理（検索・一覧表示） -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_kikakuCd" key="web.admin.content.user.list.field.kikakuCd" /><!-- 企画名 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_kikakuCd_headerKey" key="web.admin.content.user.list.field.kikakuCd.headerKey" /><!--  -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_kikakuCd_headerValue" key="web.admin.content.user.list.field.kikakuCd.headerValue" /><!-- すべて -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_kanriUserId" key="web.admin.content.user.list.field.kanriUserId" /><!-- ユーザＩＤ -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_kanriUserNm" key="web.admin.content.user.list.field.kanriUserNm" /><!-- ユーザ名 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_siyouKahiFlg" key="web.admin.content.user.list.field.siyouKahiFlg" /><!-- 使用可否 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_siyouKahiFlg_headerKey" key="web.admin.content.user.list.field.siyouKahiFlg.headerKey" /><!--  -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_siyouKahiFlg_headerValue" key="web.admin.content.user.list.field.siyouKahiFlg.headerValue" /><!-- すべて -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_pageIndex" key="web.admin.content.user.list.field.pageIndex" /><!-- ページ番号 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_sortItem" key="web.admin.content.user.list.field.sortItem" /><!-- 並び順 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_field_listCnt" key="web.admin.content.user.list.field.listCnt" /><!-- 表示件数 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_button_search" key="web.admin.content.user.list.button.search" /><!-- 検　索 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_button_add" key="web.admin.content.user.list.button.add" /><!-- 新規追加 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_result_head_kanriUserId" key="web.admin.content.user.list.result.head.kanriUserId" /><!-- ユーザＩＤ -->
<fmt:message bundle="${packageInfo}" var="label_user_list_result_head_kanriUserNm" key="web.admin.content.user.list.result.head.kanriUserNm" /><!-- ユーザ名 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_result_head_kikakuName" key="web.admin.content.user.list.result.head.kikakuName" /><!-- 企画名 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_result_head_siyouKahiFlg" key="web.admin.content.user.list.result.head.siyouKahiFlg" /><!-- 使用可否 -->
<fmt:message bundle="${packageInfo}" var="label_user_list_result_head_edit" key="web.admin.content.user.list.result.head.edit" /><!-- &nbsp; -->
<fmt:message bundle="${packageInfo}" var="label_user_list_result_body_link_edit" key="web.admin.content.user.list.result.body.link.edit" /><!-- 編集 -->
<!-- ##Page:ユーザ管理（新規）## -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_title" key="web.admin.content.user.regist.title" /><!-- ユーザ管理（新規） -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_kanriUserId" key="web.admin.content.user.regist.field.kanriUserId" /><!-- ユーザＩＤ -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_kanriUserNm" key="web.admin.content.user.regist.field.kanriUserNm" /><!-- ユーザ名 -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_kanriUserPassword" key="web.admin.content.user.regist.field.kanriUserPassword" /><!-- パスワード -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_kanriUserPasswordKakunin" key="web.admin.content.user.regist.field.kanriUserPasswordKakunin" /><!-- パスワード（確認） -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_svFlg" key="web.admin.content.user.regist.field.svFlg" /><!-- スーパーバイザー -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_kikakuCdList" key="web.admin.content.user.regist.field.kikakuCdList" /><!-- 企画名 -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_siyouKahiFlg" key="web.admin.content.user.regist.field.siyouKahiFlg" /><!-- 使用可否 -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_koushinBi" key="web.admin.content.user.regist.field.koushinBi" /><!-- 更新日 -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_field_maxKoushinBi" key="web.admin.content.user.regist.field.maxKoushinBi" /><!-- 企画最大更新日 -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_text_kanriUserPasswordKakunin_message" key="web.admin.content.user.regist.text.kanriUserPasswordKakunin.message" /><!-- 確認のため、もう一度入力してください。 -->
<fmt:message bundle="${packageInfo}" var="label_user_regist_button_regist" key="web.admin.content.user.regist.button.regist" /><!-- 登　録 -->
<!-- ##Page:ユーザ管理（編集）## -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_title" key="web.admin.content.user.edit.title" /><!-- ユーザ管理（編集） -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_kanriUserId" key="web.admin.content.user.edit.field.kanriUserId" /><!-- ユーザＩＤ -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_kanriUserNm" key="web.admin.content.user.edit.field.kanriUserNm" /><!-- ユーザ名 -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_kanriUserPassword" key="web.admin.content.user.edit.field.kanriUserPassword" /><!-- パスワード -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_kanriUserPasswordKakunin" key="web.admin.content.user.edit.field.kanriUserPasswordKakunin" /><!-- パスワード（確認） -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_svFlg" key="web.admin.content.user.edit.field.svFlg" /><!-- スーパーバイザー -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_kikakuCdList" key="web.admin.content.user.edit.field.kikakuCdList" /><!-- 企画名 -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_siyouKahiFlg" key="web.admin.content.user.edit.field.siyouKahiFlg" /><!-- 使用可否 -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_koushinBi" key="web.admin.content.user.edit.field.koushinBi" /><!-- 更新日 -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_field_maxKoushinBi" key="web.admin.content.user.edit.field.maxKoushinBi" /><!-- 企画最大更新日 -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_text_kanriUserPasswordKakunin_message" key="web.admin.content.user.edit.text.kanriUserPasswordKakunin.message" /><!-- 確認のため、もう一度入力してください。 -->
<fmt:message bundle="${packageInfo}" var="label_user_edit_button_edit" key="web.admin.content.user.edit.button.edit" /><!-- 更　新 -->
<!-- ##Page:マスタ管理（検索・一覧表示）## -->
<fmt:message bundle="${packageInfo}" var="label_code_list_title" key="web.admin.content.code.list.title" /><!-- マスター管理（検索・一覧表示） -->
<fmt:message bundle="${packageInfo}" var="label_code_list_field_sikibetsuCd" key="web.admin.content.code.list.field.sikibetsuCd" /><!-- コード番号 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_field_sikibetsuNm" key="web.admin.content.code.list.field.sikibetsuNm" /><!-- コード名称 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_field_sortItem" key="web.admin.content.code.list.field.sortItem" /><!-- 並び順 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_field_listCnt" key="web.admin.content.code.list.field.listCnt" /><!-- 表示件数 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_field_pageIndex" key="web.admin.content.code.list.field.pageIndex" /><!-- ページ番号 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_button_search" key="web.admin.content.code.list.button.search" /><!-- 検　索 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_result_head_sikibetsuCd" key="web.admin.content.code.list.result.head.sikibetsuCd" /><!-- 番号 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_result_head_sikibetsuNm" key="web.admin.content.code.list.result.head.sikibetsuNm" /><!-- 名称 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_result_head_codeMemo" key="web.admin.content.code.list.result.head.codeMemo" /><!-- 説明 -->
<fmt:message bundle="${packageInfo}" var="label_code_list_result_head_edit" key="web.admin.content.code.list.result.head.edit" /><!-- &nbsp; -->
<fmt:message bundle="${packageInfo}" var="label_code_list_result_body_link_edit" key="web.admin.content.code.list.result.body.link.edit" /><!-- 編集 -->
<!-- ##Page:マスタ管理（編集）## -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_title" key="web.admin.content.code.edit.title" /><!-- マスター管理（編集） -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_head_codeJyouhou" key="web.admin.content.code.edit.head.codeJyouhou" /><!-- コード情報 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_head_codeMeisai" key="web.admin.content.code.edit.head.codeMeisai" /><!-- コード明細 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_field_sikibetsuCd" key="web.admin.content.code.edit.field.sikibetsuCd" /><!-- コード番号 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_field_sikibetsuNm" key="web.admin.content.code.edit.field.sikibetsuNm" /><!-- コード名称 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_field_codeMemo" key="web.admin.content.code.edit.field.codeMemo" /><!-- コード説明 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_button_edit" key="web.admin.content.code.edit.button.edit" /><!-- 更　新 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_button_add" key="web.admin.content.code.edit.button.add" /><!-- 行追加 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_result_head_code" key="web.admin.content.code.edit.result.head.code" /><!-- 値 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_result_head_value" key="web.admin.content.code.edit.result.head.value" /><!-- 内容 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_result_head_bikou" key="web.admin.content.code.edit.result.head.bikou" /><!-- 説明（備考） -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_result_head_sortOrder" key="web.admin.content.code.edit.result.head.sortOrder" /><!-- 表示順 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_result_head_siyouKahiFlg" key="web.admin.content.code.edit.result.head.siyouKahiFlg" /><!-- 使用可否 -->
<fmt:message bundle="${packageInfo}" var="label_code_edit_result_head_delFlg" key="web.admin.content.code.edit.result.head.delFlg" /><!-- 削除 -->
<!-- ##Page:お知らせ管理（検索・一覧表示） -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_title" key="web.admin.content.comment.list.title" /><!-- お知らせ管理（検索・一覧表示） -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_catalogId" key="web.admin.content.comment.list.field.catalogId" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_catalogId_headerKey" key="web.admin.content.comment.list.field.catalogId.headerKey" /><!--  -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_catalogId_headerValue" key="web.admin.content.comment.list.field.catalogId.headerValue" /><!-- すべて -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_msgNo" key="web.admin.content.comment.list.field.msgNo" /><!-- 番号 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_msgHeader" key="web.admin.content.comment.list.field.msgHeader" /><!-- タイトル -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_msgKeisaiKbn" key="web.admin.content.comment.list.field.msgKeisaiKbn" /><!-- 掲載区分 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_msgKeisaiKbn_headerKey" key="web.admin.content.comment.list.field.msgKeisaiKbn.headerKey" /><!--  -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_msgKeisaiKbn_headerValue" key="web.admin.content.comment.list.field.msgKeisaiKbn.headerValue" /><!-- すべて -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_keisai" key="web.admin.content.comment.list.field.keisai" /><!-- 掲載期間 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_keisaiFrom" key="web.admin.content.comment.list.field.keisaiFrom" /><!-- 掲載期間開始日 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_keisaiTo" key="web.admin.content.comment.list.field.keisaiTo" /><!-- 掲載期間終了日 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_field_waveLine" key="web.admin.content.comment.list.field.waveLine" /><!-- ～ -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_button_search" key="web.admin.content.comment.list.button.search" /><!-- 検　索 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_button_add" key="web.admin.content.comment.list.button.add" /><!-- 新規追加 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_result_head_catalogName" key="web.admin.content.comment.list.result.head.catalogName" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_result_head_msgNo" key="web.admin.content.comment.list.result.head.msgNo" /><!-- 番号 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_result_head_msgHeader" key="web.admin.content.comment.list.result.head.msgHeader" /><!-- タイトル -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_result_head_msgkeisaiName" key="web.admin.content.comment.list.result.head.msgkeisaiName" /><!-- 掲載区分 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_result_head_keisai" key="web.admin.content.comment.list.result.head.keisai" /><!-- 掲載期間 -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_result_body_waveLine" key="web.admin.content.comment.list.result.body.waveLine" /><!-- ～ -->
<fmt:message bundle="${packageInfo}" var="label_comment_list_result_body_link_edit" key="web.admin.content.comment.list.result.body.link.edit" /><!-- 編集 -->
<!-- ##Page:お知らせ管理（編集）## -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_title" key="web.admin.content.comment.edit.title" /><!-- お知らせ管理（編集） -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_catalogId" key="web.admin.content.comment.edit.field.catalogId" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_msgNo" key="web.admin.content.comment.edit.field.msgNo" /><!-- お知らせ番号 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_msgKeisaiKbn" key="web.admin.content.comment.edit.field.msgKeisaiKbn" /><!-- 掲載区分 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_keisai" key="web.admin.content.comment.edit.field.keisai" /><!-- 掲載期間 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_keisaiFrom" key="web.admin.content.comment.edit.field.keisaiFrom" /><!-- 掲載期間開始日 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_keisaiTo" key="web.admin.content.comment.edit.field.keisaiTo" /><!-- 掲載期間終了日 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_msgHeader" key="web.admin.content.comment.edit.field.msgHeader" /><!-- タイトル -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_msgNaiyou" key="web.admin.content.comment.edit.field.msgNaiyou" /><!-- お知らせ内容 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_koushinBi" key="web.admin.content.comment.edit.field.koushinBi" /><!-- 更新日 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_maxKoushinBi" key="web.admin.content.comment.edit.field.maxKoushinBi" /><!-- 企画最大更新日 -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_field_waveLine" key="web.admin.content.comment.edit.field.waveLine" /><!-- ～ -->
<fmt:message bundle="${packageInfo}" var="label_comment_edit_button_edit" key="web.admin.content.comment.edit.button.edit" /><!-- 更　新 -->
<!-- ##Page:お知らせ管理（新規）## -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_title" key="web.admin.content.comment.regist.title" /><!-- お知らせ管理（新規） -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_catalogId" key="web.admin.content.comment.regist.field.catalogId" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_msgNo" key="web.admin.content.comment.regist.field.msgNo" /><!-- お知らせ番号 -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_msgKeisaiKbn" key="web.admin.content.comment.regist.field.msgKeisaiKbn" /><!-- 掲載区分 -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_keisai" key="web.admin.content.comment.regist.field.keisai" /><!-- 掲載期間 -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_msgHeader" key="web.admin.content.comment.regist.field.msgHeader" /><!-- タイトル -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_msgNaiyou" key="web.admin.content.comment.regist.field.msgNaiyou" /><!-- お知らせ内容 -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_koushinBi" key="web.admin.content.comment.regist.field.koushinBi" /><!-- 更新日 -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_maxKoushinBi" key="web.admin.content.comment.regist.field.maxKoushinBi" /><!-- 企画最大更新日 -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_field_waveLine" key="web.admin.content.comment.regist.field.waveLine" /><!-- ～ -->
<fmt:message bundle="${packageInfo}" var="label_comment_regist_button_regist" key="web.admin.content.comment.regist.button.regist" /><!-- 登　録 -->
<!-- ##Page:カタログ管理（検索・一覧表示）## -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_title" key="web.admin.content.catalog.list.title" /><!-- カタログ管理（検索・一覧表示） -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_field_catalogName" key="web.admin.content.catalog.list.field.catalogName" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_field_catalogYuukouBi" key="web.admin.content.catalog.list.field.catalogYuukouBi" /><!-- 有効期間 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_field_catalogYuukouFrom" key="web.admin.content.catalog.list.field.catalogYuukouFrom" /><!-- 有効期間開始日 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_field_catalogYuukouTo" key="web.admin.content.catalog.list.field.catalogYuukouTo" /><!-- 有効期間終了日 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_field_sortItem" key="web.admin.content.catalog.list.field.sortItem" /><!-- 並び順 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_field_listCnt" key="web.admin.content.catalog.list.field.listCnt" /><!-- 表示件数 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_field_pageIndex" key="web.admin.content.catalog.list.field.pageIndex" /><!-- ページ番号 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_button_search" key="web.admin.content.catalog.list.button.search" /><!-- 検　索 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_result_head_kikakuName" key="web.admin.content.catalog.list.result.head.kikakuName" /><!-- 企画名 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_result_head_webCourseHyoujiName" key="web.admin.content.catalog.list.result.head.webCourseHyoujiName" /><!-- コース名 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_result_head_catalogName" key="web.admin.content.catalog.list.result.head.catalogName" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_result_head_catalogYuukouBi" key="web.admin.content.catalog.list.result.head.catalogYuukouBi" /><!-- 有効期間 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_result_head_edit" key="web.admin.content.catalog.list.result.head.edit" /><!-- &nbsp; -->
<fmt:message bundle="${packageInfo}" var="label_catalog_list_result_body_link_edit" key="web.admin.content.catalog.list.result.body.link.edit" /><!-- 編集 -->
<!-- ##Page:カタログ管理（編集）## -->
<fmt:message bundle="${packageInfo}" var="label_catalog_edit_title" key="web.admin.content.catalog.edit.title" /><!-- カタログ管理（編集） -->
<fmt:message bundle="${packageInfo}" var="label_catalog_edit_button_edit" key="web.admin.content.catalog.edit.button.edit" /><!-- 更　新 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_edit_field_catalogId" key="web.admin.content.catalog.edit.field.catalogId" /><!-- カタログID -->
<fmt:message bundle="${packageInfo}" var="label_catalog_edit_field_catalogName" key="web.admin.content.catalog.edit.field.catalogName" /><!-- カタログ名 -->
<fmt:message bundle="${packageInfo}" var="label_catalog_edit_field_genre" key="web.admin.content.catalog.edit.field.genre" /><!-- カテゴリ -->
<fmt:message bundle="${packageInfo}" var="label_catalog_edit_field_limited" key="web.admin.content.catalog.edit.field.limited" /><!-- おすすめ・限定品 -->
<!-- ##Page:商品情報一括取り込み## -->
<fmt:message bundle="${packageInfo}" var="label_itemImport_import_title" key="web.admin.content.itemImport.import.title" /><!-- 商品情報一括取り込み -->
<fmt:message bundle="${packageInfo}" var="label_itemImport_import_text_message" key="web.admin.content.itemImport.import.text.message" /><!-- カタログ商品情報が格納されているファイルを選択し、アップロードボタンをクリックしてください。 -->
<fmt:message bundle="${packageInfo}" var="label_itemImport_import_field_syouhinFile" key="web.admin.content.itemImport.import.field.syouhinFile" /><!-- カタログ商品情報ファイル -->
