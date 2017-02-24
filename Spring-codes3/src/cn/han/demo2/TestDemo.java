package cn.han.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext2.xml")
public class TestDemo {
	@Autowired
	@Qualifier("orderProxy")
	private OrderImpl oo;

	@Test
	public void tt(){
		oo.order1();
		oo.order2();
	}
	
}
