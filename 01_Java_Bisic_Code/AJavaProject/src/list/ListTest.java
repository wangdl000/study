package list;

import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {



		ArrayList books = new ArrayList(2);


		//向books集合中添加三个元素
		books.add("轻量级Java EE企业应用实战");
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂Android讲义"));
		books.add(null);



		ArrayList books2 = new ArrayList();
		for (String str : books) {
			books2.add(str);
		}


//		ArrayList books2 = books;
//		(ArrayList) books.clone();
		books2.add("");

		System.out.println(books);

		//将新字符串对象插入在第二个位置
		books.add(1, new String("疯狂Ajax讲义"));


		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}

		//删除第三个元素
		books.remove(2);
		System.out.println(books);

		//判断指定元素在List集合中位置：输出1，表明位于第二位
		System.out.println(books.indexOf(new String("疯狂Ajax讲义"))); //①
		//将第二个元素替换成新的字符串对象
		books.set(1, new String("LittleHann"));
		System.out.println(books);

		//将books集合的第二个元素（包括）
		//到第三个元素（不包括）截取成子集合
		System.out.println(books.subList(1, 2));
	}
}