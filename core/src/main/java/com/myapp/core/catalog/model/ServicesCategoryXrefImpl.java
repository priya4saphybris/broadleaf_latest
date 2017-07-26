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
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "SERVICES_CATEGORY_XREF")
@AdminPresentationClass(excludeFromPolymorphism = false)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class ServicesCategoryXrefImpl implements ServicesCategoryXref
{
	@Id
	@GeneratedValue(generator = "ServiceCategoryId")
	@GenericGenerator(name = "ServiceCategoryId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "ServicesCategoryXrefImpl"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.catalog.model.ServicesCategoryXrefImpl") })
	@Column(name = "SERVICE_CATEGORY__ID")
	private Long id;
	
	@ManyToOne(targetEntity = ServicesImpl.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "SERVICE_ID")
	private Services service;
	
	@ManyToOne(targetEntity = CategoryImpl.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Services getService() {
		return service;
	}
	public void setService(Services service) {
		this.service = service;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
