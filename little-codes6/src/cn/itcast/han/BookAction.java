package cn.itcast.han;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class BookAction implements Action{
	private String[] books;
	public String[] getBooks() {
		return books;
	}
	public void setBooks(String[] books) {
		this.books = books;
	}
	public String execute() throws Exception {
		String user = (String) ActionContext.getContext().getSession().get("username");
		if(user.equals("han") && user != null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
