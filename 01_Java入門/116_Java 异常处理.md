异常是一个程序执行过程中出现的问题。引起异常的原因包括以下几点：

用户输入无效的数据
用户打开一个不能被找到的文件
网络连接已经丢失或 JVM 已经耗尽内存
一些异常是由于用户的错误，也有是因为程序员的错误，还有是因为一些物理资源在某些形式上的错误。

在 Java 中了解异常处理,您需要了解异常的三个类别:

检测异常：一个已检测异常通常是用户错误或是一个程序员不能预见的错误，如果一个文件将要被打开，但系统找不到这个文件，异常就会发生。这些异常在编译时不能被简单忽略。
运行时异常：运行时异常是可以被程序语法避免的。不同于检测异常，运行时异常在编译时可以被忽略。
错误：这并不是异常，但这不是用户或程序员可以控制的。错误经常在你的代码中被忽略因为你针对一个错误几乎做不了任何事。比如，如果一个堆栈溢出发生时，将会出现一个错误。他们在编译时也会被忽略。
异常的层次结构
所有的异常类都是 java.lang.Exception 类的子类型。异常类都是 Throwable 类的子类。除了异常类 Error 类也是由 Throwable 类产生的的子类。

错误一般不会由 Java 程序解决。这些条件通常是在 Java 程序解决不了的错误出现时才会发生。 Errors 用来去指示那些运行时环境生成的错误。举例说明：JVM（java虚拟机）是不在内存中的。一般程序不能从错误中恢复。

Exception 类含有两个子类：IOException 类和 RuntimeException 类。

image

异常方法
下面是 Throwable 类的重要方法列表。

SN	方法描述
1	public String getMessage() 
返回关于发生异常的细节信息，这些信息在Throwable的构造函数中被初始化
2	public Throwable getCause() 
返回发生异常的原因，由 Throwable 对象来表示
3	public String toString() 
返回与getMessage()的结果相联系的类的名称
4	public void printStackTrace() 
打印 toString()跟踪错误输出流的栈地址的结果。
5	public StackTraceElement [] getStackTrace() 
返回一个数组,其中包含每个元素在栈的地址。元素的索引0代表调用栈的顶部,最后一个元素表示方法调用栈的底部。
6	public Throwable fillInStackTrace() 
用当前栈地址来填充 Throwable 对象的栈地址,添加到任何先前的栈地址信息。
捕获异常
一个方法用关键字 try 和 catch 来捕获异常。一个 try/catch 块放置在可能产生异常的代码外。在 try/catch 块内的代码是被保护的，并且其语法如下：

try
{
   //Protected code
}catch(ExceptionName e1)
{
   //Catch block
}
关于 catch 的声明，你必须要指明你要捕获的异常的类型。如果受保护的代码中发生异常，跟在 try 后面的 catch 块会被检测。如果异常类型在 catch 中出现了，那么这个异常会被传递到 catch 当中，就像实参传递到方法参数当中。

示例
下面的例子声明了一个含有两个元素的数组。然后代码试图访问数组的第三个元素，这将抛出一个异常。

// File Name : ExcepTest.java
import java.io.*;
public class ExcepTest{

   public static void main(String args[]){
      try{
         int a[] = new int[2];
         System.out.println("Access element three :" + a[3]);
      }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("Exception thrown  :" + e);
      }
      System.out.println("Out of the block");
   }
}
这将产生如下的结果

Exception thrown  :java.lang.ArrayIndexOutOfBoundsException: 3
Out of the block
多个catch块
一个 try 块可以有多个 catch 块。多个 catch 块的语法如下:

try
{
   //Protected code
}catch(ExceptionType1 e1)
{
   //Catch block
}catch(ExceptionType2 e2)
{
   //Catch block
}catch(ExceptionType3 e3)
{
   //Catch block
}
前面的语句演示三个 catch 块,但是你可以在一个 try 后面跟任意数量的 catch 块。当被保护代码中出现异常时，异常首先会被第一个 catch 块抓住，如果该异常类型在第一个 catch 块中列出，便在第一个 catch 块中被捕获。如果没有列出，便依次向下一个 catch 块中去匹配，直到找到该异常类型。最后不论是否找到现有的方法都会停止执行，并且抛出异常到上一个方法的栈地址。

示例
下面是代码段显示如何使用多个 try/catch 语句。

try
{
   file = new FileInputStream(fileName);
   x = (byte) file.read();
}catch(IOException i)
{
   i.printStackTrace();
   return -1;
}catch(FileNotFoundException f) //Not valid!
{
   f.printStackTrace();
   return -1;
}
throws/throw 关键词
如果一个方法不能处理检测异常，那么该方法必须用关键字 throws 来声明。throws 关键字在方法签名的最后出现。

你可以通过关键字 throw 来抛出一个异常或进行你刚捕获到的异常的实例化。试着去理解关键字 throws 和 throw 的不同。

以下方法声明它抛出 RemoteException 异常:

import java.io.*;
public class className
{
   public void deposit(double amount) throws RemoteException
   {
      // Method implementation
      throw new RemoteException();
   }
   //Remainder of class definition
}
一个方法可以声明抛出一个以上的异常,这些异常用逗号分隔。例如,下面的方法声明抛出 RemoteException 和 InsufficientFundsException :

import java.io.*;
public class className
{
   public void withdraw(double amount) throws RemoteException,
                              InsufficientFundsException
   {
       // Method implementation
   }
   //Remainder of class definition
}
关键字 finally
finally 关键字用于创建跟在 try 后面的代码块,finally 代码块总是会被执行的，不管是怎样的异常发生。

使用 finally 块允许你运行您想要执行的任何 cleanup-type 语句,无论在受保护的代码中发生什么。

finally 代码块出现在最后一个 catch 块之后并且语法如下：

try
{
   //Protected code
}catch(ExceptionType1 e1)
{
   //Catch block
}catch(ExceptionType2 e2)
{
   //Catch block
}catch(ExceptionType3 e3)
{
   //Catch block
}finally
{
   //The finally block always executes.
}
示例
public class ExcepTest{

   public static void main(String args[]){
      int a[] = new int[2];
      try{
         System.out.println("Access element three :" + a[3]);
      }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("Exception thrown  :" + e);
      }
      finally{
         a[0] = 6;
         System.out.println("First element value: " +a[0]);
         System.out.println("The finally statement is executed");
      }
   }
}
这将产生如下结果：

Exception thrown  :java.lang.ArrayIndexOutOfBoundsException: 3
First element value: 6
The finally statement is executed
以下几点需要注意：

catch 在没有 try 关键字的情况下是不能够出现的。
try/catch 语句块中并不是强制出现 finally 块。
try 语句块不能独立存在（即没有任何 catch 和 finally 块）。
在 try catch 和 finally 块之间是不能出现任何代码的。
声明自己的异常
你可以在 Java 中创建自己的异常。编写自己的异常类，要记住以下几点：

所有的异常必须 Throwable 的子类。
如果你想写一个自动遵守正确处理或声明规则的检测异常,需要继承 Exception 类。
如果你想编写一个运行时异常,需要继承 RuntimeException 类。
我们如下可以定义自己的异常类：

class MyException extends Exception{
}
你只需要继承 Exception 类来创建你自己的异常类。这些被认为是检测异常。以下 InsufficientFundsException 类是一个用户定义的异常，同样继承了 Exception 类，成为检测异常。一个异常类和任何其他类一样,包含字段和方法。

例子：

// File Name InsufficientFundsException.java
import java.io.*;

public class InsufficientFundsException extends Exception
{
   private double amount;
   public InsufficientFundsException(double amount)
   {
      this.amount = amount;
   } 
   public double getAmount()
   {
      return amount;
   }
}
为了演示使用用户定义的异常,下面的 CheckingAccount 类包含一个 withdraw() 方法抛出了一个 InsufficientFundsException 异常。

// File Name CheckingAccount.java
import java.io.*;

public class CheckingAccount
{
   private double balance;
   private int number;
   public CheckingAccount(int number)
   {
      this.number = number;
   }
   public void deposit(double amount)
   {
      balance += amount;
   }
   public void withdraw(double amount) throws
                              InsufficientFundsException
   {
      if(amount <= balance)
      {
         balance -= amount;
      }
      else
      {
         double needs = amount - balance;
         throw new InsufficientFundsException(needs);
      }
   }
   public double getBalance()
   {
      return balance;
   }
   public int getNumber()
   {
      return number;
   }
}
下面的 BankDemo 程序演示了调用 CheckingAccount 的 deposit() 和 withdraw() 方法。

// File Name BankDemo.java
public class BankDemo
{
   public static void main(String [] args)
   {
      CheckingAccount c = new CheckingAccount(101);
      System.out.println("Depositing $500...");
      c.deposit(500.00);
      try
      {
         System.out.println("\nWithdrawing $100...");
         c.withdraw(100.00);
         System.out.println("\nWithdrawing $600...");
         c.withdraw(600.00);
      }catch(InsufficientFundsException e)
      {
         System.out.println("Sorry, but you are short $"
                                  + e.getAmount());
         e.printStackTrace();
      }
    }
}
编译上述三个文件并运行 BankDemo,将产生以下结果:

Depositing $500...

Withdrawing $100...

Withdrawing $600...
Sorry, but you are short $200.0
InsufficientFundsException
        at CheckingAccount.withdraw(CheckingAccount.java:25)
        at BankDemo.main(BankDemo.java:13)
常见的异常
在 Java 中,可以定义两种异常和错误

JVM 异常：这些异常/错误是由 JVM 在逻辑层上或专门抛出的。例子： NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException。
程序性异常：这些异常是由应用程序或是编写 API 的程序员明确抛出的，如：IllegalArgumentException, IllegalStateException。
