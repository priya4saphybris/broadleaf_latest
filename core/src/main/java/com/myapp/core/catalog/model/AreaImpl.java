package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="AREA")
public class AreaImpl implements Area
{
	@Id
	@GeneratedValue(generator = "AreaId")
	@GenericGenerator(name = "AreaId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "AreaImpl"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.catalog.model.AreaImpl") })
	@Column(name = "AREA_ID", nullable = false)
	private Long id;
	
	@Column(name = "AREA_CODE", nullable = true)
	private String areaCode;
	
	@Column(name = "AREA_NAME", nullable = true)
	private String areaName;
	
	@OneToOne(targetEntity=CountrySubdivisionImpl.class, optional= false)
	@JoinColumn(name="CITY_CODE")
	private CountrySubdivision cityCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public CountrySubdivision getCityCode() {
		return cityCode;
	}

	public void setCityCode(CountrySubdivision cityCode) {
		this.cityCode = cityCode;
	}
}
