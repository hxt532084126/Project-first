package cn.han.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAction {
	public static void main(String[] args){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyService service = (MyService) applicationContext.getBean("myService");
		System.out.println(service);
		applicationContext.close();
	}
}
