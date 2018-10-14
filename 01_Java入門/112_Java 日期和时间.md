Java 在 java.util 包中提供了 Date 类，这个类封装了当前的日期和时间。

Date 类支持两种构造函数。第一个构造函数初始化对象的当前日期和时间。

Date( )
下面的构造函数接收一个参数等于自1970年1月1日午夜起已经过的毫秒数

Date(long millisec)
一旦有一个可用的日期对象，可以调用以下任何一种支持的方法使用时间：

SN	方法和描述
1	boolean after(Date date)
如果调用Date对象包含或晚于指定的日期则返回true，否则，返回false。
2	boolean before(Date date)
如果调用Date对象包含或早于日期指定的日期返回true，否则，返回false。
3	Object clone( )
重复调用Date对象。
4	int compareTo(Date date)
调用对象的值与日期比较。如果这两个值相等返回0。如果调用对象是早于日期返回一个负值。如果调用对象迟于日期返回正值。
5	int compareTo(Object obj)
以相同的compareTo(Date)操作 如果obj是一个类日期。否则，它会抛出一个ClassCastException。
6	boolean equals(Object date)
如果调用Date对象包含相同的时间及日期指定日期则返回true，否则，返回false。
7	long getTime( )
返回自1970年1月1日起已经过的毫秒数。
8	int hashCode( )
返回调用对象的哈希代码。
9	void setTime(long time)
设置所指定的时间，这表示从1970年1月1日从午夜的时间和日期以毫秒为单位经过的时间。
10	String toString( )
调用Date对象转换为字符串，并返回结果。
获取当前日期和时间
在 Java 中容易得到当前的日期和时间。可以使用一个简单的 Date 对象的 toString() 方法，如下所示打印当前日期和时间：

import java.util.Date;

public class DateDemo {
   public static void main(String args[]) {
       // Instantiate a Date object
       Date date = new Date();

       // display time and date using toString()
       System.out.println(date.toString());
   }
}
这将产生以下结果:

Mon May 04 09:51:52 CDT 2009
日期比较
有以下三种方式来比较两个日期：

可以使用 getTime() 来获得自1970年1月1日午夜十二时起已经过的毫秒数，然后比较两个对象的值。
可以使用 before( ), after( ), 和 equals( ) 方法，由于12日在18日前，例如， new Date(99, 2, 12).before(new Date (99, 2, 18)) 返回值为 true。
可以使用 compareTo() 方法，这是由 Comparable 接口定义，由 Date 实现。
使用 SimpleDateFormat 格式化日期
SimpleDateFormat 是一个具体的类，以本地方式用于格式化和转换日期。SimpleDateFormat 允许选择用户定义的模式为日期时间格式。例如：

import java.util.*;
import java.text.*;

public class DateDemo {
   public static void main(String args[]) {

      Date dNow = new Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

      System.out.println("Current Date: " + ft.format(dNow));
   }
}
这将产生以下结果:

Current Date: Sun 2004.07.18 at 04:14:09 PM PDT
简单的 DateFormat 格式代码
要指定时间格式，使用时间模式字符串。在这个模式中，所有的 ASCII 字母被保留为模式字母，其定义如下：

字符	描述	例子
G	时代指示器	AD
y	四位数年份	2001
M	年中的月份	July or 07
d	月份中日期	10
h	时间 A.M./P.M.(1~12)	12
H	天中的小时 (0~23)	22
m	小时中的分钟	30
s	分钟中的秒钟	55
S	毫秒	234
E	星期中的天	Tuesday
D	年中的天	360
F	月中星期中的天	2 (second Wed. in July)
w	年中的星期	40
W	月中的星期	1
a	A.M./P.M. 标记	PM
k	天中的小时(1~24)	24
K	小时A.M./P.M. (0~11)	10
z	时区	东部标准时间
'	脱离文本	分隔符
"	单引号	`
用 printf 格式化日期
日期和时间格式用 printf 方法可以非常轻松地做到。可以使用两个字母的格式，从 t 开始并在下面给出的表格中的其中一个字母结束。例如：

import java.util.Date;

public class DateDemo {

  public static void main(String args[]) {
     // Instantiate a Date object
     Date date = new Date();

     // display time and date using toString()
     String str = String.format("Current Date/Time : %tc", date );

     System.out.printf(str);
  }
}
这将产生以下结果:

Current Date/Time : Sat Dec 15 16:37:57 MST 2012
如果提供日期多次格式化是一种不好的做法。一个格式字符串可以指示要格式化的参数的索引。
索引必须紧跟在 ％ 之后，并必须由 $ 终止。例如：

import java.util.Date;

public class DateDemo {

   public static void main(String args[]) {
       // Instantiate a Date object
       Date date = new Date();

       // display time and date using toString()
       System.out.printf("%1$s %2$tB %2$td, %2$tY", 
                         "Due date:", date);
   }
}
这将产生以下结果:

Due date: February 09, 2004
或者，也可以使用 < 标志。则表示相同的参数，根据前述格式规范，应再次使用。例如：

import java.util.Date;

public class DateDemo {

   public static void main(String args[]) {
       // Instantiate a Date object
       Date date = new Date();

       // display formatted date
       System.out.printf("%s %tB %<te, %<tY", 
                         "Due date:", date);
   }
}
这将产生以下结果:

Due date: February 09, 2004
日期和时间转换字符
字符	描述	例子
c	完整的日期和时间	Mon May 04 09:51:52 CDT 2009
F	ISO 8601 日期	2004-02-09
D	U.S. 格式时间 (月/日/年)	02/09/2004
T	24-时制	18:05:19
r	12-时制	06:05:19 pm
R	24-时制，无秒	18:05
Y	四位数年份 (用前行零列)	2004
y	年份的后两位数(用前行零列)	04
C	年份的前两位(用前行零列)	20
B	完整月份名称	February
b	缩写月份名称	Feb
m	两位数月份 (用前行零列)	02
d	两位数日期 (用前行零列)	03
e	两位数日期(无前行零列)	9
A	完整星期名称	Monday
a	缩写星期名称	Mon
j	年中的三位数天数(用前行零列)	069
H	两位数小时(用前行零列), 00 和 23之间	18
k	两位数小时(无前行零列), 0 和 23 之间	18
I	两位数小时 (用前行零列), 01和12之间	06
l	两位数小时 (无前行零列), 1 和12之间	6
M	两位数分钟 (用前行零列)	05
S	两位数秒钟(用前行零列)	19
L	三位数毫秒（用前行零列)	047
N	九位数纳秒 (用前行零列)	047000000
P	大写上下午标记	PM
p	小写上下午标记	pm
z	RFC 822 从GMT数字抵消	-0800
Z	时区	PST
s	从 1970-01-01 00:00:00 的秒数GMT	1078884319
Q	从 1970-01-01 00:00:00 的毫秒数GMT	1078884319047
有相关的日期和时间等有用的类。欲了解更多详细信息，可以参考 Java 标准文档。

字符串转换日期
SimpleDateFormat 类有一些额外的方法，如 parse()，它试图根据存储在给定 SimpleDateFormat 的对象的格式来转换字符串。例如：

import java.util.*;
import java.text.*;

public class DateDemo {

   public static void main(String args[]) {
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 

      String input = args.length == 0 ? "1818-11-11" : args[0]; 

      System.out.print(input + " Parses as "); 

      Date t; 

      try { 
          t = ft.parse(input); 
          System.out.println(t); 
      } catch (ParseException e) { 
          System.out.println("Unparseable using " + ft); 
      }
   }
}
上述程序的运行示例将产生以下结果：

$ java DateDemo
1818-11-11 Parses as Wed Nov 11 00:00:00 GMT 1818
$ java DateDemo 2007-12-01
2007-12-01 Parses as Sat Dec 01 00:00:00 GMT 2007
休眠一段时间
你可以进行任何期间的时间休眠，从一毫秒直到你的电脑的整个生命周期。例如，下面的程序会休眠10秒：

import java.util.*;

public class SleepDemo {
   public static void main(String args[]) {
      try { 
         System.out.println(new Date( ) + "\n"); 
         Thread.sleep(5*60*10); 
         System.out.println(new Date( ) + "\n"); 
      } catch (Exception e) { 
          System.out.println("Got an exception!"); 
      }
   }
}
这将产生以下结果:

Sun May 03 18:04:41 GMT 2009

Sun May 03 18:04:51 GMT 2009
测量执行时间
有时候，可能需要测量的时间点以毫秒为单位。因此，让我们再一次重新写上面的例子:

import java.util.*;

public class DiffDemo {

   public static void main(String args[]) {
      try {
         long start = System.currentTimeMillis( );
         System.out.println(new Date( ) + "\n");
         Thread.sleep(5*60*10);
         System.out.println(new Date( ) + "\n");
         long end = System.currentTimeMillis( );
         long diff = end - start;
         System.out.println("Difference is : " + diff);
      } catch (Exception e) {
         System.out.println("Got an exception!");
      }
   }
}
这将产生以下结果:

Sun May 03 18:16:51 GMT 2009

Sun May 03 18:16:57 GMT 2009

Difference is : 5993
GregorianCalendar 类
GregorianCalendar 是一个 Calendar 类具体的实现，即你所熟悉的对正常 Gregorian 公历的实现。本教程中不讨论 Calendar 类，可以看看标准 Java 文档。

Calendar 的 getInstance() 方法返回与当前日期和时间默认语言环境和时区初始化的一个 GregorianCalendar。 GregorianCalendar 中定义了两个字段：AD 和 BC。这些代表在公历中定义的两个时代。

也有几个构造函数的 GregorianCalendar 对象：

SN	构造函数描述
1	GregorianCalendar() 
在默认时区与默认语言环境使用当前时间构造默认的GregorianCalendar。
2	GregorianCalendar(int year, int month, int date) 
在默认时区设置默认的语言环境用给定的日期构造一个GregorianCalendar
3	GregorianCalendar(int year, int month, int date, int hour, int minute) 
用给定的日期和时间设置为与默认语言环境的默认时区构造一个GregorianCalendar。
4	GregorianCalendar(int year, int month, int date, int hour, int minute, int second) 
用给定的日期和时间设置为与默认语言环境的默认时区构造一个 GregorianCalendar
5	GregorianCalendar(Locale aLocale) 
基于当前时间与给定语言环境的默认时区构建一个GregorianCalendar。
6	GregorianCalendar(TimeZone zone) 
基于当前时间，使用默认的语言环境在给定的时区构建一个GregorianCalendar。
7	GregorianCalendar(TimeZone zone, Locale aLocale) 
基于当前时间与给定语言环境的给定时区构建一个GregorianCalendar。
这里是由 GregorianCalendar 类提供的一些有用的方法的列表：

SN	方法和描述
1	void add(int field, int amount) 
基于日历的规则，以给定的时间字段添加指定（有符号的）时间量。
2	protected void computeFields() 
将UTC转换为毫秒时间字段值.
3	protected void computeTime() 
覆盖日历转换时间域值为UTC的毫秒.
4	boolean equals(Object obj) 
这个GregorianCalendar与一个对象引用比较.
5	int get(int field) 
获取给定时间域的值.
6	int getActualMaximum(int field) 
返回该字段可能的最大值，给定到当前的日期.
7	int getActualMinimum(int field) 
返回该字段可能具有的最小值，给定当前的日期.
8	int getGreatestMinimum(int field) 
对于给定的字段中返回高最低值（如果有变化）.
9	Date getGregorianChange() 
获取公历更改日期.
10	int getLeastMaximum(int field) 
对于给定的字段返回最低的最大值，如果有变化.
11	int getMaximum(int field) 
返回给定字段中的最大值.
12	Date getTime() 
获取日历的当前时间.
13	long getTimeInMillis() 
获取日历的当前时间长.
14	TimeZone getTimeZone() 
获取时区.
15	int getMinimum(int field) 
返回给定字段中的最小值.
16	int hashCode() 
重写hashCode.
17	boolean isLeapYear(int year) 
确定给定年份是闰年.
18	void roll(int field, boolean up) 
加上或减去（上/下）的时间在给定的时间字段一个单元，不更改更大的字段.
19	void set(int field, int value) 
设置时间字段与给定值.
20	void set(int year, int month, int date) 
设置为年，月，日的值.
21	void set(int year, int month, int date, int hour, int minute) 
设置为年，月，日，小时和分钟值.
22	void set(int year, int month, int date, int hour, int minute, int second) 
设置为字段的年，月，日，小时，分钟和秒的值.
23	void setGregorianChange(Date date) 
设置GregorianCalendar更改日期.
24	void setTime(Date date) 
设置日历的当前时间与给定日期.
25	void setTimeInMillis(long millis) 
从给定long值设置日历的当前时间.
26	void setTimeZone(TimeZone value) 
将时区设置与给定的时区值.
27	String toString() 
返回此日历的字符串表示形式.
示例
import java.util.*;

public class GregorianCalendarDemo {

   public static void main(String args[]) {
      String months[] = {
      "Jan", "Feb", "Mar", "Apr",
      "May", "Jun", "Jul", "Aug",
      "Sep", "Oct", "Nov", "Dec"};

      int year;
      // Create a Gregorian calendar initialized
      // with the current date and time in the
      // default locale and timezone.
      GregorianCalendar gcalendar = new GregorianCalendar();
      // Display current time and date information.
      System.out.print("Date: ");
      System.out.print(months[gcalendar.get(Calendar.MONTH)]);
      System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
      System.out.println(year = gcalendar.get(Calendar.YEAR));
      System.out.print("Time: ");
      System.out.print(gcalendar.get(Calendar.HOUR) + ":");
      System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
      System.out.println(gcalendar.get(Calendar.SECOND));

      // Test if the current year is a leap year
      if(gcalendar.isLeapYear(year)) {
         System.out.println("The current year is a leap year");
      }
      else {
         System.out.println("The current year is not a leap year");
      }
   }
}
这将产生以下结果:

Date: Apr 22 2009
Time: 11:25:27
The current year is not a leap year