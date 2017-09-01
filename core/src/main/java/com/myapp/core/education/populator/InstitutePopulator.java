package com.myapp.core.education.populator;

import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.education.beans.InstituteData;
import com.myapp.core.education.organization.Institute;
import com.myapp.core.populator.Populator;

public class InstitutePopulator implements Populator<Institute, InstituteData>
{

	@Override
	public void populate(Institute source, InstituteData target) throws ConvertionException 
	{
		target.setId(source.getId());
		target.setName(source.getName());
		target.setBreakTime(source.getBreakTime());
		target.setContactNumber1(source.getContactNumber1());
		target.setContactNumber2(source.getContactNumber2());
		target.setTimings(source.getTimings());
		target.setDescription(source.getDescription());
	}
	
}
