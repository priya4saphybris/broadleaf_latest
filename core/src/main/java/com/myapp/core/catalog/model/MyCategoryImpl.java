package com.myapp.core.catalog.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "MY_CATEGORY")
public class MyCategoryImpl extends CategoryImpl implements MyCategory
{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(targetEntity = StoreCategoryXrefImpl.class, mappedBy = "myCategory", orphanRemoval = true, cascade = {
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.REFRESH })
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blCategories")
	@BatchSize(size = 50)
	private List<StoreCategoryXref> allStoreCategoryXrefs;
	
	@Override
	public List<StoreCategoryXref> getAllStoreCategoryXrefs() 
	{
		return this.allStoreCategoryXrefs;
	}

	@Override
	public void setAllStoreCategoryXrefs(List<StoreCategoryXref> allStoreCategoryXrefs) 
	{
		this.allStoreCategoryXrefs=allStoreCategoryXrefs;
	}
	
}
