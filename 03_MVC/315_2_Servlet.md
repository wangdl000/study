## 一、Servlet简介  
　　Servlet是sun公司提供的一门用于开发动态web资源的技术。  
　　Sun公司在其API中提供了一个servlet接口，用户若想用发一个动态web资源(即开发一个Java程序向浏览器输出数据)，需要完成以下2个步骤：  
　　1、编写一个Java类，实现servlet接口。  
　　2、把开发好的Java类部署到web服务器中。  
　　按照一种约定俗成的称呼习惯，通常我们也把实现了servlet接口的java程序，称之为Servlet。  

## 二、Servlet的运行过程  
Servlet程序是由WEB服务器调用，web服务器收到客户端的Servlet访问请求后：   
　　①Web服务器首先检查是否已经装载并创建了该Servlet的实例对象。如果是，则直接执行第④步，否则，执行第②步。  
　　②装载并创建该Servlet的一个实例对象。   
　　③调用Servlet实例对象的init()方法。  
　　④创建一个用于封装HTTP请求消息的HttpServletRequest对象和一个代表HTTP响应消息的HttpServletResponse对象，然后调用Servlet的service()方法并将请求和响应对象作为参数传递进去。  
　　⑤WEB应用程序被停止或重新启动之前，Servlet引擎将卸载Servlet，并在卸载之前调用Servlet的destroy()方法。   


### 三、Servlet调用图  

### 四、在Eclipse中开发Servlet  
　　在eclipse中新建一个web project工程，eclipse会自动创建下图所示目录结构：    


#### 4.1、Servlet接口实现类  

　　Servlet接口SUN公司定义了两个默认实现类，分别为：GenericServlet、HttpServlet。  

　　HttpServlet指能够处理HTTP请求的servlet，它在原有Servlet接口上添加了一些与HTTP协议处理方法，它比Servlet接口的功能更为强大。因此开发人员在编写Servlet时，通常应继承这个类，而避免直接去实现Servlet接口。  
　　HttpServlet在实现Servlet接口时，覆写了service方法，该方法体内的代码会自动判断用户的请求方式，如为GET请求，则调用HttpServlet的doGet方法，如为Post请求，则调用doPost方法。因此，开发人员在编写Servlet时，通常只需要覆写doGet或doPost方法，而不要去覆写service方法。  

#### 4.2、通过Eclipse创建和编写Servlet    

　　选中gacl.servlet.study包，右键→New→Servlet，如下图所示：  


这样，我们就通过Eclipse帮我们创建好一个名字为ServletDemo1的Servlet，创建好的ServletDemo01里面会有如下代码：  

package gacl.servlet.study;
 2 
 3 import java.io.IOException;
 4 import java.io.PrintWriter;
 5 
 6 import javax.servlet.ServletException;
 7 import javax.servlet.http.HttpServlet;
 8 import javax.servlet.http.HttpServletRequest;
 9 import javax.servlet.http.HttpServletResponse;
10 
11 public class ServletDemo1 extends HttpServlet {
12 
13     /**
14      * The doGet method of the servlet. <br>
15      *
16      * This method is called when a form has its tag value method equals to get.
17      * 
18      * @param request the request send by the client to the server
19      * @param response the response send by the server to the client
20      * @throws ServletException if an error occurred
21      * @throws IOException if an error occurred
22      */
23     public void doGet(HttpServletRequest request, HttpServletResponse response)
24             throws ServletException, IOException {
25 
26         response.setContentType("text/html");
27         PrintWriter out = response.getWriter();
28         out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
29         out.println("<HTML>");
30         out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
31         out.println("  <BODY>");
32         out.print("    This is ");
33         out.print(this.getClass());
34         out.println(", using the GET method");
35         out.println("  </BODY>");
36         out.println("</HTML>");
37         out.flush();
38         out.close();
39     }
40 
41     /**
42      * The doPost method of the servlet. <br>
43      *
44      * This method is called when a form has its tag value method equals to post.
45      * 
46      * @param request the request send by the client to the server
47      * @param response the response send by the server to the client
48      * @throws ServletException if an error occurred
49      * @throws IOException if an error occurred
50      */
51     public void doPost(HttpServletRequest request, HttpServletResponse response)
52             throws ServletException, IOException {
53 
54         response.setContentType("text/html");
55         PrintWriter out = response.getWriter();
56         out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
57         out.println("<HTML>");
58         out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
59         out.println("  <BODY>");
60         out.print("    This is ");
61         out.print(this.getClass());
62         out.println(", using the POST method");
63         out.println("  </BODY>");
64         out.println("</HTML>");
65         out.flush();
66         out.close();
67     }
68 
69 }

这些代码都是Eclipse自动生成的，而web.xml文件中也多了<servlet></servlet>和<servlet-mapping></servlet-mapping>两对标签，这两对标签是配置ServletDemo1的，如下图所示：  






资料来源：  
https://www.cnblogs.com/xdp-gacl/p/3760336.html

