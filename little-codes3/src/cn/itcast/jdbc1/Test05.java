package cn.itcast.jdbc1;

import java.sql.Connection;

public class Test05 {
	public static void main(String[] args){
		Connection conn = Test02.getConnection();
		System.out.println("done");
	}
}
