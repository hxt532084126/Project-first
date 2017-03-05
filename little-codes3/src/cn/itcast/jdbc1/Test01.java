package cn.itcast.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;





public class Test01 {
	public static void main(String[] args) throws Exception{
		//注册驱动(都是一样的)
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		String url = "jdbc:mysql:///mydata";
		Connection con = DriverManager.getConnection(url, "root", "123");
		//通过连接获取操作sql的语句Statement
		Statement st = con.createStatement();
		//写操作语句
		String x = "select * from student";
		ResultSet rs = st.executeQuery(x);		
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String english = rs.getString("english");
			String chinese = rs.getString("chinese");
			String math = rs.getString("math");
			System.out.println(id + " : " + name  + " : " + english + " : " + chinese  + " : " +math);
		}
		
	}
}
