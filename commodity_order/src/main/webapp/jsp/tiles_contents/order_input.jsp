<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div class="Section">
        <form action="order_confirm" method="post" >
        <table cellspacing="7" class="tableStyle2">
            <tr>
                <td class="nocol">
                    <img src="${pageContext.request.contextPath}/images/titles/title_sub002.gif" alt="お客様情報" width="110" height="30" />
                </td>
            </tr>
            <tr>
                <td>
                    <div class="Section">
                        <p class="text2">
                            お客様の情報を入力して下さい。<br />
                            郵便番号を入力してから「住所の自動入力」をクリックすると自動入力されます。<br />
                            番地、マンション名等は手動で入力して下さい。
                            <img src="${pageContext.request.contextPath}/images/order/icon_required.gif" alt="必須" width="27" height="14" />
                            の項目は必須になります。<br />
                            個人のお客様は、「お名前（法人）」はご記入不要です。<br /><br />
                            ご記入いただいたメールアドレス宛に、お申し込み確認メールをお送りいたします。
                            <br />
                            <br />
                        </p>
                        <table cellpadding="0" cellspacing="0" class="orderListTable">
                            <tr>
                                <th scope="row">
                                    お名前
                                    <img src="${pageContext.request.contextPath}/images/order/icon_required.gif" alt="必須" width="27" height="14" class="RightFloat" />
                                </th>
                                <td>
                                    <label for="uname">姓　</label>
                                    <s:textfield name="kname1" size="15" maxlength="30" cssErrorStyle="background-color:RED;" />
                                    　　
                                    <label for="uname2">名　</label>
                                    <s:textfield name="kname2" size="15" maxlength="30" cssErrorStyle="background-color:RED;" />
                                    <s:fielderror>
                                        <s:param>kname1</s:param>
                                        <s:param>kname2</s:param>
                                    </s:fielderror>
                                </td>
                                <td class="textG">
                                    （例）高島屋　太郎
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    フリガナ
                                    <img src="${pageContext.request.contextPath}/images/order/icon_required.gif" alt="必須" width="27" height="14" class="RightFloat" />
                                </th>
                                <td>
                                    全角カナでご入力して下さい。<br />
                                    <label for="uname3">セイ</label>
                                    <s:textfield name="kananame1" size="15" maxlength="30" cssErrorStyle="background-color:RED;"/>
                                    　　　
                                    <label for="uname4">メイ</label>
                                    <s:textfield name="kananame2" size="15" maxlength="30" cssErrorStyle="background-color:RED;"/>
                                    <s:fielderror>
                                        <s:param>kananame1</s:param>
                                        <s:param>kananame2</s:param>
                                    </s:fielderror>
                                </td>
                                <td class="textG">（例）タカシマヤ　タロウ</td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    法人／部署名等
                                </th>
                                <td>
                                    <s:textfield name="knameHoujin" size="30" maxlength="30" cssErrorStyle="background-color:RED;"/>
                                    <s:fielderror>
                                        <s:param>knameHoujin</s:param>
                                    </s:fielderror>
                                </td>
                                <td class="textG">
                                    （例）㈱高島屋
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    郵便番号
                                    <img src="${pageContext.request.contextPath}/images/order/icon_required.gif" alt="必須" width="27" height="14" class="RightFloat" />
                                </th>
                                <td class="LeftAdjust">
                                    <s:textfield name="postNo1" size="4" maxlength="3" cssErrorStyle="background-color:RED;" />
                                    －
                                    <s:textfield name="postNo2" size="5" maxlength="4" cssErrorStyle="background-color:RED;" />
                                    　
                                    <input type="button" value="住所の自動入力" class="button" id="submitbutton" onclick="AjaxZip2.zip2addr( 'postNo1', 'jyuusyo1', 'jyuusyo2', 'postNo2', 'jyuusyo3');" />
                                    <s:fielderror>
                                        <s:param>postNo1</s:param>
                                        <s:param>postNo2</s:param>
                                    </s:fielderror>
                                </td>
                                <td  class="textG">
                                    （例）103-8265
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    ご住所
                                    <img src="${pageContext.request.contextPath}/images/order/icon_required.gif" alt="必須" width="27" height="14" class="RightFloat" />
                                </th>
                                <td>
                                    都道府県
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    市区町村
                                    <br />
                                    <s:textfield name="jyuusyo1" size="4" maxlength="4" cssErrorStyle="background-color:RED;" />
                                    &nbsp;&nbsp;
                                    <s:textfield name="jyuusyo2" size="30" maxlength="30" cssErrorStyle="background-color:RED;" />
                                    <br />
                                    それ以外の住所　※ 番地・建物名までご入力して下さい。<br />
                                    <s:textfield name="jyuusyo3" size="50" maxlength="50" cssErrorStyle="background-color:RED;" />
                                    <s:fielderror>
                                        <s:param>jyuusyo1</s:param>
                                        <s:param>jyuusyo2</s:param>
                                        <s:param>jyuusyo3</s:param>
                                    </s:fielderror>
                                </td>
                                <td class="textG">
                                    （例）東京都中央区日本橋2丁目4番地1号
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    電話番号
                                    <img src="${pageContext.request.contextPath}/images/order/icon_required.gif" alt="必須" width="27" height="14" class="RightFloat" />
                                </th>
                                <td>
                                    <s:textfield name="telNo1" size="8" maxlength="8" cssErrorStyle="background-color:RED;" />
                                    －
                                    <s:textfield name="telNo2" size="8" maxlength="8" cssErrorStyle="background-color:RED;" />
                                    －
                                    <s:textfield name="telNo3" size="8" maxlength="8" cssErrorStyle="background-color:RED;" />
                                    <span class="TextStyleR">
                                        （半角数字）
                                    </span>
                                    <s:fielderror>
                                        <s:param>telNo1</s:param>
                                        <s:param>telNo2</s:param>
                                        <s:param>telNo3</s:param>
                                    </s:fielderror>
                                </td>
                                <td class="textG">
                                    （例）03-3211-4111
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    メールアドレス
                                    <img src="${pageContext.request.contextPath}/images/order/icon_required.gif" alt="必須" width="27" height="14" class="RightFloat" />
                                </th>
                                <td>
                                    <s:textfield name="mailAddress" size="30" maxlength="30" cssErrorStyle="background-color:RED;" />
                                    (半角英数字）
                                    <br />
                                    <s:fielderror>
                                        <s:param>mailAddress</s:param>
                                    </s:fielderror>
                                    <br />
                                    <p>確認のためにもう一度入力して下さい。</p>
                                    <s:textfield name="conf_mailAddress" size="30" maxlength="30" cssErrorStyle="background-color:RED;" />
                                    <s:fielderror>
                                        <s:param>conf_mailAddress</s:param>
                                    </s:fielderror>
                                </td>
                                <td class="textG">
                                    （例）tarou@takashimaya.co.jp
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="Section2">

                        <s:iterator value="ItemBean" status="" var="r_ItemBean">
                            <s:hidden name="ItemBean.hagakiSyouhinCd" value="%{#r_ItemBean.hagakiSyouhinCd}" />
                        </s:iterator>

                        <s:iterator value="haisouDiv" status="" var="r_haisouDiv">
                            <s:hidden name="haisouDiv" value="%{#r_haisouDiv}" />
                        </s:iterator>

                        <s:iterator value="haisouDate" status="" var="r_haisouDate">
                            <s:hidden name="haisouDate" value="%{#r_haisouDate}" />
                        </s:iterator>

                        <s:a action="order_cart">
                            <img src="${pageContext.request.contextPath}/images/order/btn_007-01.gif" alt="商品選択へ戻る" width="230" height="45" border="0"  />
                        </s:a>
                        　　　
                        <s:submit method="confirm" type="image" src="%{baseDir}/images/order/btn_007-02.gif" alt="お申込み内容を確認する" width="230" height="45" border="0"  />
                    </div>
                </td>
            </tr>
        </table>
        </form>
    </div>
