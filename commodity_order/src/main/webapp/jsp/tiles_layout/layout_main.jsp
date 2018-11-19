<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html lang="jp">
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" >
	<title>
		<tiles:getAsString name="title" />
	</title>
	<link id="companyStyle" media="all" type="text/css" href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
	<link media="all" type="text/css" href="${pageContext.request.contextPath}/css/order.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
	<head/>
</head>
<body>
	<div class="layout01" id="container">
		<div id="header">
			<tiles:insertAttribute name="content_header"/>
		</div>
		<%-- グローバルナビ --%>
		<tiles:insertAttribute name="content_global_navi"/>
		<div id="contents">
			<div id="leftArea">
			<tiles:insertAttribute name="content_left_area"/>
			</div>
			<div id="rightArea">
				<tiles:insertAttribute name="content_right_area"/>
			</div>
			<div id="pageTop">
				<tiles:insertAttribute name="content_page_top"/>
			</div>
		</div>
		<div id="footer">
			<tiles:insertAttribute name="content_footer"/>
		</div>
	</div>
</body>
</html>
