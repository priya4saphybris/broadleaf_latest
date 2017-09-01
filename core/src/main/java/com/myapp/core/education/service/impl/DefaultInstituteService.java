package com.myapp.core.education.service.impl;

import java.util.List;

import com.myapp.core.education.dao.InstituteDao;
import com.myapp.core.education.organization.Institute;
import com.myapp.core.education.service.InstituteService;

public class DefaultInstituteService implements InstituteService
{
	private InstituteDao instituteDao;
	
	
	public InstituteDao getInstituteDao() {
		return instituteDao;
	}

	public void setInstituteDao(InstituteDao instituteDao) {
		this.instituteDao = instituteDao;
	}

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
