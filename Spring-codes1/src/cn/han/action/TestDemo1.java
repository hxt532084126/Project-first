package cn.han.action;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.han.demo.Product;

/**
 * 
 * @ClassName: TestDemo1
 * @Description: Spring Example
 * @author Heaven
 * @date 2017-2-22 下午1:47:32
 * @version v1.0
 */

public class TestDemo1 {

	// demo1
	// first model
	public static void Demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		User service = (User) applicationContext.getBean("user");
		service.say();
	}

	// demo2
	// change the configure

	@Test
	public void Demo2() {
		// 先获取配置文件()
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 然后加入配置信息
		User serviceUser = (User) applicationContext.getBean("user");
		serviceUser.say();
	}
	
	@Test
	public void Demo3() {
		// 先获取配置文件()---从磁盘中读取
		// ApplicationContext applicationContext = new
		// FileSystemXmlApplicationContext(
		// "C:/applicationContext.xml");
		
		//从指定的配置文件位置中读取
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 然后加入配置信息
		User serviceUser = (User) applicationContext.getBean("user");
		serviceUser.say();
	}
	
	
	@Test
	public void Demo4(){
		 ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 然后加入配置信息
		Product serviceUser = (Product) applicationContext.getBean("product");
		serviceUser.say();
		applicationContext.close();
	}
}









