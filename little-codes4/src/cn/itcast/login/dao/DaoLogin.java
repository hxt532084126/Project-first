package cn.itcast.login.dao;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.login.bean.DataSourceUtils;
import cn.itcast.login.bean.User;

public class DaoLogin {

	public User operateLogin(String username, String password) throws SQLException {
		//从获得连接池,设置查询语句,调用runner语句,执行查询操作
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		return runner.query(sql, new BeanHandler<User>(User.class), username,password);
	}
}
