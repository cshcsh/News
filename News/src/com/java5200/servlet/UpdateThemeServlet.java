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

public class UpdateThemeServlet extends HttpServlet {
	
	ThemeDao themeDao=new ThemeDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		req.setCharacterEncoding("UTF-8");
		String themeId=req.getParameter("themeId");
		String themeName=req.getParameter("themeName");
		Theme  theme=new Theme(Integer.parseInt(themeId),themeName);
		List<Theme> themeList=null;
		int n=-1;
		try {
			conn=DbUtil.getConnection();
			try {
				n=themeDao.updateTheme(conn, theme);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(n>0){
			req.setAttribute("errorMsg", "�޸�����ɹ�");
		}else{
			req.setAttribute("errorMsg", "�޸�����ʧ��");
		}
		req.setAttribute("themeList", themeList);
		req.setAttribute("mainPage", "/updateThemeJsp.jsp");
		req.setAttribute("navCode", "��ǰλ��:��ҳ>����>�޸�����");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

}
