<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Login with Spring Security 5 !!</title>
  <meta charset="utf-8"/>
  <link rel="stylesheet" href="css/bootstrap.min.css"
        integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body onload="document.loginForm.username.focus();" style="background-color: cornsilk;">
<div class="container">

  <h1>Login Page with Spring Security 5 !!</h1>

  <h3>Login with Username and Password</h3>

  <!-- 認証エラー時のメッセージを表示するエリア -->
  <div class="alert alert-danger alert-dismissible fade show" role="alert"
       th:if="${param.error} and ${session['SPRING_SECURITY_LAST_EXCEPTION'] != null}">
    <span th:text="${session['SPRING_SECURITY_LAST_EXCEPTION'].message}">Bad Credential!</span>
  </div>

  <!-- 認証フォームを表示するエリア -->
  <form name="loginForm" th:action="@{/login}" method="post">
    <div class="form-group">
      <label for="username">User ID</label>
      <input type="username" class="form-control" id="username" name="username">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
  </form>

  <hr>

  <h3>Login with OAuth 2.0/OIDC 1.0</h3>
  <!-- OAuth 2.0 Login用のリンクを表示するエリア -->
  <table>
    <tr th:each="clientRegistration : ${@clientRegistrationRepository}">
      <td><a class="btn btn-primary btn-lg btn-block"
             th:href="@{/oauth2/authorization/{id}(id=${clientRegistration.registrationId})}"
             th:text="|Sign in with ${clientRegistration.clientName}|">Sign in with GitHub</a></td>
    </tr>
  </table>

</div>
</body>
</html>