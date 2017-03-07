package cn.itcast.login.service;

import java.sql.SQLException;

import cn.itcast.login.bean.User;
import cn.itcast.login.dao.DaoLogin;

public class LoginService {
	DaoLogin dao = new DaoLogin();
	public User operateLogin(String username, String password) throws SQLException {
		//将username, password的信息传递到dao中
		return dao.operateLogin(username,password);
	}
}
