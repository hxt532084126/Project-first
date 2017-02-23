package cn.han.demo1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class MyService {
	@Autowired
	@Qualifier(value="car")
	private Car car;
	@Autowired
	@Qualifier(value="person")
	private Person person;
	public String toString() {
		return "MyService [car=" + car + ", person=" + person + "]";
	}
	@PostConstruct
	public void start(){
		System.out.println("start");
	}
	@PreDestroy
	public void destory(){
		System.out.println("end");
	}
}
