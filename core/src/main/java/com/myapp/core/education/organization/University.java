package com.myapp.core.education.organization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="UNIVERSITY")
public class University 
{
	@Id
	@GeneratedValue(generator = "Universityid")
	@GenericGenerator(name = "Universityid", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "University"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.education.organization.University") })
	@Column(name = "INSTITUTE_ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
