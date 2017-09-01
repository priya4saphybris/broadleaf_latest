package com.myapp.core.education.service;

import java.util.List;

import com.myapp.core.education.standard.Standard;

public interface StandardService 
{
	Standard save(Standard standard);
	Standard getStandardById(Long id);
	List<Standard> getStandards();
}
