package cn.itcast.han;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class FunctionDemo implements Action {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		if(username.equals("han") && password.equals("5857")){
			ActionContext.getContext().getSession().put("username", username);  //设置session值
			ActionContext.getContext().getSession().put("password", password);  
			return LOGIN;
		}else{
			return ERROR;
		}
		
	}
}
