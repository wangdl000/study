## Java5到Java10的新增特性功能
![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/00_logo.jpg)  
> #### *Java5*
> #### *Java6*
> #### *Java7*
> #### *Java8*
> #### *Java9*
> #### *Java10*

## 详细内容

### 1. Java5  

  - 泛型（Generics）：  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_05_generics.jpg)  
  - 枚举(Typesafe Enums)：  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_05_enum.jpg)   
  - 可变参数 (Varargs)：注意！其本质是一个数组，如果一个方法中包含了可变参数，那么必须放在最后的位置。  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_05_Varargs.jpg)   
  - 新的线程模型和并发库（java.util.concurrent)  
  - 注解（Annotations）  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_05_Annotations.jpg)   
  -  静态导入（Static Import）  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_05_StaticImport.jpg)  
  - 自动封箱拆箱(Autoboxing/Unboxing)  
  - 增强循环（Enhanced for Loop）  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_05_Loop.jpg)  

### 2. Java6  

集合框架在Java6中得到了增强，更有利于人们的开发。比如，新增了很多的接口和类，还有添加了新的数组拷贝方法，比如Arrays.copyOf和Arrays.copeOfRange。  

Scripting，他可以让其他的语言在Java的平台上编译运行，因为Java6中已经包含了一个机遇MozillaRhino的一个实现JS的脚本引擎。  

JDBC4.0版本的规范从Java6之后开始支持了。  

### 3. Java7  

  - 泛型实例化类型的自动推断：  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_07_tuiduan.jpg)  

  - 字面常量数字的下划线。用下划线连接整数，其本身没有什么含意，主要是可以提高代码中的可读性，但是不能用在数字的首末。  

  - 二进制前缀0b或者0B。比如Byte、int、long等整形的数据类型在Java7中已经可以用可以用二进制来表示了。  
   ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_07_byte.jpg)  
 

  - switch在Java7版本之后就支持String类型。  
  - 新增try-with-resources语句：  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_07_try_with_resources.jpg)  

 单个catch中，可以捕获多个异常类型，而且根据改进的类型，检查后会重新抛出异常。  

### 4. Java8  

 Java8中，新增了很多的特效功能，主要有：lambada表达式、重复注解、方法引用、默认方法、类型注解、方法参数反射、类型推断增强、Stream API 、HashMap改进、Date Time API、还有java.util 包下的改进，比如新增了并行数组排序、无符号运算、Base的64编解码。HotSpot中还删除了永久代等等。新增的这些功能让得Java8到现在还有很多公司的开发者在使用！  

### 5. Java9  

  - 在Java9版本中，新增了JVM的机制，而且还统一了JVM中的日志，所有组件都引导同一个日志管理系统中。  
  - diamond语法与匿名内部类结合使用  
  - java模块系统 （Java Platform Module System）。  
  - 新的版本号格式。$MAJOR.$MINOR.$SECURITY.$PATCH  
  - Javadoc中，简化了Doclet API。加入了搜索框，支持新的模块系统和生成H5的格式。  
  - properties文件支持UTF-8编码，在此前的Java版本中，只支持ISO-8859-1。  
  - 支持私有接口方法  
  
### 6. Java10  

  - 局部变量类型推断：  
  ![](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_java/01_06_param.jpg)  

使用var保留类型来声明变量。注意：var不属于关键字，它的使用场景必须为：本地变量可以被初始化、有了增强的for循环、传统for循环中声明的索引变量、Try-with-resources 变量。 

### 总结  
  当然，新增的一些特性远远不止这些。上述内容的具体用法，将在基本数据类型中详细描述。