package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.myapp.core.user.MyCustomer;
import com.myapp.core.user.MyCustomerImpl;

@Entity
@Table(name="SIZE_DETAILS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class SizeDetailsImpl 
{
	@Id
	@GeneratedValue
	@Column(name="SIZE_DETAILS_ID")
	private Long id;
	
	@ManyToOne(targetEntity = MyCustomerImpl.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="CUSTOMER_ID")
	private MyCustomer myCustomer;
	
	@ManyToOne(targetEntity= FabricDetails.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="TOPDETAILS_ID")
	private FabricDetails fabricDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MyCustomer getMyCustomer() {
		return myCustomer;
	}

	public void setMyCustomer(MyCustomer myCustomer) {
		this.myCustomer = myCustomer;
	}

	public FabricDetails getFabricDetails() {
		return fabricDetails;
	}

	public void setFabricDetails(FabricDetails fabricDetails) {
		this.fabricDetails = fabricDetails;
	}
	
}
