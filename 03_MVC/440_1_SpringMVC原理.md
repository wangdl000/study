## Spring MVC  

## 什么是MVC  

  - MVC是Java Web开发的一种模式。  
  - WEB，在英语中web即表示网页的意思，它用于表示Internet主机上供外界访问的资源。
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



## SpringMVC原理  

### 术语  
  - DispatcherServlet——前端控制器。  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_mvc1.png)   
    - 为什么叫做前端控制器？举个例子：  
    如下图，前端控制器很类似医院的分诊台。
    ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/00_springmvc2.png)   

  - Controller  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part2.png)   
  - HandlerAdapter  
    Spring MVC没有控制器接口，是通过注解的方式表示某个类是控制器，所以需要适配为控制器。  
    ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part3.png)   
  - HandlerInterceptor  
  HandlerAdapter是Spring MVC内部使用的，Spring MVC会把控制器和HandlerInterceptor包装为HandlerAdapter。  
  - HandlerMapping  
  DispatcherServlet会通过HandlerMapping把控制器和HandlerInterceptor包装为HandlerExecutionChain。  
    ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part3.png)   
  - HandlerExecutionChain  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part4.png)   
  - ModelAndView  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part5.png)   
    Spring MVC会把Model和Map封装为ModelAndView:  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc_part6.png)   

### Spring MVC——总体架构图  
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc1.png)   
  ![440](https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_springmvc1.png)   


### Spring工作流程描述  
  ![440]( https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_flow1.png)  

  ![440]( https://github.com/wangdl000/study/blob/master/03_MVC/resource_springmvc/01_flow2.png)  

  - 1. 用户向服务器发送请求，请求被Spring 前端控制Servelt DispatcherServlet捕获。  
  - 2. DispatcherServlet对请求URL进行解析，得到请求资源标识符（URI）。  
然后根据该URI，调用HandlerMapping获得该Handler配置的所有相关的对象（包括Handler对象以及Handler对象对应的拦截器）。  
最后以HandlerExecutionChain对象的形式返回。    
  - 3. DispatcherServlet 根据获得的Handler，选择一个合适的HandlerAdapter。（附注：如果成功获得HandlerAdapter后，此时将开始执行拦截器的preHandler(...)方法）  
  - 4.  提取Request中的模型数据，填充Handler入参，开始执行Handler（Controller)。 在填充Handler的入参过程中，根据你的配置，Spring将帮你做一些额外的工作：  
      HttpMessageConveter： 将请求消息（如Json、xml等数据）转换成一个对象，将对象转换为指定的响应信息
      数据转换：对请求消息进行数据转换。如String转换成Integer、Double等
   数据根式化：对请求消息进行数据格式化。 如将字符串转换成格式化数字或格式化日期等。  
      数据验证： 验证数据的有效性（长度、格式等），验证结果存储到BindingResult或Error中。  
  - 5.  Handler执行完成后，向DispatcherServlet 返回一个ModelAndView对象。  
  - 6.  根据返回的ModelAndView，选择一个适合的ViewResolver（必须是已经注册到Spring容器中的ViewResolver)返回给DispatcherServlet。  
  - 7. ViewResolver 结合Model和View，来渲染视图。  
  - 8. 将渲染结果返回给客户端。  

资料来源：  

【JavaWeb基础知识总结】  
https://www.cnblogs.com/du-0210/p/8426624.html

http://www.cnblogs.com/wangxuerui/p/5796348.html

https://www.cnblogs.com/zzt-lovelinlin/p/7060461.html

https://www.jianshu.com/p/3c37b6709a64
