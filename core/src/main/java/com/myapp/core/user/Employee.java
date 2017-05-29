package com.myapp.core.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.CustomerImpl;

@Table
@Entity(name="EMPLOYEE")
public class Employee extends CustomerImpl
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date dateOfJoining;

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
