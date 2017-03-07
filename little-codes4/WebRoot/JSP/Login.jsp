<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "/day2-10/loginServlet" method ="post">
		<font color = "red">username : </font><input type = "text" name = "username"/><br />
		<font color = "red">password : </font><input type = "password" name = "password" /><br />
		<input type = "checkbox" name = "AutoLogin" value = "choosed"/>记住用户名<br />
		<input type = "submit" value = "submit"/><br />
	</form>
</body>
</html>