import java.math.BigDecimal;

public class test3 {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("4.5");
		BigDecimal b = new BigDecimal("0");

		System.out.println("a + b =" + a.add(b));
		System.out.println("a - b =" + a.subtract(b));
		System.out.println("a * b =" + a.multiply(b));
		System.out.println("a / b =" + a.divide(b));
	}
}
