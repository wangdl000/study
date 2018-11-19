﻿<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="pageTitle">
    <span style="font-size:150%;font-weight:bold;">
        <s:text name="web.admin.content.comment.regist.title"></s:text>
    </span>
    <div style="clear: both;margin: 0px 0px 0px 0px;padding: 2px 0;text-align: right;vertical-align:middle;border-top: 2px solid #0000ff;"></div>
</div>
<div id="mainArea" class="adminMainArea">
    <div class="main">
        <form action="msg_regist" method="post" >
        <s:actionerror/>
        <s:token/>
        <div class="center">
            <table class="itemListTable noBorder" width="90%">
                <colgroup width="15%"></colgroup>
                <colgroup width="35%"></colgroup>
                <colgroup width="15%"></colgroup>
                <colgroup width="35%"></colgroup>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.comment.regist.field.catalogId"></s:text>
                    </th>
                    <td class="left" colspan="3">
                        <s:set name="catalogMap" value="%{cache.getCatalogMap(adminLogin.kikakuCd)}"/>
                        <s:select label=""
                                  name="catalogId"
                                  list="catalogMap"
                                  listKey="key"
                                  listValue="value"
                                  multiple="false"
                                  size="1"
                                  required="true"
                                  cssClass="select"
                                  cssErrorClass="fieldError"
                        />
                        <s:fielderror>
                                <s:param>catalogId</s:param>
                        </s:fielderror>
                    </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.comment.regist.field.msgNo"></s:text>
                    </th>
                    <td class="left" colspan="3">
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.comment.regist.field.msgKeisaiKbn"></s:text>
                    </th>
                    <td class="left">
                        <s:select label=""
                                   name="msgKeisaiKbn"
                                   list="getCodeMap(5030)"
                                   listKey="key"
                                   listValue="value"
                                   multiple="false"
                                   size="1"
                                   required="true"
                                   cssClass="select"
                                   cssErrorClass="fieldError"/>
                        <s:fielderror>
                            <s:param>msgKeisaiKbn</s:param>
                        </s:fielderror>
                    </td>
                    <th class="center">
                        <s:text name="web.admin.content.comment.regist.field.keisai"></s:text>
                    </th>
                    <td class="left">
                        <s:textfield name="keisaiFrom" size="10" maxlength="10" cssErrorClass="fieldError" cssClass="imeoff"/>
                        <s:fielderror>
                            <s:param>keisaiFrom</s:param>
                        </s:fielderror>&nbsp;<s:text name="web.admin.content.comment.regist.field.waveLine"></s:text>&nbsp;
                        <s:textfield name="keisaiTo" size="10" maxlength="10" cssErrorClass="fieldError" cssClass="imeoff"/>
                        <s:fielderror>
                            <s:param>keisaiTo</s:param>
                        </s:fielderror>
                    </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.comment.regist.field.msgHeader"></s:text>
                    </th>
                    <td class="left" colspan="3">
                        <s:textarea name="msgHeader" cols="65" rows="2" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>msgHeader</s:param>
                        </s:fielderror>
                    </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.comment.regist.field.msgNaiyou"></s:text>
                    </th>
                    <td class="left" colspan="3">
                        <s:textarea name="msgNaiyou" cols="65" rows="5" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>msgNaiyou</s:param>
                        </s:fielderror>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" class="right noBorder"><br>
                        <s:submit value="%{getText('web.admin.content.comment.regist.button.regist')}" 
                                  cssClass="button" 
                                  cssStyle="width:100px;height:30px"
                                  action="msg_regist" 
                                  method="regist_exec"/>
                    </td>
                </tr>
            </table>
        </div>
        </form>
    </div>
</div><!-- mainArea -->