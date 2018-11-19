<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
USAGE

<s:set name="PAGING_PAGE_INDEX" value="現在の表示ページ" />
<s:set name="PAGING_START_INDEX" value="現在表示している開始行" />
<s:set name="PAGING_LIST_CNT" value="一度に表示する行数" />
<s:set name="PAGING_TOTAL_REC_CNT" value="データの全件数" />
<s:set name="PAGING_NOW_VIEW_LIST_SIZE" value="今回表示する行数" />
<s:set name="PAGING_SORT_ORDER_NAME" value="ソート項目の名称" />
<s:set name="PAGING_SORT_ORDER_VALUE" value="ソート項目の値" />

<s:set name="PAGING_ACTION_NAMESPACE" value="リンク先のネームスペース" />
<s:set name="PAGING_ACTION_PATH_NAME" value="リンク先のアクションパス" />
<s:set name="PAGING_ACTION_METHOD" value="リンク先のアクションメソッド" />

<jsp:include page="../tiles_contents_sub/paging.jsp" />

--%>

<ul class="clearFix">
    <li class="info">
        <s:text name="web.admin.common.paging.countText" >
            <s:param><s:property value="#PAGING_START_INDEX" /></s:param><%-- 開始件数 --%>
            <s:param><s:property value="%{#PAGING_START_INDEX + #PAGING_NOW_VIEW_LIST_SIZE - 1}" /></s:param><%-- 終了件数 --%>
            <s:param><s:property value="#PAGING_TOTAL_REC_CNT" /></s:param><%-- 全件数 --%>
        </s:text>
    </li>
    <li class="prev">
        <s:if test="%{#PAGING_PAGE_INDEX > 1}">
            <s:url id="prevUrl" namespace="%{#PAGING_ACTION_NAMESPACE}" action="%{#PAGING_ACTION_PATH_NAME}" method="%{#PAGING_ACTION_METHOD}">
                <s:param name="%{#PAGING_SORT_ORDER_NAME}" value="#PAGING_SORT_ORDER_VALUE"/>
                <s:param name="listCnt" value="#PAGING_LIST_CNT"/>
                <s:param name="pageIndex" value="%{(new java.lang.Integer(#PAGING_PAGE_INDEX)) - 1}"/>
            </s:url>
            <s:a href="%{prevUrl}">
                <s:text name="web.admin.common.paging.link.prev" />
            </s:a>
        </s:if>
        <s:else>
            <s:text name="web.admin.common.paging.link.prev" />
        </s:else>
    </li>
    <s:if test="%{(#PAGING_TOTAL_REC_CNT % #PAGING_LIST_CNT)==0}">
        <s:set name="addPageIndex" value="0" />
    </s:if>
    <s:else>
        <s:set name="addPageIndex" value="1" />
    </s:else>
    <s:set name="maxPageIndex" value="%{(new java.lang.Integer(#PAGING_TOTAL_REC_CNT)) /  (new java.lang.Integer(#PAGING_LIST_CNT)) + #addPageIndex}" />
    <s:iterator status="stat" value="(#maxPageIndex).{ #this }" >
        <li>
            <s:if test="%{#stat.count==(new java.lang.Integer(#PAGING_PAGE_INDEX))}">
                <strong>
                    <s:text name="web.admin.common.paging.link.number">
                        <s:param><s:property value="#stat.count" /></s:param>
                    </s:text>
                </strong>
            </s:if>
            <s:else>
                <s:url id="pageUrl" namespace="%{#PAGING_ACTION_NAMESPACE}" action="%{#PAGING_ACTION_PATH_NAME}" method="%{#PAGING_ACTION_METHOD}">
                    <s:param name="%{#PAGING_SORT_ORDER_NAME}" value="#PAGING_SORT_ORDER_VALUE"/>
                    <s:param name="listCnt" value="#PAGING_LIST_CNT"/>
                    <s:param name="pageIndex" value="#stat.count"/>
                </s:url>
                <s:a href="%{pageUrl}">
                    <s:text name="web.admin.common.paging.link.number">
                        <s:param><s:property value="#stat.count" /></s:param>
                    </s:text>
                </s:a>
            </s:else>
        </li>
    </s:iterator>
    <li class="next">
        <s:if test="#maxPageIndex > #PAGING_PAGE_INDEX" >
            <s:url id="nextUrl" namespace="%{#PAGING_ACTION_NAMESPACE}" action="%{#PAGING_ACTION_PATH_NAME}" method="%{#PAGING_ACTION_METHOD}">
                <s:param name="%{#PAGING_SORT_ORDER_NAME}" value="#PAGING_SORT_ORDER_VALUE"/>
                <s:param name="listCnt" value="#PAGING_LIST_CNT"/>
                <s:param name="pageIndex" value="%{(new java.lang.Integer(#PAGING_PAGE_INDEX)) + 1}"/>
            </s:url>
            <s:a href="%{nextUrl}">
                <s:text name="web.admin.common.paging.link.next" />
            </s:a>
        </s:if>
        <s:else>
            <s:text name="web.admin.common.paging.link.next" />
        </s:else>
    </li>
</ul>
