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

public class ThemeNewsServlet extends HttpServlet {
	
	ThemeDao themeDao=new ThemeDao();
	NewsDao newsDao=new NewsDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		String themeId=req.getParameter("id");
		List<Theme> themeList=new ArrayList<Theme>();
		List<News> themeNewsList=new ArrayList<News>();
		List<News> themeId1NewsList=new ArrayList<News>();
		List<News> themeId2NewsList=new ArrayList<News>();
		try {
			conn=DbUtil.getConnection();
			themeList=themeDao.themeList(conn);
			themeNewsList=newsDao.newsListByThemeId(conn, themeId);
			themeId1NewsList=newsDao.newsListByThemeId(conn, "1");
			themeId2NewsList=newsDao.newsListByThemeId(conn, "2");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("themeList", themeList);
		req.setAttribute("newsList", themeNewsList);
		req.setAttribute("themeId1NewsList", themeId1NewsList);
		req.setAttribute("themeId2NewsList", themeId2NewsList);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
