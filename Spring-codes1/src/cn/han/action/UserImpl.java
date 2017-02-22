package cn.han.action;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class UserImpl implements User,BeanPostProcessor{
	private String info;
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	public void say() {
		System.out.println("user implementation!" + info);
	}
	
	public void setup(){
		System.out.println("对象被初始化了...");
	}
	
	public void teardown(){
		System.out.println("对象被消灭了...");
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("对参数进行校验");
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("再次校验");
		return bean;
	}
}
