变量可以给我们提供我们程序可以操纵的命名的存储。Java 中的每种变量都有特定的类型，这决定了变量的大小和它的设计占用内存空间；这一些列的值可以存储在那个内存空间中；变量可以应用的操作。

在使用前你必须现将所要使用的变量进行声明。声明变量的基本格式如下：

data type variable [ = value][, variable [= value] ...] ;
这里的 data type 是 Java 的一种数据类型，variable 是一种变量的名称。要声明一个以上的特定变量类型，你可以采用逗号分隔开。

下面是 Java 中有效的变量声明和赋值的例子：

int a, b, c; // Declares three ints, a, b, and c.
int a = 10, b = 10; // Example of initialization
byte B = 22; // initializes a byte type variable B.
double pi = 3.14159; // declares and assigns a value of PI.
char a = 'a'; // the char variable a iis initialized with value 'a'
本章将介绍 Java 中的各种可用的变量类型。Java 中共有三种变量：

本地变量
实例变量
类、静态变量
本地变量
本地变量在方法、构造器或者块中声明
本地变量在方法、构造器或者块进入时被创建，一旦退出该变量就会被摧毁
可访问描述符不能用于本地变量
本地变量仅在已经声明的方法、构造器或者块中可见
本地变量在栈深度内部实施
本地变量没有默认值，因此本地变量必须被声明并且在第一次使用前要给它赋值
例子
这里，age（年龄）是本地变量。这是在 pupAge() 方法下定义的，它的范围仅限于这个方法。

public class Test{ 
   public void pupAge(){
      int age = 0;
      age = age + 7;
      System.out.println("Puppy age is : " + age);
   }

   public static void main(String args[]){
      Test test = new Test();
      test.pupAge();
   }
}
上述代码会输出如下结果：

Puppy age is: 7
例子
下面的例子使用了本地变量 age 但是没有进行初始化，所以在编辑是就会显示错误。

public class Test{ 
   public void pupAge(){
      int age;
      age = age + 7;
      System.out.println("Puppy age is : " + age);
   }

   public static void main(String args[]){
      Test test = new Test();
      test.pupAge();
   }
}
编辑时会产生如下错误：

Test.java:4:variable number might not have been initialized
age = age + 7;
^
1 error
实例变量
实例变量在类中声明，但是它在方法、构造器或者块外。
当堆中的对象被分配了一个空间时，每个实例变量的位置就被创建了。
当对象采用关键字“ new ”创建时实例变量就被创建了，当对象被销毁时它也就被销毁了。
实例变量的值必须被一个以上的方法、构造器或者块，或者类中必须出现的对象的状态的重要部分所引用。
实例变量可以在类水平上在使用前或者使用后声明。
实例变量可以用可访问描述符。
实例变量对类中的所有方法、构造器或者块可见。一般来讲，推荐将这些变量私有（访问层面）。然而子类的可见性可用可访问描述符给予那些变量。
实例变量有默认值。数字的默认值为零，布尔型默认值为假，对象引用默认值为空。在声明或者构造器内可以进行赋值。
实例变量可以采用直接在类中叫名字方式访问。然而在静态方法和不同的类（实例变量可以被访问）中应当使用完全限定名称。ObjectReference.VariableName
例子
import java.io.*;

public class Employee{
   // this instance variable is visible for any child class.
   public String name;

   // salary  variable is visible in Employee class only.
   private double salary;

   // The name variable is assigned in the constructor. 
   public Employee (String empName){
      name = empName;
   }

   // The salary variable is assigned a value.
   public void setSalary(double empSal){
      salary = empSal;
   }

   // This method prints the employee details.
   public void printEmp(){
      System.out.println("name  : " + name );
      System.out.println("salary :" + salary);
   }

   public static void main(String args[]){
      Employee empOne = new Employee("Ransika");
      empOne.setSalary(1000);
      empOne.printEmp();
   }
}
上述代码会输出如下结果：

name  : Ransika
salary :1000.0
类、静态变量
类变量也叫静态变量，它是在类中用 static 关键字声明的，但是它在方法、构造器或者块之外。
每个类中只有一个类变量，不管这个类有多少对象。
除了作为常量被声明之外，类变量很少被应用。常量是被作为 public、private, final 和 static 被声明的变量。实例变量的初始值不会被改变。
静态变量存储在静态内存中，很少采用静态变量而不是声明结束或者用常量public 或 private 之一。
静态变量随着程序的开始和结束而开始和结束。
可见性和实例变量相似。然而大多数静态变量被声明为public由于他们必须为类的使用者所用。
默认值和实例变量相似。对于数字的默认值为零，布尔型默认值为假，对象引用默认值为空。在声明或者构造器内可以进行赋值。除此之外，可以在特殊的静态初始化区赋值。
静态变量可以用类的名称访问。ClassName.VariableName
当静态变量被作为 public static final 声明时，变量（常量）名称都要用大写字母。如果静态变量不是 public 和 final，它的命名方法和实例变量和本地变量相同。
例子
import java.io.*;

public class Employee{
   // salary  variable is a private static variable
   private static double salary;

   // DEPARTMENT is a constant
   public static final String DEPARTMENT = "Development ";

   public static void main(String args[]){
      salary = 1000;
      System.out.println(DEPARTMENT+"average salary:"+salary);
   }
}
上述代码会输出如下结果：

Development average salary:1000
注：如果变量从类外访问，常量就必须以 Employee.DEPARTMENT 访问。