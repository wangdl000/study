** 参照**  
>  https://blog.csdn.net/u012393192/article/details/80808237
  
## JavaBean  
JavaBean 是一种JAVA语言写成的可重用组件。JavaBean符合一定规范编写的Java类，不是一种技术，而是一种规范。大家针对这种规范，总结了很多开发技巧、工具函数。符合这种规范的类，可以被其它的程序员或者框架使用。它的方法命名，构造及行为必须符合特定的约定：  

1、所有属性为private。  

2、这个类必须有一个公共的缺省构造函数。即是提供无参数的构造器。  

3、这个类的属性使用getter和setter来访问，其他方法遵从标准命名规范。  

4、这个类应是可序列化的。实现serializable接口。  

## POJO   
  （Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans，是为了避免和EJB混淆所创造的简称。  
  其中有一些属性及其getter、setter方法的类，没有业务逻辑，有时可以作为VO（value-object）或DTO（Data Transfer Object）来使用。不允许有业务方法，也不能携带connection之类的方法，实际就是普通JavaBeans。POJO类中有属性和get、set方法，但是没有业务逻辑  
POJO例（class名字后没有继承 等修饰符)： 
/**
 * POJO类代码示例
 */  
public class UserInfoPojoDemo {

    private int userId;// 用户帐号
    private String pwd;// 用户密码

    /**
     * Constructor
     */
    public UserInfoPojoDemo() {
    }

    public UserInfoPojoDemo(String pwd) {
        this.pwd = pwd;
    }

    public UserInfoPojoDemo(int userId) {
        this.userId = userId;
    }

    public UserInfoPojoDemo(int userId, String pwd) {
        this.userId = userId;
        this.pwd = pwd;
    }

    /**
     *Access 
     */
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
### JavaBean例（有序列化修饰符）：  

public class UserInfo implements java.io.Serializable{  

//实现serializable接口。  
private static final long serialVersionUID = 1L;  

private String name;  
private int age;  

//无参构造器  
public UserInfo() {  

}  

public String getName() {  
    return name;  
}  

public void setName(String name) {  
    this.name = name;  
}  

public int getAge() {  
    return age;  
}  

public void setAge(int age) {  
    this.age = age;  
}  

//javabean当中可以有其它的方法  
public void userInfoPrint(){  
    System.out.println("");  
 } 
}  

### 区别：  
POJO其实是比javabean更纯净的简单类或接口。POJO严格地遵守简单对象的概念，而一些JavaBean中往往会封装一些简单逻辑。  

POJO主要用于数据的临时传递，它只能装载数据， 作为数据存储的载体，而不具有业务逻辑处理的能力。  

Javabean虽然数据的获取与POJO一样，但是javabean当中可以有其它的方法。  

## entity（实体类）  

对java实体类的众多理解：  

A .就是属性类，通常定义在model层里面  

B. 一般的实体类对应一个数据表，其中的属性对应数据表中的字段。  
好处：  
1.对对象实体的封装，体现OO思想。  
2.属性可以对字段定义和状态进行判断和过滤 
3.把相关信息用一个实体类封装后，我们在程序中可以把实体类作为参数传递，更加方便。  

C. 说白了就是为了让程序员在对数据库操作的时候不用写SQL语句  

D. 就是一个数据库表生成一个类  
这样做对数据库操作起来方便
编写代码较少 提高效率 可以使程序员专注逻辑关系  

E. 实体类就是把对某一个表的操作全写在一个类中.  

F. 在Java开发中经常要定义一些实体类，这些类的定义的好坏会直接影响，编写代码的质量和难易程度，以下是别人总结的一些经验。  

一、实体类的名字尽量和数据库的表的名字对应相同。  

二、实体类应该实现java.io.Serializable接口。  

三、实体类应该有个无参的构造方法。  

四、实体类应该有个有参（所有的参数）的构造方法。  

五、实体类有属性和方法，属性对应数据库中表的字段，主要有getter和setter方法。  

六、实体类还应该有个属性serialVersionUID。  
例如：private static final long serialVersionUID = -6125297654796395674L;  

七、属性一般是private类型，方法位public类型，对于数据库自动生成的ID字段对应的属性的set方法应为private。  

