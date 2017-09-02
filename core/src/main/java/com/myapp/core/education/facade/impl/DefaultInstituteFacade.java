package com.myapp.core.education.facade.impl;

import java.util.List;

import com.myapp.core.converter.Converter;
import com.myapp.core.education.beans.InstituteData;
import com.myapp.core.education.facade.InstituteFacade;
import com.myapp.core.education.organization.Institute;
import com.myapp.core.education.populator.InstituteReversePopulator;
import com.myapp.core.education.service.InstituteService;

public class DefaultInstituteFacade implements InstituteFacade
{
	private InstituteService instituteService;
	
	private Converter<Institute, InstituteData> instituteConverter;
	
	private InstituteReversePopulator instituteReversePopulator;
	
	public InstituteReversePopulator getInstituteReversePopulator() {
		return instituteReversePopulator;
	}

	public void setInstituteReversePopulator(InstituteReversePopulator instituteReversePopulator) {
		this.instituteReversePopulator = instituteReversePopulator;
	}

	public Converter<Institute, InstituteData> getInstituteConverter() {
		return instituteConverter;
	}

	public void setInstituteConverter(Converter<Institute, InstituteData> instituteConverter) {
		this.instituteConverter = instituteConverter;
	}

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
		instituteReversePopulator.populate(instituteData, institute);
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
