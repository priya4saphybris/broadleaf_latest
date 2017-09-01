package com.myapp.core.education.dao;

import java.util.List;

import com.myapp.core.education.organization.Institute;

public interface InstituteDao 
{
	Institute save(Institute institute);
	Institute getInstitute(Long id);
	List<Institute> getInstitues();
}
