## Servlet运行原理    

### 一：servlet定义  
Servlet是一个Java应用程序，运行在服务器端，用来处理客户端请求并作出响应的程序。  

Servlet多线程体系结构是建立在Java多线程机制之上的，它的生命周期是由Web容器负责的。  

      
当客户端第一次请求某个Servlet时，Servlet容器将会根据web.xml配置文件实例化这个Servlet类，此时它贮存于内存中。  
当有新的客户端请求该Servlet时，一般不会再实例化该Servlet类，也就是有多个线程在使用这个实例。   
这样，当两个或多个线程同时访问同一个Servlet时，可能会发生多个线程同时访问同一资源的情况，数据可能会变得不一致。  
所以在用Servlet构建的Web应用时要注意线程安全的问题。每一个请求都是一个线程，而不是进程，  
因此，Servlet对请求的处理的性能非常高。  

对于Servlet，它被设计为多线程的  
（如果它是单线程的，你就可以想象，当1000个人同时请求一个网页时，在第一个人获得请求结果之前，其它999个人都在郁闷地等待），  
如果为每个用户的每一次请求都创建 一个新的线程对象来运行的话，系统就会在创建线程和销毁线程上耗费很大的开销，  
大大降低系统的效率。  
    。  

因此，Servlet多线程机制背后有一个线程池在支持，线程池在初始化初期就创建了一定数量的线程对象，通过提高对这些对象的利用率，避免高频率地创建对象，从而达到提高程序的效率的目的。  
（由线程来执行Servlet的service方法，servlet在Tomcat中是以单例模式存在的， Servlet的线程安全问题只有在大量的并发访问时才会显现出来，并且很难发现，因此在编写Servlet程序时要特别注意。线程安全问题主要是由实例变量造成的,因此在Servlet中应避免使用实例变量。如果应用程设计无法避免使用实例变量，那么使用同步来保护要使用的实例变量，但为保证系统的最佳性能，应该同步可用性最小的代码路径）

 Struts2的Action是原型，非单实例的；会对每一个请求,产生一个Action的实例来处理。  

 解决servlet线程安全的方案：同步对共享数据的操作 Synchronized (this){...}、避免使用实例变量  
![415_01](https://github.com/wangdl000/study/blob/master/03_MVC/resource_servlet/01_http.jpg)  
①客户端向服务器端发出请求；  

②这个过程比较重要，这时Tomcat会创建两个对象：HttpServletResponse和HttpServletRequest。并将它们的引用（注意是引用）传给刚分配的线程；  

③线程开始着手接洽servlet；   

④servlet根据传来的是GET和POST，分别调用doGet()和doPost()方法进行处理；  

⑤和⑥servlet将处理后的结果通过线程传回Tomcat，并在之后将这个线程销毁或者送还线程池；  

⑦Tomcat将处理后的结果变成一个HTTP响应发送回客户端，这样，客户端就可以接受到处理后的结果了。  

### 二：简单servlet实例   
//导入所需的包   
 

    import javax.servlet.http.*;
    
    import javax.servlet.*;
    
    import java.io.*;
    
    public class FirstServlet extends HttpServlet {
    
    //处理请求的方法
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    
    throws ServletException, java.io.IOException {
    
    //数据发送给客户端—>控制台方式输出
    
    //System.out.println(“Hello Servlet”);
    
    //数据发送给客户端—>HTML页面输出
    
    resp.setContentType(“text/html”);
    
    resp.getWriter().print(“<html>”);
    
    resp.getWriter().print(“<head>”);
    
    resp.getWriter().print(“</head>”);
    
    resp.getWriter().print(“<body>”);
    
    resp.getWriter().print(“Hello World”);
    
    resp.getWriter().print(“</body>”);
    
    resp.getWriter().print(“</html>”);
    
    }
    
    }

### 三：servlet配置到Tomcat中去

Tomcat是一个web容器，也叫web服务器。我们都知道J2EE有十三个标准，这些标准大部分都是接口，Tomcat只是实现了JSP 和 servlet 开发标准。实现了所有的开发标准，就是应用程序服务器，比如Jboss。

编译好的servlet类只能运行在tomcat容器中，客户端浏览器不可以直接访问Servlet，需要在web.xml中配置一下 

    <servlet>
    <servlet-name>FirstServlet</servlet-name>
    
    <servlet-class>FirstServlet</servlet-class>
    
    </servlet>
    
    <servlet-mapping>
    
    <servlet-name>FirstServlet</servlet-name>
    
    <url-pattern>/servlet/FirstServlet</url-pattern>
    
    </servlet-mapping>

 Tomcat启动成功后，在浏览器中输入：http://localhost:8080/abingtest/servlet/FirstServlet

### 四：servlet运行原理
当我们在浏览器中输入http://localhost:8080/abingtest/servlet/FirstServlet的时候，Tomcat是如何找到我们的servlet ，运行，并返回我们想看到的页面的呢。

1. WebApplication的标准目录结构：
WEB-INF/classes

/lib

Web.xml

也就是一个完整的web应用程序目录下，必须包含以上的目录结构。

Classes 文件夹下是项目中用到的类文件，均由JDK编译成了.class文件

Lib文件夹是我们项目中引用的jar包

Web.xml是整个web应用程序的配置文档。

了解了这些，我们再来看Tomcat的工作流程。

2. Tomcat解析URL
a) 首先来看URL中包含的信息：”协议” + “端口号” + “路径(项目名称+文件路径)”

Tomcat启动后，监听我们的8080端口，当有Url请求发过来之后，解析出项目名称 abingtest，然后到webapps目录下搜索到该项目文件夹。

b) 项目文件找到后，开始寻找类文件。

这个时候Tomcat去Web.xml文件中寻找<servlet-mapping> 配置节中包含”servlet/FirstServlet”字符串，进而找到该类文件所在的位置。 
![415_02](https://github.com/wangdl000/study/blob/master/03_MVC/resource_servlet/02_url.gif)  


3. Servelt中的doGet() 和 doPost() 方法
我们写的FirstServlet 继承了HttpServlet ，重写了HttpServlet中的doGet() 方法，HttpServlet中还有一个doPost()方法。这两个方法都是用来处理Http请求的。Servlet会根据我们提交表单的方法（method=post/get）调用service方法来自动选择（我们在下一篇文章中来详细说明一下Service方法是如何自动调用FirstServlet中的doGet()方法的）

4. Servlet如何接收数据  
    import javax.servlet.http.*;
     
    
    import javax.servlet.*;
    
    import java.io.*;
    
    public class FirstServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    
    throws ServletException, java.io.IOException {
    
    //获取表单数据
    
    String userName = request.getParameter(“userName”);
    
    }
    
    }

 Http协议会将网页中的所有内容包装成为一个request对象传递给servlet ，Servlet通过这个对象拿到表单中的所有数据，处理完成之后，通过Response对象返回给客户端浏览器。

5. Servlet的生命周期  
Servlet的生命周期是由Tomcat容器管理的  

a) 客户发出请求—>Web 服务器转发到Web容器Tomcat；

b) Tomcat主线程对转发来用户的请求做出响应创建两个对象：HttpServletRequest和HttpServletResponse；

c) 从请求中的URL中找到正确Servlet，Tomcat为其创建或者分配一个线程，同时把2创建的两个对象传递给该线程；

d) Tomcat调用Servlet的servic()方法，根据请求参数的不同调用doGet()或者doPost()方法；

e) 假设是HTTP GET请求，doGet()方法生成静态页面，并组合到响应对象里；
Servlet线程结束，Tomcat将响应对象转换为HTTP响应发回给客户，同时删除请求和响应对象。  
从该过程中，我们可以理解Servlet的生命周期：  
** Servlet类加载（对应3步）**   
** Servlet实例化（对应3步）**  
** 调用init方法（对应3步）**  
** 调用service()方法（对应4、5步）**  
** 调用destroy()方法（对应6步）**  

![415_04](https://github.com/wangdl000/study/blob/master/03_MVC/resource_servlet/04_run.gif)  

### 五：Servlet生命周期的各个阶段
![415_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_servlet/05_way.gif)  

Servlet运行在Servlet容器中，其生命周期由容器来管理。Servlet的生命周期通过javax.servlet.Servlet接口中的init()、service()和destroy()方法来表示。  
![415_06](https://github.com/wangdl000/study/blob/master/03_MVC/resource_servlet/06_life.gif) 

### Servlet的生命周期包含了下面4个阶段： 

  - （1）加载和实例化

Servlet容器负责加载和实例化Servlet。当Servlet容器启动时，或者在容器检测到需要这个Servlet来响应第一个请求时，创建Servlet实例。当Servlet容器启动后，它必须要知道所需的Servlet类在什么位置，Servlet容器可以从本地文件系统、远程文件系统或者其他的网络服务中通过类加载器加载Servlet类，成功加载后，容器创建Servlet的实例。因为容器是通过Java的反射API来创建Servlet实例，调用的是Servlet的默认构造方法（即不带参数的构造方法），所以我们在编写Servlet类的时候，不应该提供带参数的构造方法。  

  - （2）初始化

在Servlet实例化之后，容器将调用Servlet的init()方法初始化这个对象。初始化的目的是为了让Servlet对象在处理客户端请求前完成一些初始化的工作，如建立数据库的连接，获取配置信息等。对于每一个Servlet实例，init()方法只被调用一次。在初始化期间，Servlet实例可以使用容器为它准备的ServletConfig对象从Web应用程序的配置信息（在web.xml中配置）中获取初始化的参数信息。在初始化期间，如果发生错误，Servlet实例可以抛出ServletException异常或者UnavailableException异常来通知容器。ServletException异常用于指明一般的初始化失败，例如没有找到初始化参数；而UnavailableException异常用于通知容器该Servlet实例不可用。例如，数据库服务器没有启动，数据库连接无法建立，Servlet就可以抛出UnavailableException异常向容器指出它暂时或永久不可用。  

  - （3）请求处理

Servlet容器调用Servlet的service()方法对请求进行处理。要注意的是，在service()方法调用之前，init()方法必须成功执行。在service()方法中，Servlet实例通过ServletRequest对象得到客户端的相关信息和请求信息，在对请求进行处理后，调用ServletResponse对象的方法设置响应信息。在service()方法执行期间，如果发生错误，Servlet实例可以抛出ServletException异常或者UnavailableException异常。如果UnavailableException异常指示了该实例永久不可用，Servlet容器将调用实例的destroy()方法，释放该实例。此后对该实例的任何请求，都将收到容器发送的HTTP 404（请求的资源不可用）响应。如果UnavailableException异常指示了该实例暂时不可用，那么在暂时不可用的时间段内，对该实例的任何请求，都将收到容器发送的HTTP 503（服务器暂时忙，不能处理请求）响应。  

  - （4）服务终止

当容器检测到一个Servlet实例应该从服务中被移除的时候，容器就会调用实例的destroy()方法，以便让该实例可以释放它所使用的资源，保存数据到持久存储设备中。当需要释放内存或者容器关闭时，容器就会调用Servlet实例的destroy()方法。在destroy()方法调用之后，容器会释放这个Servlet实例，该实例随后会被Java的垃圾收集器所回收。如果再次需要这个Servlet处理请求，Servlet容器会创建一个新的Servlet实例。  

在整个Servlet的生命周期过程中，创建Servlet实例、调用实例的init()和destroy()方法都只进行一次，当初始化完成后，Servlet容器会将该实例保存在内存中，通过调用它的service()方法，为接收到的请求服务。下面给出Servlet整个生命周期过程的UML序列图  
![415_07](https://github.com/wangdl000/study/blob/master/03_MVC/resource_servlet/07_uml.gif) 


资料地址  
http://www.cnblogs.com/gaoxiangde/p/4339571.html

