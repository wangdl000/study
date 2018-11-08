import java.util.ArrayList;

public class Control {

	public static void main(String[] args) {

		// 向控制台輸出Hello World !!!!!!
		System.out.println("Hello World !!!!!!");

		int age1 = 10;
		int age2 = 30;

		int outAge1 = age2 / age1;

		int outAge2 = age1 + age2;

		int outAge3 = age1 * age2;

		int outAge4 = age1 - age2;

		System.out.println(outAge1);
		System.out.println(outAge2);
		System.out.println(outAge3);
		System.out.println(outAge4);

		Person p1 = new Person();
		p1.setName("王");

		System.out.println(p1.getName());

		/* *************************************** */
		/* ******* 用JAVA管理【人員信息表】******* */
		/* *************************************** */

		// 案例1：
		String[] strPerson1 = getSamplePerson1();

		//　输出案例1结果
		System.out.println(strPerson1); // 并不能从控制台直接看出结果

		// 輸出數組長度【.length】和各個元素的值
		System.out.println(strPerson1.length);
		System.out.println(strPerson1[0]);
		System.out.println(strPerson1[1]);
		System.out.println(strPerson1[2]);
		System.out.println(strPerson1[3]);
		// + 並不是數值運算的加，用在兩個字符串之間，代表字符串鏈接
		System.out.println(strPerson1[0] + strPerson1[1] + strPerson1[2] + strPerson1[3]);
		// 有格式輸出（字符之间用TAB分割，也可以用\n来换行 另外\r\n等等）
		System.out.println(strPerson1[0] + "\t" + strPerson1[1] + "\t" + strPerson1[2] + "\t" + strPerson1[3]);

		// 有的時候並不能確定數組中是否有值，就需要先判斷數組長度是否滿足預想長度
		if (strPerson1.length > 3) {
			for (int i = 0; i < strPerson1.length; i++) {
				System.out.println("FOR" + i + ":" + strPerson1[i]);
			}
		}

		// 案例2：
		String[][] strPerson2 = getSampleAllPerson2();
		System.out.println(strPerson2[0].length);

		/*
		 * 从案例1，案例2可以看出用数组，尤其是多维数组管理复杂数据
		 * 非常繁琐，而且极易出错
		 * []数组只能管理相同类型的数据，对于不同类型的数据，显然 无能为力
		 * 同时，数组只能管理固定元素个数的数据
		 * 接下来介绍，用对象BEAN和List来管理复杂数据
		 *
		 */
		// 案例3：
		Person person1 = getSamplePerson3();

		System.out.println(person1); // 同样 无法在控制台 直接确认结果
		System.out.println(person1.getName());
		System.out.println(person1.getAge());
		System.out.println(person1.getSex());
		System.out.println(person1.getAdrress());

		// 案例4：
		// 用List 和 对象BEAN 组合 来管理多条数据
		// List可以管理数据条数不固定的数据
		ArrayList<Person> personlist = getSampleAllPerson4();

		// 输出List的条数 结果用DEBUG方式观看
		System.out.println(personlist.size());

		// List的取值方法 同[]数组一样，Java中List的第一条为0
		for (int j = 0; j < personlist.size(); j++) {
			Person p = personlist.get(j);
			System.out.println("第" + (j + 1) + "条：" + p.getName());
			System.out.println("第" + (j + 1) + "条：" + p.getAge());
			System.out.println("第" + (j + 1) + "条：" + p.getSex());
			System.out.println("第" + (j + 1) + "条：" + p.getAdrress());
		}


		// 案例5：
		// 對於案例2那樣 長度固定的複雜數組，可以用枚舉（enum）使之简单化


	}

	/**
	 * 案例1：<br>
	 * 注释的方式3
	 * 填充EXCEL表格中No.1各项信息
	 * @return 人员信息No.1各项信息
	 */
	private static String[] getSamplePerson1() {

		// 注释的方式1 双斜线

		// 定義一個引用參數 strPerson1数组，长度为4
		String[] strPerson1 = new String[4];
		strPerson1[0] = "王";
		strPerson1[1] = "25";
		strPerson1[2] = "男";
		strPerson1[3] = "東京";

		/*
		 * 注释的方式2
		 */

		// 或者如下定义
		/*
		String strPerson1[] = {"王" , "25", "男" , "東京"};
		*/
		// 注意数组中的各个元素的数据的类型必须一致，
		// 如下定义则会出错（25为整数类型）
		// String strPerson1[] = {"王" , 25, "男" , "東京"};

		// 返回一维数组
		return strPerson1;
	}

	/**
	 * 案例2：<br>
	 * 填充EXCEL表格中所有信息
	 * @return 人员信息No.1各项信息
	 */
	private static String[][] getSampleAllPerson2() {
		// 定義三行四列的二維數組，並且直接設定初期值
		String strPerson[][] = {
				{ "王", "25", "男", "東京" },
				{ "Tom", "35", "Man", "Unknow" },
				{ "田中", "45", "女性", "川崎" }
		};

		/*
		 * 或者如下定義
		 */
		String strPerson9[][] = new String[3][4];

		// strPerson9的具體效果請用DEBUG模式觀看,這裡用前一種方式返回
		strPerson9[0][0] = "王";
		strPerson9[0][1] = "25";
		strPerson9[0][2] = "男";
		strPerson9[0][3] = "東京";

		strPerson9[1][0] = "Tom";
		strPerson9[1][1] = "35";
		strPerson9[1][2] = "Man";
		strPerson9[1][3] = "Unknow";

		strPerson9[2][0] = "田中";
		strPerson9[2][1] = "45";
		strPerson9[2][2] = "女性";
		strPerson9[2][3] = "川崎";
		System.out.println(strPerson9);

		return strPerson;
	}

	/**
	 *
	 * 案例4：<br>
	 * 填充EXCEL表格中No.1各项信息
	 * @return 人员信息对象
	 */
	private static Person getSamplePerson3() {
		Person person = new Person();
		person.setName("王");
		person.setAge(25);
		person.setSex("男");
		person.setAdrress("東京");

		return person;
	}

	/**
	 *
	 * 案例4：<br>
	 * 填充EXCEL表格中所有信息
	 * @return 人员信息对象List
	 */
	private static ArrayList<Person> getSampleAllPerson4() {
		// 定义变量：listPerson 类型为 引用数据类型ArrayList，ArrayList的泛型为 引用数据类型 Person
		ArrayList<Person> listPerson = new ArrayList<Person>();
		// 定义参数person 其类型为 引用数据类型 Person
		Person person = new Person();

		person.setName("王");
		person.setAge(25);
		person.setSex("男");
		person.setAdrress("東京");
		// 将赋值后的参数person 添加到List中  第一条
		listPerson.add(person);

		// 将参数person初始化（清空原有值：Q：why？ A：避免过多定义参数占用内存）
		person = new Person();
		person.setName("Tom");
		person.setAge(35);
		person.setSex("Man");
		person.setAdrress("Unknow");
		// 将赋值后的参数person 添加到List中  第二条
		listPerson.add(person);

		person.setName("田中");
		person.setAge(45);
		person.setSex("女性");
		person.setAdrress("川崎");
		// 将赋值后的参数person 添加到List中 第三条
		listPerson.add(person);

		return listPerson;
	}

}
