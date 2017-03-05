package cn.itcast.jdbc1;

public class Test04 {
	public static void main(String[] args){
		try{
			throw new MyException("自定义异常");
		}catch(Exception e){
			System.out.print(e);
		}
	}
}


class MyException extends Exception{
	public MyException(String str){
		super(str);
	}
}
