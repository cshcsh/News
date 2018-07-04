package com.java5200.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java5200.dao.NewsDao;
import com.java5200.dao.ThemeDao;
import com.java5200.entity.News;
import com.java5200.entity.Theme;
import com.java5200.util.DbUtil;
import com.java5200.util.NavUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class DeleteNewsJspServlet extends HttpServlet {
	

	NewsDao newsDao=new NewsDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		List<News>newsList=null;
		try {
			try {
				conn=DbUtil.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			newsList=newsDao.newsList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("newsList", newsList);
		req.setAttribute("mainPage", "/deleteNewsJsp.jsp");
		req.setAttribute("navCode", "当前位置:主页>新闻>删除新闻");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

}
