package com.myapp.core.education.service.impl;

import java.util.List;

import com.myapp.core.education.dao.StandardDao;
import com.myapp.core.education.service.StandardService;
import com.myapp.core.education.standard.Standard;

public class DefaultStandardService implements StandardService
{
	private StandardDao standardDao;
	
	
	public StandardDao getStandardDao() {
		return standardDao;
	}

	public void setStandardDao(StandardDao standardDao) {
		this.standardDao = standardDao;
	}

	@Override
	public Standard save(Standard standard) 
	{
		return standardDao.save(standard);
	}

	@Override
	public Standard getStandardById(Long id) 
	{
		return standardDao.getStandardById(id);
	}

	@Override
	public List<Standard> getStandards() 
	{
		return standardDao.getStandards();
	}
	
}
