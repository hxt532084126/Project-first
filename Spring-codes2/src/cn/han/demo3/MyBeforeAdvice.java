package cn.han.demo3;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice{

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("funciton accelerate!");
	}

}
