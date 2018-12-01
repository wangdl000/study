package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestOracleJDBC {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// 1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.获取连接Connection对象
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123");
			String sql = "select * from emp";
			// 3.得到语句PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// 4.遍历结果集
			while (rs.next()) {
				System.out.println(rs.getString("EMPNO") + "\t" + rs.getString("ENAME") + "\t" + rs.getString("MGR")
						+ "\t" + rs.getString("HIREDATE") + "\t" + rs.getString("SAL") + "\t" + rs.getString("COMM")
						+ "\t" + rs.getString("DEPTNO"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// 5.关闭连接，释放资源
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
