package com.myapp.core.education.beans;

import com.myapp.core.beans.AddressData;

public class InstituteData 
{
	private Long id;
	private String name;
	private String description;
	private String contactNumber1;
	private String contactNumber2;
	private String timings;
	private String breakTime;
	private AddressData addressData;
	
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
	public String getContactNumber1() {
		return contactNumber1;
	}
	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}
	public String getContactNumber2() {
		return contactNumber2;
	}
	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public String getBreakTime() {
		return breakTime;
	}
	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}
	public AddressData getAddressData() {
		return addressData;
	}
	public void setAddressData(AddressData addressData) {
		this.addressData = addressData;
	}
	
}
