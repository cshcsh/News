package com.java5200.util;

import com.java5200.entity.News;

public class NavUtil {

	public static String getNavgation(String mainMenu,News news){
		StringBuffer navCode=new StringBuffer();
		navCode.append("��ǰλ��:");
		navCode.append("<a href='a.jsp'>��ҳ</a>>");
		navCode.append("<a href='themeNews.jsp?id="+news.getThemeId()+"'>"+mainMenu+"</a>>");
		navCode.append("<a href='#'>����</a>");
		return navCode.toString();
	}
}
