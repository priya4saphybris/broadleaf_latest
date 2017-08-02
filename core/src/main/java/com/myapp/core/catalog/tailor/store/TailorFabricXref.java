package com.myapp.core.catalog.tailor.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.myapp.core.catalog.model.SizeDetailsImpl;

@Entity
@Table(name="TAILOR_FABRIC")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class TailorFabricXref 
{
	@Id
	@GeneratedValue
	@Column(name="TARILOR_FABRIC_ID")
	private Long id;
	
	@ManyToOne(targetEntity = SizeDetailsImpl.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "SIZEDETAILS_ID")
	private SizeDetailsImpl sizeDetails;
	
	@ManyToOne(targetEntity = TailorStore.class, optional = false, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "TAILOR_STORE_ID")
	private TailorStore tailor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SizeDetailsImpl getSizeDetails() {
		return sizeDetails;
	}

	public void setSizeDetails(SizeDetailsImpl sizeDetails) {
		this.sizeDetails = sizeDetails;
	}

	public TailorStore getTailor() {
		return tailor;
	}

	public void setTailor(TailorStore tailor) {
		this.tailor = tailor;
	}
	
}
