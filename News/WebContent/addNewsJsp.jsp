<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	// 权限验证
	if (session.getAttribute("currentUser") == null) {
		response.sendRedirect("a.jsp");
		return;
	}
%>
<div>
	<form action="#" method="post">
		主题：<input type="text" name="themeName"/>
		<input type="submit" value="添加"/>
	</form>
</div>