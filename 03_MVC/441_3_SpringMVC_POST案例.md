## SpringMVC POST请求案例  

### 1、准备一个登录界面 login.jsp  
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <base href="<%=basepath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    </head>
    <body>
	    <h2>login.jsp登录界面</h2>
	    <form action="uc/islogin" method="post">
		用户名：<input type="text" name="loginName"><br /> 
		密码：<input type="text" name="loginPwd"><br /> 
		<input type="submit" value="登录" />
    	</form>
    </body>
    </html>

### 2、在控制器中准备一个方法来处理该请求  
    @Controller
    @RequestMapping("uc")
    public class UserController {
	     @RequestMapping(value = "islogin", method = RequestMethod.POST)
	     public String isLogin(Users user) {
		    System.out.println("loginName=" + user.getLoginName() + ",loginPwd="
		+ user.getLoginPwd());
	   	return "suc";
	     }	
    }

### method属性指定请求的方式，常用到的method属性的值有两个：  
  - method=RequestMethod.GET  
  - method=RequestMethod.POST。

在开发中页面传递到后台的数据可能会很多，所以我们可以把多个参数封装为一个对象来传递。但要注意的是页面中的name必须和实体类的属性名一致。  

该案例的实体类为Users:    

    public class Users implements Serializable {
	    private Integer userId;
	    private String loginName;
	    private String loginPwd;
	    private String realName;


	    public Integer getUserId() {
	    	return userId;
	    }


	    public void setUserId(Integer userId) {
		    this.userId = userId;
	    }


	    public String getLoginName() {
		    return loginName;
	    }


	    public void setLoginName(String loginName) {
		    this.loginName = loginName;
	   }


	    public String getLoginPwd() {
		    return loginPwd;
	    }


	    public void setLoginPwd(String loginPwd) {
		    this.loginPwd = loginPwd;
	    }

	    public String getRealName() {
		    return realName;
	    }


	    public void setRealName(String realName) {
		    this.realName = realName;
	    }
    }


