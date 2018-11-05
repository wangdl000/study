package day03;

class OperateDemo5 {
	public static void main(String[] args) {

		int x = 0, y;

		y = (x > 1) ? 100 : 200;
		System.out.println("y=" + y);

		int a = 1;
		int b = 2;
		//获取两个整数中的较大的整数。
		int max = a > b ? a : b;

		int o = 2;
		int p = 3;
		int q = 4;
		//获取三个整数中的较大的整数。
		int temp = o > p ? o : p;
		int max2 = temp > q ? temp : q;

	}
}
