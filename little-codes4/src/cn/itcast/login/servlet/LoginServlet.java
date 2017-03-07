package cn.itcast.login.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.login.bean.User;
import cn.itcast.login.service.LoginService;
import cn.itcast.login.utils.MD5method;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// request解决请求信息的编码问题(post)
		request.setCharacterEncoding("UTF-8");
		// response解决浏览器的打开编码的问题
		response.setContentType("text/html;charset=utf-8");

		// 从request域中取出username和password两个参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//使用md5加密技术加密
		password = MD5method.md5(password);
		
		// 调用service方法,返回user
		LoginService service = new LoginService();
		User user = null;
		try {
			user = service.operateLogin(username, password);
		} catch (SQLException e) {
			response.getWriter().write("登陆失败");
		}

		// 如果user不为空,那么就说明登陆成功,然后判断是否勾选自动登陆,如果都满足,将user的信息存入cookie
		if (user != null) {
			if ("choosed".equals(request.getParameter("AutoLogin"))) {
				//使用URLEncoder.encode(username,"utf-8")能解决编码问题
				Cookie cookie = new Cookie("userCookie", URLEncoder.encode(username,"utf-8") + ":"+ password);
				cookie.setMaxAge(60 * 60 * 24 * 30);// 这里的数据是秒
				System.out.println("实现登陆,并将user信息存入cookie");
				cookie.setPath("/");// 说明无论访问web中什么页面,都能使用这个cookie
				response.addCookie(cookie);
			}
			//重定向至success.jsp界面
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()
					+ "/JSP/success.jsp");
		} else {
			System.out.println("fail in login!");
			request.getRequestDispatcher("/JSP/Login.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
