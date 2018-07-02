<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css">
<title>管理_新闻中心-Powered by java5200</title>
<style type="text/css">
.drop-down-content>li {
	list-style: none;
}

.drop-down-content>li>a {
	display: block;
	width: 100px;
	height: 45px;
	text-align: center;
	line-height: 45px;
	background-color: #1F3A79;
	font-size: 14px;
	color: #fff;
	text-decoration: none;
	font-family: Microsoft YaHei;
}

.drop-down {
	position: relative;
}

.drop-down-content {
	padding: 0;
	position: absolute;
	left: -999px;
}

.drop-down-content li:hover a {
	background-color: red;
}

.nav .drop-down:hover .drop-down-content {
	left: 0;
}
</style>

<%
	// 权限验证
	if (session.getAttribute("currentUser") == null) {
		response.sendRedirect("a.jsp");
		return;
	}
%>
</head>

<body>
	<div>
		<%-- <jsp:include page="/common/admin/head2.jsp" /> --%>
		<div class="head2">
			<div class="logo2">
				<img alt="新闻管理系统"
					src="${pageContext.request.contextPath}/images/logo2.png">
			</div>
			<div class="currentUser">
				<font>欢迎:<font style="color: red;">${currentUser.userName }</font></font>
			</div>
		</div>


		<%-- <jsp:include page="/common/admin/menu2.jsp" /> --%>
		<div>
			<div class="menu">

				<ul class="nav">
					<li><a style="font-size: 16px;" href="main.jsp">首页</a></li>
					<li class="drop-down"><a href="#">主题管理</a>
						<ul class="drop-down-content">
							<li><a href="addThemeJsp">添加主题</a></li>
							<li><a href="deleteThemeJsp">删除主题</a></li>
							<li><a href="findThemeJsp">查找主题</a></li>
							<li><a href="deleteThemeJsp">修改主题</a></li>
						</ul></li>
					<li class="drop-down"><a href="#">新闻管理</a>
						<ul class="drop-down-content">
							<li><a href="addNewsJsp">添加新闻</a></li>
							<li><a href="deleteNewsJsp">删除新闻</a></li>
							<li><a href="findNewsJsp">查找新闻</a></li>
							<li><a href="deleteNewsJsp">修改新闻</a></li>
						</ul></li>
					<li class="drop-down"><a href="#">系统管理</a>
						<ul class="drop-down-content">
							<li><a href="updatePassword">修改密码</a></li>
							<li><a href="out">退出系统</a></li>
						</ul></li>
				</ul>

			</div>
		</div>



		<%-- <jsp:include page="/common/admin/nav2.jsp" /> --%>
		<div class="nav2">
			<c:choose>
					<c:when test="${mainPage==null }">
									当前位置:主页
					</c:when>
					<c:otherwise>
									${navCode }
							</c:otherwise>
				</c:choose>
			<!-- 当前位置：<a href="#">主页</a> -->
		</div>



		<div style="height: 700px; margin-top: 15px; text-align: center;">
			<%-- <jsp:include page="/common/admin/left.jsp" />
		<jsp:include page="/common/admin/list.jsp" /> --%>
			<%-- <jsp:include page="${mainPage }" /> --%>
			<%-- <jsp:include page="/common/admin/view2.jsp" /> --%>
			<div class="default">
			
			<c:choose>
					<c:when test="${mainPage==null }">
						<h1>欢迎使用</h1>
					</c:when>
					<c:otherwise>
						<jsp:include page="${mainPage }" />
					</c:otherwise>
				</c:choose>
			
			
			</div>
			
			
			


		</div>



		<%-- <jsp:include page="/common/admin/foot2.jsp" /> --%>
		<div class="foot2">
			<div>Copyright © 2017-2018 Java项目分享网 版权所有</div>
			<div>
				备案号:<a href="http://www.miitbeian.gov.cn/">湘ICP备18005945号</a>
			</div>
		</div>



	</div>
</body>
</html>