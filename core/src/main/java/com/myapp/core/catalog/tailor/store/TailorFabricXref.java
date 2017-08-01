package com.myapp.core.catalog.tailor.store;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.myapp.core.catalog.model.SizeDetailsImpl;

@Entity
@Table(name="TAILOR_FABRIC")
public class TailorFabricXref 
{
	private Long id;
	private SizeDetailsImpl sizeDetails;
	private TailorStore tailor;
}
