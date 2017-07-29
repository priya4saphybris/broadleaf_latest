package com.myapp.core.beans;

public class PaymentModeData 
{
	private Long id;
	private String code;
	private String logoImage;
	private String paymentType;
	private boolean active;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLogoImage() {
		return logoImage;
	}
	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
