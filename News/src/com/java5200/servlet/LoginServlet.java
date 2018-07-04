package com.java5200.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java5200.dao.UserDao;
import com.java5200.entity.User;
import com.java5200.util.DbUtil;
import com.java5200.util.StringUtil;

public class LoginServlet extends HttpServlet {
	
	UserDao userDao=new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
			req.setAttribute("error", "用户名或密码为空");
			req.getRequestDispatcher("a.jsp").forward(req, resp);
			return;
		}
		User user=new User(username, password);
		Connection conn=null;
		try {
			conn = DbUtil.getConnection();
			User currentUser=userDao.login(conn, user);
			if(currentUser==null){
				req.setAttribute("error", "用户名或密码错误");
				req.getRequestDispatcher("a.jsp").forward(req, resp);
			}else{
				HttpSession session=req.getSession();
				session.setAttribute("currentUser", currentUser);
				resp.sendRedirect("main.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DbUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
