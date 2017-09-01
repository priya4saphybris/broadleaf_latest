package com.myapp.core.education.facade.impl;

import java.util.List;

import com.myapp.core.converter.Converter;
import com.myapp.core.education.beans.InstituteData;
import com.myapp.core.education.facade.InstituteFacade;
import com.myapp.core.education.organization.Institute;
import com.myapp.core.education.service.InstituteService;

public class DefaultInstituteFacade implements InstituteFacade
{
	private InstituteService instituteService;
	
	private Converter<Institute, InstituteData> instituteConverter;
	
	public InstituteService getInstituteService() {
		return instituteService;
	}

	public void setInstituteService(InstituteService instituteService) {
		this.instituteService = instituteService;
	}

	@Override
	public InstituteData save(InstituteData instituteData) 
	{
		Institute institute= new Institute();
		institute= instituteService.save(institute);
		return instituteConverter.convert(institute);
	}

	@Override
	public InstituteData getInstitute(Long id) 
	{
		return instituteConverter.convert(instituteService.getInstitute(id));
	}

	@Override
	public List<InstituteData> getInstitutes() 
	{
		List<Institute> institutes= instituteService.getInstitues();
		return instituteConverter.convertAll(institutes);
	}

}
