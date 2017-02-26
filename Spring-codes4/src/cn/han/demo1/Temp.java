package cn.han.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Temp {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	@Test
	public void tt(){
		User user = new User();
		user.setAge("12");
		user.setName("han");
		userDao.add(user);
	}
}
