package com.myapp.core.education.organization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="INSTITUTE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
public class Institute 
{
	@Id
	@GeneratedValue(generator = "Instituteid")
	@GenericGenerator(name = "Instituteid", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "segment_value", value = "Institute"),
			@org.hibernate.annotations.Parameter(name = "entity_name", value = "com.myapp.core.education.organization.Institute") })
	@Column(name = "INSTITUTE_ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "DESCIPTION", nullable = false)
	private String description;

	@Column(name = "BREAK_TIME", nullable = false)
	private String breakTime;
	
	@Column(name = "TIMINGS", nullable = false)
	private String timings;
	
	@Column(name = "CONTACT_NUMBER_1", nullable = false)
	private String contactNumber1;
	
	@Column(name = "CONTACT_NUMBER_2", nullable = false)
	private String contactNumber2;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getContactNumber1() {
		return contactNumber1;
	}

	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}

	public String getContactNumber2() {
		return contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}
	
}
