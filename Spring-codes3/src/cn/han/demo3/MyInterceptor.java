package cn.han.demo3;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyInterceptor implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("功能被前置增强了...");
	}

}
