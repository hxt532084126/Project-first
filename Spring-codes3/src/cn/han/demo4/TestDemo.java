package cn.han.demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext4.xml")
public class TestDemo {
	@Autowired
	@Qualifier("orderDao")
	private OrderDao orderDao;
	
	@Autowired
	@Qualifier("customerDao")
	private CustomerDao customerDao;
	
	@Test
	public void tt(){
		orderDao.add();
		customerDao.add();
		orderDao.delete();
		customerDao.delete();
	}

}
