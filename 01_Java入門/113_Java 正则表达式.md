Java 提供了 java.util.regex 包来与正则表达式进行模式匹配。Java 正则表达式和 Perl 编程语言非常相似，也容易学习。

正则表达式是一个特殊的字符序列，有助于你用一种专门的语法模式来匹配或找到其他字符串或字符串集。他们可以用来搜索编辑或是操纵文本和数据。

java.util.regex 包主要包含了下面的三个类：

Pattern 类:一个 Pattern 对象是正则表达式编译表示。 Pattern 类没有提供公共的构造函数。要创建一个 Pattern 对象，你必须首先调用他的公用静态编译方法来获得 Pattern 对象。这些方法的第一个参数是正则表达式。

Matcher 类:一个 Matcher 对象是用来解释模式和执行与输入字符串相匹配的操作。和 Pattern 类一样 Matcher 类也是没有构造方法的，你需要通过调用 Pattern 对象的 matcher 方法来获得 Matcher 对象。

PatternSyntaxException: 一个 PatternSyntaxException 对象是一个不被检查的异常，来指示正则表达式中的语法错误。
捕获组
捕获组是一种将多个字符抽象为一个处理单元的方法。他们通过用括号将字符分组来创建。举个例子，正则表达式（dog）创建一个组包含字符 "d","o"和"g"。

捕获组通过从左向右计算括号的个数来进行计数。在正则表达式((A)(B(C)))中，这里有四个组：

((A)(B(C)))

(A)

(B(C))

(C)
为了在表达式中计算有多少个组，可以调用 matcher 对象中的 groupCount 方法。 groupCount 方法返回一个 int 类型来显示正则表达式中的捕获组的数量。

这里也有特殊的组，组0总是代表了整个表达式。这个组不包含在 groupCount 负责的所有组内。

示例
下面的例子展现了如何从给定的字符数字串中找出数字串

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    public static void main( String args[] ){

      // String to be scanned to find the pattern.
      String line = "This order was placed for QT3000! OK?";
      String pattern = "(.*)(\\d+)(.*)";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find( )) {
         System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
      } else {
         System.out.println("NO MATCH");
      }
   }
}
这将会得到下面的结果

Found value: This order was placed for QT3000! OK?
Found value: This order was placed for QT300
Found value: 0
正则表达式语法
这里的表格记录了 java 中可用的所有正则表达式的元字符语法：

子表达式	匹配对应
^	匹配一行的开头
$	匹配一行的结尾
.	匹配除了换行符的任何单个字符，也可以利用 m 选项允许它匹配换行符
[...]	匹配括号内的任意单个字符。
[^...]	匹配不在括号内的任意单个字符。
\A	整个字符串的开始
\z	整个字符串的结束
\Z	整个字符串的结束，除了最后一行的结束符
re*	匹配0或者更多的前表达事件
re+	匹配1个或更多的之前的事件
re?	匹配0或者1件前表达事件
re{ n}	匹配特定的n个前表达事件
re{ n,}	匹配n或者更多的前表达事件
re{ n, m}	匹配至少n最多m件前表达事件
a| b	匹配a或者b
(re)	正则表达式组匹配文本记忆
(?: re)	没有匹配文本记忆的正则表达式组
(?> re)	匹配无回溯的独立的模式
\w	匹配单词字符
\W	匹配非单词字符
\s	匹配空格。等价于 [\t\n\r\f]
\S	匹配非空格
\d	匹配数字. 等价于 [0-9]
\D	匹配非数字
\A	匹配字符串的开始
\Z	匹配字符串的末尾，如果存在新的一行，则匹配新的一行之前
\z	匹配字符串的末尾
\G	匹配上一次匹配结束的地方
\n	返回参考捕获组号“N”
\b	不在括号里时匹配单词边界。在括号里时匹配退格键
\B	匹配非词边界
\n, \t, etc.	匹配换行符，回车符，制表符，等
\Q	引用字符的初始，结束于\E
\E	结束由\Q开始的引用
Matcher 类的方法
这里列出了有用的实例方法

index 方法
index方法提供有用的指标值，精确地显示输入字符串中相匹配的位置：

SN	方法描述
1	public int start() 
返回之前匹配开始索引
2	public int start(int group)
返回被之前匹配操作得出的组捕获的子序列
3	public int end()
返回在最后一个字符匹配之后的偏移量
4	public int end(int group) 
返回在之前匹配操作得出的组捕获的子序列之后的偏移量
Study 方法
Study 方法根据输入字符串返回一个布尔类型数据来指示该模式是否被找到。

SN	方法描述
1	public boolean lookingAt() 
试图匹配输入序列，从模式的起始位置开始
2	public boolean find() 
试图找到下一个输入序列的子序列来进行模式匹配
3	public boolean find(int start）
重置匹配，并且试图找到下一个从某个特定位置开始的输入序列的子序列来进行模式匹配
4	public boolean matches() 
试图去匹配模式的整个区域
Replacement 方法
Replacement 方法是在一个输入字符串中替换文本的有效方法。

SN	方法描述
1	public Matcher appendReplacement(StringBuffer sb, String replacement)
实现一个无目的的添加和代替步骤
2	public StringBuffer appendTail(StringBuffer sb)
实现一个有目的的添加和代替步骤
3	public String replaceAll(String replacement) 
代替每一个输入序列的子序列，与给出的代替字符串的模式匹配
4	public String replaceFirst(String replacement) 
代替第一个输入序列的子序列，与给出的代替字符串的模式匹配
5	public static String quoteReplacement(String s)
返回一个特定字符串逐字替换的字符串。这个方法产生了一个字符串将作为文本替换的 Matcher 类的 appendreplacement 方法
start 和 end 方法
下面是一个例子，计算 "cats" 在输入字符串中出现的次数：

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT =
                                    "cat cat cat cattie cat";

    public static void main( String args[] ){
       Pattern p = Pattern.compile(REGEX);
       Matcher m = p.matcher(INPUT); // get a matcher object
       int count = 0;

       while(m.find()) {
         count++;
         System.out.println("Match number "+count);
         System.out.println("start(): "+m.start());
         System.out.println("end(): "+m.end());
      }
   }
}
这是产生的结果：

Match number 1
start(): 0
end(): 3
Match number 2
start(): 4
end(): 7
Match number 3
start(): 8
end(): 11
Match number 4
start(): 19
end(): 22
你可以看到这个例子用次边界来确保字母 "c""a""t" 不仅仅是一个长单词子串。它也给出了一些关于在输入字符串中匹配位置的有用的信息。

start方法返回值是之前end方法返回值加1。

matches 和 lookingAt 方法
matches 和 lookingAt 方法都是按照一定的模式匹配输入序列，两种方法不同的是 matches 方法需要匹配整个输入序列，找出其中不同的。

两种方法都总是开始于输入字符串的起始位置。这里是一个例子：

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main( String args[] ){
       pattern = Pattern.compile(REGEX);
       matcher = pattern.matcher(INPUT);

       System.out.println("Current REGEX is: "+REGEX);
       System.out.println("Current INPUT is: "+INPUT);

       System.out.println("lookingAt(): "+matcher.lookingAt());
       System.out.println("matches(): "+matcher.matches());
   }
}
这是产生的结果：

Current REGEX is: foo
Current INPUT is: fooooooooooooooooo
lookingAt(): true
matches(): false
replaceFirst 方法和 replaceAll 方法
replaceFirst 和 replaceAll 方法替换了匹配给定正则表达式的文本。正如它们的名字所表明的，replaceFirst 替换第一个情况，而 replaceAll 替换所有的情况。

这里是解释功能的例子：

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. " +
                                    "All dogs say meow.";
    private static String REPLACE = "cat";

    public static void main(String[] args) {
       Pattern p = Pattern.compile(REGEX);
       // get a matcher object
       Matcher m = p.matcher(INPUT); 
       INPUT = m.replaceAll(REPLACE);
       System.out.println(INPUT);
   }
}
以上将会产生如下结果：

The cat says meow. All cats say meow.
appendReplacement 和 appendTail 方法
Matcher 类还提供了 appendReplacement 和 appendTail 两种方法来替换文本。

这里是解释功能的例子：

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
   private static String REGEX = "a*b";
   private static String INPUT = "aabfooaabfooabfoob";
   private static String REPLACE = "-";
   public static void main(String[] args) {
      Pattern p = Pattern.compile(REGEX);
      // get a matcher object
      Matcher m = p.matcher(INPUT);
      StringBuffer sb = new StringBuffer();
      while(m.find()){
         m.appendReplacement(sb,REPLACE);
      }
      m.appendTail(sb);
      System.out.println(sb.toString());
   }
}
以上将会产生如下结果：

-foo-foo-foo-
PatternSyntaxException Class 方法
PatternSyntaxException 是一个未检查的、在正则表达式模式指示语法错误的特例。PatternSyntaxException 类提供了以下的方法来帮助你找出问题所在：

SN	方法描述
1	public String getDescription()
检索错误的描述
2	public int getIndex() 
检索误差指标
3	public String getPattern() 
检索错误的正则表达式模式
4	public String getMessage() 
返回一个包含语法错误的描述及其指标的多行字符串、错误的正则表达式模式以及显示模式里误差指标