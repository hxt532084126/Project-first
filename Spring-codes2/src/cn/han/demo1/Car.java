package cn.han.demo1;

import org.springframework.beans.factory.annotation.Value;


public class Car {
	@Value(value="pasate")
	private String name;
	public String toString(){
		return "here is Car = " + name;
	}
}
