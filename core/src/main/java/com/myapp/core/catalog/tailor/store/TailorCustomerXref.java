package com.myapp.core.catalog.tailor.store;

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
@Table(name="TAILOR_CUSTOMER_XREF")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class TailorCustomerXref 
{
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(targetEntity = TailorStore.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "TAILORESTORE_ID")
	private TailorStore tailorStore;
	
	@ManyToOne(targetEntity = MyCustomerImpl.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "CUSTOMER_ID")
	private MyCustomer customer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TailorStore getTailorStore() {
		return tailorStore;
	}
	public void setTailorStore(TailorStore tailorStore) {
		this.tailorStore = tailorStore;
	}
	public MyCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(MyCustomer customer) {
		this.customer = customer;
	}
}
