package com.java5200.util;

import com.java5200.entity.News;

public class NavUtil {

	public static String getNavgation(String mainMenu,News news){
		StringBuffer navCode=new StringBuffer();
		navCode.append("当前位置:");
		navCode.append("<a href='a.jsp'>主页</a>>");
		navCode.append("<a href='themeNews.jsp?id="+news.getThemeId()+"'>"+mainMenu+"</a>>");
		navCode.append("<a href='#'>正文</a>");
		return navCode.toString();
	}
}
