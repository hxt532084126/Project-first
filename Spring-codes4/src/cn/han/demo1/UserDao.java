package cn.han.demo1;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDao extends JdbcDaoSupport{
	public void add(User user){
		String sql = "insert into user values (?,?)";
		this.getJdbcTemplate().update(sql, user.getAge(),user.getName());
	}
}
