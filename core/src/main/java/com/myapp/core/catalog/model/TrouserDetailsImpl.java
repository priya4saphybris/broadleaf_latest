package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="TROUSER_DETAILS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class TrouserDetailsImpl extends BottomDetails
{
	@Column(name="UNIT")
	private String unit;
	
	@Column(name="WAIST")
	private String waist;
	
	@Column(name="THIGH")
	private String thigh;
	
	@Column(name="KNEE")
	private String knee;
	
	@Column(name="LEG_OPENING")
	private String legOpening;
	
	@Column(name="FRONT_RISE")
	private String frontRise;
	
	@Column(name="REAR_RISE")
	private String rearRise;
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getWaist() {
		return waist;
	}
	public void setWaist(String waist) {
		this.waist = waist;
	}
	public String getThigh() {
		return thigh;
	}
	public void setThigh(String thigh) {
		this.thigh = thigh;
	}
	public String getKnee() {
		return knee;
	}
	public void setKnee(String knee) {
		this.knee = knee;
	}
	public String getLegOpening() {
		return legOpening;
	}
	public void setLegOpening(String legOpening) {
		this.legOpening = legOpening;
	}
	public String getFrontRise() {
		return frontRise;
	}
	public void setFrontRise(String frontRise) {
		this.frontRise = frontRise;
	}
	public String getRearRise() {
		return rearRise;
	}
	public void setRearRise(String rearRise) {
		this.rearRise = rearRise;
	}
}
