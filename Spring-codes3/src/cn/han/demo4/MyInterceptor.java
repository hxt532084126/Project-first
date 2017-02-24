package cn.han.demo4;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class MyInterceptor implements MethodBeforeAdvice{
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("前置增强...");
	}
}
