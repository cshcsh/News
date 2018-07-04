package com.java5200.entity;

public class Theme {

	private Integer id;
	private String theme;
	
	public Theme() {
		super();
	}
	public Theme(String theme) {
		super();
		this.theme = theme;
	}
	
	public Theme(Integer id, String theme) {
		super();
		this.id = id;
		this.theme = theme;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
}
