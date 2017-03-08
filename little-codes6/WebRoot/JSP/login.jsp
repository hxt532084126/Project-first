<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>success!!</h1>
	<br />
	<font color="red" >${sessionScope.username}</font><br />
	<font color="red" >${sessionScope.password}</font><br />
	<br />
	<br />
	<a href = "${pageContext.request.contextPath}/JSP/GetBooks">showBook</a>
	
</body>
</html>