package com.myapp.core.education.service;

import java.util.List;

import com.myapp.core.education.organization.Institute;

public interface InstituteService 
{
	Institute save(Institute institute);
	Institute getInstitute(Long id);
	List<Institute> getInstitues();
}
