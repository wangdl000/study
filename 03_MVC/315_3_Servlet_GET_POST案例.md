## JSP（FORM）-〉Servlet POST案例  


### 一、先创建web project
在菜单栏选File->New->Web->Dynamic Web Project  

Project name我命名为BJavaWebPostTest01 （可以随便起）  

Target runTime 选我们之前tomcat配置的版本。  

一直NEXT到Finish  

 

### 二.新建jsp页面  
#### 1、在WebContent下新建一个jsp页面（如果列表里没有jsp选项，到other里去找）  

这里我给jsp页面的名字命为welcome，点击Finish，然后再body中修改如下内容：  

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

 

#### 2、创建login.jsp文件，只需修改body中的内容，如下所示：  

    <body>
       <form action="login">
       username:<input type="text" name="username"><br>
       password:<input type="password" name="pwd"><br>
       <input type="submit">
       </form>
    </body>

 

#### 3、在scr目录下的com.ht.servlet编写AcountBean.java文件，代码如下：

    package com.ht.servlet;
    
    public class AccountBean {
     private String username = "";
     private String password = "";
     public String getPassword() {
      return password;
     }
     public void setPassword(String password) {
      this.password = password;
     }
     public String getUsername() {
      return username;
     }
     public void setUsername(String username) {
      this.username = username;
     }
    }

 

#### 4、在scr目录下的com.ht.servlet编写servlet类CheckAccount.java文件，代码如下：  

    package com.ht.servlet;
    
    import java.io.IOException;
    
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    
    public class CheckAccount extends HttpServlet {
    
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp)
       throws ServletException, IOException {
      doGet(req,resp);
     }
    
     @Override
     public void doGet(HttpServletRequest req, HttpServletResponse resp)
       throws ServletException, IOException {
      HttpSession session = req.getSession();
      AccountBean account = new AccountBean();
      String username = req.getParameter("username");
      String pwd = req.getParameter("pwd");
      account.setPassword(pwd);
      account.setUsername(username);
      if((username != null)&&(username.trim().equals("jsp"))) {
       if((pwd != null)&&(pwd.trim().equals("1"))) {
        System.out.println("success");
        session.setAttribute("account", account);
        String login_suc = "success.jsp";
        resp.sendRedirect(login_suc);
        return;
       }
      }
      String login_fail = "fail.jsp";
      resp.sendRedirect(login_fail);
      return;
     }
     
    }

#### 5、在WebRoot目录下编写success.jsp文件 成功后跳转  

    <body>
       <%
       AccountBean account = (AccountBean)session.getAttribute("account");
       %>
       username:<%= account.getUsername()%>
        <br>
        password:<%= account.getPassword() %>
    </body>

#### 6、在WebRoot目录下编写fail.jsp文件 失败后跳转  

    <body>
       Login Failed! <br>
    </body>

 

  - 说明：在success.jsp文件中用到了AccountBean中的getUsername()方法，所以需要在页面头上添加包名的命名空间，如下  
      <%@ page language="java" import="com.ht.servlet.*"%> ，然后才能在页面上使用username:<%= account.getUsername()%>这种方式访问。

 

#### 7、修改web.xml配置文件  

    <?xml version="1.0" encoding="UTF-8"?>
    <web-app version="2.5"
     xmlns="http://java.sun.com/xml/ns/javaee"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
     http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
      <welcome-file-list>
        <welcome-file>login.jsp</welcome-file>
      </welcome-file-list>
     
      <servlet>
           <description>This is the description of my J2EE component</description>
           <display-name>This is the display name of my J2EE component</display-name>
             <servlet-name>CheckAccount</servlet-name>
           <servlet-class>com.ht.servlet.CheckAccount</servlet-class>
         </servlet>
    
         <servlet-mapping>
           <servlet-name>CheckAccount</servlet-name>
           <url-pattern>/login</url-pattern>
         </servlet-mapping>
    
    </web-app>

 

### 三.部署到server

  添加一个服务器，运行我们的工程。  

  - 点击 窗口->显示视图->servers 则打开服务器窗口，点击右键，新建->server，一步一步的跟着向导创建好服务器，这里我们用的是前面我们已经配置好的tomcat，如果不会的请看我前面的文章，或者自己去百度吧。  

  - 服务器创建完成后，在服务器上右键，选择“Add and Remove...”菜单，把我们刚刚的项目添加到配置中，一直到finish。  

  - 然后右键我们新建的server，在菜单中选择publish发布我们的工程到服务器，发布完成之后，启动我们的服务器。

  - 打开浏览器运行http://localhost:8080/BJavaWebPostTest01 启动起来看到如下界面 就是我们刚才创建的jsp页面。  

  一个简单的web工程就起来了哦，是不是很简单很有趣。


说明：

  - 在浏览器中后面输入的站点名称必须和项目名称相同，包括大小写也要一样如：JavaWebTest01，否则会提示找不到页面。




【一个简单的jsp+servlet实例，实现简单的登录 - jack_Meng - 博客园】
http://www.cnblogs.com/mq0036/p/6349515.html