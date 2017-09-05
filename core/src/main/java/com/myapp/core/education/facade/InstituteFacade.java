package com.myapp.core.education.facade;

import java.util.List;

import com.myapp.core.beans.AddressData;
import com.myapp.core.education.beans.InstituteData;

public interface InstituteFacade 
{
	InstituteData save(InstituteData instituteData);
	InstituteData getInstitute(Long id);
	List<InstituteData> getInstitutes();
	InstituteData createAddress(AddressData addressData, Long instituteId);
}
