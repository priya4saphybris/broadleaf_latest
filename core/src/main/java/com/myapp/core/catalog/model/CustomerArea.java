package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.broadleafcommerce.common.time.domain.TemporalTimestampListener;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerAddressPersistedEntityListener;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.hibernate.annotations.GenericGenerator;

@Entity
@EntityListeners({ TemporalTimestampListener.class, CustomerAddressPersistedEntityListener.class })
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MY_CUSTOMER_AREA")
public class CustomerArea 
{
	@Id
	@GeneratedValue(generator = "CustomerAreaId")
	@GenericGenerator(name = "CustomerAreaId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "CustomerArea"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.catalog.model.CustomerArea") })
	@Column(name = "CUSTOMER_AREA_ID")
	private Long id;
	
	@ManyToOne(cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE }, targetEntity = AreaImpl.class, optional = false)
	@JoinColumn(name = "AREA_ID")
	private Area area;
	
	@ManyToOne(cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE }, targetEntity = CustomerImpl.class, optional = false)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
