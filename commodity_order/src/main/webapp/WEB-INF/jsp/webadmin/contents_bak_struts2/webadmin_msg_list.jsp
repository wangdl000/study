<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:set name="keisaiFormat" value="%{new java.text.SimpleDateFormat(\"yyyy年MM月dd日\")}" />
<form action="msgList!page_change" method="post" >
<s:token />
<div id="pageTitle">
    <span style="font-size:150%;font-weight:bold;">
        <s:text name="web.admin.content.comment.list.title" />
    </span>
    <div style="clear: both;margin: 0px 0px 0px 0px;padding: 2px 0;text-align: right;vertical-align:middle;border-top: 2px solid #0000ff;"></div>
</div>
<div id="mainArea" class="adminMainArea">
    <div class="main">
        <div class="center" style="width: 92%; padding: 8px; background: #C0C0C0; border: 1px solid #808080;">
            <table width="100%">
                <colgroup width="12%"></colgroup>
                <colgroup width="23%"></colgroup>
                <colgroup width="10%"></colgroup>
                <colgroup width="45%"></colgroup>
                <colgroup width="10%"></colgroup>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.comment.list.field.catalogId" />
                    </td>
                    <td class="left">
                        <s:set name="catalogMap" value="%{cache.getCatalogMap(adminLogin.kikakuCd)}"/>
                        <s:select label=""
                                  headerKey="%{getText('web.admin.content.comment.list.field.catalogId.headerKey')}"
                                  headerValue="%{getText('web.admin.content.comment.list.field.catalogId.headerValue')}"
                                  name="catalogId"
                                  list="catalogMap"
                                  listKey="key"
                                  listValue="value"
                                  multiple="false"
                                  size="1"
                                  required="true"
                                  cssErrorClass="fieldError"
                                  cssClass="select"
                        />
                        <s:fielderror>
                                <s:param>catalogId</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left"></td>
                    <td class="left" colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.comment.list.field.msgNo" />
                    </td>
                    <td class="left">
                        <s:textfield name="msgNo" size="10" maxlength="8" cssErrorClass="fieldError" cssClass="imeoff"/>
                        <s:fielderror>
                            <s:param>msgNo</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:text name="web.admin.content.comment.list.field.msgHeader" />
                    </td>
                    <td class="left" colspan="2">
                        <s:textfield name="msgHeader" size="30" maxlength="500" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>msgHeader</s:param>
                        </s:fielderror>
                    </td>
                </tr>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.comment.list.field.msgKeisaiKbn" />
                    </td>
                    <td class="left">
                          <s:select label=""
                                  headerKey="%{getText('web.admin.content.comment.list.field.msgKeisaiKbn.headerKey')}"
                                  headerValue="%{getText('web.admin.content.comment.list.field.msgKeisaiKbn.headerValue')}"
                                  name="msgKeisaiKbn"
                                  list="%{getCodeMap(5030)}"
                                  listKey="key"
                                  listValue="value"
                                  multiple="false"
                                  size="1"
                                  required="true"
                                  cssErrorClass="fieldError"
                                  cssClass="select"
                        />
                        <s:fielderror>
                                <s:param>msgKeisaiKbn</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:text name="web.admin.content.comment.list.field.keisai" />
                    </td>
                    <td class="left">
                        <s:textfield name="keisaiFrom" cssErrorClass="fieldError" size="10" maxlength="10" cssClass="imeoff"/>
                        <s:fielderror>
                            <s:param>keisaiFrom</s:param>
                        </s:fielderror>
                        <s:text name="web.admin.content.comment.list.field.waveLine" />
                        <s:textfield name="keisaiTo" cssErrorClass="fieldError" size="10" maxlength="10" cssClass="imeoff"/>
                        <s:fielderror>
                            <s:param>keisaiTo</s:param>
                       </s:fielderror>
                    </td>
                    <td class="left">
                        <s:submit label=""
                            action="msgList"
                            method="submit_search"
                            value="%{getText('web.admin.content.comment.list.button.search')}"
                            cssStyle="width: 100px; height: 20px;"
                            cssClass="button"
                            cssErrorClass="fieldError"
                        />
                    </td>
                </tr>
                <tr>
                    <td class="left" colspan="4"></td>
                    <td class="left">
                        <s:submit label=""
                            action="msg_regist"
                            method="regist"
                            value="%{getText('web.admin.content.comment.list.button.add')}"
                            cssStyle="width: 100px; height: 20px;"
                            cssClass="button"
                            cssErrorClass="fieldError"
                        />
                    </td>
                </tr>
            </table>
        </div>
        <s:actionmessage/>
        <s:actionerror/>
        <s:if test="%{msgList.size != 0}">
            <div class="pager" style="display: ;">
                <table width="100%">
                    <colgroup width="50%"></colgroup>
                    <colgroup width="25%"></colgroup>
                    <colgroup width="25%"></colgroup>
                    <tbody>
                        <tr>
                            <td class="left">

                                <s:set name="PAGING_PAGE_INDEX" value="pageIndex" />
                                <s:set name="PAGING_START_INDEX" value="startIndex" />
                                <s:set name="PAGING_LIST_CNT" value="listCnt" />
                                <s:set name="PAGING_TOTAL_REC_CNT" value="totalRecCnt" />
                                <s:set name="PAGING_NOW_VIEW_LIST_SIZE" value="msgList.size()" />
                                <s:set name="PAGING_SORT_ORDER_NAME" value="%{'sortItem'}" />
                                <s:set name="PAGING_SORT_ORDER_VALUE" value="sortItem" />

                                <s:set name="PAGING_ACTION_NAMESPACE" value="%{'/webadmin'}" />
                                <s:set name="PAGING_ACTION_PATH_NAME" value="%{'msgList'}" />
                                <s:set name="PAGING_ACTION_METHOD" value="%{'page_change'}" />

                                <jsp:include page="../contents_sub/paging.jsp" />
                            </td>
                            <td class="right">
                                <s:text name="web.admin.content.user.list.field.sortItem"/>
                                <s:select label=""
                                        name="sortItem"
                                        list="%{getCodeMap(5230)}"
                                        listKey="key"
                                        listValue="value"
                                        onchange="submit();"
                                        multiple="false"
                                        size="1"
                                        required="true"
                                />
                            </td>
                            <td class="right">
                                <s:text name="web.admin.content.user.list.field.listCnt"/>
                                <s:select label=""
                                        name="listCnt"
                                        list="%{getCodeMap(5450)}"
                                        listKey="key"
                                        listValue="value"
                                        onchange="submit();"
                                        multiple="false"
                                        size="1"
                                        required="true"
                                />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div  style="display: ;margin-top: 10px;">
                <table class="itemListTable" width="95%">
                   <colgroup width="11%"></colgroup>
                   <colgroup width="8%"></colgroup>
                   <colgroup width="43%"></colgroup>
                   <colgroup width="12%"></colgroup>
                   <colgroup width="18%"></colgroup>
                   <colgroup width="8%"></colgroup>
                    <tr>
                        <th>
                            <s:text name="web.admin.content.comment.list.result.head.catalogName" />
                        </th>
                        <th>
                           <s:text name="web.admin.content.comment.list.result.head.msgNo" />
                        </th>
                        <th>
                           <s:text name="web.admin.content.comment.list.result.head.msgHeader" />
                        </th>
                        <th>
                           <s:text name="web.admin.content.comment.list.result.head.msgkeisaiName" />
                        </th>
                        <th>
                           <s:text name="web.admin.content.comment.list.result.head.keisai" />
                        </th>
                        <th>&nbsp;</th>
                    </tr>
                    <s:iterator value="msgList">
                        <tr>
                            <td class="left">
                                <s:property value="catalogName"/>&nbsp;
                            </td>
                            <td class="left">
                                <s:property value="msgNo"/>&nbsp;
                            </td>
                            <td class="left" style="word-break: break-all;">
                                <s:property value="msgHeader"/>&nbsp;
                            </td>
                            <td class="center">
                                <s:property value="%{getCodeValue(5030, msgKeisaiKbn)}"/>&nbsp;
                            </td>
                            <td class="left">
                               <s:property value="%{#keisaiFormat.format(keisaiFrom)}"/>&nbsp;
                               <s:if test="((keisaiFrom != null) || (keisaiTo != null))">
                                    <s:text name="web.admin.content.comment.list.result.body.waveLine" />&nbsp;
                               </s:if>
                              <s:property value="%{#keisaiFormat.format(keisaiTo)}"/>&nbsp;
                            </td>
                            <td class="center">
                                <s:url id="edit" namespace="/webadmin" action="msg_edit">
                                   <s:param name="catalogId" value="catalogId"/>
                                   <s:param name="msgNo" value="msgNo"/>
                                </s:url>
                                <s:a href="%{edit}">
                                    <s:text name="web.admin.content.comment.list.result.body.link.edit" />
                                </s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </s:if>
    </div>
</div>
</form>
