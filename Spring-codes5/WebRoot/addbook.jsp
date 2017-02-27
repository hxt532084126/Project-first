<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 注意这里写上theme就会称为一个html主题的form标签 -->
	<s:form action="book_add" namespace="/" method="post" theme="simple">
		图书名称:<s:textfield name="name"></s:textfield>
		图书价格:<s:textfield name="price"></s:textfield>
		<s:submit value="添加图书"></s:submit>
	</s:form>
</body>
</html>