package cn.gacl.annotation;

/**
 * 此类是用来演示注解(Annotation)的应用的，注解也是JDK1.5新增加的特性之一
 * JDK1.5内部提供的三种注解是：@SuppressWarnings(":deprecation")、@Deprecated、@Override
 * @author 孤傲苍狼
 *
 */
/**
 * 类名的命名是有讲究的，类名、属性名、变量名一般是名词，或者是形容词+名词，方法一般是动词，或者是动词+名词，
 * 以AnnotationTest作为类名和以TestAnnotation作为类名是有区别的，
 * 前者是注解的测试，符合名词的特征，后者是测试注解，听起来就是一个动作名称，是方法的命名特征
 */
public class AnnotationTest {
	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	//这里就是注解，称为压缩警告，这是JDK内部自带的一个注解，一个注解就是一个类，在这里使用了这个注解就是创建了SuppressWarnings类的一个实例对象
	public static void main(String[] args) {
		System.runFinalizersOnExit(true);
		//The method runFinalizersOnExit(boolean) from the type System is deprecated(过时的，废弃的)
		//这里的runFinalizersOnExit()方法画了一条横线表示此方法已经过时了，不建议使用了
	}

	@Deprecated //这也是JDK内部自带的一个注解，意思就是说这个方法已经废弃了，不建议使用了
	public static void sayHello() {
		System.out.println("hi,孤傲苍狼");
	}

	@Override //这也是JDK1.5之后内部提供的一个注解，意思就是要重写(覆盖)JDK内部的toString()方法
	public String toString() {
		return "孤傲苍狼";
	}
}