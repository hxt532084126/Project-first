package cn.han.demo1;

import org.springframework.beans.factory.annotation.Value;


public class Person {
	@Value(value="25")
	private String age;
	public String toString(){
		return "here is person = "+age;
	}
}
