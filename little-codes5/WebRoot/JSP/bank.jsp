<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/day2-05-bank/account" method = "POST">
		转账用户名:<input type = "text" name = "account1"/><br/>
		收账用户名:<input type = "text" name = "account2"/><br/>
		转账总金额:<input type = "text" name = "dollar"/><br/>
		<input type = "submit" value = "submit"/>
		<%
			System.out.println("From");
		 %>
	</form>
</body>
</html>