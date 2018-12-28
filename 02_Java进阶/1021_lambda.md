## Lambda & Stream

https://www.cnblogs.com/franson-2016/p/5593080.html

stream。  
【Java 8系列之Stream的基本语法详解 - 有容乃大 - 博客园】https://www.cnblogs.com/mrhgw/p/9171883.html



## Java Lambda
### Lambda表达式的语法
  - 基本语法:  
(parameters) -> expression  
或  
(parameters) ->{ statements; }  

  - 下面是Java lambda表达式的简单例子:  
  
    // 1. 不需要参数,返回值为 5  
    () -> 5  
    
    // 2. 接收一个参数(数字类型),返回其2倍的值  
    x -> 2 * x  
    
    // 3. 接受2个参数(数字),并返回他们的差值  
    (x, y) -> x – y  
    
    // 4. 接收2个int型整数,返回他们的和  
    (int x, int y) -> x + y  
    
    // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
    (String s) -> System.out.print(s)

  - 基本的Lambda例子  
  如下lambda表达式编码的方式。  
  假设有一个玩家List ,程序员可以使用 for 语句 ("for 循环")来遍历,在Java SE 8中可以转换为另一种形式:  

    String[] atp = {"Rafael Nadal", "Novak Djokovic",  
       "Stanislas Wawrinka",  
       "David Ferrer","Roger Federer",  
       "Andy Murray","Tomas Berdych",  
       "Juan Martin Del Potro"};  
    List<String> players =   Arrays.asList(atp);  
    
    // 以前的循环方式  
    for (String player : players) {  
         System.out.print(player + "; ");  
    }  
    
    // 使用 lambda 表达式以及函数操作。  (functional operation)  
    players.forEach((player) -> System.out.print(player + "; "));  
    
    // 在 Java 8 中使用双冒号操作符(double colon operator)  
    players.forEach(System.out::println);

从上边的代码可以看出lambda表达式的特点，**极大程度缩减代码**。  

  - 在图形用户界面程序中,匿名类可以使用lambda表达式来代替。  
  
    // 使用匿名内部类  
    btn.setOnAction(new EventHandler<ActionEvent>() {  
          @Override  
          public void handle(ActionEvent event) {  
              System.out.println("Hello World!");   
          }  
    });  
   
    // 或者使用 lambda expression  
    btn.setOnAction(event -> System.out.println("Hello World!"));

  - lambdas 来实现 Runnable接口 的示例:  
    // 1.1使用匿名内部类  
new Thread(new Runnable() {  
    @Override  
    public void run() {  
        System.out.println("Hello world !");  
    }  
}).start();  
  
// 1.2使用 lambda expression  
new Thread(() -> System.out.println("Hello world !")).start();  
  
// 2.1使用匿名内部类  
Runnable race1 = new Runnable() {  
    @Override  
    public void run() {  
        System.out.println("Hello world !");  
    }  
};  
  
// 2.2使用 lambda expression  
Runnable race2 = () -> System.out.println("Hello world !");  
   
// 直接调用 run 方法(没开新线程哦!)  
race1.run();  
race2.run();



    