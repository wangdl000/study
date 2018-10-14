描述符是你添加到那些定义中来改变他们的意思的关键词。Java 语言有很多描述符，包括以下这些：

可访问描述符
不可访问描述符
应用描述符，你可以在类、方法、变量中加入相应关键字。描述符要先于声明，如下面的例子所示（斜体）：

public class className {
   // ...
}
private boolean myFlag;
static final double weeks = 9.5;
protected static final int BOXWIDTH = 42;
public static void main(String[] arguments) {
   // body of method
}
可访问描述符
Java 提供一系列可访问描述符来设定类，变量，方法和构造器的访问级别。四种访问级别如下：

默认的，对封装可见。不需要描述符。
仅对类可见（private）
全部可见（public）
对封装和子类可见（protected）
不可访问描述符
Java 提供一些不可访问描述符来满足其他功能。
Static 描述符是用来创造类方法和变量的。
Final 描述符用来最终确定和实施类、方法和变量的。
Abstract 描述符用来创造不允许实例化的类和方法。
synchronized 和 volatile 描述符用来当做线的。