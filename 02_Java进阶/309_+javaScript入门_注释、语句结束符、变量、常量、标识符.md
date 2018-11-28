## javaScript入门 注释、语句结束符、变量、常量、标识符  
### 注释
// 这是单行
/* 这是多行注释*/
语句结束符
JavaScript中，每一个语句的结束都应该使用分号
;
结尾。这是在告诉解释器每段代码的有效范围。
当然，你也可以不在代码结束的位置写上分号
;
，JavaScript会在每一行结束位置自动帮你添加上
有几种特别的情况必须要加上分号。当
同一行存在多条代码分别实现不同的功能时，必须用分号隔开，比如在一行中声明多个变量
如果下面的代码用圆括号放在一起了，上面的代码就必须以分号结束。否则JavaScript会突然那位上面未加分号的代码并没结束，将上下两段不想管的代码链接在一起，导致出错。
console.log('hello')(function (arg){ alert(arg);})('ziawang')// 这种情况下就会报错，js把下面匿名函数与console函数当作一段代码，导致出错
说了这么多，最后其实就是要强调的是，一定要在每段语句结束的时候加上分号。。。
变量
在JavaScript中，定义一个变量必须要对这个变量使用
var
关键字声明
如果声明地变量没有初始化值，那么这个变量值的类型就是
undefined
类型，并且该类型的值只有一个，也是
undefined
格式（不需要声明变量类型）
var 变量名;	// 未初始化变量值var 变量名 = 变量值	// 出事化变量值var 变量名1= 变量值1, 变量名2= 变量值2, 变量名3= 变量值3; // 声明多个变量用逗号隔开，语句以分号结束
变量提升
在ES6中，如果我们在使用
var
关键字初始化一个变量之前调用了这个变量，那么调用这个变量的时候并不会报错，而是会把这个变量值当作
undefined
来对待
举例
console.log(b)	// undefinedvar b ="hello ziawang";console.log(b);	// "hello ziawang"
这就等价于
var b;console.log(b)	// undefinedb ="hello ziawang";console.log(b)	// "hello ziawang"

使用let声明变量
let
与
var
的区别
在for循环中，通过
var
是不能创建一个只存在于for循环代码块中的局部变量的，如果初始条件中的
i
变量是通过
var
关键字声明的，那么该变量在for循环结束之后，在for循环外部仍然可以调用，这就是常说的变量溢出。
使用let关键字解决变量溢出问题
使用let关键字可以在for循环的内存空间中创建一个局部变量，当for循环结束，其内存空间释放的同时，该变量也会被释放。这样既节省了内存空间，又防止了内存溢出
for (var i=0; i <5; i++){ console.log(i);}console.log(i); // 得到6，变量溢出 for (let j =0; j <5; j++){ console.log(j);}console.log(j); // 变量不会溢出，此处会抛出ReferenceError
但是要注意
let
声明得到的变量不存在
变量提升
。也就是说，如果一个变量在其使用
let
关键字声明之前调用，那么就会报错
let
初始化得到的变量，不能再重复定义。意思是，你如果已经在代码中使用
let
声明了一个变量
x
，那么当你再次使用
let
声明一个相同名称的变量
x
的时候，就会抛出错误
解构变量
解构变量
使用起来类似python的闭包
使用注意
前后一定要一致
如果等号右边是一个数组，那么等号的左边也必须使用一个数组来接收，并且用于接收该数组的元素数量不能比数组右边的对象元素个数多（可以少于右边元素的个数）
如果等号的右边是一个对象，在结构的时候左边也必须是一个对象并且需要使用该对象的属性作为解构变量接收对象的value。并且左侧对象中属性的位置可以随意
<script>let arr = [1, 2, 3, 4];let [a, b, c] = arr;console.log(a);console.log(b);console.log(c);let [a1, b1, [c1]] =[1, 2, [4]];console.log(a1);console.log(b1);console.log(c1);let {age, name} = {"name":"ziawang", age:23}console.log(name); // 解构乱序也可以，只要key正确console.log(age)</script>
全局变量
当声明变量时，如果不用
var
关键字，那么得到的变量就是一个全局变量
在JavaScript中，应该尽量使用局部变量代替全局变量
因为全局变量在调用过程中会降低js代码运行的效率。
理由： 待补充
常量
在JavaScript中可以使用关键字
const
来定义常量，该关键字定义的常量具有块级作用域
所谓块级作用域，其实可以简单理解为局部作用域，比如使用for循环时，如果在for循环内通过
const
创建了一个常量，那么这个常量的有效范围即是该for循环代码块，当for循环运行结束的时候，该常量会随着for循环内存空间的释放而释放
for (let i =0; i <5; i++){ constPI=3.141592653; console.log(PI);}console.log(PI); // 抛出ReferenceError错误
标识符
大部分编程语言的表示符规范基本都是一样的
JavaScript表示符规范如下
标识符由数字、字母、下划线、
$
组成
标识符不能以数字开头
标识符的名称要与要表达的对象相符
标识符不能与JavaScript内置的关键字（js中称为保留字）相同
关于布尔值
在JavaScript中，
null undefined 0 NAN 空字符串 空数据对象（空列表、空Map的等）
视为false