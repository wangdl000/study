package day03;

class IfDemo {
	public static void main(String[] args) {
		//		System.out.println("Hello World!1");
		//		System.out.println("Hello World!2");
		//		System.out.println("Hello World!3");
		//		System.out.println("Hello World!4");

		/*
		if语句的第一种格式：
		1，
		if(条件表达式)
		{
			执行语句；
		}
		*/

		int x = 1;
		if (x > 1) {

			if (x < 3) {

				System.out.println("yes");

			}
		}

		if (x == 5) {
			System.out.println("no");
		}

		if (x >= 6) {
			System.out.println("666");
		}

		System.out.println("over");

	}
}
