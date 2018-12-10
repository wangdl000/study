## equals方法介绍

### 一、equals方法介绍


1.1.通过下面的例子掌握equals的用法

复制代码
    package cn.galc.test;
    
    public class TestEquals {
        public static void main(String[] args) {
            /**
             * 这里使用构造方法Cat()在堆内存里面new出了两只猫，
             * 这两只猫的color，weight，height都是一样的，
             * 但c1和c2却永远不会相等，这是因为c1和c2分别为堆内存里面两只猫的引用对象，
             * 里面装着可以找到这两只猫的地址，但由于两只猫在堆内存里面存储在两个不同的空间里面，
             * 所以c1和c2分别装着不同的地址，因此c1和c2永远不会相等。
             */
            Cat c1 = new Cat(1, 1, 1);
            Cat c2 = new Cat(1, 1, 1);
            System.out.println("c1==c2的结果是："+(c1==c2));//false
            System.out.println("c1.equals(c2)的结果是："+c1.equals(c2));//false
        }
    }
    
    class Cat {
        int color, weight, height;
    
        public Cat(int color, int weight, int height) {
            this.color = color;
            this.weight = weight;
            this.height = height;
        }
    }
复制代码
1.2.画出内存分析图分析c1和c2比较的结果

程序：

Cat c1 = new Cat(1,1,1);

Cat c2 = new Cat(1,1,1);

执行完之后内存之中的布局如下图所示，



　　c1指向一个对象，c2也指向一个对象，c1和c2里面装着的是这两只Cat对象在堆内存里面存储的地址，由于这两只Cat对象分别位于不同的存储空间，因此c1和c2里面装着的地址肯定不相等，因此c1和c2这两个引用对象也肯定不相等。因此执行：“System.out.println(c1==c2);”打印出来的结果肯定是false。因此你new出来了两个对象，你放心，这两个对象的引用永远不一样，一样的话就会把其中一个给覆盖掉了，这个可不成。c1是不是等于c2比较的是c1和c2这两个引用里面装着的内容，因为new出来的两个对象的它们的引用永远不一样，因此c1和c2这两个引用的内容也永远不一样，因此c1永远不可能等于c2。因此通过比较两个对象的引用是永远无法使得两个对象相等的，一模一样的。

　　要想判断两个对象是否相等，不能通过比较两个对象的引用是否相等，这是永远都得不到相等的结果的，因为两个对象的引用永远不会相等，所以正确的比较方法是直接比较这两个对象，比较这两个对象的实质是不是一样的，即这两个对象里面的内容是不是相同的，通过比较这两个对象的属性值是否相同而决定这两个对象是否相等。

　　Object类提供了一个equals()方法来比较两个对象的内容是否相同，因此我们可以采用这个方法去比较两个对象是否在逻辑上“相等”。如：c1.equals(c2);这里是调用从Object类继承下来的equals()方法，通过查阅API文档得到Object类里的equals方法的定义如下：  

public boolean equals(Object obj)  

　　在Object这个类里面提供的Equals()方法默认的实现是比较当前对象的引用和你要比较的那个引用它们指向的是否是同一个对象，即和“c1==c2”这种写法是一样的，“c1.equals(c2)”与“c1==c2”是完全等价的。因此直接使用继承下来的equals()方法也是无法直接比较两个对象的内容是否相同的，为此，我们必须得重写equals()方法，改变这个方法默认的实现。  

下面在Cat类里面重写这个继承下来的equals()方法：  


    class Cat {
        int color, weight, height;
    
        public Cat(int color, int weight, int height) {
            this.color = color;
            this.weight = weight;
            this.height = height;
        }
        
        /**
         * 这里是重写相等从Object类继承下来的equals()方法，改变这个方法默认的实现，
         * 通过我们自己定义的实现来判断决定两个对象在逻辑上是否相等。
         * 这里我们定义如果两只猫的color，weight，height都相同，
         * 那么我们就认为这两只猫在逻辑上是一模一样的，即这两只猫是“相等”的。
         */
        public boolean equals(Object obj){
            if (obj==null){
                return false;
            }
            else{
                /**
                 * instanceof是对象运算符。
                 * 对象运算符用来测定一个对象是否属于某个指定类或指定的子类的实例。
                 * 对象运算符是一个组合单词instanceof。
                 * 该运算符是一个双目运算符，其左边的表达式是一个对象，右边的表达式是一个类，
                 * 如果左边的对象是右边的类创建的对象，则运算结果为true，否则为false。
                 */
                if (obj instanceof Cat){
                    Cat c = (Cat)obj;
                    if (c.color==this.color && c.weight==this.weight && c.height==this.height){
                        return true;
                    }
                }
            }
            return false;
        }
    }
复制代码
此时在再main方法里面执行打印的命令：

    public static void main(String[] args) {
            /**
             * 这里使用构造方法Cat()在堆内存里面new出了两只猫，
             * 这两只猫的color，weight，height都是一样的，
             * 但c1和c2却永远不会相等，这是因为c1和c2分别为堆内存里面两只猫的引用对象，
             * 里面装着可以找到这两只猫的地址，但由于两只猫在堆内存里面存储在两个不同的空间里面，
             * 所以c1和c2分别装着不同的地址，因此c1和c2永远不会相等。
             */
            Cat c1 = new Cat(1, 1, 1);
            Cat c2 = new Cat(1, 1, 1);
            System.out.println("c1==c2的结果是："+(c1==c2));//false
            System.out.println("c1.equals(c2)的结果是："+c1.equals(c2));//true
        }


　　这一次得到的结果就与上次没有重写equals()方法时得到的结果就不一样了：

　　“System.out.println(c1 == c2);”打印出来的结果依然是false，因为这里是比较两个对象的引用里面的内容，这两个引用里面的内容当然不相等，而且永远不会相等，所以打印出来的结果肯定是false。

　　“System.out.println(c1.equals(c2));”打印出来的结果为true，因为我们在Cat类里面重写了equals()方法，改变了这个方法默认的实现，我们把方法的实现改为只要这个两个对象是真的存在，并且都是猫，并且它们的颜色(color)，身高(height)和体重(weight)都相同，那么这两只猫在逻辑上就是一模一样的，是完全相同的两只猫，即这两只猫是“相等”的。所以这里打印出来的结果是true。

1.3.如何比较两个字符串对象是否相等？

看下面的例子：

复制代码
    public class TestEquals {
        
        public static void main(String args[]){
            String s1 = new String("hello");
            String s2 = new String("hello");
            System.out.println("s1 == s2的结果是："+(s1 == s2));//false
            System.out.println("s1.equals(s2)的结果是："+s1.equals(s2));//true
        }
    }
复制代码
这一次是比较两个字符串对象是否相等：

　　System.out.println(s1 == s2);

　　打印出来的结果依然是fase，因为这里比较的是s1和s2两个字符串对象的引用，两个对象的引用永远不会相等，所以打印出来的结果为false。

　　System.out.println(s1.equals(s2));

　　打印出来的结果为true，因为在String类里面重写了从Object类继承(所有的类都是从Object类继承下来，String类当然也不例外，从父类继承下来就拥有了父类的一切属性与方法，所以Sting类里面也有equals()方法，并且还把这个继承下来的equals()方法重写了)下来的equals()方法，改变了这个方法默认的实现，

　　在String类里面是这样重写equals()方法的实现的：用当前的这个字符串对象和指定的字符串对象比较，指定的字符串对象不能为空并且这个对象的字符序列和当前这个字符串对象的字符串序列一样，如果这些条件都满足，那么这两个字符串对象就是相等的。

因此这里的s2已经满足了条件，所以打印出来的结果是true。

　　以后在某一个类里面比较两个对象是否相等时，首先去API文档里面查找这个类是否重写了从Object类继承下来的equals()方法。如果重写了equals()方法，那么在比较两个对象是否相等时调用的就是重写以后的equals()方法，如果没有重写，那么调用时就是直接调用从Object类里面的继承下来的那个equals()方法，并且采用equals()方法默认的实现去比较两个对象是否相等。因此每一个类都可以根据需要对从Object类继承下来的equals()方法进行重写。

　　对于在API文档里面找某个类，如果一个类不用引入包就可以直接使用，那么这个类肯定是在java.lang这个包里面，如这里的String类，直接就可以使用了，所以String类一定是在java.lang这个包里面。使用某个类时看这个类引入的是哪个包，然后就去这个包里面找这个类，不用引入包的类一定是位于java.lang里面，直接去java.lang里面找就可以了。 

　　总结：比较两个对象是否相等，我们采用equals()方法，判断两个对象是否相等的条件是由我们重写equals()方法的实现后定义的，这样就可以比较灵活地使用equals()方法在不同的类里面比较位于同一类下的两个对象是否相等了。   