package com.myapp.core.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.myapp.core.education.standard.Standard;

@Table
@Entity(name="STUDENT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class Student
{
	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID", nullable = false)
	private Long id;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "PURSUING", nullable = false)
	private boolean pursuing;

	@Column(name = "ROLL_NUMBER", nullable = false)
	private String rollNumber;
	
	@Column(name = "DATE_OF_JOING", nullable = true)
	private Date dateOfJoining;
	
	@Column(name = "DATE_OF_EXIT", nullable = true)
	private Date dateOfExit;
	
	@Column(name = "SECTION", nullable = true)
	private String section;
	
	@Column(name = "DOB", nullable = true)
	private Date dob;
	
	@ManyToOne(targetEntity= Standard.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="STANDARD")
	private Standard standard;
	
	@ManyToOne(targetEntity= CustomerImpl.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="GUARDIAN")
	private Customer customer;
	
	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfExit() {
		return dateOfExit;
	}

	public void setDateOfExit(Date dateOfExit) {
		this.dateOfExit = dateOfExit;
	}

	public boolean isPursuing() {
		return pursuing;
	}

	public void setPursuing(boolean pursuing) {
		this.pursuing = pursuing;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
