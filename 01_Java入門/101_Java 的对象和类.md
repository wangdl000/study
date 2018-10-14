Java 是一种面向对象的语言。作为一种具有面向对象特征的语言
Java 包括以下几项基本概念：

多态性
继承性
封装性
抽象性
类
对象
实例
消息解析
在这一章，我们将深入学习类和对象。

对象：对象具有状态和行为。如果我们考虑现实世界我们可以在我们身边找到很多对象，小汽车，狗，人类等等。所有这些对象都具有状态和行为。
类：类可以被定义为描述对象支持类型的行为、状态的的模板、蓝图。
Java 中的对象
现在让我们深入学习对象。如果我们考虑一条狗，那么它的状态就是-名字，品种，颜色，它的行为就是汪汪，摇尾巴，跑。

如果我们将软件中的对象和现实世界中的对象对比，那么我们将会发现他们有很多相似的特征。软件中的对象也具有状态和行为。软件的状态被储存在文件中，它的行为通过方法来表现。

因此，在软件发展过程中方法控制对象的内在状态并且对象和对象间的交流通过方法来完成。

Java 中的类
类是有独立的对象创造出的蓝图。

下面给出了一个类的例子：

public class Dog{
   String breed;
   int age;
   String color;

   void barking(){
   }

   void hungry(){
   }

   void sleeping(){
   }
}
类可以包括以下的变量类型：

局部变量：在方法，构造器或区域中定义的变量成为局部变量。变量将会在方法内产生和发展，然后当方法结束变量就会破坏。
实例变量：实例变量是在类内但是在方法外的变量。这些变量是当类被装载时被实体化的。实例变量可以是从特定类的任何方法，构造器，区域中存取。
类变量：类变量是在类中声明的变量，它处在任何方法之外，有静态关键字。
类可以有任意数量的方法来存取不同种类方法的值。在上面的例子中，barking()，hungry() 和 sleeping() 是方法。
下面提到的是一些深入了解 Java 语言所必须讨论的重要话题。

构造器
当我们讨论类时，其中一个重要的子话题就是构造器。每一个类都有一个构造器。如果我们不单独为一个类编写构造器那么 Java 的编译器将会给这个类建立一个默认的构造器。

每当一个新的对象被创建，至少一个构造器将会被调用。构造器的一个最主要的原则就是他们必须和类有同样的名字。一个类可以有不止一个构造器。

下面给出了一个构造器的例子：

public class Puppy{
   public Puppy(){
   }

   public Puppy(String name){
      // This constructor has one parameter, name.
   }
}
在需要只创建一个类的实例的时，Java 也支持单例。

创造一个对象
如前所述，类为对象提供了蓝图。因此基本来说一个对象是从一个类中创造出来的。在 Java 中，新的关键词被用来创造新的对象。当我们从类中创造对象时需要三步：

声明：变量声明可以声明其所代表的对象类型。
实例化：“新的”关键词用来创造对象。
初始化：“新的”关键词伴随着一个构造器的启用，这个将新的对象初始化。
下面给出了一个创造对象的例子：

public class Puppy{

   public Puppy(String name){
      // This constructor has one parameter, name.
      System.out.println("Passed Name is :" + name ); 
   }
   public static void main(String []args){
      // Following statement would create an object myPuppy
      Puppy myPuppy = new Puppy( "tommy" );
   }
}
如果编译并运行上述程序，那么将输出下列结果：

Passed Name is :tommy
访问实体变量和方法
实体变量和方法是通过创造对象来访问的。为了访问一个实体变量完全有效的路径应该如下所示：

/* First create an object */
ObjectReference = new Constructor();
/* Now call a variable as follows */
ObjectReference.variableName;
/* Now you can call a class method as follows */
ObjectReference.MethodName();
例子
这个例子解释了如何存取类的实体变量和方法：

public class Puppy{

   int puppyAge;

   public Puppy(String name){
      // This constructor has one parameter, name.
      System.out.println("Passed Name is :" + name ); 
   }
   public void setAge( int age ){
       puppyAge = age;
   }

   public int getAge( ){
       System.out.println("Puppy's age is :" + puppyAge ); 
       return puppyAge;
   }
   public static void main(String []args){
      /* Object creation */
      Puppy myPuppy = new Puppy( "tommy" );

      /* Call class method to set puppy's age */
      myPuppy.setAge( 2 );

      /* Call another class method to get puppy's age */
      myPuppy.getAge( );

      /* You can access instance variable as follows as well */
      System.out.println("Variable Value :" + myPuppy.puppyAge ); 
   }
}
如果我们编译运行上述程序，那么将会产生如下结果：

Passed Name is :tommy
Puppy's age is :2
Variable Value :2
源文件声明规则
在本节的最后一部分让我们学习一下源文件声明规则。当在源文件中声明类，输入和打包语法时，这些规则是十分重要的。

每个源文件中只能有一个公共类。
一个源文件可以有很多非公共类。
公共类的名称必须是源文件的名称同时也要以 .java 为后缀。举例来说：类的名称是 public class Employee{}，那么源文件就应该是 Employee.java。
如果类是在一个程序包中定义的，那么程序包的声明必须是源文件的第一个声明。
如果输入声明出现那么他们必须被写在封装声明和类声明之间。如果没有封装声明那么输入声明必须在源文件的第一行。
输入和打包声明会暗示所有源文件中的存在的类。在源文件中很难为不同的类区分输入和封装声明。
类有不同的访问级别并且有很多不同的类；抽象的类，最终的类等等。我将会在后面的访问控制修饰符章节解释这些。
除了以上提到的类的类型之外， Java 也有像内部类和匿名类这样的特殊类。
Java 程序包
简而言之，就是一种分类类和接口的一种方法。当用 Java 开发程序时，数百个类和接口会被编写，因此分类这些类不但是必须的而且也是会使问题变得容易的。

Import 语法
在 Java 中，如果给出包括封装和类的名称的全限定名，那么编译器很容易定位到源类和源代码。Import 语法是给编译器寻找特定类的适当位置的一种方法。

举例来说，下面这行语句将会要求编译器去装载 java_installation/java/io 路径下的所有可用的类:

import java.io.*;
一个简单的案例学习
在我们的案例学习中，我们将创造两个类。他们是 Employee 和 EmployeeTest。

首先打开记事本输入下列代码。记得这个是 Employee 类，这个类是公共类。现在以 Employee.java 为文件名保存这个源文件。

这个 Employee 类包括四个实体变量姓名（name），年龄（age），职位（designation）和薪水（salary）。这个类有一个确定的需要参数的的构造器。

import java.io.*;
public class Employee{
   String name;
   int age;
   String designation;
   double salary;

   // This is the constructor of the class Employee
   public Employee(String name){
      this.name = name;
   }
   // Assign the age of the Employee  to the variable age.
   public void empAge(int empAge){
      age =  empAge;
   }
   /* Assign the designation to the variable designation.*/
   public void empDesignation(String empDesig){
      designation = empDesig;
   }
   /* Assign the salary to the variable salary.*/
   public void empSalary(double empSalary){
      salary = empSalary;
   }
   /* Print the Employee details */
   public void printEmployee(){
      System.out.println("Name:"+ name );
      System.out.println("Age:" + age );
      System.out.println("Designation:" + designation );
      System.out.println("Salary:" + salary);
   }
}
正如本指导之前所述，编程从主函数开始。因此，我们为了运行这个 Employee 类就应当建立主函数和类。我们将分别为这些任务创建类。

下面所给的是 EmployeeTest 类，这个类创建了两个 Employee 类的实例，并且为每个对象调用方法从而给每个变量赋值。

在 EmployeeTest.java 文件中保存下列代码

import java.io.*;
public class EmployeeTest{

   public static void main(String args[]){
      /* Create two objects using constructor */
      Employee empOne = new Employee("James Smith");
      Employee empTwo = new Employee("Mary Anne");

      // Invoking methods for each object created
      empOne.empAge(26);
      empOne.empDesignation("Senior Software Engineer");
      empOne.empSalary(1000);
      empOne.printEmployee();

      empTwo.empAge(21);
      empTwo.empDesignation("Software Engineer");
      empTwo.empSalary(500);
      empTwo.printEmployee();
   }
}
现在编译两个类然后运行 EmployeeTest，你将会看到如下结果：

C :> javac Employee.java
C :> vi EmployeeTest.java
C :> javac EmployeeTest.java
C :> java EmployeeTest
Name:James Smith
Age:26
Designation:Senior Software Engineer
Salary:1000.0
Name:Mary Anne
Age:21
Designation:Software Engineer
Salary:500.0