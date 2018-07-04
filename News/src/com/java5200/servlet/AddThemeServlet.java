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

public class AddThemeServlet extends HttpServlet {
	
	ThemeDao themeDao=new ThemeDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		Boolean flag=false;
		req.setCharacterEncoding("UTF-8");
		String themeName=req.getParameter("themeName");
		try {
			conn=DbUtil.getConnection();
			flag=themeDao.findByName(conn, themeName);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(!flag){
			Theme theme=new Theme(themeName);
			int n=-1;
			try {
				n=themeDao.addTheme(conn, theme);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(n>0){
				req.setAttribute("errorMsg", "����ɹ�");
			}else{
				req.setAttribute("errorMsg", "����ʧ��");
			}
		}else{
			req.setAttribute("errorMsg", "�������Ѵ���");
		}
		
		req.setAttribute("mainPage", "/addThemeJsp.jsp");
		req.setAttribute("navCode", "��ǰλ��:��ҳ>����>�������");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

}
