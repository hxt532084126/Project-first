package cn.han.demo2;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		System.out.println("before环绕增强");
		Object result = methodInvocation.proceed();
		System.out.println("after环绕增强");
				
		return result;
	}
	
}
