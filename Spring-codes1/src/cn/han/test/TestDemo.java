package cn.han.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	@Test
	public void Demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Person p = (Person) applicationContext.getBean("person");
		p.getCar().go();
		applicationContext.close();
	}
}
