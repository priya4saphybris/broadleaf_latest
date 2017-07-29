package com.myapp.core.beans;

/**
 * @author Arun1234
 *
 */
public class CustomerData 
{
	private Long id;
	private String userName;
	private String firstName;
	private String lastName;
	private AreaData areaData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public AreaData getAreaData() {
		return areaData;
	}
	public void setAreaData(AreaData areaData) {
		this.areaData = areaData;
	}
}
