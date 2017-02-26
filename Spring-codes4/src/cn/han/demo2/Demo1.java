package cn.han.demo2;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Demo1 {
	@Test
	public void test(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///data1");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		//然后使用jdbcTemplate模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "create table user(age int,name varchar(30));";
		jdbcTemplate.execute(sql);
	}
}
