package cn.itcast.login.filter;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.login.bean.User;
import cn.itcast.login.exception.MyException;

public class UserFilter implements Filter {

	// 这四个值意思是从admin,User两个properties文件中读取的字符串
	// 并将这两对字符串打成字符数组
	private String userString;
	private String adminString;
	private String[] userStrings;
	private String[] adminStrings;

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

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

		User user = (User) request.getSession().getAttribute("user");
		// 循环遍历字符串数组,然后逐一比对,如若地址值比对成功,那么就继续操作
		for (String aString : adminStrings) {
			if (path.endsWith(aString)) {
				if (user != null) {
					String role = user.getRole();
					if (!role.equals("admin")) {
						throw new MyException("you are not an admin");
					}
				} else {
					throw new MyException("you are not an admin");
				}
			}
		}

		// 循环遍历字符串数组,然后逐一比对,如若地址值比对成功,那么就继续操作
		for (String uString : userStrings) {
			if (path.endsWith(uString)) {
				if (user != null) {
					String role = user.getRole();
					if (!role.equals("user")) {
						throw new MyException("you are a not user");
					}
				} else {
					throw new MyException("you are a not user");
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		adminString = ResourceBundle.getBundle("admin").getString("url");
		userString = ResourceBundle.getBundle("User").getString("url");
		adminStrings = adminString.split(",");
		userStrings = userString.split(",");
	}
}
