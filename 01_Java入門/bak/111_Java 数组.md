Java 提供了一个数据结构：数组，用于存储相同类型的元素的一个固定大小的连续集合。数组是用于存储数据的集合，但往往将数组认为是相同类型的变量的集合。

跟声明单个变量相反，如 number0, number1, ... number99, 声明一个数组变量，如数字和使用 numbers[0], numbers[1] ..., numbers[99] 来表示各个变量。

此次教程将介绍如何使用索引变量声明数组变量，创建数组，并处理数组。

声明数组变量
要使用一个程序的数组，必须声明一个变量来引用数组，必须指定数组的变量可以引用的类型。下面是来声明一个数组变量的语法：

dataType[] arrayRefVar;   // preferred way.

or

dataType arrayRefVar[];  //  works but not preferred way.
注 风格 dataType[] arrayRefVar 是首选的。风格 dataType arrayRefVar[] 来自于 C/C++ 语言， 方便Java 继承 C/C++ 的编程风格。

示例
下面的代码片段是这种语法的例子：

double[] myList;         // preferred way.

or

double myList[];         //  works but not preferred way.
创建数组
可以通过使用 new 运算符使用以下语法创建一个数组：

arrayRefVar = new dataType[arraySize];
上面的语句做了两件事：

它创建了一个使用 new dataType[arraySize] 的数组;
它将新创建的数组引用分配给变量 arrayRefVar。
声明数组变量，建立一个数组，并分配给变量数组引用可以在一个语句中组合使用，如下所示：

dataType[] arrayRefVar = new dataType[arraySize];
另外，可以创建数组，如下所示：

dataType[] arrayRefVar = {value0, value1, ..., valuek};
数组元素通过索引访问。数组的下标是从0开始的，也就是说，它们从0开始到 arrayRefVar.length-1。

示例
下面的语句声明一个数组变量 myList，创建 double 类型的10个元素的数组，并把它的引用分配到 myList ：

double[] myList = new double[10];
以下图片代表数组 myList。在这里，myList 有10个 double 值，索引是从0到9。

image
处理数组
当处理数组元素时，经常使用的是 loop 循环或 foreach 循环，因为一个数组中所有的元素是相同类型的并且数组的大小是已知的。

示例
下面是一个演示如何创建，初始化和处理数组的完整例子：

public class TestArray {

   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};

      // Print all the array elements
      for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
      // Summing all elements
      double total = 0;
      for (int i = 0; i < myList.length; i++) {
         total += myList[i];
      }
      System.out.println("Total is " + total);
      // Finding the largest element
      double max = myList[0];
      for (int i = 1; i < myList.length; i++) {
         if (myList[i] > max) max = myList[i];
      }
      System.out.println("Max is " + max);
   }
}
这将产生以下结果:

1.9
2.9
3.4
3.5
Total is 11.7
Max is 3.5
foreach 循环
JDK 1.5 引入了一个新的 for 循环被称为 foreach 循环或增强的 for 循环，它无需使用一个索引变量来完整的遍历数组。

示例
下面的代码显示数组 myList 中的所有元素：

public class TestArray {

   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};

      // Print all the array elements
      for (double element: myList) {
         System.out.println(element);
      }
   }
}
这将产生以下结果:

1.9
2.9
3.4
3.5
将数组传递给方法
正如传递基本类型值的方法，也可以将数组传递给方法。例如，下面的方法显示在一个 int 数组中的元素：

public static void printArray(int[] array) {
  for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + " ");
  }
}
你可以通过传递数组调用它。例如，下面的语句调用方法 PrintArray 显示3，1，2，6，4，2：

printArray(new int[]{3, 1, 2, 6, 4, 2});
从一个方法返回一个数组
一个方法也可以返回一个数组。例如，下面所示的方法返回一个数组，它是另一个数组的反转：

public static int[] reverse(int[] list) {
  int[] result = new int[list.length];

  for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
    result[j] = list[i];
  }
  return result;
}
Arrays 类
java.util.Arrays 中的类包含各种静态方法用于排序和搜索数组、数组的比较和填充数组元素。这些方法为所有基本类型所重载。

SN	方法和描述
1	public static int binarySearch (Object[] a, Object key)
使用二进制搜索算法搜索对象的指定数组（字节，整数，双精度等）来指定值。该数组必须在进行此调用之前进行分类。如果它被包含在列表 (-(insertion point + 1)， 将返回索引搜索关键字。
2	public static boolean equals (long[] a, long[] a2)
如果多头的两个指定数组彼此相等返回true。两个数组认为是相等判定方法：如果两个数组包含相同的元素数目，并在两个数组元素的所有相应对相等。如果两个数组相等，返回true。同样的方法可以用于所有其它的原始数据类型 (Byte, short, Int, etc.)
3	public static void fill(int[] a, int val)
将指定的int值到指定的int型数组中的每个元素。同样的方法可以用于所有其它的原始数据类型(Byte, short, Int etc.)
4	public static void sort(Object[] a)
将对象指定的数组升序排列，根据其元素的自然顺序。同样的方法可以用于所有其它的原始数据类型( Byte, short, Int, etc.)


将一个数组用for循环copy到另一个数组中去
clone
