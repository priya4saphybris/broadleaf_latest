package com.myapp.core.education.populator;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.service.CustomerService;

import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.education.beans.StudentData;
import com.myapp.core.education.service.InstituteService;
import com.myapp.core.populator.Populator;
import com.myapp.core.user.Student;

public class StudentReversePopulator implements Populator<StudentData, Student> 
{
	private CustomerService customerService;
	
	private InstituteService instituteService;
	
	
	public InstituteService getInstituteService() {
		return instituteService;
	}

	public void setInstituteService(InstituteService instituteService) {
		this.instituteService = instituteService;
	}

	public CustomerService getCustomerService() 
	{
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) 
	{
		this.customerService = customerService;
	}


	@Override
	public void populate(StudentData source, Student target) throws ConvertionException 
	{
		if(null != source.getCustomerData())
		{
			Customer customer=customerService.readCustomerById(source.getCustomerData().getId());
			target.setCustomer(customer);
		}
		//target.setDateOfExit(source.ge);
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setPursuing(true);
		target.setRollNumber(source.getRollNumber());
		if(null != source.getStandardData())
		{
			//target.setStandard(standard);
		}
		if(null != source.getInstituteData())
		{
			target.setInstitute(instituteService.getInstitute(source.getInstituteData().getId()));
		}
		
	}
}
