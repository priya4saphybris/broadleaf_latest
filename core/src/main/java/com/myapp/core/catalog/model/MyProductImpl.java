package com.myapp.core.catalog.model;

import javax.persistence.CascadeType;
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
	
}
