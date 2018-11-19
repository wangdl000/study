<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <div class="Section">
        <table cellspacing="7" class="tableStyle2">
            <tr>
                <td class="nocol">
                    <img src="${pageContext.request.contextPath}/images/titles/title_sub001.gif" alt="ご希望商品" width="110" height="30" />
                </td>
            </tr>
            <tr>
                <td>
                    <s:iterator value="orderItemList" status="orderItemStatus">
                        <div class="image_L">
                            <img src="${pageContext.request.contextPath}/<s:property value="itemBean.miniImage1"/>" alt="<s:property value="ItemBean.syouhinHyoujiName"/>の画像" width="120" height="120" />
                        </div>
                        <div class="item_R">

                            <%-- チョイス数 --%>
                            <s:if test="catalogBean.threeChoiceFlg == 1 || catalogBean.twoChoiceFlg == 1">
                                <div style="text-align: left; margin: 0px 10px 10px 0px; float: left;">
                                    <img width="110" height="28" alt="<s:property value="itemBean.choiceSu" />アイテムチョイス" src="${pageContext.request.contextPath}/images/icon_choice/icon_<s:property value="itemBean.choiceSu" />item.gif" />
                                </div>
                            </s:if>

                            <div style="text-align:left;margin:0px 10px 10px 0px;float:left;">
                                <div class="item_No">商品番号 <s:property value="itemBean.viewItemCd" /></div>
                            </div>
                            <div class="item_Title"><s:property value="ItemBean.syouhinHyoujiName"/></div>
                            <p><s:property value="itemBean.itemNaiyou" /></P>
                            <p><s:property value="itemBean.itemSanti" /></p>
                            <p><s:property value="itemBean.itemKigen" /></p>
                            <div class="left">
                                <table cellspacing="0" border="0">
                                    <tr>
                                        <td width="100" align="center" class="left">
                                            <img src="images/order/icon_haitatu.gif" alt="配達指定日" width="86" height="28" />
                                        </td>
                                        <td align="center">
                                            <b><s:date name="haisouDate" format="yyyy年MM月dd日(E)" /></b>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="section_line" ></div>
                    </s:iterator>
                </td>
            </tr>
            <tr>
                <td class="nocol">
                    <br />
                </td>
            </tr>
            <tr>
                <td class="nocol"><img src="${pageContext.request.contextPath}/images/titles/title_sub002.gif" alt="お客様情報" width="110" height="30" /></td>
            </tr>
            <tr>
                <td>
                    <div class="Section">
                        <table cellpadding="0" cellspacing="0" class="orderListTable">
                            <tr>
                                <th scope="row">お名前</th>
                                <td>
                                    <b>
                                        <s:property value="kname1"/>　<s:property value="kname2"/>
                                    </b>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">フリガナ</th>
                                <td><b><s:property value="kananame1"/>　<s:property value="kananame2"/></b></td>
                            </tr>
                            <tr>
                                <th scope="row">法人／部署名等</th>
                                <td>
                                    <b>
                                        <s:if test="knameHoujin != ''">
                                            <s:property value="knameHoujin"/>
                                        </s:if>
                                        <s:else>
                                            &nbsp;
                                        </s:else>
                                    </b>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">郵便番号</th>
                                <td class="LeftAdjust">
                                    <b><s:property value="postNo1"/>-<s:property value="postNo2"/></b>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">ご住所</th>
                                <td><b><s:property value="jyuusyo1"/><s:property value="jyuusyo2"/><s:property value="jyuusyo3"/></b></td>
                            </tr>
                            <tr>
                                <th scope="row">電話番号</th>
                                <td><b><s:property value="telNo1"/>-<s:property value="telNo2"/>-<s:property value="telNo2"/></b></td>
                            </tr>
                            <tr>
                                <th scope="row">メールアドレス</th>
                                <td><b><s:property value="mailAddress"/></b></td>
                            </tr>
                        </table>
                    </div>
                    <div class="Section2">

                        <form>
                            <s:hidden name="kname1" />
                            <s:hidden name="kname2" />
                            <s:hidden name="kananame1" />
                            <s:hidden name="kananame2" />
                            <s:hidden name="knameHoujin"/>
                            <s:hidden name="postNo1" />
                            <s:hidden name="postNo2" />
                            <s:hidden name="jyuusyo1" />
                            <s:hidden name="jyuusyo2" />
                            <s:hidden name="jyuusyo3" />
                            <s:hidden name="telNo1" />
                            <s:hidden name="telNo2" />
                            <s:hidden name="telNo3" />
                            <s:hidden name="mailAddress" />
                            <s:hidden name="conf_mailAddress" />

                            <s:iterator value="ItemBean" status="" var="r_ItemBean">
                                <s:hidden name="ItemBean.hagakiSyouhinCd" value="%{#r_ItemBean.hagakiSyouhinCd}" />
                            </s:iterator>

                            <s:iterator value="haisouDiv" status="" var="r_haisouDiv">
                                <s:hidden name="haisouDiv" value="%{#r_haisouDiv}" />
                            </s:iterator>

                            <s:iterator value="haisouDate" status="" var="r_haisouDate">
                                <s:hidden name="haisouDate" value="%{#r_haisouDate}" />
                            </s:iterator>

                            <s:submit type="image" action="order_input" src="%{baseDir}/images/order/btn_007-03.gif" alt="お客様情報入力へ戻る" width="230" height="45" border="0" />
                            　　　
                            <s:submit type="image" action="order_complete" src="%{baseDir}/images/order/btn_007-04.gif" alt="お申込み内容を確定する" width="230" height="45" border="0"  />
                        </form>

                    </div>
                </td>
            </tr>
        </table>
    </div>
