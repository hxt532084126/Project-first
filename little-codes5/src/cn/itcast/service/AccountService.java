package cn.itcast.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.itcast.dao.AccountOperation;
import cn.itcast.dao.MyException;
import cn.itcast.file.Tool;

public class AccountService {
	public static final Connection conn = Tool.getConnection();
	public static void getPram(String user1, String user2, double money) throws MyException{
		//写事务
			try {
				conn.setAutoCommit(false);
				AccountOperation.getOut(user1,money);
				AccountOperation.getIn(user2,money);
				System.out.println("AccountService to AccountOperation");
				System.out.println("user1 : " + user1 + "  user2 : " + user2 +"  money : " + money);
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
					System.out.println("操作失败,回滚了");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			finally{
				try {
					conn.commit();
					System.out.println("交易成功");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Tool.closeConnection(conn);
			}
	}
}
