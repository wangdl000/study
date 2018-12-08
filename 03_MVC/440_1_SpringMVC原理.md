## Spring MVC  

## 什么是MVC  

  - MVC是Java Web开发的一种模式。  


## 什么是WEB  
  了解MVC之前，先要了解什么是WEB。  
  - WEB，在英语中web即表示网页的意思，它用于表示Internet主机上供外界访问的资源。  
   【计算机网络】这里跳过： 
https://www.jianshu.com/p/a6d086a3997d
    - Internet上供外界访问的Web资源分为：
      - 静态web资源（如html 页面）：指web页面中供人们浏览的数据始终是不变。
      - 动态web资源：指web页面中供人们浏览的数据是由程序产生的，不同时间点访问web页面看到的内容各不相同。

  - 在Java中，动态web资源开发技术统称为Javaweb。  
  - JavaWeb项目有两种使用方式
    - B/S ====> 浏览器+服务器   只要有浏览器就可以。
    - C/S ====> 客户端+服务器.  必须的在客户端安装程序。（客户端需要安装Jre和对应的C/S软件）。    
    现在的JavaWeb项目(软件)基本上都是B/S的。  
  - B/S怎样通信:  
    - 必须有请求有响应。  
    - 有一次请求就应该具有一次响应，它们是成对出现的。   

### WEB服务器介绍  

  - 大型服务器：  
    - websphere(IBM), weblogic(Oracle)   
    J2EE容器 ——
支持EJB (EnterPrice Java Bean (企业级的javabean)) 、Spring 。  
    - weblogic BEA公司产品，被Oracle收购，全面支持JavaEE规范，收费软件，企业中非常主流的服务器 -------- 网络上文档非常全面。
    - WebSphere （WACs框架中常用）。文档非常少，IBM公司产品，价格昂贵，全面支持JavaEE 规范。  
    - Tomcat- apache，是开源的Servlet容器。  
    Tomcat 开源小型web服务器 ，完全免费，主要用于中小型web项目，只支持Servlet和JSP 等少量javaee规范 ，Apache公司jakarta 一个子项目。  
    - Jboss – hibernate公司开发的J2EE容器。不是开源免费。  
  - Tomcat入門  
http://www.tohoho-web.com/ex/draft/tomcat.htm
  - Tomcatのサーバ設定  
https://thinkit.co.jp/free/article/0708/2/8

### MVC原理  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc4.png)  
  - MVC就是Model-View-Controller的缩写，是一个设计模式，它强制性的使应用程序的输入、处理和输出分开。  

#### View——视图层，为用户提供UI，重点关注数据的呈现  
![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc5.png)    

#### Model——模型层  
![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc6.png)    

#### Controller——控制器  
![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc7.png)   

### MVC是一种架构模式和思考方式  
![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc81.png)   

## springMVC是什么：  

　　springMVC是一个MVC的开源框架，springMVC=struts2+spring，springMVC就相当于是Struts2加上sring的整合，但是这里有一个疑惑就是，springMVC和spring是什么样的关系呢？这个在百度百科上有一个很好的解释：意思是说，springMVC是spring的一个后续产品，其实就是spring在原有基础上，又提供了web应用的MVC模块，可以简单的把springMVC理解为是spring的一个模块（类似AOP，IOC这样的模块），网络上经常会说springMVC和spring无缝集成，其实springMVC就是spring的一个子模块，所以根本不需要同spring进行整合。  



## SpringMVC原理  


### Spring MVC——总体架构图  
 ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_springmvc102.png)  

### Spring工作流程描述  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_flow1.png)  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_flow2.png)  

1、  用户发送请求至前端控制器DispatcherServlet。

2、  DispatcherServlet收到请求调用HandlerMapping处理器映射器。

3、  处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。

4、  DispatcherServlet调用HandlerAdapter处理器适配器。

5、  HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。

6、  Controller执行完成返回ModelAndView。

7、  HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。  

8、  DispatcherServlet将ModelAndView传给ViewReslover视图解析器。

9、  ViewReslover解析后返回具体View。

10、DispatcherServlet根据View进行渲染视图（即将模型数据填充至视图中）。  

11、 DispatcherServlet响应用户。  

## 组件： 

### Controller  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part2.png)   

### 1、前端控制器DispatcherServlet（不需要工程师开发）,由框架提供  
作用：接收请求，响应结果，相当于转发器，中央处理器。有了dispatcherServlet减少了其它组件之间的耦合度。
用户请求到达前端控制器，它就相当于mvc模式中的c，dispatcherServlet是整个流程控制的中心，由它调用其它组件处理用户的请求，dispatcherServlet的存在降低了组件之间的耦合性。
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc1.png)   
 上图是前端控制器的原理图  

为什么叫做前端控制器？举个例子：  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc2.png)   
前端控制器很类似医院的分诊台。  

在前端控制器模型中各个角色的作用：  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc3.png)    

### 2、处理器映射器HandlerMapping(不需要工程师开发),由框架提供  
作用：根据请求的url查找Handler
HandlerMapping负责根据用户请求找到Handler即处理器，springmvc提供了不同的映射器实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等。

### 3、处理器适配器HandlerAdapter  
作用：按照特定规则（HandlerAdapter要求的规则）去执行Handler
通过HandlerAdapter对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理器进行执行。
![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part3.png)   

### 4、处理器Handler(需要工程师开发)  
注意：编写Handler时按照HandlerAdapter的要求去做，这样适配器才可以去正确执行Handler
Handler 是继DispatcherServlet前端控制器的后端控制器，在DispatcherServlet的控制下Handler对具体的用户请求进行处理。
由于Handler涉及到具体的用户业务请求，所以一般情况需要工程师根据业务需求开发Handler。

### 5、视图解析器View resolver(不需要工程师开发),由框架提供  
作用：进行视图解析，根据逻辑视图名解析成真正的视图（view）  
View Resolver负责将处理结果生成View视图，View Resolver首先根据逻辑视图名解析成物理视图名即具体的页面地址，再生成View视图对象，最后对View进行渲染将处理结果通过页面展示给用户。   springmvc框架提供了很多的View视图类型，包括：jstlView、freemarkerView、pdfView等。  
一般情况下需要通过页面标签或页面模版技术将模型数据通过页面展示给用户，需要由工程师根据业务需求开发具体的页面。  
ViewResolver：通过扩展视图解析器，支持更多类型的视图解析，例如：jsp、freemarker、pdf、excel等。  
Spring MVC会把Model和Map封装为ModelAndView:   
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part5.png)   
     
### 6、视图View(需要工程师开发jsp...)  
View是一个接口，实现类支持不同的View类型（jsp、freemarker、pdf...）


## 核心架构的具体流程步骤如下：  

  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/05_springmvc1.jpg)    

1、首先用户发送请求——>DispatcherServlet，前端控制器收到请求后自己不进行处理，而是委托给其他的解析器进行处理，作为统一访问点，进行全局的流程控制；  
2、DispatcherServlet——>HandlerMapping， HandlerMapping 将会把请求映射为HandlerExecutionChain 对象（包含一个Handler 处理器（页面控制器）对象、多个HandlerInterceptor 拦截器）对象，通过这种策略模式，很容易添加新的映射策略；  
3、DispatcherServlet——>HandlerAdapter，HandlerAdapter 将会把处理器包装为适配器，从而支持多种类型的处理器，即适配器设计模式的应用，从而很容易支持很多类型的处理器；  
4、HandlerAdapter——>处理器功能处理方法的调用，HandlerAdapter 将会根据适配的结果调用真正的处理器的功能处理方法，完成功能处理；并返回一个ModelAndView 对象（包含模型数据、逻辑视图名）；  
5、ModelAndView的逻辑视图名——> ViewResolver， ViewResolver 将把逻辑视图名解析为具体的View，通过这种策略模式，很容易更换其他视图技术；   
6、View——>渲染，View会根据传进来的Model模型数据进行渲染，此处的Model实际是一个Map数据结构，因此很容易支持其他视图技术；  
7、返回控制权给DispatcherServlet，由DispatcherServlet返回响应给用户，到此一个流程结束。    

下边两个组件通常情况下需要开发：   

Handler：处理器，即后端控制器用controller表示。   

View：视图，即展示给用户的界面，视图中通常需要标签语言展示模型数据。    


  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/06_springmvc2.png)    

## 最后，再理解一下SpringMVC的基本概念  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_springmvc103.png)   

### 资料来源：   

【JavaWeb基础知识总结】  
https://www.cnblogs.com/du-0210/p/8426624.html

http://www.cnblogs.com/wangxuerui/p/5796348.html

https://www.cnblogs.com/zzt-lovelinlin/p/7060461.html

https://www.jianshu.com/p/3c37b6709a64
