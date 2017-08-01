package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="SHIRT_DETAILS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class ShirtDetailsImpl extends TopDetails
{	
	@Column(name="COLLAR")
	private String collar;
	
	@Column(name="WAIST")
	private String waist;
	
	@Column(name="SLEEVE_LENGTH")
	private String sleeveLength;
	
	@Column(name="HAND_LENGTH")
	private String handLength;
	
	public String getCollar() {
		return collar;
	}
	public void setCollar(String collar) {
		this.collar = collar;
	}
	public String getWaist() {
		return waist;
	}
	public void setWaist(String waist) {
		this.waist = waist;
	}
	public String getSleeveLength() {
		return sleeveLength;
	}
	public void setSleeveLength(String sleeveLength) {
		this.sleeveLength = sleeveLength;
	}
	public String getHandLength() {
		return handLength;
	}
	public void setHandLength(String handLength) {
		this.handLength = handLength;
	}
	
}
