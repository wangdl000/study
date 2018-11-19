<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <div class="Section">
    <form>
      <table cellspacing="7" class="tableStyle2">
        <tr>
          <td class="nocol"><img src="${pageContext.request.contextPath}/images/titles/title_sub001.gif" alt="ご希望商品" width="110" height="30" /></td>
        </tr>
        <tr>
         <td>
            <div class="Section"><p class="text2">
            ※ 1アイテムチョイスコースの商品は一点のみお申し込み下さい。<br />

            　　通常、2010年12月15日以降にお届けいたします。(日付はリードタイム計算結果を表示)<br /><br />
            ご希望の商品のお届け希望日をご入力ください。<br />
            ※ 現在表示されている日程より前は選択できません。<br />
            ※ 配送状況によってお届け日のご希望には添えない場合がございます。<br />　　配送時間はご指定になれません。
            </p></div>
            <s:if test="%{orderItemList == null || orderItemList.size == 0}">
                <%-- 空 --%>
                商品が選択されていません。
            </s:if>
            <s:else>
                <%--空でない --%>

            <div class="section_line" ></div>

            <s:iterator value="orderItemList" status="orderItemStatus">

                <s:if test="#orderItemStatus.index > 0">
                    <div class="section_line" ></div>
                </s:if>

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

                    <div style="text-align:left;margin:0px 0px 10px 0px;float:left;">
                        <div class="item_No">商品番号 <s:property value="itemBean.viewItemCd" /></div>
                        <s:hidden name="itemBean.hagakiSyouhinCd" />
                    </div>

                    <div class="item_Title"><s:property value="ItemBean.syouhinHyoujiName"/></div>
                    <p><s:property value="itemBean.itemNaiyou" /></P>
                    <p><s:property value="itemBean.itemSanti" /></p>
                    <p><s:property value="itemBean.itemKigen" /></p>
                    <div class="left">
                        <table cellspacing="0" border="0">
                            <tr>
                                <td class="top-left" width="100">
                                    <div class="item_icon"><img src="${pageContext.request.contextPath}/images/order/icon_haitatu.gif" alt="配達指定日" width="86" height="28" /></div>
                                </td>
                                 <td width="500">
                                    <div class="top-left">

                                        <s:set name="haisouDivRadioMap" value="#{'1':'最短日にお届け','2':'ご指定日にお届け'}"/>
                                        <s:set name="haisouDiv[%{#orderItemStatus.index}]" value="haisouDiv"/>

                                        <s:iterator value="haisouDivRadioMap">
                                            <s:radio name="haisouDiv[%{#orderItemStatus.index}]" list="#{key: value}"/><br/>
                                        </s:iterator>

                                    </div>
                                    <div class="form2">
                                        &nbsp;&nbsp;&nbsp;&nbsp;

                                        <s:set name="haisouYear" value="%{(new java.text.SimpleDateFormat('yyyy')).format(itemBean.todokeBi)}"/>
                                        <s:set name="haisouMonth" value="%{(new java.text.SimpleDateFormat('MM')).format(itemBean.todokeBi)}"/>
                                        <s:set name="haisouDay" value="%{(new java.text.SimpleDateFormat('dd')).format(itemBean.todokeBi)}"/>

                                        <s:select label="haisouYear"
                                                    id="haisouYear%{#orderItemStatus.index}"
                                                    name="haisouYear%{#orderItemStatus.index}"
                                                    list="#{'2010':'2010','2011':'2011'}"
                                                    value="haisouYear"
                                                    required="true"
                                                    onChange="setHaisouDate(this)"
                                         />
                                        年
                                        <s:select label="haisouMonth"
                                                    id="haisouMonth%{#orderItemStatus.index}"
                                                    name="haisouMonth%{#orderItemStatus.index}"
                                                    list="#{'01':'1','02':'2','03':'3','04':'4','05':'5','06':'6','07':'7','08':'8','09':'9','10':'10','11':'11','12':'12'}"
                                                    value="haisouMonth"
                                                    required="true"
                                                    onChange="setHaisouDate(this)"
                                         />
                                        月
                                        <s:select label="haisouDay"
                                                    id="haisouDay%{#orderItemStatus.index}"
                                                    name="haisouDay%{#orderItemStatus.index}"
                                                    list="#{'01':'1','02':'2','03':'3','04':'4','05':'5','06':'6','07':'7','08':'8','09':'9','10':'10','11':'11','12':'12','13':'13','14':'14','15':'15','16':'16','17':'17','18':'18','19':'19','20':'20','21':'21','22':'22','23':'23','24':'24','25':'25','26':'26','27':'27','28':'28','29':'29','30':'30','31':'31'}"
                                                    value="haisouDay"
                                                    required="true"
                                                    onChange="setHaisouDate(this)"
                                         />
                                        日
                                    </div>
                                    &nbsp;
<%-- Datepicker設定 --%>
<script type="text/javascript">

    function setHaisouDate(haisou) {

        var idx = haisou.name.substr(haisou.name.length - 1, 1);

        var year = document.getElementById('haisouYear' + idx).value;
        var month = document.getElementById('haisouMonth' + idx).value;
        var day = document.getElementById('haisouDay' + idx).value;

        document.getElementsByName('haisouDate')[idx].value = year + '/' + month + '/' + day;

    }

    $(
      function() {

        $('#datepicker<s:property value="%{#orderItemStatus.index}" />').datepicker( {

            numberOfMonths: 2,
            showButtonPanel: false,

            minDate: new Date(<s:date name="itemBean.todokeBi" format="yyyy" />, <s:date name="itemBean.todokeBi" format="MM" /> - 1, <s:date name="itemBean.todokeBi" format="dd" />),

            <s:iterator value="todokeFukabiList" var="todokeFukabi" status="todokeFukabiStatus" >
                <s:if test="#todokeFukabiStatus.last">
                    maxDate: new Date(<s:date name="todokeFukabi" format="yyyy" />, <s:date name="todokeFukabi" format="MM" /> - 1, <s:date name="todokeFukabi" format="dd" />),
                </s:if>
            </s:iterator>

            firstDay: 0,

            onlyMondays: function(date){
                var day = date.getDay();
                return [(day == 1), ""]
            },

            <%-- 除外日は設定できない。 --%>
            beforeShowDay: function(date) {

                var ary = new Array();

                <s:iterator value="todokeFukabiList" var="todokeFukabi" >
                    ary[new Date(<s:date name="todokeFukabi" format="yyyy" />, <s:date name="todokeFukabi" format="MM" /> - 1, <s:date name="todokeFukabi" format="dd" />)] = 1;
                </s:iterator>

                if (ary[date] != 1) {
                    return [true, ''];
                } else {
                	return [false, ''];
                }
            },

            showOn: 'button',
            buttonImage: '${pageContext.request.contextPath}/images/order/icon_calendar.png',
            buttonImageOnly: true,
            beforeShow : function() {
              $('#ui-datepicker-div').css( 'font-size', '70%' );
            },

            onSelect : function(date) {
              if ( date.length > 0 ) {
                $('#haisouYear<s:property value="%{#orderItemStatus.index}" />').val(date.split("/")[0]);
                $('#haisouMonth<s:property value="%{#orderItemStatus.index}" />').val(date.split("/")[1]);
                $('#haisouDay<s:property value="%{#orderItemStatus.index}" />').val(date.split("/")[2]);
              }
            }

        });
      }

    );

</script>
<input name="haisouDate" type="hidden" id="datepicker<s:property value="%{#orderItemStatus.index}" />"  value="<s:date name="itemBean.todokeBi" format="yyyy/MM/dd" />"/>

                                </td>
                                <td>
                                    <div class="Section2">
                                        <s:url id="removeItemUrl" namespace="/" action="order_cart_remove" method="">
                                            <s:param name="remove_item" value="%{hashCode}"/>
                                        </s:url>
                                        <s:a href="%{removeItemUrl}">
                                            <img src="${pageContext.request.contextPath}/images/order/btn_sakujo.gif" alt="削除" width="230" height="45" border="0" />
                                        </s:a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </s:iterator>

            <div class="section_line" ></div>

            </s:else>

            <div class="Section2">
                <s:a action="top">
                    <img src="${pageContext.request.contextPath}/images/order/btn_005-01.gif" alt="他の商品を選ぶ" width="230" height="45" border="0"  />
                </s:a>
                　　　
                <s:submit type="image" action="order_input" src="%{baseDir}/images/order/btn_005-02.gif" alt="お届け先の入力" width="230" height="45" border="0" >
                </s:submit>
            </div>
          </td>
        </tr>
      </table>
      </form>
    </div>
