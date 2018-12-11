## this关键字
### 一、this关键字
　　

this是一个引用，它指向自身的这个对象。

看内存分析图：



　　假设我们在堆内存new了一个对象，在这个对象里面你想象着他有一个引用this，this指向这个对象自己，所以这就是this，这个new出来的对象名字是什么，我们不知道，不知道也没关系，因为这并不影响这个对象在内存里面的存在，这个对象只要在内存中存在，他就一定有一个引用this。

看下面的例子分析：

复制代码
    package cn.galc.test;
    
    public class Leaf {
    
        int i = 0;
    
        public Leaf(int i) {
            this.i = i;
        }
    
        Leaf increament() {
            i++;
            return this;
        }
    
        void print() {
            System.out.println("i = " + i);
        }
    
        public static void main(String[] args) {
            Leaf leaf = new Leaf(100);
            leaf.increament().increament().print();
        }
    }



在内存中分析main方法的执行过程

首先分析第一句话：Leaf leaf = new Leaf(100);

　　程序执行到这里的时候，栈空间里面有一个变量leaf，它指向了我们new出来的在堆空间里面的Leaf对象。new这个Leaf对象的时候，调用了构造方法Leaf(),这个构造方法里面有一个形参i，所以在栈空间里面给构造方法分配有一小块内存，名字叫i用来装传递过来的实参。这里传过来的实参是100，所以i里面装的值就是100。得到这个值之后，构造方法继续执行，执行this.i = i;这里就是把栈空间里面的i的值通过值传递给Leaf对象里面的成员变量i，所以成员变量i的值也变成了100。内存中的布局如下图所示：

　　

　　构造方法执行完之后，为这个构造方法分配的内存消失，所以栈里面的i所标记的那一小块内存会消失。因此第一句话执行完之后，内存中的布局如下图所示：

　　

接下来分析第二句话：leaf.increament().increament().print();

　　首先逐个分析：leaf.increament()，这里是调用increament()方法，是对new出来的那个Leaf对象调用的，leaf是Leaf对象的引用对象，因此通过这个引用对象来调用increament()方法，即相当于是Leaf对象自己调用了increament()方法。increament()方法的定义如下：

    Leaf increament(){
    　　i++;
    　　return this;
    
    }

　　因此Leaf对象调用increament()方法时，首先执行方法体里面的第一句话i++;这样就把Leaf对象的成员变量i的值由原来的100变成了101。此时的内存布局如下图所示。



　　接下来执行方法体里面的第二句话：return this;

　　这里把this作为返回值，当有返回值的时候，首先会在栈里面给这个返回值分配一小块临时的存储空间。这块存储空间里面的内容是this里面的内容。this指向它自身，所以栈内存里面的那块临时存储空间里面装的this也是指向堆内存里面的Leaf对象。

所以leaf.increament().increament().print();这句话里面的left.increament()这一小句话执行完之后，内存中的布局如下图所示。

　　

　　leaf.increament().increament().print();这句话里面的left.increament()这一小句话执行完之后，返回一个this，此时leaf.increament().increament().print();就相当于是this.increament().print();

　　接着栈里面的存储在临时空间里面的this调用increament()方法，而this指的就是Leaf对象，所以又是Leaf对象调用increament()方法。Leaf对象调用increament()方法时，又会执行方法体里面的i++，所以此时i又由原来的101变成了102。然后又执行return this，所以栈内存里面又多了一块临时存储空间，里面装的值也是this，这个this又是指向堆内存里面的Leaf对象。因此此时这个Leaf对象有了四个指向他自己的引用对象。

　　leaf.increament().increament().print();这句话里面的leaf.increament().increament()这一小句话执行完之后,都返回了一个this，所以此时的leaf.increament().increament().print();就相当于是这样子的：this.this.print(); 

　　接下来又是栈里面的那个新的this调用print()方法，使用this来调用，那就相当于是Leaf对象来调用，Leaf对象自己调用print()方法将自己的i属性的值打印出来，所以打印出来的结果应该是102。  

　　因此main方法里面的整个程序执行完之后，内存中的布局如下图所示：  

　　

　　this的总结：this一般出现在方法里面，当这个方法还没有调用的时候，this指的是谁并不知道。但是实际当中，你如果new了一个对象出来，那么this指的就是当前这个对象。对哪个对象调用方法，this指的就是调用方法的这个对象（你对哪个对象调用这个方法，this指的就是谁）。如果再new一个对象，这个对象他也有自己的this，他自己的this就当然指的是他自己了。  