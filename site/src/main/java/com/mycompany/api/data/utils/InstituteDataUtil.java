package com.mycompany.api.data.utils;

import com.myapp.core.education.beans.InstituteData;
import com.mycompany.api.eductaion.response.InstituteResponse;

public class InstituteDataUtil 
{
	public static boolean validate(InstituteData instituteData, InstituteResponse response)
	{
		if(null == instituteData)
		{
			response.setErrorMessage("Institute Data must be present");
			return true;
		}
		
		if(null != instituteData.getName())
		{
			response.setErrorMessage("Institute name must be present");
			return true;
		}
		return false;
	}
}
