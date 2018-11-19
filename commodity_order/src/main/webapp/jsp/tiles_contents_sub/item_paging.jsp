<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
                <%-- ページング制御 --%>

                <s:if test="itemList == null || itemList.size==0">
                    &laquo;前へ
                    [1]
                    次へ&raquo;
                    &nbsp;&nbsp;
                    0
                    ～
                    0件
                    ／
                    全0件
                </s:if>
                <s:else>

                    <s:set name="startIdx" value="%{start - 1}"/>

                    <s:if test="(#startIdx + limit - 1) < itemList.size()">
                        <s:set name="lastIdx" value="%{#startIdx + limit - 1}"/>
                    </s:if>
                    <s:else>
                        <s:set name="lastIdx" value="%{itemList.size() - 1}"/>
                    </s:else>
                    <%-- 前へURL --%>
                    <s:url id="beforeUrl" namespace="/" action="item_search" method="">
                        <s:param name="genreNo" value="genreNo"/>
                        <s:param name="start" value="start - limit"/>
                    </s:url>
                    <%-- 次へURL --%>
                    <s:url id="nextUrl" namespace="/" action="item_search" method="">
                        <s:param name="genreNo" value="genreNo"/>
                        <s:param name="start" value="start + limit"/>
                    </s:url>

                    <s:iterator value="itemList" status="itemStatus">
                        <s:if test="#itemStatus.first">
                            <s:if test="#startIdx > 0">
                                <s:a href="%{beforeUrl}">
                                    &laquo;前へ
                                </s:a>
                            </s:if>
                            <s:else>
                                &laquo;前へ
                            </s:else>
                        </s:if>

                        <s:if test="(#itemStatus.index % limit) == 0">
                            <s:url id="itemPageUrl" namespace="/" action="item_search" method="">
                                <s:param name="genreNo" value="genreNo"/>
                                <s:param name="start" value="#itemStatus.index + 1"/>
                            </s:url>
                            <s:if test="#itemStatus.index >= #startIdx && #itemStatus.index  < (#startIdx + limit)">
                                <strong>
                                    [<s:property value="#itemStatus.index / limit + 1"/>]
                                </strong>
                            </s:if>
                            <s:else>
                                <s:a href="%{itemPageUrl}">
                                    [<s:property value="#itemStatus.index / limit + 1"/>]
                                </s:a>
                            </s:else>
                        </s:if>

                        <s:if test="#itemStatus.last">
                            <s:if test="(start + limit) < #itemStatus.index">
                                    <s:a href="%{nextUrl}">
                                        次へ&raquo;
                                    </s:a>
                            </s:if>
                            <s:else>
                                次へ&raquo;
                            </s:else>
                            &nbsp;&nbsp;
                            <s:property value="start " />
                            ～
                            <s:property value="#lastIdx + 1" />件
                            ／
                            全<s:property value="#itemStatus.index + 1"/>件
                        </s:if>
                    </s:iterator>
                </s:else>
