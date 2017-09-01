package com.myapp.core.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Table
@Entity(name="STUDENT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class Student
{
	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID", nullable = false)
	private Long id;
	
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
}
