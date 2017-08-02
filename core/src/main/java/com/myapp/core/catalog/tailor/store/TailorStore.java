package com.myapp.core.catalog.tailor.store;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.myapp.core.catalog.model.MyStoreImpl;

@Entity
@Table(name="TAILOR_STORE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class TailorStore extends MyStoreImpl
{
	
	private static final long serialVersionUID = 1L;

	@OneToMany(targetEntity = TailorFabricXref.class, mappedBy = "tailor", orphanRemoval = true, cascade = {
			javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.REFRESH })
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
	private List<TailorFabricXref> fabricOrders;
	
	@OneToMany(targetEntity = TailorCustomerXref.class, mappedBy = "tailorStore", orphanRemoval = true, cascade = {
			javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.REFRESH })
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
	private List<TailorCustomerXref> customers;

	public List<TailorFabricXref> getFabricOrders() {
		return fabricOrders;
	}

	public void setFabricOrders(List<TailorFabricXref> fabricOrders) {
		this.fabricOrders = fabricOrders;
	}

	public List<TailorCustomerXref> getCustomers() {
		return customers;
	}

	public void setCustomers(List<TailorCustomerXref> customers) {
		this.customers = customers;
	}
}
