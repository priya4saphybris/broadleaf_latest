package com.myapp.core.catalog.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.broadleafcommerce.core.store.domain.StoreImpl;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.myapp.core.user.MyCustomer;
import com.myapp.core.user.MyCustomerImpl;

@Entity
@Table(name = "MY_STORE")
public class MyStoreImpl extends StoreImpl implements MyStore
{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(targetEntity = StoreCategoryXrefImpl.class, mappedBy = "myStore", orphanRemoval = true, cascade = {
			javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.REFRESH })
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
	private List<StoreCategoryXref> allCategoryXrefs;
	
	@ManyToOne(targetEntity = MyCustomerImpl.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "customer_id")
	private MyCustomer admin;
	
	@Override
	public List<StoreCategoryXref> getAllCategoryXrefs() {
		// TODO Auto-generated method stub
		return this.allCategoryXrefs;
	}
	
	
	public void setAllCategoryXrefs(List<StoreCategoryXref> allCategoryXrefs)
	{
		this.allCategoryXrefs=allCategoryXrefs;
	}


	public MyCustomer getAdmin() {
		return admin;
	}


	public void setAdmin(MyCustomer admin) {
		this.admin = admin;
	}
}
