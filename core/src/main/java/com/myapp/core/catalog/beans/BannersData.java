package com.myapp.core.catalog.beans;

public class BannersData 
{
	private Long id;
	private String url;
	private Long catgeory;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getCatgeory() {
		return catgeory;
	}
	public void setCatgeory(Long catgeory) {
		this.catgeory = catgeory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
