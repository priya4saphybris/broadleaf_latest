package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne(targetEntity= MyCustomerImpl.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="CUSTOMER_ID")
	private MyCustomer myCustomer;
	
	@OneToOne(targetEntity= TopDetails.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="TOPDETAILS_ID")
	private TopDetails topDetails;
	
	@OneToOne(targetEntity= BottomDetails.class, optional = true, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name="BOTTOMDETAILS_ID")
	private BottomDetails bottomDetails;

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

	public TopDetails getTopDetails() {
		return topDetails;
	}

	public void setTopDetails(TopDetails topDetails) {
		this.topDetails = topDetails;
	}

	public BottomDetails getBottomDetails() {
		return bottomDetails;
	}

	public void setBottomDetails(BottomDetails bottomDetails) {
		this.bottomDetails = bottomDetails;
	}
	
}
