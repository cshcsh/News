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

public class DeleteThemeServlet extends HttpServlet {
	
	ThemeDao themeDao=new ThemeDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		List<Theme> themeList=null;
		String id=req.getParameter("id");
		int n=-1;
		try {
			conn=DbUtil.getConnection();
			themeList=themeDao.themeList(conn);
			n=themeDao.deleteTheme(conn, id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(n>0){
			req.setAttribute("errorMsg", "删除成功");
		}else{
			req.setAttribute("errorMsg", "该主题下有新闻，删除失败");
		}
		req.setAttribute("themeList", themeList);
		req.setAttribute("mainPage", "/deleteThemeJsp.jsp");
		req.setAttribute("navCode", "当前位置:主页>主题>删除主题");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

}
