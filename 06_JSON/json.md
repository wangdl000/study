## 1、JSON  

### 1.1、JSON介绍
#### 1.1.1、JSON定义
JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式。  
json是个非常重要的**数据结构**，在web开发中应用十分广泛。 

 【官方介绍】  
 http://www.json.org/json-zh.html

#### 1.1.2、JSON的数据格式
实例：  

    {
        "name":"tester",
        "age":16,
        "msg":["a","b"],
        "regex": "^http://.*"
    };

JSON 值可以是：数字（整数或浮点数）、字符串（在双引号中）、逻辑值（true 或 false）、数组（在方括号中）、对象（在花括号中）、null。  

### 1.2、在客户端（Javascript）使用JSON
#### 1.2.1 JSON.parse
JSON.parse是将json格式的字符串转换成json对象。  
 
实例：  

    var str ='{"name":"tester","age":16,"msg":["a","b"],"regex": "^http://.*"}';
    var json = JSON.parse(str);
    console.log("name:" + json.name);
    console.log("msgLen:" + json.msg.length);

    // 运行结果  
    // name: tester  
    // msgLen:2

  - 备注：单引号写在{}外，每个属性名都必须用双引号。  

#### 1.2.2、JSON.stringify
JSON.stringify是将json对象转换成json格式的字符串。  

    var json = {"name":"tester","age":16,"msg":["a","b"],"regex": "^http://.*"};
    var str = JSON.stringify(json);
    console.log("str:" + str);
    console.log("strLen:" + str.length);

    // 结果
    // str:{"name":"tester","age":16,"msg":["a","b"],"regex":"^http://.*"}
    // strLen:60

### 1.3、JSON在JAVA中使用 

在使用json之前首先要明白需要哪些jar文件,初次使用的时候很容易犯错，如果没有加入正确的jar包，会报各种各样的问题。  

  - 在使用json之前需要准备下面的六个jar 包：  
    - commons-lang-1.0.4.jar  
    - commons-collections-2.1.jar  
    - commons-beanutils-1.8.0.jar  
    - json-lib-2.4.jar  
    - ezmorph-1.0.6.jar  
    - commons-logging-1.1.jar  

### 1.3、JSON所需JAR包下载:  

  - JSON所需JAR包  
  需要说明几点：
    - （1）json-lib最新版本可以从这个地方下载：  
 http://sourceforge.net/projects/json-lib/files/json-lib/  
    - （2）ezmorph是一个简单的java类库，用于将一种bean转换成另外一种bean。其动态bean的实现依赖于commons-
beanutils包。ezmorph可以在这个地方下载源码：  
 http://sourceforge.net/projects/ezmorph/files/ezmorph/  
    - （3）commons-beanutils是操作Java Bean的类库，依赖于commons-collections。  
    - （4）commons-collections类库是各种集合类和集合工具类的封装。  
https://www.bbsmax.com/A/GBJr7m9R50/  

### 1.4、 
JSON.parse是将json格式的字符串转换成json对象。  

## 2、SpringMVC的JSON数据交互



### 2.1 ResponseRequestBody用法  


【SpringMVC的JSON数据交互-ResponseRequestBody用法】  
https://mz.mbd.baidu.com/74im6lu?f=cp