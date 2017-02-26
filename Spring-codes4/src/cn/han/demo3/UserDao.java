package cn.han.demo3;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDao extends JdbcDaoSupport{
	public void add(User user){
		String sql="insert into user values(?,?)";
		this.getJdbcTemplate().update(sql,user.getName(),user.getSex());
	}
}
