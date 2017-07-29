package com.myapp.core.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PAYMENT_MODE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class PaymentModeImpl implements PaymentMode
{
	@Id
	@GeneratedValue(generator = "PaymentModeId")
	@GenericGenerator(name = "PaymentModeId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "PaymentModeImpl"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.catalog.model.PaymentModeImpl") })
	@Column(name = "PAYMENT_MODE_ID")
	private Long id;
	
	@Column(name="CODE", nullable=false)
	private String code;
	
	@Column(name="LOGO_IMAGE", nullable=true)
	private String logoImage;
	
	@Column(name="PAYMENT_TYPE", nullable=false)
	private String type;
	
	@Column(name="IS_ACTIVE", nullable=false)
	private boolean active;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLogoImage() {
		return logoImage;
	}
	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
