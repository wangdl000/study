一般情况下，当我们处理字符时，我们用原始数据类型 char。

示例
char ch = 'a';

// Unicode for uppercase Greek omega character
char uniChar = '\u039A'; 

// an array of chars
char[] charArray ={ 'a', 'b', 'c', 'd', 'e' };
然而在开发中，我们会遇到需要使用对象而不是原始数据类型的情况。为了达到这个需求。Java 为原始数据类型 char 提供了包装类 Character。

Character 类为操控字符提供了一系列有用处的类（例如：静态类）。你可以借助 Character 构造函数创造一个 Character 对象。

Character ch = new Character('a');
Java 编译器也将能在某些情况下为你创造一个 Character 对象。例如：如果你将一个原始 char 传输到一个可预期对象的方法，编译器就会为你自动将 char 转化成 Character。 如果转换从反方向进行，这个特点被称之为自动装箱或拆箱。

示例
// Here following primitive char 'a'
// is boxed into the Character object ch
Character ch = 'a';

// Here primitive 'x' is boxed for method test,
// return is unboxed to char 'c'

char c = test('x');
转义序列
有反斜杠（\）在前的字符是一个转义序列并且对于编译器有特殊的意义。

换行符(\n)在 System.out.println() 语句中经常使用，在字符串打印出来后换行。

以下的表格展示了 Java 转义序列：

转义序列	描述
\t	在文本中插入一个标签。
\b	在文本中插入一个退格。
\n	在文本中插入一个换行符。
\r	在文本中插入一个回车。
\f	在文本中插入一个换页。
\'	在文本中插入一个单引号字符。
\\	在文本中插入一个反斜杠字符。
当一个转义序列遇到一个打印语句，编译器就会相应地解译。

示例
如果你想把引号放入引号内，必须使用转义序列, \” ,在内部引用:

public class Test {

   public static void main(String args[]) {
      System.out.println("She said \"Hello!\" to me.");
   }
}
这将产生以下结果：

She said "Hello!" to me.
Character 方法
以下列表是实现 Character 类所有子类的重要的实例方法：

SN	方法描述
1	isLetter() 
确定具体的char值是一个字母
2	isDigit() 
确定具体的char值是一个数字
3	isWhitespace()
确定具体的char值是一个空格
4	isUpperCase()
确定具体的char值是一个大写字母
5	isLowerCase()
确定具体的char值是一个小写字母
6	toUpperCase()
返回指定字符值的大写形式
7	toLowerCase()
返回指定字符值的小写写形式
8	toString()
返回代表指定的字符值的一个String对象,即一个字符的字符串
若想查看完整的方法，请参阅 java.lang.Character API 规范。