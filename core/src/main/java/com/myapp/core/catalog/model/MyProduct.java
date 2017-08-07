package com.myapp.core.catalog.model;

import org.broadleafcommerce.core.store.domain.Store;

public interface MyProduct 
{
	void setStore(Store store);
	Store getStore();
	String getCode();
	void setCode(String code);
	void setRemoteId(Long remoteId);
	Long getRemoteId();
	void setCurrency(String currency);
	String getCurrency();
	void setMainImageHighRes(String mainImageHighRes);
	String getMainImageHighRes();
	void setMainImage(String mainImage);
	String getMainImage();
}
