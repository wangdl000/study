<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>

<c:set var="title" value="webadmin" scope="request" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<%
	SimpleDateFormat koushinBiFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSSS");
%>
<%-- <fmt:formatDate value="<%=koushinBiFormat %>" pattern="yyyy-MM-dd HH:mm:ss.SSSS" /> --%>
<jsp:include page="../base/package.jsp" flush="false" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:insertAttribute name="title" /></title>

<link media="all" type="text/css"
	href="${pageContext.request.contextPath}/webadmin/css/admin.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/webadmin/js/common.js"
	type="text/javascript"></script>
</head>
<body>
	<div id="container" class="layout01">
		<div id="header">
			<tiles:insertAttribute name="webadmin_content_header" />
		</div>
		<!--header-->
		<div id="separate"></div>
		<div id="contents">
			<div id="leftArea">
				<tiles:insertAttribute name="webadmin_content_left_area" />
			</div>
			<!--leftPanel-->
			<div id="rightArea">
				<tiles:insertAttribute name="webadmin_content_right_area" />
			</div>
			<!-- rightArea -->
		</div>
		<!--contents-->
		<div id="pageTop">
			<tiles:insertAttribute name="webadmin_content_page_top" />
		</div>
		<div id="adminfooter">
			<tiles:insertAttribute name="webadmin_content_footer" />
		</div>
	</div>
</body>
</html>
