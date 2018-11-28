import java.math.BigDecimal;
import java.math.RoundingMode;

public class test4 {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("4.5635");

		a = a.setScale(3, RoundingMode.HALF_UP); //保留3位小数，且四舍五入
		System.out.println(a);
	}
}
