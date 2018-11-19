<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

                <div id="pageTitle">
                    <span style="font-size: 150%; font-weight: bold;">
                        <s:text name="web.admin.content.user.regist.title" />
                    </span>
                    <div style="clear: both; margin: 0px; padding: 2px 0pt; text-align: right; vertical-align: middle; border-top: 2px solid rgb(0, 0, 255);"></div>
                </div>

                <div class="adminMainArea" id="mainArea">
                    <form action="user_regist">
                    <s:actionerror/>
                    <div class="main">
                        <div class="center">
                            <table width="90%" class="itemListTable noBorder">
                                <colgroup width="20%"></colgroup>
                                <colgroup width="80%"></colgroup>
                                <tbody>
                                    <tr>
                                        <th class="center">
                                            <s:text name="web.admin.content.user.regist.field.kanriUserId" />
                                        </th>
                                        <td class="left">
                                            <s:textfield name="kanriUserId" cssErrorClass="fieldError" maxlength="20" size="20" cssClass="imeoff" />
                                            <s:fielderror>
                                                <s:param>kanriUserId</s:param>
                                            </s:fielderror>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="center">
                                            <s:text name="web.admin.content.user.regist.field.kanriUserNm" />
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
                                            <s:text name="web.admin.content.user.regist.field.kanriUserPassword" />
                                        </th>
                                        <td class="left">
                                            <s:password name="kanriUserPassword" cssErrorClass="fieldError" maxlength="20" size="30" cssClass="imeoff" />
                                            <s:fielderror>
                                                <s:param>kanriUserPassword</s:param>
                                            </s:fielderror>
                                            <p style="margin: 5px 0px 0px;">
                                                <s:text name="web.admin.content.user.regist.text.kanriUserPasswordKakunin.message" />
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
                                            <s:text name="web.admin.content.user.regist.field.svFlg" />
                                        </th>
                                        <td class="left">
                                            <s:checkbox name="svFlg" value="%{svFlg == \"1\"}" cssErrorClass="fieldError" fieldValue="1"/>
                                            <s:fielderror>
                                                <s:param>svFlg</s:param>
                                            </s:fielderror>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="center">
                                            <s:text name="web.admin.content.user.regist.field.kikakuCdList" />
                                        </th>
                                        <td class="left">
                                            <s:checkboxlist name="kikakuCdList" list="%{cache.kikakuMap}" listKey="key" listValue="value" cssErrorClass="fieldError"/>
                                            <s:fielderror>
                                                <s:param>kikakuCdList</s:param>
                                            </s:fielderror>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="center">
                                            <s:text name="web.admin.content.user.regist.field.siyouKahiFlg" />
                                        </th>
                                        <td class="left">
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
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="right noBorder" colspan="4">
                                            <s:submit
                                                action="user_regist"
                                                method="regist_exec"
                                                cssStyle="width: 100px; height: 30px;"
                                                cssClass="button"
                                                value="%{getText('web.admin.content.user.regist.button.regist')}"
                                            />
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    </form>
                </div><!-- mainArea -->

