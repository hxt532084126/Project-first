package cn.han.action;

import cn.han.service.BookService;
import cn.han.vo.Book;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @ClassName: BookAction
 * @Description: this is a class of storing book infomation(name and price)
 * @author Heaven
 * @date 2017-2-27 下午4:10:23
 * @version v1.0
 * 
 */
public class BookAction extends ActionSupport implements ModelDriven<Book> {
	
	private Book book = new Book();
	//getModel could help developers to save the book inner information as an object 
	//encapsulate the certain object
	public Book getModel() {
		return book;
	}
	
	private BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	/*
	 * success ： 表示请求处理成功，该值也是默认值。
	 * error ：表示请求处理失败。
	 * none ：表示请求处理完成后不跳转到任何页面。
	 * input ：表示输入时如果验证失败应该跳转到什么地方。
	 * login ：表示登录失败后跳转的目标。
	 * 
	 */
	public String add(){
		System.out.println("web layer...");
		return NONE;
	}
	
	
	
}
