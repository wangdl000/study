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

	<script src="common/js/jquery-1.4.4.js" charset="UTF-8" type="text/javascript"></script>

    <script src="common/js/jquery-ui-1.8.6.custom.min.js" type="text/javascript"></script>
    <script src="common/js/ui/i18n/jquery.ui.datepicker-ja.js"></script>

    <link href="common/css/ui-lightness/jquery-ui-1.8.6.custom.css" rel="stylesheet" type="text/css">

    <script src="/common/ajaxzip2/ajaxzip2.js" charset="UTF-8" type="text/javascript"></script>
    <script type="text/javascript">AjaxZip2.JSONDATA = 'common/ajaxzip2/data';</script>
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

			<tiles:insertAttribute name="content_area"/>

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
