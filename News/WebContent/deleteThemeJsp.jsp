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
<ul>
	<c:forEach var="theme" items="${themeList }">

		<li>${theme.theme }&nbsp;&nbsp;&nbsp;&nbsp;<a style="color: red;" href="deleteTheme?id=${theme.id }">删除</a>
		&nbsp;&nbsp;&nbsp;&nbsp;<a style="color: red;" href="updateThemeJsp?themeId=${theme.id }&themeName=${theme.theme}">修改</a></li>
	</c:forEach>
	<span>${errorMsg }</span>
</ul>