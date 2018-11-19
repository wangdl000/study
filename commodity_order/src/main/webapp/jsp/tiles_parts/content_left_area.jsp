<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="leftList1">
    <img width="169" height="80" alt="お手持ちのカタログ Aコース" src="${pageContext.request.contextPath}/images/common/leftNavi/left_title01.gif">
</div>
<div class="leftList2">
    <img width="184" height="60" border="0" alt="商品番号から申し込む" src="${pageContext.request.contextPath}/images/common/leftNavi/left_menu01.gif">
</div>
<div class="leftSearch">
    <p class="text1">
        カタログ記載の商品番号をご入力下さい。
    </p>
    <form action="item_detail_form" method="get" >
        <div class="form">
            <s:textfield name="syouhinCd1" cssErrorStyle="background-color:RED;" size="6" maxlength="5"  />
            -
            <s:textfield name="syouhinCd2" cssErrorStyle="background-color:RED;" size="2" maxlength="1"  />
        </div>
        <s:fielderror>
            <s:param>syouhinCd1</s:param>
            <s:param>syouhinCd2</s:param>
        </s:fielderror>
        <s:submit type="image" method="form_search" alt="商品を確認する"  src="%{baseDir}/images/common/leftNavi/left_btn_search.gif" width="153" height="32" border="0" style="margin-bottom: 10px;" />
    </form>
    <p class="right">
        <a href="#">≫ご利用ガイド</a>
    </p>
</div>
<div class="leftList2">
    <img width="184" height="60" border="0" alt="カテゴリーから選ぶ" src="${pageContext.request.contextPath}/images/common/leftNavi/left_menu02.gif">
</div>
<div class="localnavi_top">
    <div class="ins_localnavi">
        <ul class="child">
            <s:iterator value="#session['SESSION_ORDER_PAGE_COMMONS_INFO'].genreList" status="genreStatus">
                <s:if test="menuHyoujiFlg== 1">
                    <s:url id="searchItemUrl" namespace="/" action="item_search" method="">
                        <s:param name="genreNo" value="genreNo"/>
                    </s:url>
                    <li>
                        <s:a href="%{searchItemUrl}">
                            <s:property value="genreName"/>
                        </s:a>
                    </li>
                </s:if>
            </s:iterator>
        </ul>
        <br>
        <div class="leftList2">
            <s:url id="2choiceUrl" namespace="/" action="item_search" method="">
                <s:param name="choiceSu" value="2"/>
            </s:url>
            <s:a href="%{2choiceUrl}">
                <img border="0" alt="2点チョイスから選ぶ" src="${pageContext.request.contextPath}/images/common/leftNavi/left_navititle_2choice.gif">
            </s:a>
        </div>
        <br>

        <div class="leftList2"><s:a action="top"><img border="0" alt="インターネット限定アイテム" src="${pageContext.request.contextPath}/images/common/leftNavi/left_limited.gif"></s:a></div>
    </div>
</div>
