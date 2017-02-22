package cn.han.demo;

import org.junit.Test;
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









