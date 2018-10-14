字符串，它被广泛应用于 Java 编程，是一个字符序列。在 Java 编程语言中，字符串是对象。

Java 平台提供了 String 类来创建和操作字符串。

创建字符串
最直接的方式来创建一个字符串是这样写的：

String greeting = "Hello world!";
当你创建一个字符串时，编译器在这种情况下用它的值创建一个 String 对象，如："Hello world!'。

任何其他对象可以通过使用 new 关键字，并通过构造函数创建 String 对象。 String 类有11种构造函数提供使用不同类型的字符串的初始值，如一个字符数组。

public class StringDemo{

   public static void main(String args[]){
      char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.'};
      String helloString = new String(helloArray);  
      System.out.println( helloString );
   }
}
这将产生以下结果：

hello.
注 String 类是不可变的，因此，一旦创建了 String 对象那么是不能改变的。如果需要大量修改字符的字符串，那么应该使用 StringBuffer & StringBuilder 类。

String 长度
用于获取有关对象的信息的方法称为存取方法。可以和字符串一起使用的一个存取方法是 length() ，它返回包含在字符串对象中的字符数。

下面的两行代码被执行之后，len 等于17：

public class StringDemo {

   public static void main(String args[]) {
      String palindrome = "Dot saw I was Tod";
      int len = palindrome.length();
      System.out.println( "String Length is : " + len );
   }
}
这将产生以下结果:

String Length is : 17
连接字符串
String类包括用于连接两个字符串的方法：

string1.concat(string2);
这返回一个新的字符串，即在 string1 结尾处添加 string2。还可以使用 concat（）方法连接字符串，如：

"My name is ".concat("Zara");
字符串更常使用 “ + ” 运算符连接在一起，如：

"Hello," + " world" + "!"
这将产生：

"Hello, world!"
看看下面的例子：

public class StringDemo {

   public static void main(String args[]) {
      String string1 = "saw I was ";
      System.out.println("Dot " + string1 + "Tod");
   }
}
这将产生以下结果:

Dot saw I was Tod
创建格式化字符串
已经有 printf() 和 format() 方法来打印输出格式的数字。 String 类有一个等价的方法 format()，它返回一个 String 对象，而不是一个 PrintStream 对象。

使用字符串的静态 format() 方法允许创建可重复使用的格式化字符串，而不是一次性的 print 语句。例如，如果代替以下方法：

System.out.printf("The value of the float variable is " +
                  "%f, while the value of the integer " +
                  "variable is %d, and the string " +
                  "is %s", floatVar, intVar, stringVar);
可以这样写：

String fs;
fs = String.format("The value of the float variable is " +
                   "%f, while the value of the integer " +
                   "variable is %d, and the string " +
                   "is %s", floatVar, intVar, stringVar);
System.out.println(fs);
String 方法
这里是由 String 类支持的方法列表：

SN	方法及描述
1	char charAt(int index) 
返回指定索引处的字符。
2	int compareTo(Object o) 
将这个字符串与另一个对象比较。
3	int compareTo(String anotherString)
比较两个字符串的字典顺序。
4	int compareToIgnoreCase(String str) 
比较两个字符串按字典顺序，不区分大小写的差异。
5	String concat(String str)
将指定的字符串串连到这个字符串的结尾。
6	boolean contentEquals(StringBuffer sb) 
返回true当且仅当该字符串代表相同的字符序列作为指定的StringBuffer。
7	static String copyValueOf(char[] data) 
返回表示所指定的数组中的字符序列的字符串。
8	static String copyValueOf(char[] data, int offset, int count)
返回表示所指定的数组中的字符序列的字符串。
9	boolean endsWith(String suffix) 
测试此字符串是否以指定的后缀结束。
10	boolean equals(Object anObject)
比较此字符串与指定的对象。
11	boolean equalsIgnoreCase(String anotherString)
比较这个字符串到另一个字符串，忽略大小写的考虑。
12	byte getBytes() 
将此String解码使用平台的默认字符集，并将结果存储到一个新的字节数组中的字节序列。
13	byte[] getBytes(String charsetName
将此String解码使用指定的字符集的字节序列，并将结果存储到一个新的字节数组。
14	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
从这个字符串复制字符到目标字符数组。
15	int hashCode()
为这个字符串返回一个哈希代码。
16	int indexOf(int ch) 
返回此字符串指定字符第一次出现处的索引。
17	int indexOf(int ch, int fromIndex) 
返回索引这个字符串中指定字符第一次出现处，指定索引处开始搜索。
18	int indexOf(String str)
返回此字符串指定子字符串的第一次出现处的索引。
19	int indexOf(String str,int fromIndex)
返回这个字符串中指定子字符串的第一次出现处的索引，从指定的索引处开始。
20	String intern()
返回字符串对象的规范化表示。
21	int lastIndexOf(int ch) 
返回此字符串指定字符最后一次出现处的索引。
22	int lastIndexOf(int ch, int fromIndex) 
返回此字符串指定字符最后一次出现处的索引，从指定索引开始向后搜索。
23	int lastIndexOf(String str)
返回此字符串指定子字符串的最右边出现处的索引。
24	int lastIndexOf(String str, int fromIndex) 
返回索引这个字符串中指定子字符串的最后出现处，从指定的索引开始处向后搜索。
25	int length() 
返回此字符串的长度。
26	boolean matches(String regex)
判断此字符串是否与给定的正则表达式匹配。
27	boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) 
测试两个字符串的区域等于。
28	boolean regionMatches(int toffset, String other, int ooffset, int len)
测试两个字符串的区域都是相等的。
29	String replace(char oldChar, char newChar)
返回从newChar更换oldChar所有出现在此字符串中产生一个新的字符串。
30	String replaceAll(String regex, String replacement
替换此字符串中给定的正则表达式与给定替换相匹配的每个子字符串。
31	String replaceFirst(String regex, String replacement) 
替换此字符串匹配给定的正则表达式给定替换第一个子字符串。
32	String[] split(String regex) 
分割围绕给定的正则表达式匹配的这个字符串。
33	String[] split(String regex, int limit) 
分割围绕给定的正则表达式匹配的这个字符串。
34	boolean startsWith(String prefix)
测试此字符串是否以指定的前缀开头。
35	boolean startsWith(String prefix, int toffset)
测试此字符串是否以指定索引开始的指定前缀开始。
36	CharSequence subSequence(int beginIndex, int endIndex)
返回一个新的字符序列，这个序列的子序列。
37	String substring(int beginIndex)
返回一个新的字符串，它是此字符串的一个子字符串。
38	String substring(int beginIndex, int endIndex)
返回一个新的字符串，它是此字符串的一个子字符串。
39	char[] toCharArray() 
这个字符串转换为一个新的字符数组。
40	String toLowerCase()
将所有在此字符串中的字符使用默认语言环境的规则小写。
41	String toLowerCase(Locale locale)
将所有在此字符串中的字符使用给定Locale的规则小写。
42	String toString()
这个对象（它已经是一个字符串！）返回字符串形式（这里是自己本身）。
43	String toUpperCase() 
使用默认语言环境的规则将此String中所有的字符转换为大写。
44	String toUpperCase(Locale locale) 
使用给定Locale的规则将此String中所有的字符转换为大写。
45	String trim() 
返回字符串的一个副本，开头和结尾的空格去除。
46	static String valueOf(primitive data type x) 
返回传递的数据类型参数的字符串表示形式。
