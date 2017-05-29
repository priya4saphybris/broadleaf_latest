package com.myapp.core.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.CustomerImpl;

@Table
@Entity(name="STUDENT")
public class Student extends CustomerImpl
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean pursuing;

	private Date dateOfJoining;
	
	private Date dateOfExit;
	
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
}
