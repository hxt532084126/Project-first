<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${user.username}
	<h1>success</h1>
	<br />
	<a href="${pageContext.request.contextPath}/JSP/Student/search.jsp">查询学生</a>
	<br />
	<a href="${pageContext.request.contextPath}/JSP/Student/add.jsp">添加学生</a>
	<br />
	<a href="${pageContext.request.contextPath}/JSP/Student/delete.jsp">删除学生</a>
	<br />
	<a href="${pageContext.request.contextPath}/JSP/Student/modify.jsp">修改学生</a>
	<br />
</body>
</html>