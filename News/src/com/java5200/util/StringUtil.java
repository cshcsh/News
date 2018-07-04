package com.java5200.util;

public class StringUtil {

	public static boolean isEmpty(String string){
		if(string==null||"".equals(string)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String string){
		if(string!=null&&!"".equals(string)){
			return true;
		}else{
			return false;
		}
	}
}
