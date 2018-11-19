<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basedir = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<form action="syouhinEdit" method="post"   enctype="multipart/form-data">
<s:token/>
<div id="pageTitle">
    <span style="font-size:150%;font-weight:bold;">
        <s:text name="web.admin.content.item.edit.title" />
    </span>
    <div style="clear: both;margin: 0px 0px 0px 0px;padding: 2px 0;text-align: right;vertical-align:middle;border-top: 2px solid #0000ff;"></div>
</div>
<s:actionmessage/>
<s:actionerror/>
<div id="mainArea" class="adminMainArea">
    <div class="main">
        <div class="center">
            <table class="itemListTable noBorder" width="95%">
                <colgroup width="20%"></colgroup>
                <colgroup width="30%"></colgroup>
                <colgroup width="15%"></colgroup>
                <colgroup width="35%"></colgroup>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.item.edit.field.catalogName" />
                    </th>
                    <td class="left" colspan="3">
                        <s:property value="catalogName"/>&nbsp;
                    </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.item.edit.field.hagakiSyouhinCd" />
                    </th>
                    <td class="left" colspan="3">
                        <s:property value="hagakiSyouhinCd"/>&nbsp;
                    </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.item.edit.field.genreList" />
                    </th>
                        <td class="left" colspan="3">
                            <s:set name="genreMap" value="%{cache.getGenreMap(catalogId)}"/>
                            <s:checkboxlist
                                name="genreList"
                                list="genreMap"
                                listKey="key"
                                listValue="value"
                                value="genreList"
                            />
                        </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.item.edit.field.limitedList" />
                    </th>
                        <td class="left" colspan="3">
                            <s:set name="limitedMap" value="%{cache.getLimitedMap(catalogId)}"/>
                            <s:checkboxlist
                                name="limitedList"
                                list="limitedMap"
                                listKey="key"
                                listValue="value"
                                value="limitedList"
                            />
                        </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.item.edit.field.itemKeisaiKbn" />
                    </th>
                    <td class="left" colspan="3">
                         <s:select label=""
                                   name="itemKeisaiKbn"
                                   list="getCodeMap(5010)"
                                   listKey="key"
                                   listValue="value"
                                   multiple="false"
                                   size="1"
                                   required="true"
                                   value="itemKeisaiKbn"
                                   cssClass="select"
                                   cssErrorClass="fieldError"
                         />
                         <s:fielderror>
                                <s:param>itemKeisaiKbn</s:param>
                         </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.kikanGenteiFlg" />
                   </th>
                   <td class="left">
                   <s:if test="%{kikanGenteiFlg==\"1\"}">
                        <s:checkbox name="kikanGenteiFlg" value="true" fieldValue="1" />
                    </s:if>
                    <s:else>
                        <s:checkbox name="kikanGenteiFlg" value="false" fieldValue="1" />
                    </s:else>
                        <s:text name="web.admin.content.item.edit.field.kikanGenteiFlg.comment" />
                   </td>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.dispGenteiKikan" />
                   </th>
                   <td class="left">
                       <s:textfield name="dispGenteiKikan" size="20" maxlength="50" cssErrorClass="fieldError" cssClass="imeon" />
                       <s:fielderror>
                                <s:param>dispGenteiKikan</s:param>
                        </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.syouhinHyoujiName" />
                   </th>
                   <td class="left" colspan="3">
                       <s:textfield name="syouhinHyoujiName" size="40" maxlength="100" cssErrorClass="fieldError" cssClass="imeon" />
                       <s:fielderror>
                            <s:param>syouhinHyoujiName</s:param>
                       </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.catchCopy" />
                   </th>
                   <td class="left" colspan="3">
                        <s:textarea name="catchCopy" cols="65" rows="4" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>catchCopy</s:param>
                        </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.itemSyosai" />
                   </th>
                   <td class="left" colspan="3">
                        <s:textarea name="itemSyosai" cols="65" rows="4" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>itemSyosai</s:param>
                        </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.itemNaiyou" />
                   </th>
                   <td class="left" colspan="3">
                        <s:textarea name="itemNaiyou" cols="65" rows="4" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>itemNaiyou</s:param>
                        </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.itemSanti" />
                   </th>
                   <td class="left" colspan="3">
                        <s:textfield name="itemSanti" size="40" maxlength="200" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>itemSanti</s:param>
                        </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.itemKigen" />
                   </th>
                   <td class="left" colspan="3">
                       <s:textfield name="itemKigen" size="40" maxlength="50" cssErrorClass="fieldError" cssClass="imeon"/>
                       <s:fielderror>
                            <s:param>itemKigen</s:param>
                       </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center" rowspan="2">
                        <s:text name="web.admin.content.item.edit.field.arerugiJoho" />
                   </th>
                   <td class="left" colspan="3">
                       <ul>
                           <li style="float: left; list-style: none; padding: 2px 6px;">
                           <s:if test="%{allergieTamagoFlg==\"1\"}">
                               <s:checkbox name="allergieTamagoFlg" value="true" fieldValue="1" />
                           </s:if>
                           <s:else>
                               <s:checkbox name="allergieTamagoFlg" value="false" fieldValue="1" />
                           </s:else>
                               <s:text name="web.admin.content.item.edit.field.allergieTamagoFlg" />
                           </li>
                           <li style="float: left; list-style: none; padding: 2px 6px;">
                           <s:if test="%{allergieMilkFlg==\"1\"}">
                               <s:checkbox name="allergieMilkFlg" value="true" fieldValue="1" />
                           </s:if>
                           <s:else>
                               <s:checkbox name="allergieMilkFlg" value="false" fieldValue="1" />
                           </s:else>
                               <s:text name="web.admin.content.item.edit.field.allergieMilkFlg" />
                           </li>
                           <li style="float: left; list-style: none; padding: 2px 6px;">
                           <s:if test="%{allergieKomugiFlg==\"1\"}">
                               <s:checkbox name="allergieKomugiFlg" value="true" fieldValue="1" />
                           </s:if>
                           <s:else>
                               <s:checkbox name="allergieKomugiFlg" value="false" fieldValue="1" />
                           </s:else>
                               <s:text name="web.admin.content.item.edit.field.allergieKomugiFlg" />
                           </li>
                           <li style="float: left; list-style: none; padding: 2px 6px;">
                           <s:if test="%{allergiePeanutFlg==\"1\"}">
                               <s:checkbox name="allergiePeanutFlg" value="true" fieldValue="1" />
                           </s:if>
                           <s:else>
                               <s:checkbox name="allergiePeanutFlg" value="false" fieldValue="1" />
                           </s:else>
                               <s:text name="web.admin.content.item.edit.field.allergiePeanutFlg" />
                           </li>
                           <li style="float: left; list-style: none; padding: 2px 6px;">
                           <s:if test="%{allergieSobaFlg==\"1\"}">
                               <s:checkbox name="allergieSobaFlg" value="true" fieldValue="1" />
                           </s:if>
                           <s:else>
                               <s:checkbox name="allergieSobaFlg" value="false" fieldValue="1" />
                           </s:else>
                               <s:text name="web.admin.content.item.edit.field.allergieSobaFlg" />
                           </li>
                           <li style="float: left; list-style: none; padding: 2px 6px;">
                           <s:if test="%{allergieEbiFlg==\"1\"}">
                               <s:checkbox name="allergieEbiFlg" value="true" fieldValue="1" />
                           </s:if>
                           <s:else>
                               <s:checkbox name="allergieEbiFlg" value="false" fieldValue="1" />
                           </s:else>
                               <s:text name="web.admin.content.item.edit.field.allergieEbiFlg" />
                           </li>
                           <li style="float: left; list-style: none; padding: 2px 6px;">
                           <s:if test="%{allergieKaniFlg==\"1\"}">
                               <s:checkbox name="allergieKaniFlg" value="true" fieldValue="1" />
                           </s:if>
                           <s:else>
                               <s:checkbox name="allergieKaniFlg" value="false" fieldValue="1" />
                           </s:else>
                               <s:text name="web.admin.content.item.edit.field.allergieKaniFlg" />
                           </li>
                       </ul>
                   </td>
               </tr>
               <tr>
                       <td class="left" colspan="3">
                            <s:text name="web.admin.content.item.edit.field.allergieEtcText" />
                            <s:textfield name="allergieEtcText" size="62" maxlength="100" cssErrorClass="fieldError" cssClass="imeon"/>
                            <s:fielderror>
                                <s:param>allergieEtcText</s:param>
                            </s:fielderror>
                       </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.itemHaisouHouhou" />
                   </th>
                   <td class="left" colspan="3">
                        <s:select label=""
                                   name="itemHaisouHouhou"
                                   list="getCodeMap(5610)"
                                   listKey="key"
                                   listValue="value"
                                   multiple="false"
                                   size="1"
                                   required="true"
                                   cssClass="select"
                                   cssErrorClass="fieldError"
                        />
                        <s:fielderror>
                            <s:param>itemHaisouHouhou</s:param>
                        </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.catalogKeisaiPageNo" />
                   </th>
                   <td class="left" colspan="3">
                        <s:textfield name="catalogKeisaiPageNo" size="5" maxlength="5" cssErrorClass="fieldError" cssClass="imeoff right" />
                        <s:fielderror>
                            <s:param>catalogKeisaiPageNo</s:param>
                        </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.sortOrder" />
                   </th>
                   <td class="left" colspan="3">
                       <s:textfield name="sortOrder" size="5" maxlength="5" cssErrorClass="fieldError" cssClass="imeoff right" />
                       <s:text name="web.admin.content.item.edit.field.sortOrder.comment" />
                       <s:fielderror>
                            <s:param>sortOrder</s:param>
                       </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.todokeBiSiteiFukaFlg" />
                   </th>
                   <td class="left" colspan="3">
                        <s:select label=""
                                   name="todokeBiSiteiFukaFlg"
                                   list="getCodeMap(5620)"
                                   listKey="key"
                                   listValue="value"
                                   multiple="false"
                                   size="1"
                                   required="true"
                                   cssClass="select"
                                   cssErrorClass="fieldError"
                        />
                        <s:fielderror>
                            <s:param>todokeBiSiteiFukaFlg</s:param>
                        </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.syouhinImage1" />
                   </th>
                   <td class="left" colspan="3">
                       <img class="thumImage" style="float: left; margin-right: 20px;" src="${pageContext.request.contextPath}/<s:property value="%{miniImage1}"/>"; width="100" height="100" />
                       <s:hidden name="miniImage1" value="%{miniImage1}"/>
                       <p style="padding: 10px 0;">
                            <s:text name="web.admin.content.item.edit.field.syouhinImage1.comment" />
                       </p>
                       <s:file name="syouhinImage1"></s:file>
                       <span style="margin-left: 80px;">
                        <s:if test="%{syouhinImageDelFlg1==\"1\"}">
                            <s:checkbox name="syouhinImageDelFlg1" value="true" fieldValue="1" />
                        </s:if>
                        <s:else>
                            <s:checkbox name="syouhinImageDelFlg1" value="false" fieldValue="1" />
                        </s:else>
                            <s:text name="web.admin.content.item.edit.field.syouhinImageDelFlg1" />
                       </span>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.syouhinImage2" />
                   </th>
                   <td class="left" colspan="3">
                       <img class="thumImage" style="float: left; margin-right: 20px;" src="${pageContext.request.contextPath}/<s:property value="%{miniImage2}"/>"; width="100" height="100" />
                       <s:hidden name="miniImage2" value="%{miniImage2}"/>
                       <p style="padding: 10px 0;">
                            <s:text name="web.admin.content.item.edit.field.syouhinImage2.comment" />
                       </p>
                       <s:file name="syouhinImage2"></s:file>
                       <span style="margin-left: 80px;">
                       <s:if test="%{syouhinImageDelFlg2==\"1\"}">
                            <s:checkbox name="syouhinImageDelFlg2" value="true" fieldValue="1" />
                        </s:if>
                        <s:else>
                            <s:checkbox name="syouhinImageDelFlg2" value="false" fieldValue="1" />
                        </s:else>
                            <s:text name="web.admin.content.item.edit.field.syouhinImageDelFlg2" />
                       </span>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                        <s:text name="web.admin.content.item.edit.field.syouhinImage3" />
                   </th>
                   <td class="left" colspan="3">
                       <img class="thumImage" style="float: left; margin-right: 20px;" src="${pageContext.request.contextPath}/<s:property value="%{miniImage3}"/>"; width="100" height="100" />
                       <s:hidden name="miniImage3" value="%{miniImage3}"/>
                       <p style="padding: 10px 0;">
                            <s:text name="web.admin.content.item.edit.field.syouhinImage3.comment" />
                       </p>
                       <s:file name="syouhinImage3"></s:file>
                       <span style="margin-left: 80px;">
                       <s:if test="%{syouhinImageDelFlg3==\"1\"}">
                            <s:checkbox name="syouhinImageDelFlg3" value="true" fieldValue="1"/>
                        </s:if>
                        <s:else>
                            <s:checkbox name="syouhinImageDelFlg3" value="false" fieldValue="1"/>
                        </s:else>
                            <s:text name="web.admin.content.item.edit.field.syouhinImageDelFlg3" />
                       </span>
                   </td>
               </tr>
               <tr>
                   <th class="center">
                            <s:text name="web.admin.content.item.edit.field.webSyouhinBikou" />
                   </th>
                   <td class="left" colspan="3">
                       <s:textarea name="webSyouhinBikou" cols="65" rows="4" cssErrorClass="fieldError" cssClass="imeon"/>
                       <s:fielderror>
                            <s:param>webSyouhinBikou</s:param>
                       </s:fielderror>
                   </td>
               </tr>
               <tr>
                   <td colspan="4" class="right noBorder">
                       <br/>
                       <s:submit
                            method="edit"
                            value="%{getText('web.admin.content.item.edit.button.update')}"
                            cssStyle="width:100px;height:30px"
                            cssClass="button"
                            cssErrorClass="fieldError"
                       />
                   </td>
               </tr>
            </table>
        </div>
    </div>
</div><!-- mainArea -->
<s:hidden name="catalogId" />
<s:hidden name="catalogName" />
<s:hidden name="hagakiSyouhinCd" />
<s:hidden name="koushinBi" value="%{#koushinBiFormat.format(koushinBi)}" />
<s:hidden name="maxKoushinBi" value="%{#koushinBiFormat.format(maxKoushinBi)}" />
</form>