public class UserInfo implements java.io.Serializable {

	//实现serializable接口。
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;

	//无参构造器
	public UserInfo() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//javabean当中可以有其它的方法
	public void userInfoPrint() {
		System.out.println("");
	}
}