package com.myapp.core.user;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.CustomerImpl;

import com.myapp.core.catalog.model.Area;
import com.myapp.core.catalog.model.AreaImpl;

@Entity
@Table(name = "MY_CUSTOMER")
public class MyCustomerImpl extends CustomerImpl implements MyCustomer
{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity= AreaImpl.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="AREA_ID")
	private Area area;

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
