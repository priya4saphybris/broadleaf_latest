package com.myapp.core.beans;

import java.util.List;

public class LocationData 
{
	private Long id;
	private String stateName;
	private String stateCode;
	private String cityName;
	private String cityCode;
	private List<AreaData> areas;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public List<AreaData> getAreas() {
		return areas;
	}
	public void setAreas(List<AreaData> areas) {
		this.areas = areas;
	}
}
