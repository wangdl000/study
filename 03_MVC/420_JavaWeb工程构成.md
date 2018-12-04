## Java项目目录结构

> 1、一般web项目 
> 2、maven web项目目录结构  
### 1、一般web项目目录结构 
![420](https://github.com/wangdl000/study/blob/master/03_MVC/resource_javaweb/01_nomal.png)     
  - 1、红色箭头src目录  
  src下一般存放包和写的类文件


2、橙色箭头 webRoot文件夹  
是存放web信息的目录，CSS、JS、图片（images、pictures）都存放在这里  

 

3、黄色箭头 META-INF文件夹以及MANIFEST.MF文件  

相当于一个信息包，目录中的文件和目录获得java平台的认可与解释，用来配置应用程序、扩展程序、类加载器和服务。

manifest.mf文件，在用jar打包时自动生成。

 

4、WEB-INF  
WEB-INF是用来存储服务端配置文件信息和在服务端运行的类文件的，它下面的东西不允许客户端直接访问的
包括的一些文件  

/WEB-INF/web.xml  
Web应用程序配置文件，描述了 servlet 和其他的应用组件配置及命名规则。

 /WEB-INF/lib/

存放web应用需要的各种JAR文件，放置仅在这个应用中要求使用的jar文件,如数据库驱动jar文件。

 /WEB-INF/classes/

包含了站点所有用的 class 文件，包括 servlet class 和非servlet class，他们不能包含在 .jar文件中。

 /WEB-INF/src/

 源码目录，按照包名结构放置各个Java文件。

 /WEB-INF/database.properties

 数据库配置文件

 /WEB-INF/tags/

存放了自定义标签文件，该目录并不一定为 tags，可以根据自己的喜好和习惯为自己的标签文件库命名，当使用自定义的标签文件库名称时，在使用标签文件时就必须声明正确的标签文件库路径。例如：当自定义标签文件库名称为 simpleTags 时，在使用 simpleTags 目录下的标签文件时，就必须在 jsp 文件头声明为：<%@ taglibprefix="tags" tagdir="/WEB-INF /simpleTags" % >。

/WEB-INF/jsp/

jsp 1.2 以下版本的文件存放位置。改目录没有特定的声明，同样，可以根据自己的喜好与习惯来命名。此目录主要存放的是 jsp 1.2 以下版本的文件，为区分 jsp 2.0 文件，通常使用 jsp 命名，当然你也可以命名为 jspOldEdition 。

/WEB-INF/jsp2/

与 jsp 文件目录相比，该目录下主要存放 Jsp 2.0 以下版本的文件，当然，它也是可以任意命名的，同样为区别 Jsp 1.2以下版本的文件目录，通常才命名为 jsp2。


### 2、maven web项目目录结构  
![420](https://github.com/wangdl000/study/blob/master/03_MVC/resource_javaweb/02_maven.png)   
红箭头的四个根目录下的文件

1、在顶级目录上是工程的描述文件pom.xml ：

用来配置maven jar包信息。

2、第一个红色箭头的src

Src目录包含所有工程的源码文件，配置文件，资源文件等等。

它下面的子目录一般包含main（主要的工程源文件），test（测试文件），site（项目站点文件）

src/main/resources，

负责管理项目主体的资源。在使用Maven2执行compile之后，这个目录中的所有文件及子目录，会复制到target/classes目录中，为以后的打包提供了方便。

src/test/resources，

负责管理项目测试的资源。在使用Maven2执行test-compile之后，这个目录中的所有文件及子目录，会复制到target/test-classes目录中，为后续的测试做好了准备。

3、第二个红色箭头的src

webapp存放的内容和普通web文件webRoot 内容相似

4、target

target是有存放项目构建后的文件和目录，jar包、war包、编译的class文件等。

target里的所有内容都是maven构建的时候生成的

（jar 包就是 java archive file java 的一种文档格式。jar 文件非常类似 zip）

（WAR是Sun提出的一种Web应用程序格式，与JAR类似，也是许多文件的一个压缩包。这个包中的文件按一定目录结构来组织：通常其根目录下包含有Html和Jsp文件或者包含这两种文件的目录，另外还会有一个WEB-INF目录，这个目录很重要。通常在WEB-INF目录下有一个web.xml文件和一个classes目录，web.xml是这个应用的配置文件，而classes目录下则包含编译好的Servlet类和Jsp或Servlet所依赖的其它类（如JavaBean）。通常这些所依赖的类也可以打包成JAR放到WEB-INF下的lib目录下，当然也可以放到系统的CLASSPATH中，但那样移植和管理起来不方便.）

### 总体概况的目录结构：  
![420](https://github.com/wangdl000/study/blob/master/03_MVC/resource_javaweb/03_list.png)  

    src
    
      -main
    
          –bin 脚本库
    
          –java java源代码文件
    
          –resources 资源库，会自动复制到classes目录里
    
          –filters 资源过滤文件
    
          –assembly 组件的描述配置（如何打包）
    
          –config 配置文件
    
          –webapp web应用的目录。WEB-INF、css、js等
    
      -test
    
          –java 单元测试java源代码文件
    
          –resources 测试需要用的资源库
    
          –filters 测试资源过滤库
    
      -site Site（一些文档）
    
    target
    
    LICENSE.txt Project’s license
    
    README.txt Project’s readme

    target是有存放项目构建后的文件和目录，jar包、war包、编译的class文件等。
    
    target里的所有内容都是maven构建的时候生成的



资料来源  
https://my.oschina.net/zjllovecode/blog/916567