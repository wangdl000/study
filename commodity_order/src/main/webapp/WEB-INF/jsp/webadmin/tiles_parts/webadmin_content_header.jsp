<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="package" var="packageInfo" />
<fmt:message bundle="${packageInfo}" var="label_text_userNameSuffix" key="web.admin.header.text.userNameSuffix" /><!-- 　様 -->
<fmt:message bundle="${packageInfo}" var="label_button_logout" key="web.admin.header.button.logout" /><!-- ログアウト -->

<div class="logo">
    <img src="${pageContext.request.contextPath}/rose_selection/images/common/header/logo.jpg" alt="" width="166" height="60" />
</div>
<div class="user">
    <span style="margin-right: 50px;font-size : 1.5em;">
<!--         <s:property value="%{cache.kikakuMap.get(adminLogin.kikakuCd)}"/> -->
    </span>
    <span>
<!--         <s:property value="%{adminLogin.kanriUserNm}"/>-->${label_text_userNameSuffix }
    </span>
</div>
<div>
    <div class="navi">
        <ul>
            <li>
                <form action="logout">
                    <input type="submit" class="button" style="width:100px;height:30px" value="${label_button_logout }" />
                </form>
            </li>
        </ul>
    </div><!--navi-->
</div>
