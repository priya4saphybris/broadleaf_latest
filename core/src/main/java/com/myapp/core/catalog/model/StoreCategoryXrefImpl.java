package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.broadleafcommerce.common.presentation.AdminPresentationClass;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.store.domain.Store;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MY_STORE_CATEGORY_XREF")
@AdminPresentationClass(excludeFromPolymorphism = false)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class StoreCategoryXrefImpl implements StoreCategoryXref
{
	@Id
	@GeneratedValue(generator = "StoreCategoryId")
	@GenericGenerator(name = "StoreCategoryId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "StoreCategoryXrefImpl"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.catalog.model.StoreCategoryXrefImpl") })
	@Column(name = "STORE_CATEGORY__ID")
	private Long id;
	
	@ManyToOne(targetEntity = MyCategoryImpl.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "CATEGORY_ID")
	private Category myCategory;
	
	@ManyToOne(targetEntity = MyStoreImpl.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "STORE_ID")
	private Store myStore;
	
	public Category getMyCategory() {
		return myCategory;
	}

	public void setMyCategory(Category myCategory) {
		this.myCategory = myCategory;
	}

	@Override
	public void setId(Long id) 
	{
		this.id=id;
	}

	@Override
	public Long getId() 
	{
		return this.id;
	}

	@Override
	public void setMyStore(Store myStore) 
	{
		this.myStore= myStore;
	}

	@Override
	public Store getMyStore() 
	{
		return this.myStore;
	}

}
