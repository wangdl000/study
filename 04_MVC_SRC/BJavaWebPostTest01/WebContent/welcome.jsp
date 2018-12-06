
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="gbk"%>
<%@ page language="java" import="com.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    Acount account = (Acount)session.getAttribute("account");
%>
<h2>
Welcome to "<%= account.getUsername()%>" Login System!
</h2>
This is the first javaWeb Project!
</body>
</html>