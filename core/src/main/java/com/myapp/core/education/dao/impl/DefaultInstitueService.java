package com.myapp.core.education.dao.impl;

import java.util.List;

import com.myapp.core.education.dao.InstituteDao;
import com.myapp.core.education.organization.Institute;
import com.myapp.core.education.service.InstituteService;

public class DefaultInstitueService implements InstituteService
{
	private InstituteDao instituteDao;
	
	@Override
	public Institute save(Institute institute) 
	{
		return instituteDao.save(institute);
	}

	@Override
	public Institute getInstitute(Long id) 
	{
		return instituteDao.getInstitute(id);
	}

	@Override
	public List<Institute> getInstitues() 
	{
		return instituteDao.getInstitues();
	}
}
