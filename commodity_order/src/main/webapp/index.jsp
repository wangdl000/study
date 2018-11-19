<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basedir = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>テスト用マイン画面</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="${pageContext.request.contextPath }/css/metisMenu.min.css" rel="stylesheet">
<!-- DataTables CSS -->
<link href="${pageContext.request.contextPath }/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath }/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/css/boot-crm.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<h2>■テスト用マイン画面</h2>
<%-- 	${password } --%>
	<span>pageContext.request.contextPath:::::${pageContext.request.contextPath}</span><br>
	<span>path:::: <%=path %></span><br>
	<span>basedir:::::::<%=basedir %></span><br>

	<h3>
		<a href="customer/list.action" class="active">参照用サンプル（中国語）</a>
	</h3>



	<br>

	<h3>
		<a href="adminLogin/init.action" class="active">D-001_管理者向け_ログイン</a>
	</h3>
	<h3>
		<a href="adminLogin/init.action" class="active">商品情報一覧・検索</a>
	</h3>

</body>
</html>
