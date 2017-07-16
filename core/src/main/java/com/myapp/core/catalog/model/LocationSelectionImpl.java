package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="LOCATION_SELECTION")
public class LocationSelectionImpl implements LocationSelection
{
	@Id
	@GeneratedValue(generator = "Selectionid")
	@GenericGenerator(name = "Selectionid", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "LocationSelectionImpl"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.catalog.model.LocationSelectionImpl") })
	@Column(name = "SELECTION_ID", nullable = false)
	private Long id;
	
	@Column(name="CITY_CODE")
	private String cityCode;
	
	@Column(name="STATE_CODE")
	private String stateCode;
	
	@Override
	public void setId(Long id) 
	{
		this.id= id;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setCityCode(String cityCode) 
	{
		this.cityCode= cityCode;
	}

	@Override
	public String getCityCode() 
	{
		return this.cityCode;
	}

	@Override
	public void setStateCode(String stateCode) 
	{
		this.stateCode= stateCode;
	}

	@Override
	public String getStateCode() 
	{
		return this.stateCode;
	}

}
