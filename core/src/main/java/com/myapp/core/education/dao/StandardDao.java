package com.myapp.core.education.dao;

import java.util.List;

import com.myapp.core.education.standard.Standard;

public interface StandardDao 
{
	Standard save(Standard standard);
	Standard getStandardById(Long id);
	List<Standard> getStandards();
}
