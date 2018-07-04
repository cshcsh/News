package com.java5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java5200.entity.News;
import com.java5200.entity.User;

public class NewsDao {

	public List<News>  newsList(Connection connection) throws SQLException{
		List<News> newsList=new ArrayList<News>();
		StringBuffer stringBuffer=new StringBuffer("select * from t_news order by id desc limit 0,30");
		PreparedStatement ps=connection.prepareStatement(stringBuffer.toString());
		ResultSet resultSet=ps.executeQuery();
		while(resultSet.next()){
			News news=new News();
			news.setId(resultSet.getInt("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setDate(resultSet.getDate("date"));
			news.setThemeId(resultSet.getInt("themeId"));
			newsList.add(news);
		}
		return newsList;
	}
	
	public List<News>  newsListByThemeId(Connection connection,String themeId) throws SQLException{
		List<News> newsList=new ArrayList<News>();
		String sql="select * from t_news where themeId=? order by id desc limit 0,9";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1, themeId);
		ResultSet resultSet=ps.executeQuery();
		while(resultSet.next()){
			News news=new News();
			news.setId(resultSet.getInt("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setDate(resultSet.getDate("date"));
			news.setThemeId(resultSet.getInt("themeId"));
			newsList.add(news);
		}
		return newsList;
	}
	
	public News getNewsById(Connection conn,String id) throws NumberFormatException, SQLException{
		News news=null;
		String sql="select * from t_news where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			news=new News();
			news.setId(Integer.parseInt(rs.getString("id")));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setDate(rs.getDate("date"));
			news.setThemeId(Integer.parseInt(rs.getString("ThemeId")));
		}
		return news;
	}
}
