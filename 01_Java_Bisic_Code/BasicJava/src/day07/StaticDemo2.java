package day07;


class Person3
{
	private String name;
	private int age;
	static String country = "CN";
	public Person3(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	public void show()
	{
		System.out.println(Person3.country+":"+this.name+":"+this.age);
	}

	public static void method()
	{
		System.out.println(Person3.country);
	}
}

class StaticDemo2
{
	public static void main(String[] args) throws Exception
	{
		Thread.sleep(5000);
		Person3.method();

		Person3 p = new Person3("java",20);
		p.show();
	}
}
