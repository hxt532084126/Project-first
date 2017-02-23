package cn.han.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDemo {
	@Autowired
	@Qualifier("customerProxy")
	private CustomerDao customerDao;
	
	@Test
	public void tt(){
		customerDao.add();
		customerDao.delete();
	}
	
}
