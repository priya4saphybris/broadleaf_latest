package com.myapp.core.education.populator;

import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.education.beans.InstituteData;
import com.myapp.core.education.organization.Institute;
import com.myapp.core.populator.Populator;

public class InstituteReversePopulator implements Populator<InstituteData, Institute>
{

	@Override
	public void populate(InstituteData source, Institute target) throws ConvertionException 
	{
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setTimings(source.getTimings());
		target.setBreakTime(source.getBreakTime());
		target.setContactNumber1(source.getContactNumber1());
		target.setContactNumber2(source.getContactNumber2());
	}
	
}
