package com.myapp.core.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MY_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class User 
{
	@Id
	@GeneratedValue(generator = "Userid")
	@GenericGenerator(name = "Userid", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "User"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.user.User") })
	@Column(name = "USER_ID", nullable = false)
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE1")
	private String phone1;
	
	@Column(name = "PHONE2")
	private String phone2;
	
	@Column(name = "LOGIN_DISSABLED")
	private boolean loginDisabled;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "DOB")
	private String dateOfBirth;
	
	@Column(name = "ACTIVE")
	private boolean active;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public boolean isLoginDisabled() {
		return loginDisabled;
	}

	public void setLoginDisabled(boolean loginDisabled) {
		this.loginDisabled = loginDisabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
