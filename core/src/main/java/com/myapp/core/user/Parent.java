package com.myapp.core.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.CustomerImpl;

@Table
@Entity(name="PARENT")
public class Parent extends CustomerImpl
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isGaurdian;

	public boolean isGaurdian() {
		return isGaurdian;
	}

	public void setGaurdian(boolean isGaurdian) {
		this.isGaurdian = isGaurdian;
	}
}
