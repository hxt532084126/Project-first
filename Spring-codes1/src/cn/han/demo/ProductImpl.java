package cn.han.demo;

public class ProductImpl implements Product{

	public void say() {
		System.out.println("第9步:调用其中的方法了...");
	}
	
	public void setup(){
		System.out.println("第6步:对象被初始化了...");
	}
	
	public void destroymethod(){
		System.out.println("第11步:对象被消灭了...");
	}

}
