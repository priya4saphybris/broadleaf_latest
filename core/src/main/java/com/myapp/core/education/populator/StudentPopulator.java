package com.myapp.core.education.populator;

import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.education.beans.StudentData;
import com.myapp.core.populator.Populator;
import com.myapp.core.user.Student;

public class StudentPopulator implements Populator<Student, StudentData>
{
	@Override
	public void populate(Student source, StudentData target) throws ConvertionException 
	{
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setRollNumber(source.getRollNumber());
		if(null != source.getStandard())
		{
			target.setStandard(source.getStandard().getName());
		}
		
	}
	
}
