package com.myapp.core.education.beans;

import com.myapp.core.beans.CustomerData;

public class StudentData
{
	private Long id;
	private String firstName;
	private String lastName;
	private String rollNumber;
	private String standard;
	private String age;
	private CustomerData customerData;
	private StandardData standardData;
	private InstituteData instituteData;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public StandardData getStandardData() {
		return standardData;
	}
	public void setStandardData(StandardData standardData) {
		this.standardData = standardData;
	}
	public CustomerData getCustomerData() {
		return customerData;
	}
	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}
	public InstituteData getInstituteData() {
		return instituteData;
	}
	public void setInstituteData(InstituteData instituteData) {
		this.instituteData = instituteData;
	}
	
}
