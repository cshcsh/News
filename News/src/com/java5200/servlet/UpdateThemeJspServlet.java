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

public class UpdateThemeJspServlet extends HttpServlet {
	
	ThemeDao themeDao=new ThemeDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		String themeId=req.getParameter("themeId");
		String themeName=req.getParameter("themeName");
		List<Theme> themeList=null;
		try {
			try {
				conn=DbUtil.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			themeList=themeDao.themeList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("themeId", themeId);
		req.setAttribute("themeName", themeName);
		req.setAttribute("themeList", themeList);
		req.setAttribute("mainPage", "/updateThemeJsp.jsp");
		req.setAttribute("navCode", "当前位置:主页>主题>修改主题");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

}
