<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="pageTitle">
    <span style="font-size: 150%; font-weight: bold;">
        <s:text name="web.admin.content.user.edit.title" />
    </span>
    <div style="clear: both; margin: 0px; padding: 2px 0pt; text-align: right; vertical-align: middle; border-top: 2px solid rgb(0, 0, 255);"></div>
</div>
<div class="adminMainArea" id="mainArea">
    <form action="user_edit">
    <s:actionerror/>
    <div class="main">
        <div class="center">
            <table width="90%" class="itemListTable noBorder">
                <colgroup width="20%"></colgroup>
                <colgroup width="80%"></colgroup>
                <tbody>
                    <tr>
                        <th class="center">
                            <s:text name="web.admin.content.user.edit.field.kanriUserId" />
                        </th>
                        <td class="left">
                            <s:property value="kanriUserId"/>
                            <s:hidden name="kanriUserId"/>
                        </td>
                    </tr>
                    <tr>
                        <th class="center">
                            <s:text name="web.admin.content.user.edit.field.kanriUserNm" />
                        </th>
                        <td class="left">
                            <s:textfield name="kanriUserNm" cssErrorClass="fieldError" maxlength="20" size="40" cssClass="imeon" />
                            <s:fielderror>
                                <s:param>kanriUserNm</s:param>
                            </s:fielderror>
                        </td>
                    </tr>
                    <tr>
                        <th class="center">
                            <s:text name="web.admin.content.user.edit.field.kanriUserPassword" />
                        </th>
                        <td class="left">
                            <s:password name="kanriUserPassword" cssErrorClass="fieldError" maxlength="20" size="30" cssClass="imeoff" />
                            <s:fielderror>
                                <s:param>kanriUserPassword</s:param>
                            </s:fielderror>
                            <p style="margin: 5px 0px 0px;">
                                <s:text name="web.admin.content.user.edit.text.kanriUserPasswordKakunin.message" />
                            </p>
                            <p>
                                <s:password name="kanriUserPasswordKakunin" cssErrorClass="fieldError" maxlength="20" size="30" cssClass="imeoff" />
                                <s:fielderror>
                                    <s:param>kanriUserPasswordKakunin</s:param>
                                </s:fielderror>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <th class="center">
                            <s:text name="web.admin.content.user.edit.field.svFlg" />
                        </th>
                        <td class="left">
                            <s:if test="%{adminLogin.svFlg==\"1\" && kanriUserId != adminLogin.kanriUserId}">
                                <s:checkbox name="svFlg" value="%{svFlg == \"1\"}" cssErrorClass="fieldError" fieldValue="1"/>
                                <s:fielderror>
                                    <s:param>svFlg</s:param>
                                </s:fielderror>
                            </s:if>
                            <s:else>
                                <s:if test="%{svFlg == \"1\"}">
                                    <s:property value="%{getCodeValue(5700,1)}"/>
                                </s:if>
                                <s:else>
                                    <s:property value="%{getCodeValue(5700,0)}"/>
                                </s:else>
                            <s:hidden name="svFlg" />
                            </s:else>
                        </td>
                    </tr>
                    <tr>
                        <th class="center">
                            <s:text name="web.admin.content.user.edit.field.kikakuCdList" />
                        </th>
                        <td class="left">
                            <s:if test="%{adminLogin.svFlg==\"1\"}">
                                <s:checkboxlist name="kikakuCdList" list="%{cache.kikakuMap}" listKey="key" listValue="value" cssErrorClass="fieldError"/>
                                <s:fielderror>
                                    <s:param>kikakuCdList</s:param>
                                </s:fielderror>
                            </s:if>
                            <s:else>
                                <s:iterator value="kikakuCdList" status="kikakuStatus" var="kikakuVar">
                                    <s:if test="#kikakuStatus.index > 0">
                                    、
                                    </s:if>
                                    <s:property value="%{cache.kikakuMap.get(#kikakuVar)}"/>
                                    <s:hidden name="kikakuCdList" value="%{#kikakuVar}" />
                                </s:iterator>
                            </s:else>
                        </td>
                    </tr>
                    <tr>
                        <th class="center">
                            <s:text name="web.admin.content.user.edit.field.siyouKahiFlg" />
                        </th>
                        <td class="left">
                            <s:if test="%{adminLogin.svFlg==\"1\"}">
                                <s:select label=""
                                    name="siyouKahiFlg"
                                    list="%{getCodeMap(5050)}"
                                    listKey="key"
                                    listValue="value"
                                    multiple="false"
                                    size="1"
                                    required="true"
                                    cssErrorClass="fieldError"
                                    cssClass="select"
                                />
                                <s:fielderror>
                                    <s:param>siyouKahiFlg</s:param>
                                </s:fielderror>
                            </s:if>
                            <s:else>
                                <s:property value="%{getCodeValue(5050,siyouKahiFlg)}"/>
                                <s:hidden name="siyouKahiFlg" />
                            </s:else>
                        </td>
                    </tr>
                    <tr>
                        <td class="right noBorder" colspan="4">
                            <s:hidden name="koushinBi" value="%{#koushinBiFormat.format(koushinBi)}" />
                            <s:hidden name="maxKoushinBi" value="%{#koushinBiFormat.format(maxKoushinBi)}" />
                            <s:submit
                                action="user_edit"
                                method="edit_exec"
                                cssStyle="width: 100px; height: 30px;"
                                cssClass="button"
                                value="%{getText('web.admin.content.user.edit.button.edit')}"
                            />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <s:hidden name="koushinBi" />
    <s:hidden name="maxKoushinBi" />
    </form>
</div><!-- mainArea -->
