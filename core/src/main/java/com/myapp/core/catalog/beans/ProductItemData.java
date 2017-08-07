package com.myapp.core.catalog.beans;

import java.util.List;

public class ProductItemData 
{
	private Long id;
	private Long remoteId;
	private String url;
	private double price;
	private String priceFormatted;
	private double discountPrice;
	private String discountPriceFormatted;
	private long category;
	private String currency;
	private String code;
	private String description;
	private String mainImage;
	private String mainImageHighRes;
	private List<ProductItemData> related;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRemoteId() {
		return remoteId;
	}
	public void setRemoteId(Long remoteId) {
		this.remoteId = remoteId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPriceFormatted() {
		return priceFormatted;
	}
	public void setPriceFormatted(String priceFormatted) {
		this.priceFormatted = priceFormatted;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getDiscountPriceFormatted() {
		return discountPriceFormatted;
	}
	public void setDiscountPriceFormatted(String discountPriceFormatted) {
		this.discountPriceFormatted = discountPriceFormatted;
	}
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
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
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public String getMainImageHighRes() {
		return mainImageHighRes;
	}
	public void setMainImageHighRes(String mainImageHighRes) {
		this.mainImageHighRes = mainImageHighRes;
	}
	public List<ProductItemData> getRelated() {
		return related;
	}
	public void setRelated(List<ProductItemData> related) {
		this.related = related;
	}
}