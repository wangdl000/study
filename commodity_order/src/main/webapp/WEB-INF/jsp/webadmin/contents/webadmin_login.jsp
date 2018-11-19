<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:setBundle basename="package" var="packageInfo" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" >
    <title>
<%--          <tiles:getAsString name="title" /> --%>
    </title>
    <link media="all" type="text/css" href="${pageContext.request.contextPath}/webadmin/css/admin.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/webadmin/js/common.js" type="text/javascript"></script>
    <head/>
</head>
<body>
    <div class="center" style="width:400px; margin: 60px; border:1px solid #000000">
        <h1 style="line-height: 200%;">
            <fmt:message key="web.admin.common.company.name" bundle="${packageInfo}" />
            <br/>
            <fmt:message key="web.admin.content.login.title" bundle="${packageInfo}" />
        </h1>
    </div>
<!--     <s:actionmessage/> -->
<!--     <s:actionerror/> -->
    <div class="center" style="width:400px; margin: 60px; border:1px solid #000000">
        <form:form
				action="${pageContext.request.contextPath}/adminLogin/login.action"
				method="POST"
				modelAttribute="adminmodel">
<!--         <s:token /> -->
        <table style="border:0px solid #000000" width="400px">
            <colgroup width="40%"></colgroup>
            <colgroup width="60%"></colgroup>
            <tr>
                <td class="left" style="padding: 4px;" nowrap>
                    <fmt:message bundle="${packageInfo}" key="web.admin.content.login.field.kanriUserId" />
                </td>
                <td class="left" style="padding: 4px;">
                    <input type="text" name="kanriUserId" />
                    <form:errors path="kanriUserId" />
                </td>
            </tr>
            <tr>
                <td class="left" style="padding: 4px;" nowrap>
						<fmt:message bundle="${packageInfo}" key="web.admin.content.login.field.kanriUserPassword" />
                </td>
                <td class="left" style="padding: 4px;">
                    <input type="password" name="kanriUserPassword" class="password imeoff"  />
                    <form:errors path="kanriUserPassword" />
                </td>
            </tr>
            <tr>
                <td class="left" style="padding: 4px;">
                    <fmt:message bundle="${packageInfo}" key="web.admin.content.login.field.kikakuCd" />
                </td>
                <td class="left" style="padding: 4px;">
					<form:select items="${adminmodel.kikakuMap}" multiple="false" path="kikakuCd"/><br>
                </td>
            </tr>
            <tr>
                <td class="right" colspan="2" style="padding: 0 8px;">
                    <form:button type="submit" id="login" name="login" ><fmt:message bundle="${packageInfo}" key="web.admin.content.login.button.login" /></form:button>
                </td>
            </tr>
        </table>
        </form:form>
    </div>
    <br/>
</body>
</html>
