package com.java5200.entity;

import java.util.Date;

public class News {

	private Integer id;
	private String title;
	private String content;
	private Date date;
	private Integer themeId;
	
	public News() {
		super();
	}
	public News(String title, String content, Date date, Integer themeId) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.themeId = themeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getThemeId() {
		return themeId;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	
}
