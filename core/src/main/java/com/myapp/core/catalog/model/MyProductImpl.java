package com.myapp.core.catalog.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.store.domain.Store;
import org.broadleafcommerce.core.store.domain.StoreImpl;
import org.hibernate.annotations.Index;

@Entity
@Table(name = "MY_PRODUCT")
public class MyProductImpl extends ProductImpl implements MyProduct
{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity = StoreImpl.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinColumn(name = "DEFAULT_STORE_ID")
	@Index(name = "STORE_PARENT_INDEX", columnNames = { "DEFAULT_STORE_ID" })
	private Store store;
	
	@Column(name="CODE", nullable= false)
	private String code;
	
	@Column(name="MAIN_IMAGE")
	private String mainImage;
	
	@Column(name="MAIN_IMAGE_HR")
	private String mainImageHighRes;
	
	@Column(name="CURRENCY")
	private String currency;
	
	@Column(name="REMOTE_ID")
	private Long remoteId;
	
	@Override
	public void setStore(Store store) 
	{
		this.store= store;
	}

	@Override
	public Store getStore() 
	{
		return this.store;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getMainImage() {
		return mainImage;
	}

	@Override
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	@Override
	public String getMainImageHighRes() {
		return mainImageHighRes;
	}

	@Override
	public void setMainImageHighRes(String mainImageHighRes) {
		this.mainImageHighRes = mainImageHighRes;
	}

	@Override
	public String getCurrency() {
		return currency;
	}

	@Override
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public Long getRemoteId() {
		return remoteId;
	}

	@Override
	public void setRemoteId(Long remoteId) {
		this.remoteId = remoteId;
	}
	
}
