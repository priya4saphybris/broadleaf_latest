package com.myapp.core.education.facade.impl;

import java.util.List;

import com.myapp.core.converter.Converter;
import com.myapp.core.education.beans.StandardData;
import com.myapp.core.education.facade.StandardFacade;
import com.myapp.core.education.populator.StandardReversePopulator;
import com.myapp.core.education.service.StandardService;
import com.myapp.core.education.standard.Standard;

public class DefaultStandardFacade implements StandardFacade
{
	private StandardService standardService;
	
	private Converter<Standard, StandardData> standardConverter;
	
	private StandardReversePopulator standardReversePopulator;
	
	
	public StandardReversePopulator getStandardReversePopulator() {
		return standardReversePopulator;
	}

	public void setStandardReversePopulator(StandardReversePopulator standardReversePopulator) {
		this.standardReversePopulator = standardReversePopulator;
	}

	public Converter<Standard, StandardData> getStandardConverter() {
		return standardConverter;
	}

	public void setStandardConverter(Converter<Standard, StandardData> standardConverter) {
		this.standardConverter = standardConverter;
	}

	public StandardService getStandardService() {
		return standardService;
	}

	public void setStandardService(StandardService standardService) {
		this.standardService = standardService;
	}

	@Override
	public StandardData save(StandardData standardData) 
	{
		Standard standard= new Standard();
		standardReversePopulator.populate(standardData, standard);
		return standardConverter.convert(standardService.save(standard));
	}

	@Override
	public List<StandardData> getStandards() 
	{
		List<Standard> standards= standardService.getStandards();
		return standardConverter.convertAll(standards);
	}

	@Override
	public StandardData getStandardById(Long id) 
	{
		return standardConverter.convert(standardService.getStandardById(id));
	}
	
}
