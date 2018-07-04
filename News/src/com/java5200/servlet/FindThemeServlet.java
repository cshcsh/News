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

public class FindThemeServlet extends HttpServlet {
	
	ThemeDao themeDao=new ThemeDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		String id=req.getParameter("themeId");
		String themeName="";
		try {
			try {
				conn=DbUtil.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			themeName=themeDao.themeNameById(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!"".equals(themeName)){
			req.setAttribute("errorMsg", "查找主题："+themeName);
		}else{
			req.setAttribute("errorMsg", "没有此主题ID");
		}
		req.setAttribute("mainPage", "/findThemeJsp.jsp");
		req.setAttribute("navCode", "当前位置:主页>主题>查找主题");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

}
