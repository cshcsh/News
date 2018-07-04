package com.java5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java5200.entity.Theme;

public class ThemeDao {

	public List<Theme>  themeList(Connection connection) throws SQLException{
		List<Theme> themeList=new ArrayList<Theme>();
		StringBuffer stringBuffer=new StringBuffer("select * from t_theme limit 0,15");
		PreparedStatement ps=connection.prepareStatement(stringBuffer.toString());
		ResultSet resultSet=ps.executeQuery();
		while(resultSet.next()){
			Theme theme=new Theme();
			theme.setId(resultSet.getInt("id"));
			theme.setTheme(resultSet.getString("theme"));
			themeList.add(theme);
		}
		return themeList;
	}
	
	public String  themeNameById(Connection connection,String id) throws SQLException{
		String sql="select * from t_theme where id=?";
		List<Theme> list=new ArrayList<>();
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet resultSet=ps.executeQuery();
		while(resultSet.next()){
			Theme theme=new Theme();
			theme.setId(resultSet.getInt("id"));
			theme.setTheme(resultSet.getString("theme"));
			list.add(theme);
		}
		if(list.size()>0){
			return list.get(0).getTheme();
		}else{
			return "";
		}
	}
	
	public int addTheme(Connection con,Theme theme)throws Exception{
		String sql="insert into t_theme values(null,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, theme.getTheme());
		return pstmt.executeUpdate();
	}
	
	public boolean findByName(Connection con,String themeName)throws Exception{
		String sql="select * from t_theme where theme like '%"+themeName+"%'";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
	
	public int deleteTheme(Connection con,String id)throws Exception{
		String sql="delete from t_theme where id="+id;
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	
	public int updateTheme(Connection con,Theme theme)throws Exception{
		String sql="update t_theme set theme=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, theme.getTheme());
		pstmt.setInt(2, theme.getId());
		return pstmt.executeUpdate();
	}
}
