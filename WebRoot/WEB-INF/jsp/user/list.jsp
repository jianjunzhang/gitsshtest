<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="user_addInput.action">添加用户</a></h1>
	<s:iterator value="#list.datas">
		${id }---<a href="group_show.action?cid=${id }">${username }</a>
		---${password }---${nickname }---${group.name }&nbsp;
		<a href="user_delete.action?id=${id }">删除</a>&nbsp;
		<a href="user_updateInput.action?id=${id }">更新</a>
		<br />
	</s:iterator>
	
	<jsp:include page="/inc/pager.jsp">
		<jsp:param value="user_list.action" name="url"/>
		<jsp:param value="${list.totalRecord }" name="items"/>
		<jsp:param value="${list.pageSize }" name="pageSize"/>
	</jsp:include>
</body>
</html>