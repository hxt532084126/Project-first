package cn.itcast.login.bean;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//这是一个连接池的工具类

public class DataSourceUtils {

	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}

	public static DataSource getDataSource() {
		return cpds;
	}

}
