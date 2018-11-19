<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../base/package.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
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
		<!--footer-->
	</div>
	<!--container-->
</body>
</html>
