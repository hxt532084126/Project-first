package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class InitJdbc {
	public static final String DRIVERCLASSS;
	public static final String URL;
	public static final String USERNAME;
	public static final String PASSWORD;

	// 这里的JdbcStart 指的是那个properties文件
	// 获取properties配置文件中各个对应的值
	static {
		DRIVERCLASSS = ResourceBundle.getBundle("JdbcStart").getString("driverClass");
		URL = ResourceBundle.getBundle("JdbcStart").getString("url");
		USERNAME = ResourceBundle.getBundle("JdbcStart").getString("username");
		PASSWORD = ResourceBundle.getBundle("JdbcStart").getString("password");
	}
	// 加载驱动,定义在静态代码块中,所以只执行
	static {
		try {
			Class.forName(DRIVERCLASSS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("driver");
	}

	// 创建连接
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("connection");
		return con;
	}
	
	
	//关闭操作
		public static void closeConnection(Connection con) throws SQLException{
			if(con!=null){
				con.close();
			}
		}
		public static void closeStatement(Statement st) throws SQLException{
			if(st!=null){
				st.close();
			}
		}
		public static void closeResultSet(ResultSet rs) throws SQLException{
			if(rs!=null){
				rs.close();
			}
		}

}
