package com.myapp.core.catalog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SERVICES")
public class ServicesImpl 
{
	@Id
	@GeneratedValue(generator = "ServicesId")
	@GenericGenerator(name = "ServicesId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "ServicesImpl"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.catalog.model.ServicesImpl") })
	@Column(name = "SERVICES_ID", nullable = false)
	private Long id;
	
	@OneToOne(targetEntity= AreaImpl.class)
	@JoinColumn(name="AREA_ID")
	private Area area;
	
	@OneToMany(targetEntity= CategoryImpl.class)
	@JoinColumn(name="CATEGORY_ID")
	private List<Category> availableCategories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Category> getAvailableCategories() {
		return availableCategories;
	}

	public void setAvailableCategories(List<Category> availableCategories) {
		this.availableCategories = availableCategories;
	}
	
}
