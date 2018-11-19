<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:url id="ItemUrl" namespace="/" action="item_detail" method="">
    <s:param name="syouhinCd" value="hagakiSyouhinCd"/>
</s:url>
<img src="${pageContext.request.contextPath}/<s:property value="miniImage1"/>" alt="<s:property value="syouhinHyoujiName"/>" width="120" height="120" />
<br />
<p>
    [<s:property value="viewItemCd"/>]
    &nbsp;
    <s:iterator value="genreNoIconList" status="">
        <img src="${pageContext.request.contextPath}/images/genre_icons/genre_icon_<s:property/>.gif" alt="" border="0"  />&nbsp;
    </s:iterator>
    <br>
    <s:property value="syouhinHyoujiName"/>
    <br>
    <s:a href="%{ItemUrl}">商品詳細を見る</s:a>
</p>
