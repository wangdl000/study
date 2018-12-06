<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ page language="java" import="com.ht.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		AccountBean account = (AccountBean) session.getAttribute("account");
	%>
	username:<%=account.getUsername()%>
	<br> password:<%=account.getPassword()%>
</body>
</html>