package com.myapp.core.user;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.CustomerImpl;

import com.myapp.core.catalog.model.LocationSelection;
import com.myapp.core.catalog.model.LocationSelectionImpl;

@Entity
@Table(name = "MY_CUSTOMER")
public class MyCustomerImpl extends CustomerImpl implements MyCustomer
{
	private static final long serialVersionUID = 1L;
	
	@OneToOne(targetEntity= LocationSelectionImpl.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="LOCATION_ID")
	private LocationSelection locationSelection;

	public LocationSelection getLocationSelection() {
		return locationSelection;
	}

	public void setLocationSelection(LocationSelection locationSelection) {
		this.locationSelection = locationSelection;
	}
}
