## Java常用包

Java的核心类都放在Java包以及其子包下，Java扩展的许多类都放在Javax包以及其子包下。  

这些实用类也就是前面所说的API，Oracle按这些类的功能分别放在不同的包下。  

**下面几个包是Java语言中的常用包：**  

1），java.lang：Java语言的核心类，如String，Math，System和Thread类等，使用这个包下的类无须使用import语句导入，系统会自动导入这个包下的所有类。  

2），java.util：这个包下包含了java的大量工具类、集合框架类和接口，例如Arrays，List，Set。  

3），java.net：网络编程接口和类，以后要写和网络相关的应用就要用这个包。  

4），java.io：流的接口和类，以后要写读写文件或者图片等这些就要用这个包。  

5），java.text：java格式化相关类，以后我们要做软件国际化就要用这个包。  

6），java.sql：jdbc相关接口和类 ，以后操作java连接数据库就要使用到这个包。  

7），java.awt：抽象窗口工具集相关接口和类，搞一个类似于QQ一样的软件，界面就得使用这个包。  

8），java.swing ： 图形用户界面相关接口和类(可跨平台)。  


Java.lang  

1），常用类概述  

JDK API下面是这么描述这个包的，提供利用Java编程语言进行程序设计的基础类。 

最重要的类是 Object（它是类层次结构的根）和 Class（它的实例表示正在运行的应用程序中的类）。 

把基本类型的值当成一个对象来表示通常很有必要。包装器类 Boolean、Character、Integer、Long、Float 和 Double 就是用于这个目的。  

例如，一个Double类型的对象包含了一个类型为 double 的字段，这表示如果引用某个值，则可以将该值存储在引用类型的变量中。这些类还提供了大量用于转换基值的方
法，并支持一些标准方法，比如 equals 和 hashCode。Void 类是一个非实例化的类，它保持一个对表示基本类型 void 的 Class 对象的引用。  

类Math提供了常用的数学函数，比如正弦、余弦和平方根。类似地，类 String 和 StringBuffer 提供了常用的字符串操作。  

类ClassLoader、Process、Runtime、SecurityManager 和 System提供了管理类的动态加载、外部进程创建、主机环境查询（比如时间）和安全策略实施等“系统操作”。  

类 Throwable 包含了可能由 throw 语句抛出的对象。Throwable 的子类表示错误和异常。  

2），异常摘要  

ArithmeticException：当出现异常的运算条件时，抛出此异常。  

IndexOutOfBoundsException：指示某排序索引（例如对数组、字符串或向量的排序）超出范围时抛出，包含下面2个子类。  

ArrayIndexOutOfBoundsException：用非法索引访问数组时抛出的异常。  

StringIndexOutOfBoundsException：此异常由 String 方法抛出，指示索引或者为负，或者超出字符串的大小。  

ArrayStoreException：试图将错误类型的对象存储到一个对象数组时抛出的异常。  

ClassCastException：当试图将对象强制转换为不是实例的子类时，抛出该异常。  

ClassNotFoundException：当应用程序试图使用以下方法通过字符串名加载类时，抛出该异常： Class 类中的 forName 方法。  

CloneNotSupportedException：当调用 Object 类中的 clone 方法复制对象，但该对象的类无法实现 Cloneable 接口时，抛出该异常。  

EnumConstantNotPresentException：当应用程序试图通过名称和枚举类型访问那些不包含具有指定名称的常量的枚举常量时，抛出该异常。  

Exception：Exception 类及其子类是 Throwable 的一种形式，它指出了合理的应用程序想要捕获的条件。  

IllegalAccessException：当应用程序试图反射性地创建一个实例（而不是数组）、设置或获取一个字段，或者调用一个方法，但当前正在执行的方法无法访问指定类、字段、方
法或构造方法的定义时，抛出 IllegalAccessException。  

IllegalArgumentException：抛出的异常表明向方法传递了一个不合法或不正确的参数。    

IllegalMonitorStateException：抛出的异常表明某一线程已经试图等待对象的监视器，或者试图通知其他正在等待对象的监视器而本身没有指定监视器的线程。  

IllegalStateException：在非法或不适当的时间调用方法时产生的信号。  

IllegalThreadStateException：指示线程没有处于请求操作所要求的适当状态时抛出的异常。  

InstantiationException：当应用程序试图使用 Class 类中的 newInstance 方法创建一个类的实例，而指定的类对象无法被实例化时，抛出该异常。  

InterruptedException：当线程在活动之前或活动期间处于正在等待、休眠或占用状态且该线程被中断时，抛出该异常。  

NegativeArraySizeException：如果应用程序试图创建大小为负的数组，则抛出该异常。     

NoSuchFieldException：类不包含指定名称的字段时产生的信号。  

NoSuchMethodException：无法找到某一特定方法时，抛出该异常。  

NullPointerException：当应用程序试图在需要对象的地方使用 null 时，抛出该异常。  

NumberFormatException：当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常。  

RuntimeException：RuntimeException 是那些可能在 Java 虚拟机正常运行期间抛出的异常的超类。  

SecurityException：由安全管理器抛出的异常，指示存在安全侵犯。  

TypeNotPresentException：当应用程序试图使用表示类型名称的字符串对类型进行访问，但无法找到带有指定名称的类型定义时，抛出该异常。  

UnsupportedOperationException：当不支持请求的操作时，抛出该异常。  