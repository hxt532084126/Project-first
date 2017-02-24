package cn.han.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestDemo {
	@Autowired
	@Qualifier("customerProxy")
	private Customer customer;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Test
	public void tt(){
		customer.add();
		customer.delete();
	}
}
