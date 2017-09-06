package com.myapp.core.beans;

public class ProductData 
{
	private Long id;
	private String name;
	private String url;
	private String price;
	private String price_formatted;
	private String category;
	private String brand;
	private String discount_price;
	private String discount_price_formatted;
	private String currency;
	private String code;
	private String description;
	private String main_image;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice_formatted() {
		return price_formatted;
	}
	public void setPrice_formatted(String price_formatted) {
		this.price_formatted = price_formatted;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(String discount_price) {
		this.discount_price = discount_price;
	}
	public String getDiscount_price_formatted() {
		return discount_price_formatted;
	}
	public void setDiscount_price_formatted(String discount_price_formatted) {
		this.discount_price_formatted = discount_price_formatted;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMain_image() {
		return main_image;
	}
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
}
