package day06;

import java.util.ArrayList;

/*
人：
属性：
	年龄。

行为：
	说话。

*/

/*
private:私有，是一个权限修饰符。用于修饰成员。
		私有的内容只在本类中有效。

注意：私有仅仅是封装的一种体现而已。


*/
class Person {
	private /*私有*/int age;

	public void setAge(int a)//setXxx getXxx
	{
		age = a;
	}

	public int getAge() {
		return age;
	}

	//	/*
	public void haha(int a) {
		if (a > 0 && a < 130) {
			age = a;
			speak();
		} else
			System.out.println("错误的数据");
	}

	//	*/
	void speak() {
		System.out.println("age=" + age);
	}
}

class PersonDemo {
	public static void main(String[] args) {

		PersonDemo demo1 = new PersonDemo();

		String abcd = demo1.selectSort();

		System.out.print(abcd);
		System.out.print(abcd);
		System.out.print(abcd);
		System.out.print(abcd);

		System.out.println("aaaa");

		System.out.println(abcd);

		Person p = new Person();
		//		p.age = -20;
		p.haha(-20);
		//		p.speak();
		int[] arr = null;

		PersonDemo demo = new PersonDemo();
		int ccc = demo.selectSort(arr);

		//		int bbb = PersonDemo.selectSort(arr);

		//		PersonDemo.selectSort(1);
		String ddd = selectSort();
	}

	public static String selectSort() {

        String[] str = new String[1];

//		@SuppressWarnings("rawtypes")
		ArrayList collection2 = new ArrayList();
		collection2.add("");


		ArrayList<Integer> collection3 = new ArrayList<Integer>();
		collection3.add(1);


		String rtn = "我实在富川";


		String rtn1 = "我实在富川";


		if (rtn1.equals(rtn)) {

		}
		int aa = rtn1.compareTo(rtn);


		if (rtn == rtn1) {


		}
		int a = 0;

		if (a == 1) {
			return "我不是富川";
		}
		else {

		}

		return rtn;
	}

	public int selectSort(int[] arr) {

		int aaa = 0;
		return aaa;
	}

	private static void swap(int[] arr, int a, int b) {
	}
}
