package cn.itcast.file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Tool {
	public static final String CURL;
	public static final String URL;
	public static final String USERNAME;
	public static final String PASSWORD;
	
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//获取properties文件中的数据,并给全局常量赋值
	
	static{
		CURL = ResourceBundle.getBundle("jdbcTool").getString("curl");
		URL = ResourceBundle.getBundle("jdbcTool").getString("url");
		USERNAME = ResourceBundle.getBundle("jdbcTool").getString("username");
		PASSWORD = ResourceBundle.getBundle("jdbcTool").getString("password");
	}
	
	//注册驱动
	static{
		try {
			System.out.println("Driver");
			Class.forName(CURL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//创建连接
	public static Connection getConnection(){
		Connection con = tl.get();
		if(con == null)
		{
			try {
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				tl.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void closeConnection(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	public static void closeStatement(Statement st){
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeResultSet(ResultSet res){
		if(res != null){
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}















