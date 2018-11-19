<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="jp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title id="title">
		<tiles:getAsString name="title" />
	</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css" type="text/css" media="all" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js" ></script>
	<head/>
</head>
<body>

<div class="Section2 center">
    <img src="${pageContext.request.contextPath}/images/common/header/logo_login.gif" alt="高島屋 ローズセレクション グルメ" width="430" height="100" />
</div>
<div class="Section2">
<table cellspacing="7" class="tableStyle3">
	<tr>
		<td>

        <s:actionerror />

        <form action="login" method="post" >
        <s:token />
		<table style="margin: 0 auto;" width="430">
			<tr>
				<td colspan="2" class="left" style="padding: 8px;">
				    <img src="${pageContext.request.contextPath}/images/common/header/title_login.gif" alt="お申し込み者様ログイン" width="225" height="17" /></td>
			</tr>
			<tr>
				<td class="left" style="padding: 8px;">
				    受付番号
				</td>
				<td class="left" style="padding: 8px;">
				    <s:textfield name="id" value="%{id[0]}" cssErrorStyle="background-color:RED;" size="4" maxlength="4"  />
                    <span>&nbsp;-&nbsp;</span>
                    <s:textfield name="id" value="%{id[1]}" cssErrorStyle="background-color:RED;" size="4" maxlength="4"  />
				    <span>&nbsp;-&nbsp;</span>
                    <s:textfield name="id" value="%{id[2]}" cssErrorStyle="background-color:RED;" size="4" maxlength="4"  />
                    <s:fielderror>
                        <s:param>id</s:param>
                    </s:fielderror>
				</td>
			</tr>
			<tr>
				<td class="left" style="padding: 8px;">パスワード</td>
				<td class="left" style="padding: 8px;">
                    <s:password name="password" cssErrorStyle="background-color:RED;" size="30" maxlength="10" value="" class="password" />
                    <s:fielderror>
                        <s:param>password</s:param>
                    </s:fielderror>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="center">
                    <s:submit value="ログイン" type="image" method="login" src="%{baseDir}/images/common/header/btn_login.gif" />
				 </td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>
</div>

<div class="center">
 <img src="${pageContext.request.contextPath}/images/item/焼き肉.jpg" alt="ハガキ" width="220" height="200" border="0"/>
</div>

<br />
<br />

<div class="right">
 <a href="#">
    <img src="${pageContext.request.contextPath}/images/common/header/login_subnavi01.gif" alt="プライバシーポリシー" width="140" height="28" border="0"/>
 </a>
 <a href="#">
    <img src="${pageContext.request.contextPath}/images/common/header/login_subnavi02.gif" alt="推奨環境" width="140" height="28" border="0"/>
 </a>
</div>


</body>
</html>
