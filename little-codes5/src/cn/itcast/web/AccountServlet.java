package cn.itcast.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.dao.MyException;
import cn.itcast.service.AccountService;

public class AccountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("text/html;charset=UTF-8");
		//将数据全部获得打包发给service
		String user1 = request.getParameter("account1");
		String user2 = request.getParameter("account2");
		double money = Double.parseDouble(request.getParameter("dollar"));
		
		//调用service方法传参数过去
		try {
			AccountService.getPram(user1,user2,money);
			System.out.println("AccountServlet");
		} catch (MyException e) {
			response.getWriter().write(e.toString());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
