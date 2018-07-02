<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css">
<title>首页_新闻中心-Powered by java5200</title>
</head>
<body>
	<div>
		<div>
			<div class="login_form">
				<form action="login" method="post">
					<font color="red">${error }</font> 用户名：<input type="text"
						name="username" /> 密码：<input type="password" name="password" />
					<input type="submit" value="登录" />
				</form>
			</div>
			<hr style="height: 2px; border: none; border-top: 1px solid gray;" />
			<div class="logo1">
				<img alt="新闻中国"
					src="${pageContext.request.contextPath}/images/logo1.png">
			</div>
		</div>

		<div>
			<div class="menu">

				<ul>
					<li><a href="a.jsp">首页</a></li>
					<c:forEach var="theme" items="${themeList }">

						<li><a href="themeNews.jsp?id=${theme.id }">${theme.theme }</a></li>
					</c:forEach>

				</ul>

			</div>
		</div>


		<div style="height: 760px; margin-top: 15px;">

			<div class="left">
				<div>
					<div class="left_title1">国内新闻</div>
					<div>
						<ul class="ul_li">
							<c:forEach var="news1" items="${themeId1NewsList }">

								<li><a href="showNews.jsp?id=${news1.id }">${news1.title }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div>
					<div class="left_title1">国际新闻</div>
					<div>
						<ul class="ul_li">
							<c:forEach var="news2" items="${themeId2NewsList }">

								<li><a href="showNews.jsp?id=${news2.id }">${news2.title }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>

			<div class="list">
				<div class="list_title">即时新闻</div>
				<div>
					<ul class="ul_li2">
						<c:forEach var="news" items="${newsList }">

							<li><a href="showNews.jsp?id=${news.id }">${news.title }</a><font>${news.date }</font></li>
						</c:forEach>
					</ul>
				</div>
			</div>


		</div>


		<div class="foot">
			<div>Copyright © 2017-2018 Java项目分享网 版权所有</div>
			<div>
				备案号:<a href="http://www.miitbeian.gov.cn/">湘ICP备18005945号</a>
			</div>
		</div>


	</div>
</body>
</html>