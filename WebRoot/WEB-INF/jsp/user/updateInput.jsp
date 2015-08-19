<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户</title>
</head>
<body>
	<h1>更新用户</h1>
	<s:form action="user_update.action" method="post">
		<s:hidden name="id"/>
		<s:textfield label="用户名称" name="username"/>
		<s:password label="用户密码" name="password" showPassword="true"/>
		<s:textfield label="用户昵称" name="nickname"/>
		<s:select list="#list" listKey="id" listValue="name" name="gid" label="用户所在组"></s:select>
		<s:submit value="提交"/>
	</s:form>
</body>
</html>