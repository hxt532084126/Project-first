package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement s = null;

		// 注册驱动,并获取连接
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql:///mydata", "root","123");
			//设置权限
			conn.setAutoCommit(false);
			// 获取执行句柄
			s = conn.createStatement();
			// 执行操作
			s.executeUpdate("update student set chinese = 1");
		} catch (SQLException e) {
			e.printStackTrace();
			// 数据回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 提交
			// 关闭自动事务
			try {
				conn.commit();
				InitJdbc.closeConnection(conn);
				InitJdbc.closeStatement(s);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
