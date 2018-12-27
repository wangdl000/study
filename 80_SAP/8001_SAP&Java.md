## 浅谈SAP和Java
 2018.12.27
### 前言
  下定决心好好学习SAP。   
  因为一直做JAVA开发，所以从JAVA角度理解SAP。  
  首先，查了谢资料先了解一下SAP和Java的关系。或许今后的目标就是用JavaAPI做SAP周边开发了吧。  
  SAP系统大部分功能都是用ABAP语言实现的。  
  SAP实施顾问大体上分模块的function顾问和ABAP顾问。  
  做模块的function顾问主要是行业经验较丰富，能够充分理解客户的需求，而且熟悉SAP系统的配置。  
  而SAP系统就是通过配置文件来实现大部分需求功能的，这样可以减少Bug，加快实施速度。  

  - ABAP顾问的职责则是  
    - **实现客户某些特定的需求**  
    - **那些无法通过配置而能够完成的功能**   
    - 还有很重要的工作就是 **使用ABAP语言来打印报表**，而ABAP语言其一个很强大的特性就是来打印报表。  
    
  程序员转行到SAP,可能刚开始最容易也是最可能接触的就是ABAP（Advanced Bussiness Application Programming）。  

#### 为什么SAP需要JAVA  
  比如某公司实施了SAP系统,那么每天都会长时间使用SAP系统工作的员工必须使用SAP提供的SAP客户登陆端来登陆服务器.这个客户端上百M,装在员工电脑上,没有问题.但是很多其它的情况SAP客户登陆端就不能解决问题了,比如,此公司的某合作伙伴公司的人过来,需要临时使用这个SAP系统的几个功能,而且就使用这一次,那么他还要专门去装个百兆大的SAP客户端?又比如,现在SAP也提供了CRM的解决方案.CRM(Customer Relationship Management)是公司提高服务质量,加强客户满意度的电子商务手段,其中有时候也包括大家熟悉的网上购物服务,这个时候,ABAP在这个领域就不大擅长了。  

  SAP提供了BAPI(Business Application Programming Interface)。  
  BAPI是SAP系统对外提供的一系列接口,主要是使第三方程序通过这些接口来使用SAP,从而方便客户定制某些程序。  
  VB,Java,C,C++等都可以通过BAPI来访问SAP。  
  BAPI是通过R/3系统上的RFC(Remote function call)功能来实现的。  
  因为BAPI的强大功能作为基础,SAP就完全可以选择Java在CRM上加强各种功能。  
  比如可以用Java快速开发一个实现特定功能的客户端；  
  又比如用struts、jsp、servlet来做一个网上购物的电子商务网站；  
  而这些Java程序都是通过BAPI和后台的SAP系统交换数据的。  

  - ABAP重要知识点  
    - Classical ABAP程序的结构  
    - 用ABAP来打印报表  
    - 程序内部使用的subroutine的结构和使用  
    - 系统公用的function module的结构和使用  
    - BAPI（用Java Connector(JCo)调用BAPI提供的接口）  

#### 推荐资料：
  - BAPI Learning Guide
  - Enterprise Java for SAP    

### 小结
  以上是今天对SAP的全部理解。  
  接下来将要尝试在Linux系统中搭建一个SAP案例。  
  最后，灌一口鸡汤，技术、能力、业务、口才各个方面的提升，才是晋升的关键。    