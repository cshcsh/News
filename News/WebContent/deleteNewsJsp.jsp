<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	// 权限验证
	if (session.getAttribute("currentUser") == null) {
		response.sendRedirect("a.jsp");
		return;
	}
%>
<ul style="text-align: left;">
	<c:forEach var="news" items="${newsList }">

		<li>${news.title }&nbsp;&nbsp;&nbsp;&nbsp;<a style="color: red;" href="#">删除</a>
		&nbsp;&nbsp;&nbsp;&nbsp;<a style="color: red;" href="updateNewsJsp">修改</a></li>
	</c:forEach>
</ul>