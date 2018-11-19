<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="package" var="packageInfo" />

<div class="separate"></div>
<div class="copy">
    <fmt:message bundle="${packageInfo}" key="web.admin.footer.text.copyright" />
</div>
