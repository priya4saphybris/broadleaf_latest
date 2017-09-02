package com.mycompany.api.data.utils;

import com.myapp.core.education.beans.StudentData;

public class StudentDataUtil 
{
	public static boolean validate(StudentData studentData)
	{
		boolean invalid= false;
		
		if(null == studentData)
		{
			return (invalid=true);
		}
		
		if(null == studentData.getFirstName() || null == studentData.getLastName())
		{
			return (invalid=true);
		}
		
		if(null == studentData.getStandard())
		{
			return (invalid=true);
		}
		
		if(null == studentData.getCustomerData())
		{
			return (invalid=true);
		}
		
		if(null == studentData.getRollNumber())
		{
			return (invalid=true);
		}
		
		return invalid;
	}
}
