<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="globalNavi">
    <div style="height:23px; width: 430px; margin-left: auto; margin-right: 0;">
        <form action="itemSearch" method="post" >
            <p style="float: left;margin-left: auto; margin-right: 0;">
                <s:select label="ジャンル"
                        name="genreNo"
                        list="#session['SESSION_ORDER_PAGE_COMMONS_INFO'].genreList"
                        listKey="genreNo"
                        listValue="genreName"
                        headerKey=""
                        headerValue="選択してください"
                        multiple="false"
                        size=""
                        required="true"
                        value="%{commonsBean.searchJenre}"
                />
                <s:textfield id="syouhinHyoujiName" name="syouhinHyoujiName" value="%{commonsBean.searchKeywords}" size="30" maxlength="100" />
            </p>
            <p style="float: left;margin-left: auto; margin-right: 0;">
                <input type="image" style="border: 0px none;" id="doSearchCtgry" src="images/common/header/header_bt09.gif" alt="検索" size="57">
            </p>
        </form>
    </div>
</div>