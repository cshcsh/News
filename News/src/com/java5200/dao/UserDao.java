package com.java5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java5200.entity.User;

public class UserDao {

	public User login(Connection conn,User user) throws SQLException{
		User resultUser=null;
		String sql="select * from t_user where username=? and password=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setUserName(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
	
	public int modifyPassword(Connection con,User user)throws Exception{
		String sql="update t_user set password=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setInt(2, user.getId());
		return pstmt.executeUpdate();
	}
}
