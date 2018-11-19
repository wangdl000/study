<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="Section">
    <table cellspacing="7" class="tableStyle2">
        <tbody>
            <tr>
                <th>
                    <span class="LeftFloat"><img width="90" height="37" alt="商品詳細" src="${pageContext.request.contextPath}/images/titles/title_004.gif"></span>
                </th>
            </tr>
            <tr>
                <td>
                    <div class="image_L">
                        <img width="250" height="250" alt="<s:property value="itemBean.syouhinHyoujiName" />の画像" src="${pageContext.request.contextPath}/<s:property value="itemBean.syouhinImage1"/>">
                    </div>

                    <s:if test="catalogBean.threeChoiceFlg == 1 || catalogBean.twoChoiceFlg == 1">

                        <div style="text-align: left; margin: 10px 10px 0px 0px; float: left;">
                            <img width="110" height="28" alt="<s:property value="itemBean.choiceSu" />アイテムチョイス" src="${pageContext.request.contextPath}/images/icon_choice/icon_<s:property value="itemBean.choiceSu" />item.gif" />
                        </div>

                    </s:if>

                    <div style="text-align: left; margin: 10px 10px 0px 0px; float: left;">
                        <div class="item_No">商品番号 <s:property value="itemBean.viewItemCd" /></div>
                    </div>
                    <div style="float: left; margin: 10px 20px 0px 0px; width: 400px; display: block;">
                        <div class="item_Title2">
                            <strong>
                                ${itemBean.syouhinHyoujiName }
                            </strong>
                        </div>
                    </div>
                    <div style="float: left; margin: 0px 20px 10px 0pt; width: 400px; display: block;">
                        <p>
                            <%-- 期間限定 --%>
                            <s:if test="itemBean.kikanGenteiFlg==1">
                                <img border="0" alt="期間限定" src="${pageContext.request.contextPath}/images/order/icon_limited2.gif">&nbsp;
                            </s:if>

                            <%-- ジャンルアイコン --%>
                            <s:iterator value="itemBean.genreNoIconList" status="">
                                <img src="${pageContext.request.contextPath}/images/genre_icons/genre_icon_<s:property/>.gif" alt="" border="0"  />&nbsp;
                            </s:iterator>

                            <%-- 冷凍冷蔵 --%>
                            <s:if test="itemBean.itemHaisouHouhou==1">
                                <img border="0" alt="冷蔵" src="${pageContext.request.contextPath}/images/order/icon_rei1.gif">&nbsp;
                            </s:if>
                            <s:elseif test="itemBean.itemHaisouHouhou==2">
                                <img border="0" alt="冷凍" src="${pageContext.request.contextPath}/images/order/icon_rei2.gif">&nbsp;
                            </s:elseif>
                        </p>
                    </div>
                    <div class="item_R2">
                        <div class="item_Title">
                            <s:property value="itemBean.catchCopy" />
                        </div>
                        <p>
                            <s:property value="itemBean.itemSyosai" />
                        </p>
                    </div>
                    <div style="float: left; margin: 0px 20px; display: block; width:700px">
                        <p>
                            <s:property value="itemBean.itemNaiyou" />
                        </p>
                        <p>
                            <s:property value="itemBean.itemSanti" />
                        </p>
                        <p>
                            <s:property value="itemBean.itemKigen" />
                        </p>
                        <p>
                            <s:property value="itemBean.webSyouhinBikou" />
                        </p>
                    </div>
                    <div class="Section2">
                        <div class="btn1">
                            <form action="order_cart_add" method="post" >
                                <s:hidden name="hagakiSyouhinCd" value="%{itemBean.hagakiSyouhinCd}"/>
                                <s:submit type="image" width="280" height="45" border="0" alt="この商品を申し込む" src="%{baseDir}/images/order/btn_004-02.gif" />
                            </form>
                        </div>
                    <!---本ページは一点チョイスのみのコースなので以下は表示しない
                        <p>※ この商品は一点チョイスコースの商品です。他の商品と組み合わせてのお申し込みは出来ませんのでご注意下さい。</P>
                    -->
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
</div>
