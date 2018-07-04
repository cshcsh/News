package com.java5200.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static String dbDriver="com.mysql.jdbc.Driver";
	private static String dbUrl="jdbc:mysql://localhost:3306/db_news";
	private static String dbUserName="root";
	private static String dbPassword="admin";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(dbDriver);
		Connection connection=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return connection;
	}
	
	public static void closeConnection(Connection con) throws SQLException{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con=getConnection();
		if(con!=null){
			System.out.println("数据库连接成功");
		}else{
			System.out.println("数据库连接失败");
		}
		closeConnection(con);
	}

}
