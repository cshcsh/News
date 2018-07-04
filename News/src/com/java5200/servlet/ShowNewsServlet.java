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

public class ShowNewsServlet extends HttpServlet {
	
	ThemeDao themeDao=new ThemeDao();
	NewsDao newsDao=new NewsDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		News news=null;
		String themeName=null;
		String id=req.getParameter("id");
		List<Theme> themeList=new ArrayList<Theme>();
		try {
			conn=DbUtil.getConnection();
			themeList=themeDao.themeList(conn);
			news=newsDao.getNewsById(conn, id);
			themeName = themeDao.themeNameById(conn, news.getThemeId().toString());
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
		String navCode=NavUtil.getNavgation(themeName,news);
		req.setAttribute("themeList", themeList);
		req.setAttribute("news", news);
		req.setAttribute("navCode", navCode);
		
		req.getRequestDispatcher("content.jsp").forward(req, resp);
	}

}
