<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="logo">
	<a href="adminLogin/top.action"> <img
		src="${pageContext.request.contextPath}/images/common/header/logo_rose_selectiion2.gif"
		alt="高島屋 ローズセレクション グルメ" width="405" height="70" />
	</a>
</div>
<div>
	<div class="navi">
		<ul>
			<li><a href=""><img
					src="${pageContext.request.contextPath}/images/common/header/header_subnavi01.gif"
					alt="ご利用ガイド" width="114" height="52" /></a></li>
			<li><a href=""><img
					src="${pageContext.request.contextPath}/images/common/header/header_subnavi02-1.gif"
					alt="よくある質問" width="113" height="52" /></a></li>
			<li><a href=""><img
					src="${pageContext.request.contextPath}/images/common/header/header_subnavi03.gif"
					alt="お問い合わせ" width="113" height="52" /></a></li>
			<li><a href=""><img
					src="${pageContext.request.contextPath}/images/common/header/header_subnavi04.gif"
					alt="ログアウト" width="113" height="52" /></a></li>
		</ul>
	</div>
	<div class="user">
		<span>承り番号 ： <!--              <s:property value="#session.SESSION_LOGIN_INFO.viewToiawaseNo" /> TODO -->
		</span>
	</div>
</div>
<div
	style="border-bottom: 2px solid rgb(255, 0, 0); margin: 5px 0px 0px; clear: both;">
</div>
