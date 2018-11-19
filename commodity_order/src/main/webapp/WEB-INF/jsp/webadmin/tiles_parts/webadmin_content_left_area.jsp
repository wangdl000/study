<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="package" var="packageInfo" />
<fmt:message bundle="${packageInfo}" var="label_button_top" key="web.admin.menu.button.top" /><!-- トップ -->
<fmt:message bundle="${packageInfo}" var="label_button_item" key="web.admin.menu.button.item" /><!-- 商品管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_code" key="web.admin.menu.button.code" /><!-- マスター管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_comment" key="web.admin.menu.button.comment" /><!-- お知らせ管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_catalog" key="web.admin.menu.button.catalog" /><!-- カタログ管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_user" key="web.admin.menu.button.user" /><!-- ユーザ管理 -->
<fmt:message bundle="${packageInfo}" var="label_button_itemImport" key="web.admin.menu.button.itemImport" /><!-- 商品情報一括取り込み -->

<form id="left">
<!-- <s:token /> -->
    <ul>
        <li class="list1">
           <input type="button" value="${label_button_top}" type= "button" class="button" style="width:150px;height:30px" onClick="btnClick('top')" />
        </li>
        <li class="list1">
           <input type="button" value="${label_button_item}"  type= "button" class="button" style="width:150px;height:30px" onClick="btnClick('item')" />
        </li>
        <li class="list1">
           <input type="button" value="${label_button_code}"  type= "button" class="button" style="width:150px;height:30px" onClick="btnClick('code')" />
        </li>
        <li class="list1">
           <input type="button" value="${label_button_comment}"  type= "button" class="button" style="width:150px;height:30px" onClick="btnClick('coment')"/>
        </li>
        <li class="list1">
           <input type="button" value="${label_button_catalog}"  type= "button" class="button" style="width:150px;height:30px" onClick="btnClick('catalog')"/>
        </li>
        <li class="list1">
           <input type="button" value="${label_button_user}"  type="button" class="button" style="width:150px;height:30px" onClick="btnClick('uploaduser')" />
        </li>
    </ul>
    <br>
    <ul>
        <li class="list1">
            <input type="button" value="${label_button_itemImport}" type="button" class="button" style="width:150px;height:30px" onClick="btnClick('toItemImport')" />
        </li>
    </ul>
</form>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/customer_sample/js/jquery.min.js"></script>
<script type="text/javascript">


	function btnClick(actionId) {
		alert("Helle: " + actionId);
		switch (actionId) {
		case "top":
			toTop(top);
			break;

		default:
			break;
		}
	}
	function toTop(id) {

		var data = {
			//userAccount : """,
			//userPasswd : ""
		};
		$.ajax({
			url : "${pageContext.request.contextPath}/top/init.action",
			type : "GET",
			dataType : 'text',
			data : "",
			contentType : 'application/json;charset=UTF-8',
			success : function(result) {
				alert("jquery ajax:::::::::" + result);
				console.log(result);
			}
		});

	}
</script>

