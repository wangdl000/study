<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="pageTitle">
    <span style="font-size:150%;font-weight:bold;">
        <s:text name="web.admin.content.catalog.list.title" />
    </span>
    <div style="clear: both;margin: 0px 0px 0px 0px;padding: 2px 0;text-align: right;vertical-align:middle;border-top: 2px solid #0000ff;"></div>
</div>
<form action="catalogList!page_change" >
<div id="mainArea" class="adminMainArea">
    <div class="main">
        <div class="center" style="width: 92%; padding: 8px; background: #C0C0C0; border: 1px solid #808080;">
            <table width="100%">
                <colgroup width="10%"></colgroup>
                <colgroup width="22%"></colgroup>
                <colgroup width="10%"></colgroup>
                <colgroup width="48%"></colgroup>
                <colgroup width="10%"></colgroup>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.catalog.list.field.catalogName" />
                    </td>
                    <td class="left" colspan="4">
                     <s:textfield name="catalogName" size="40" maxlength="40" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                            <s:param>catalogName</s:param>
                        </s:fielderror>
                     </td>
                </tr>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.catalog.list.field.catalogYuukouBi" />
                    </td>
                    <td class="left">
                    <s:textfield name="catalogYuukouFrom" size="10" maxlength="10" cssErrorClass="fieldError" cssClass="imeoff"/>
                        <s:fielderror>
                            <s:param>catalogYuukouFrom</s:param>
                        </s:fielderror>
                    &nbsp;～&nbsp;
                    <s:textfield name="catalogYuukouTo" size="10" maxlength="10" cssErrorClass="fieldError" cssClass="imeoff"/>
                        <s:fielderror>
                            <s:param>catalogYuukouTo</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                    <s:submit
                            action="catalogList"
                            method="submit_search"
                            value="%{getText('web.admin.content.catalog.list.button.search')}"
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
<s:if test="%{kikakuCourseCatalogList.size != 0}">
        <div class="pager">
            <table width="100%">
                <colgroup width="50%"></colgroup>
                <colgroup width="25%"></colgroup>
                <colgroup width="25%"></colgroup>
                <tr>
                    <td class="left">
                        <s:set name="PAGING_PAGE_INDEX" value="pageIndex" />
                        <s:set name="PAGING_START_INDEX" value="startIndex" />
                        <s:set name="PAGING_LIST_CNT" value="listCnt" />
                        <s:set name="PAGING_TOTAL_REC_CNT" value="totalRecCnt" />
                        <s:set name="PAGING_NOW_VIEW_LIST_SIZE" value="kikakuCourseCatalogList.size()" />
                        <s:set name="PAGING_SORT_ORDER_NAME" value="%{'sortItem'}" />
                        <s:set name="PAGING_SORT_ORDER_VALUE" value="sortItem" />

                        <s:set name="PAGING_ACTION_NAMESPACE" value="%{'/webadmin'}" />
                        <s:set name="PAGING_ACTION_PATH_NAME" value="%{'catalogList'}" />
                        <s:set name="PAGING_ACTION_METHOD" value="%{'page_change'}" />

                        <jsp:include page="../contents_sub/paging.jsp" />
                    </td>
                    <td class="right">
                        <s:text name="web.admin.content.catalog.list.field.sortItem" />
                        <s:select label=""
                                   name="sortItem"
                                   list="getCodeMap(5240)"
                                   listKey="key"
                                   listValue="value"
                                   multiple="false"
                                   size="1"
                                   required="true"
                                   value="sortItem"
                                   onchange="form.submit();"
                                    />
                    </td>
                    <td class="right">
                        <s:text name="web.admin.content.catalog.list.field.listCnt" />
                        <s:select label=""
                                   name="listCnt"
                                   list="getCodeMap(5440)"
                                   listKey="key"
                                   listValue="value"
                                   multiple="false"
                                   size="1"
                                   required="true"
                                   value="listCnt"
                                   onchange="form.submit();"
                                    />
                    </td>
                </tr>
            </table>
        </div>

        <div style="margin-top: 10px;">
            <table class="itemListTable" width="95%">
                <colgroup width="20%"></colgroup>
                <colgroup width="20%"></colgroup>
                <colgroup width="20%"></colgroup>
                <colgroup width="20%"></colgroup>
                <colgroup width="7%"></colgroup>
                <tr>
                    <th>
                        <s:text name="web.admin.content.catalog.list.result.head.kikakuName" />
                    </th>
                    <th>
                        <s:text name="web.admin.content.catalog.list.result.head.webCourseHyoujiName" />
                    </th>
                    <th>
                        <s:text name="web.admin.content.catalog.list.result.head.catalogName" />
                    </th>
                    <th>
                        <s:text name="web.admin.content.catalog.list.result.head.catalogYuukouBi" />
                    </th>
                    <th>
                        <s:text name="web.admin.content.catalog.list.result.head.edit" />
                    </th>
                </tr>
                <s:iterator value="kikakuCourseCatalogList">
                <tr>
                    <td class="left"><s:property value="kikakuName"/>&nbsp;</td>
                    <td class="left"><s:property value="webCourseHyoujiName"/>&nbsp;</td>
                    <td class="left"><s:property value="catalogName"/>&nbsp;</td>
                    <td class="left"><s:property value="catalogYuukouBi"/>&nbsp;</td>
                    <td class="center">
                    <s:url id="hensyu" namespace="/webadmin" action="catalogEdit">
                        <s:param name="catalogId" value="catalogID"/>
                    </s:url>
                    <s:a href="%{hensyu}">
                        <s:text name="web.admin.content.catalog.list.result.body.link.edit" />
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
