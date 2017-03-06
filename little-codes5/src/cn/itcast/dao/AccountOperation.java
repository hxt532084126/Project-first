package cn.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.file.Tool;

public class AccountOperation {
	public static void getOut(String user1, double money)
			throws SQLException, MyException {
		Connection conn = Tool.getConnection();
		// 处理数据
		System.out.println("转出账户: conn :" + user1 + "   money : " + money);
		// 第二种方式(解决sql注入的问题)
		String sql = "update bank set remaindollar = remaindollar - ? where name = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, user1);
		int flag = ps.executeUpdate();

		/*
		 * 第一种方式 获得操作句柄 Statement s = conn.createStatement(); String sql =
		 * "update bank set remaindollar = remaindollar - '"
		 * +money+"'where name = '"+user1+"'"; int flag = s.executeUpdate(sql);
		 */
		System.out.println("转出操作完成");
		if (flag == 0) {
			System.out.println("转出失败");
			throw new MyException("转出失败");
		}
	}

	public static void getIn(String user2, double money)
			throws SQLException, MyException {
		Connection conn = Tool.getConnection();
		// 处理数据
		System.out.println("转出账户: conn :" + user2 + "   money : " + money);
		// 第二种方式(解决sql注入的问题)
		String sql = "update bank set remaindollar = remaindollar + ? where name = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, user2);
		int flag = ps.executeUpdate();

		/*
		 * 第一种方式: 获得操作句柄 Statement s = conn.createStatement(); String sql =
		 * "update bank set remaindollar = remaindollar + '"
		 * +money+"'where name = '"+user2+"'"; int flag = s.executeUpdate(sql);
		 */
		System.out.println("转入操作完成");
		if (flag == 0) {
			System.out.println("转入失败");
			throw new MyException("转入失败");
		}
	}

}
