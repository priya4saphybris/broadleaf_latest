package com.myapp.core.catalog.beans;

import java.util.List;

public class FacetValueData 
{
	private Long id;
	private String name;
	private String label;
	private String type;
	private List<FacetBasicValueData> values;
	private String quantity;
	
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
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<FacetBasicValueData> getValues() {
		return values;
	}
	public void setValues(List<FacetBasicValueData> values) {
		this.values = values;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
