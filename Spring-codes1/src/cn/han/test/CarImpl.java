package cn.han.test;

public class CarImpl implements Car {
	private String name;
	private String color;
	
	public CarImpl(String name,String color){
		this.name = name;
		this.color = color;
	}
	public CarImpl(){}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void go() {
		System.out.println("step 7");
	}
	public void start(){
		System.out.println("开始啦");
	}
	public void destory(){
		System.out.println("结束了");
	}
	public String toString() {
		return "CarImpl [name=" + name + ", color=" + color + "]";
	}

}
