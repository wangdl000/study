当我们需要执行的代码块数次，通常被称为一个循环。
Java有非常灵活的三循环机制。可以使用以下三种循环之一：

while 循环
do...while 循环
for 循环
截至Java5，对增强的for循环进行了介绍。这主要是用于数组。

while 循环
while循环是一个控制结构，可以重复的特定任务次数。

语法
while循环的语法是：

while(Boolean_expression)
{
   //Statements
}
在执行时，如果布尔表达式的结果为真，则循环中的动作将被执行。只要该表达式的结果为真，执行将继续下去。

在这里，while循环的关键点是循环可能不会永远运行。当表达式进行测试，结果为假，循环体将被跳过，在while循环之后的第一个语句将被执行。

示例
public class Test {

   public static void main(String args[]) {
      int x = 10;

      while( x < 20 ) {
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }
   }
}
这将产生以下结果:

value of x : 10
value of x : 11
value of x : 12
value of x : 13
value of x : 14
value of x : 15
value of x : 16
value of x : 17
value of x : 18
value of x : 19
do...while 循环
do ... while循环类似于while循环，不同的是一个do ... while循环是保证至少执行一次。

语法
do...while循环的语法是：

do
{
   //Statements
} while (Boolean_expression);
请注意，布尔表达式出现在循环的结尾，所以在循环中的语句执行前一次布尔测试。

如果布尔表达式为真，控制流跳回，并且在循环中的语句再次执行。这个过程反复进行，直到布尔表达式为假。

示例
public class Test {

   public static void main(String args[]){
      int x = 10;

      do{
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }while( x < 20 );
   }
}
这将产生以下结果:

value of x : 10
value of x : 11
value of x : 12
value of x : 13
value of x : 14
value of x : 15
value of x : 16
value of x : 17
value of x : 18
value of x : 19
for 循环
for循环是一个循环控制结构，可以有效地编写需要执行的特定次数的循环。

知道一个任务要重复多少次的时候，for循环是有好处的。

语法
for循环的语法是：

for(initialization; Boolean_expression; update)
{
   //Statements
}
下面是一个for循环的控制流程：

初始化步骤首先被执行，并且仅一次。这个步骤可声明和初始化任何循环控制变量。不需要把一个声明放在这里，只需要一个分号出现。

接下来，布尔表达式求值。如果是 true，则执行循环体。如果是false，则循环体不执行, 并且流程控制的跳转到经过for循环的下一个语句。

之后循环体在for循环执行时，控制流程跳转备份到更新语句。该语句允许更新任何循环控制变量。这个语句可以留空，只要一个分号出现在布尔表达式之后。

布尔表达式现在再次评估计算。如果是true，循环执行，并重复这个过程（循环体，然后更新的步骤，然后布尔表达式）。之后，布尔表达式为 false，则循环终止。
示例
public class Test {

   public static void main(String args[]) {

      for(int x = 10; x < 20; x = x+1) {
         System.out.print("value of x : " + x );
         System.out.print("\n");
      }
   }
}
这将产生以下结果:

value of x : 10
value of x : 11
value of x : 12
value of x : 13
value of x : 14
value of x : 15
value of x : 16
value of x : 17
value of x : 18
value of x : 19
for 循环在 Java 中新特性
截至Java5，对增强的for循环进行了介绍。这主要是用于数组。

语法
增强的for循环的语法是：

for(declaration : expression)
{
   //Statements
}
声明: 新声明块变量，这是一种与你所正在访问数组中的元素兼容的变量。该变量在for块内可被利用并且它的值作为当前的数组元素将是相同的。

表达: 这个计算结果完成需要循环数组。表达式可以是一个数组变量或返回一个数组的方法调用。
示例
public class Test {

   public static void main(String args[]){
      int [] numbers = {10, 20, 30, 40, 50};

      for(int x : numbers ){
         System.out.print( x );
         System.out.print(",");
      }
      System.out.print("\n");
      String [] names ={"James", "Larry", "Tom", "Lacy"};
      for( String name : names ) {
         System.out.print( name );
         System.out.print(",");
      }
   }
}
这将产生以下结果:

10,20,30,40,50,
James,Larry,Tom,Lacy,
break 关键字
关键字break是用来停止整个循环的。 break关键字必须使用于任何循环中或一个switch语句中。

关键字break将停止最内层循环的执行，并开始执行在块之后的下一行代码。

语法
break语法是任何循环中一个单独的语句：

break
示例
public class Test {

   public static void main(String args[]) {
      int [] numbers = {10, 20, 30, 40, 50};

      for(int x : numbers ) {
         if( x == 30 ) {
          break;
         }
         System.out.print( x );
         System.out.print("\n");
      }
   }
}
这将产生以下结果:

10
20
continue 关键字
continue关键字可以在任一环的控制结构使用。它使循环立即跳转到循环的下一次迭代.

在for循环中，continue关键字会导致控制流立即跳转到更新语句。
在一个while循环或do/while循环，控制流立即跳转到布尔表达式。
语法
continue 语法是任何循环中一个单独的语句：

continue
示例

   public static void main(String args[]) {
      int [] numbers = {10, 20, 30, 40, 50};

      for(int x : numbers ) {
         if( x == 30 ) {
          continue;
         }
         System.out.print( x );
         System.out.print("\n");
      }
   }
}
这将产生以下结果：

10
20
40
50