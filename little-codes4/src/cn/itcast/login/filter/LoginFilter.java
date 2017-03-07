package cn.itcast.login.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.login.bean.User;
import cn.itcast.login.service.LoginService;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("进入Loginfilter");
		// 因为获取路径需要使用HttpServletRequest,所以先创建一下
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 获取三个路径
		// 获取项目全路径(/day1/1.jsp)
		String uri;
		// 获取项目虚拟路径(/day1)
		String contextPath;
		// 获取项目虚拟路径以后的路径(/1.jsp)
		String path;
		uri = request.getRequestURI();
		contextPath = request.getContextPath();
		path = uri.substring(contextPath.length());

		// 获得cookies数组,遍历数组,如果有userCookie,那么就从中取值,没有则继续访问.
		// 先判断session中是否有登陆的user对象
		User u = (User) request.getSession().getAttribute("user");
		// 如果路径地址是以Login.jsp结尾的那么就不会去判断session中是否有user
		if (!path.endsWith("Login.jsp")) {
			// 判断session中是否有user,如果有,那就说明已经登陆了,session中有值
			if (u == null) {
				Cookie[] cookies = request.getCookies();
				// 如果cookie值不为null,然后获取客户端的cookies,
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						// 如果有相对应的cookie(判断这个cookie中的对应userCookie中的值是否符合数据库中的值)
						if (cookie.getName().equals("userCookie")) {
							String str = cookie.getValue();
							String[] strs = str.split(":");
							// 获取对应的username,password
							String username = strs[0];
							String password = strs[1];
							// 到数据库中比对
							User user = null;
							try {
								user = new LoginService().operateLogin(
										username, password);
								// 满足,则在session中存储一个user
								if (user != null) {
									request.getSession().setAttribute("user",
											user);
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
