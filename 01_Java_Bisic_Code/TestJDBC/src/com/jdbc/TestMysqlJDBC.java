package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMysqlJDBC {
	int aaa = 0;

	private static final String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&"
			+ "characterEncoding=UTF8";
	private static final String username = "root";
	private static final String password = "gel1";

	public static void main(String[] args) {
		Connection conn = null;




		PreparedStatement ps = null;


		ResultSet rs = null;
		try {
			// 1.加载mysql驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取连接对象
			conn = DriverManager.getConnection(url, username, password);

			String sql = "select * from sys_user";
			// 3.通过连接对象获得ps语句
			ps = conn.prepareStatement(sql);



			rs = ps.executeQuery();

			// 4.遍历结果集
			while (rs.next()) {
				System.out.println(rs.getInt("user_id") + "\t"
						+ rs.getString("user_code") + "\t" + rs.getString("user_name") + "\t"
						+ rs.getString("user_password") + "\t" + rs.getString("user_state"));
			}

//			List<Person> aaa = new ArrayList<>();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			// 3.finally语句块中释放资源
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
