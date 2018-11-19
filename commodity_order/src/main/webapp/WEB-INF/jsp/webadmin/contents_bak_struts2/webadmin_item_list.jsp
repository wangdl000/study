<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basedir = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<form action="syouhinList!page_change" method="post" >
<!-- <s:token /> -->
<div id="pageTitle">
    <span style="font-size: 150%; font-weight: bold;">
<!--         <s:text name="web.admin.content.item.list.title" /> -->
    </span>
    <div style="clear: both;margin: 0px 0px 0px 0px;padding: 2px 0;text-align: right;vertical-align:middle;border-top: 2px solid #0000ff;"></div>
</div>
<div id="mainArea" class="adminMainArea">
    <div class="main">
        <div class="center" style="width: 92%; padding: 8px; background: #C0C0C0; border: 1px solid #808080;">
            <table width="100%">
                <colgroup width="16%"></colgroup>
                <colgroup width="25%"></colgroup>
                <colgroup width="10%"></colgroup>
                <colgroup width="39%"></colgroup>
                <colgroup width="10%"></colgroup>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.item.list.field.catalogId" />
                    </td>
                    <td class="left">
                        <s:set var="catalogMap" value="%{cache.getCatalogMap(adminLogin.kikakuCd)}"/>
                        <s:select label=""
                                  headerKey="%{getText('web.admin.content.user.list.field.catalogId.headerKey')}"
                                  headerValue="%{getText('web.admin.content.user.list.field.catalogId.headerValue')}"
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
                        <s:text name="web.admin.content.item.list.field.hagakiSyouhinCd" />
                    </td>
                    <td class="left">
                        <s:textfield name="hagakiSyouhinCd" cssErrorClass="fieldError" size="10" maxlength="6" cssClass="imeoff"/>
                        <s:fielderror>
                                <s:param>hagakiSyouhinCd</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:text name="web.admin.content.item.list.field.syouhinHyoujiName" />
                    </td>
                    <td class="left">
                        <s:textfield name="syouhinHyoujiName" cssErrorClass="fieldError" size="30" maxlength="100" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>syouhinHyoujiName</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">&nbsp;</td>
                </tr>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.item.list.field.itemKeisaiKbn" />
                    </td>
                    <td class="left">
                        <s:select label=""
                                  headerKey="%{getText('web.admin.content.item.list.field.itemKeisaiKbn.headerKey')}"
                                  headerValue="%{getText('web.admin.content.item.list.field.itemKeisaiKbn.headerValue')}"
                                  name="itemKeisaiKbn"
                                  list="%{getCodeMap(5010)}"
                                  listKey="key"
                                  listValue="value"
                                  multiple="false"
                                  size="1"
                                  required="true"
                                  cssErrorClass="fieldError"
                                  cssClass="select"
                        />
                        <s:fielderror>
                                <s:param>itemKeisaiKbn</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:text name="web.admin.content.item.list.field.genreNo" />
                    </td>
                    <td class="left">
                        <s:set var="genreMap" value="%{cache.getKikakuGenreMap(adminLogin.kikakuCd)}"/>
                        <s:select label=""
                                  headerKey="%{getText('web.admin.content.item.list.field.genreNoheaderKey')}"
                                  headerValue="%{getText('web.admin.content.item.list.field.headerValue')}"
                                  name="genreNo"
                                  list="genreMap"
                                  listKey="key"
                                  listValue="value"
                                  multiple="false"
                                  size="1"
                                  required="true"
                                  cssErrorClass="fieldError"
                                  cssClass="select"
                        />
                        <s:fielderror>
                                <s:param>genreNo</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:submit
                            action="syouhinList"
                            method="submit_search"
                            value="%{getText('web.admin.content.item.list.button.search')}"
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
        <s:if test="%{syouhinList.size != 0}">
            <div class="pager"  style="display: ;">
                <table width="100%">
                    <colgroup width="50%"></colgroup>
                    <colgroup width="25%"></colgroup>
                    <colgroup width="25%"></colgroup>
                    <tbody>
                        <tr>
                            <td class="left">

                                <s:set var="PAGING_PAGE_INDEX" value="pageIndex" />
                                <s:set var="PAGING_START_INDEX" value="startIndex" />
                                <s:set var="PAGING_LIST_CNT" value="listCnt" />
                                <s:set var="PAGING_TOTAL_REC_CNT" value="totalRecCnt" />
                                <s:set var="PAGING_NOW_VIEW_LIST_SIZE" value="syouhinList.size()" />
                                <s:set var="PAGING_SORT_ORDER_NAME" value="%{'sortItem'}" />
                                <s:set var="PAGING_SORT_ORDER_VALUE" value="sortItem" />

                                <s:set var="PAGING_ACTION_NAMESPACE" value="%{'/webadmin'}" />
                                <s:set var="PAGING_ACTION_PATH_NAME" value="%{'syouhinList'}" />
                                <s:set var="PAGING_ACTION_METHOD" value="%{'page_change'}" />

                                <jsp:include page="../contents_sub/paging.jsp" />
                            </td>
                            <td class="right">
                                <s:text name="web.admin.content.user.list.field.sortItem"/>
                                <s:select label=""
                                        name="sortItem"
                                        list="%{getCodeMap(5210)}"
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
                                        list="%{getCodeMap(5410)}"
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
                    <colgroup width="25%"></colgroup>
                    <colgroup width="15%"></colgroup>
                    <colgroup width="53%"></colgroup>
                    <colgroup width="7%"></colgroup>
                    <s:iterator value="syouhinList" status="syouhinListStatus">
                        <tr>
                            <td rowspan="5" class="center" style="padding: 2px;">
                                <s:url id="edit" namespace="/webadmin" action="syouhinEdit">
                                   <s:param name="catalogId" value="catalogId"/>
                                   <s:param name="hagakiSyouhinCd" value="hagakiSyouhinCd"/>
                                </s:url>
                                <s:a href="%{edit}">
                                    <img src="<s:property value="baseDir"/>/<s:property value="miniImage1"/>"; width="160" height="160" />
                                </s:a>
                            </td>
                            <th>
                                <s:text name="web.admin.content.item.list.result.body.hagakiSyouhinCd" />
                            </th>
                            <td class="left">
                                <s:property value="hagakiSyouhinCd"/>&nbsp;
                            </td>
                            <td rowspan="5">
                                <s:a href="%{edit}">
                                    <s:text name="web.admin.content.item.list.result.body.link.edit" />
                                </s:a>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <s:text name="web.admin.content.item.list.result.body.catalogName" />
                            </th>
                            <td class="left">
                                <s:property value="catalogName"/>&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <s:text name="web.admin.content.item.list.result.body.allGenre" />
                            </th>
                            <td class="left">
                                <s:property value="allGenre"/>&nbsp;
                            </td>
                        </tr>
                         <tr>
                             <th>
                                <s:text name="web.admin.content.item.list.result.body.syouhinHyoujiName" />
                             </th>
                             <td class="left">
                                <s:property value="syouhinHyoujiName"/>&nbsp;
                             </td>
                         </tr>
                         <tr>
                             <th>
                                <s:text name="web.admin.content.item.list.result.body.itemKeisaiName" />
                             </th>
                             <td class="left">
                                <s:property value="%{getCodeValue(5010, itemKeisaiKbn)}"/>&nbsp;
                             </td>
                         </tr>
                         <s:if test="!#syouhinListStatus.last">
                             <tr>
                                <td class="noBorder" colspan="4"><hr class="hr" /></td>
                            </tr>
                        </s:if>
                       </s:iterator>
                </table>
            </div>
        </s:if>
    </div>
</div><!-- mainArea -->
</form>