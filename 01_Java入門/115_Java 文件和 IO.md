在 Java 中 java.io 包含的每一个类几乎都要进行输入和输出操作。所有的这些流代表一个输入源和输出目的地。在 java.io 包中支持许多数据，如原语，对象，本地化字符等等。

流可以被定义为一个序列的数据。输入流用来从一个源中读数据，输出流用来向一个目的地写数据。

Java 提供了强大且灵活的有关文件和网络的 I/O 功能，但本教程涵盖的是非常基础的流和 I/O 操作。我们可以看到一个接一个的最基本的例子。

字节流
Java 字节流是用来处理8比特字节的输入和输出。尽管有许多的有关字节流的类，但是最常用的是 FileInputStream 类和 FileOutputStream 类。下面是一个例子，作用是用这两个类来完成把一个输入文件的内容复制到输出文件:

import java.io.*;

public class CopyFile {
   public static void main(String args[]) throws IOException
   {
      FileInputStream in = null;
      FileOutputStream out = null;

      try {
         in = new FileInputStream("input.txt");
         out = new FileOutputStream("output.txt");

         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      }finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}
接下来我们需要有一个文件 input.txt ，内容如下：

This is test for copy file.
下一步，编译上面的程序并执行它，结果会创建一个文件叫做 output.txt，它的内容和上面的 input.txt 内容是一样的。所以让我们将上面的代码放入 CopyFile.java 文件，然后进行如下操作：

$javac CopyFile.java
$java CopyFile
字符流
Java 字节流是用来处理8比特字节的输入和输出，Java 字符流用于处理16位 unicode 的输入和输出。尽管这里有许多关于字符流的类，但最常用的类是， FileReader 和 FileWriter。虽然在内部 FileReader 还是使用 FileInputStream 和 FileWriter 使用 FileOutputStream，但是主要的区别是 FileReader 和 FileWriter 一次读写两个字节。

我们能够重写上面的例子来完成把一个输入文件（包含 unicode 字符）的内容复制到输出文件:

import java.io.*;

public class CopyFile {
   public static void main(String args[]) throws IOException
   {
      FileReader in = null;
      FileWriter out = null;

      try {
         in = new FileReader("input.txt");
         out = new FileWriter("output.txt");

         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      }finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}
接下来我们需要有一个文件 input.txt ，内容如下：

This is test for copy file.
下一步，编译上面的程序并执行它，结果会创建一个文件叫做 output.txt，它的内容和上面的 input.txt 内容是一样的。所以让我们将上面的代码放入CopyFile.java文件，然后进行如下操作：

$javac CopyFile.java
$java CopyFile
标准流
所有的编程语言都提供了对标准 I/O 流的支持，即用户可以从自己的键盘上进行输入，并且从屏幕上输出。如果你了解 C 或 C++ 编程语言，那你一定知道三种标准输入输出 STDIN, STDOUT 和 STDERR。同样的 Java 也提供了以下的三种标准流：

Standard Input：这是用来将数据反馈给用户的程序，通常键盘作为标准输入流并且表示为 System.in。
Standard Output：这是用于输出用户程序产生的数据，通常电脑屏幕作为标准输出流，并且表示为 System.out。
Standard Error: 这是用来输出用户产生的错误数据，通常电脑屏幕作为标准错误流，并且表示为 System.err。
下面是一个示例程序用来创建一个 InputStreamReader 来读标准输入流直到用户输入字符 "q"：

import java.io.*;

public class ReadConsole {
   public static void main(String args[]) throws IOException
   {
      InputStreamReader cin = null;

      try {
         cin = new InputStreamReader(System.in);
         System.out.println("Enter characters, 'q' to quit.");
         char c;
         do {
            c = (char) cin.read();
            System.out.print(c);
         } while(c != 'q');
      }finally {
         if (cin != null) {
            cin.close();
         }
      }
   }
}
让我们把上面的代码放到 ReadConsole.java 中并且用如下方法编译执行它。这个程序将不断地读写相同的字符直到我们按下 "q"。

$javac ReadConsole.java
$java ReadConsole
Enter characters, 'q' to quit.
1
1
e
e
q
q
读写文件
像我们之前描述的，一个流可以定义为一个序列的数据。 输入流用来从一个源中读数据，输出流用来向一个目的地写数据。

这里是相关类的层次来表示输入和输出流：

image

两个重要的流是 FileInputStream 和 FileOutputStream，我们将会在本教程中讨论。

文件输入流
这个流是用来从文件中读数据的。对象能够通过用关键字 new 来创建，并且这里有很多可用的不同类型的构造函数。

下面的构造函数以文件名的字符串为参数来创建一个输入流对象去读文件。

InputStream f = new FileInputStream("C:/java/hello");
下面的构造函数需要以一个文件对象作为参数来去创建一个输入流对象去读文件，首先我们用 File() 方法来去创建一个文件对象：

File f = new File("C:/java/hello");
InputStream f = new FileInputStream(f);
一旦你有了一个输入流对象，这里将有很多的提供帮助的方法来进行读操作或是其他在流中的操作。

SN	方法描述
1	public void close() throws IOException{} 
这个方法关闭文件输出流。释放有关文件的所有系统资源。抛出IO异常。
2	protected void finalize()throws IOException {}
这个方法会切断和文件的连接。确保这个文件输出流的关闭方法在这个流没有引用的时候才会被调用。抛出IO异常。
3	public int read(int r)throws IOException{}
这个方法从InputStream 中读到特定字节数的数据。返回一个int类型。返回下一个字节的数据或是在文件末尾时返回-1。
4	public int read(byte[] r) throws IOException{} 
这个方法是从输入流中读 r 个长度字节到数组中。返回所有读到的字节数，或是在文件末尾时返回-1。
5	public int available() throws IOException{} 
给出能从输入流中读到的字节数，返回一个int类型数据。
文件输出流
FileOutputStream 是用来创建一个文件，并向其中写入数据。如果之前没有该文件，该流会在打开流之前创建一个文件。

这里是两个能够产生 FileOutputStream 对象的构造函数。

下面的构造函数以文件名的字符串作为参数来创建一个输出流对象去写文件：

OutputStream f = new FileOutputStream("C:/java/hello")
下面的构造函数需要以一个文件对象作为参数来去创建一个输出流对象去写文件，首先我们用 File() 方法来去创建一个文件对象：

File f = new File("C:/java/hello");
OutputStream f = new FileOutputStream(f)
一旦你有了一个输出流对象，这里将有很多的提供帮助的方法来进行写操作或是其他在流中的操作。

SN	方法描述
1	public void close() throws IOException{} 
这个方法关闭文件输出流。释放有关文件的所有系统资源。抛出IO异常。
2	protected void finalize()throws IOException {}
这个方法会切断和文件的连接。确保这个文件输出流的关闭方法在这个流没有引用的时候才会被调用。抛出IO异常。
3	public void write(int w)throws IOException{} 
这个方法用来写特定的字节到输出流。
4	public void write(byte[] w)
从字节数组中写 w 长度字节到输出流。
示例
下面是一个例子来演示 InputStream 和 OutputStream：

import java.io.*;

public class fileStreamTest{

   public static void main(String args[]){

   try{
      byte bWrite [] = {11,21,3,40,5};
      OutputStream os = new FileOutputStream("test.txt");
      for(int x=0; x < bWrite.length ; x++){
         os.write( bWrite[x] ); // writes the bytes
      }
      os.close();

      InputStream is = new FileInputStream("test.txt");
      int size = is.available();

      for(int i=0; i< size; i++){
         System.out.print((char)is.read() + "  ");
      }
      is.close();
   }catch(IOException e){
      System.out.print("Exception");
   }    
   }
}
上面的代码将产生 test.txt 文件并且以二进制格式写入给出的数字。同样将在 stdout 屏幕输出。

文件导航和 I/O
这里我们需要查看很多类来去了解文件导航和I/O。

File Class
FileReader Class
FileWriter Class
Java目录
目录是一个文件可以包含其他文件和目录的列表。你想要在目录中列出可用文件列表，可以通过使用 File 对象创建目录，获得完整详细的能在 File 对象中调用的以及有关目录的方法列表。

创建目录
这里有两个有用的文件方法，能够创建目录：

mkdir( ) 方法创建了一个目录，成功返回 true ，创建失败返回 false。失败情况是指文件对象的路径已经存在了,或者无法创建目录,因为整个路径不存在。
mkdirs( ) 方法创建一个目录和它的上级目录。
以下示例创建 “/ tmp / user / java / bin” 目录:

import java.io.File;

public class CreateDir {
   public static void main(String args[]) {
      String dirname = "/tmp/user/java/bin";
      File d = new File(dirname);
      // Create directory now.
      d.mkdirs();
  }
}
编译并执行以上代码创建 “/ tmp /user/ java / bin”。

提示：Java 自动按 UNIX 和 Windows 约定来处理路径分隔符。如果在 Windows 版本的 Java 中使用正斜杠(/),仍然可以得到正确的路径。

目录列表
如下，你能够用 File 对象提供的 list() 方法来列出目录中所有可用的文件和目录

import java.io.File;

public class ReadDir {
   public static void main(String[] args) {

      File file = null;
      String[] paths;

      try{      
         // create new file object
         file = new File("/tmp");

         // array of files and directory
         paths = file.list();

         // for each name in the path array
         for(String path:paths)
         {
            // prints filename and directory name
            System.out.println(path);
         }
      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
      }
   }
}
基于你/ tmp目录下可用的目录和文件，将产生以下结果：

test1.txt
test2.txt
ReadDir.java
ReadDir.class