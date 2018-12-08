package list;

import java.util.ArrayDeque;

public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque stack = new ArrayDeque();
		//依次将三个元素push入"栈"
		stack.push("疯狂Java讲义");
		stack.push("轻量级Java EE企业应用实战");
		stack.push("疯狂Android讲义");

		//输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
		System.out.println(stack);

		//访问第一个元素，但并不将其pop出"栈"，输出：疯狂Android讲义
		System.out.println(stack.peek());

		//依然输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
		System.out.println(stack);

		//pop出第一个元素，输出：疯狂Android讲义
		System.out.println(stack.pop());

		//输出：[疯狂Java讲义, 轻量级Java EE企业应用实战]
		System.out.println(stack);
	}
}