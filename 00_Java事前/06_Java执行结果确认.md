##java 运行 

> 1.System.out.println();  
  https://jingyan.baidu.com/article/d621e8da10150f2865913fb7.html    


> 2. Junit运行  
  如下内容  

> 3. log4j
    
   Java log4j 1.2でテキストにログを出力するサンプル（設定ファイルがxml)   
  https://itsakura.com/java_log4jxml   
 
## 内容  
### 1．JUnit使用  

  - ①测试方法上必须使用@Test进行修饰  
  - ②测试方法必须使用public void 进行修饰，不能带任何的参数  
  - ③新建一个源代码目录来存放我们的测试代码，即将测试代码和项目业务代码分开  
  - ④测试类所在的包名应该和被测试类所在的包名保持一致  
  - ⑤测试单元中的每个方法必须可以独立测试，测试方法间不能有任何的依赖  
  - ⑥测试类使用Test作为类名的后缀（不是必须）  
  - ⑦测试方法使用test作为方法名的前缀（不是必须）  

#### 1.1 测试代码和项目代码分开  
结构应如下：包名要一致；最好以Test作为测试类后缀；最好以test作为测试方法前缀。  
  ![jdk download](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_junit/1_1.png)   
#### 1.2 独立测试类的方法  
项目结构图中，展开测试类的所以方法，右键其中一个方法，Run As，JUnit Test：  
  ![jdk download](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_junit/1_2.png)   

### 2.测试失败的两种情况
  - 注意：测试用例是用来达到测试想要的预期结果，而不能测试出程序的逻辑错误。
  - 比如：你需要写一个计算长方形面积的方法，而你错误地认为周长的公式就是计算面积的。所以在测试方法中，就算结果达到了你的预期，但这显然不是正确的计算面积方法。
#### 2.1 新建测试类
        如下：

    package jtzen9.util;  
 
    import org.junit.Assert;  
    import org.junit.Test;  
 
    public class ErrorAndFailureTest {  

	    @Test  
	    public void testAdd() {  
	    	int result = new Calculate().add(3,3);  
	    	Assert.assertEquals("加法有问题", 5, result); //预期值与程序输出不一样  
	    }
        
	    @Test  
	    public void testDivide() {  
	    	int result = new Calculate().divide(6,0);  //除法中，除数为0  
	    	Assert.assertEquals("除法有问题", 3, result);  
	    }  
    }  

#### 2.2 运行结果
  - ①testAdd()方法是failure错误

  ![jdk download](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_junit/2_2.png)  

###2.3 说明
  - ①Failure一般由单元测试使用的断言方法判断失败所引起的，这经表示测试点发现了问题，就是说程序输出的结果和我们预期的不一样。
  - ②Error是由代码异常引起的，它可以产生于测试代码本身的错误，也可以是被测试代码中的一个隐藏的bug。