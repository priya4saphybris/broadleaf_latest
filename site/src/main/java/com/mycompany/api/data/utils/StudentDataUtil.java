package com.mycompany.api.data.utils;

import com.myapp.core.education.beans.StudentData;
import com.mycompany.api.eductaion.response.StudentResponse;

public class StudentDataUtil 
{
	public static boolean validate(StudentData studentData, StudentResponse response)
	{
		
		if(null == studentData)
		{
			response.setErrorMessage("No data present in student object");
			return true;
		}
		
		if(null == studentData.getFirstName() || null == studentData.getLastName())
		{
			response.setErrorMessage("First name or Last name should not be null");
			return true;
		}
		
		if(null == studentData.getStandard())
		{
			response.setErrorMessage("Standard should not be null");
			return true;
		}
		
		if(null == studentData.getCustomerData())
		{
			response.setErrorMessage("Customer should not be null");
			return true;
		}
		
		if(null == studentData.getRollNumber())
		{
			response.setErrorMessage("Roll number should not be null");
			return true;
		}
		
		return false;
	}
}
