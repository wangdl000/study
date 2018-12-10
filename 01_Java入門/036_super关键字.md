## super关键字
### 一、super关键字
　　

　　在JAVA类中使用super来引用父类的成分，用this来引用当前对象，如果一个类从另外一个类继承，我们new这个子类的实例对象的时候，这个子类对象里面会有一个父类对象。怎么去引用里面的父类对象呢？使用super来引用，this指的是当前对象的引用，super是当前对象里面的父对象的引用。

1.1.super关键字测试

复制代码
 1 package cn.galc.test;
 2 
 3 /**
 4  * 父类
 5  * @author gacl
 6  *
 7  */
 8 class FatherClass {
 9     public int value;
10     public void f() {
11         value=100;
12         System.out.println("父类的value属性值="+value);
13     }
14 }
15 
16 /**
17  * 子类ChildClass从父类FatherClass继承
18  * @author gacl
19  *
20  */
21 class ChildClass extends FatherClass {
22     /**
23      * 子类除了继承父类所具有的valu属性外，自己又另外声明了一个value属性，
24      * 也就是说，此时的子类拥有两个value属性。
25      */
26     public int value;
27     /**
28      * 在子类ChildClass里面重写了从父类继承下来的f()方法里面的实现，即重写了f()方法的方法体。
29      */
30     public void f() {
31         super.f();//使用super作为父类对象的引用对象来调用父类对象里面的f()方法
32         value=200;//这个value是子类自己定义的那个valu，不是从父类继承下来的那个value
33         System.out.println("子类的value属性值="+value);
34         System.out.println(value);//打印出来的是子类自定义的那个value的值，这个值是200
35         /**
36          * 打印出来的是父类里面的value值，由于子类在重写从父类继承下来的f()方法时，
37          * 第一句话“super.f();”是让父类对象的引用对象调用父类对象的f()方法，
38          * 即相当于是这个父类对象自己调用f()方法去改变自己的value属性的值，由0变了100。
39          * 所以这里打印出来的value值是100。
40          */
41         System.out.println(super.value);
42     }
43 }
44 
45 /**
46  * 测试类
47  * @author gacl
48  *
49  */
50 public class TestInherit {
51     public static void main(String[] args) {
52         ChildClass cc = new ChildClass();
53         cc.f();
54     }
55 }
复制代码
运行结果：

　　

1.2. 画内存分析图了解程序执行的整个过程

　　分析任何程序都是从main方法的第一句开始分析的，所以首先分析main方法里面的第一句话：

ChlidClass cc = new ChlidClass();
　　程序执行到这里时，首先在栈空间里面会产生一个变量cc，cc里面的值是什么这不好说，总而言之，通过这个值我们可以找到new出来的ChlidClass对象。由于子类ChlidClass是从父类FatherClass继承下来的，所以当我们new一个子类对象的时候，这个子类对象里面会包含有一个父类对象，而这个父类对象拥有他自身的属性value。这个value成员变量在FatherClass类里面声明的时候并没有对他进行初始化，所以系统默认给它初始化为0，成员变量（在类里面声明）在声明时可以不给它初始化，编译器会自动给这个成员变量初始化，但局部变量（在方法里面声明）在声明时一定要给它初始化，因为编译器不会自动给局部变量初始化，任何变量在使用之前必须对它进行初始化。

　　子类在继承父类value属性的同时，自己也单独定义了一个value属性，所以当我们new出一个子类对象的时候，这个对象会有两个value属性，一个是从父类继承下来的value，另一个是自己的value。在子类里定义的成员变量value在声明时也没有给它初始化，所以编译器默认给它初始化为0。因此，执行完第一句话以后，系统内存的布局如下图所示：

　

接下来执行第二句话：

1 cc.f();
　　当new一个对象出来的时候，这个对象会产生一个this的引用，这个this引用指向对象自身。如果new出来的对象是一个子类对象的话，那么这个子类对象里面还会有一个super引用，这个super指向当前对象里面的父对象。所以相当于程序里面有一个this，this指向对象自己，还有一个super，super指向当前对象里面的父对象。

　　这里调用重写之后的f()方法，方法体内的第一句话：“super.f();”是让这个子类对象里面的父对象自己调用自己的f()方法去改变自己value属性的值，父对象通过指向他的引用super来调用自己的f()方法，所以执行完这一句以后，父对象里面的value的值变成了100。接着执行“value=200；”这里的vaule是子类对象自己声明的value，不是从父类继承下来的那个value。所以这句话执行完毕后，子类对象自己本身的value值变成了200。此时的内存布局如下图所示：  



　　方法体内的最后三句话都是执行打印value值的命令，前两句打印出来的是子类对象自己的那个value值，因此打印出来的结果为200，最后一句话打印的是这个子类对象里面的父类对象自己的value值，打印出来的结果为100。  

　　到此，整个内存分析就结束了，最终内存显示的结果如上面所示。  