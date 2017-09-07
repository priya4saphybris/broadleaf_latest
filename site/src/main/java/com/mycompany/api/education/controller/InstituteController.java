package com.mycompany.api.education.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.AddressData;
import com.myapp.core.education.beans.InstituteData;
import com.myapp.core.education.facade.InstituteFacade;
import com.mycompany.api.data.utils.InstituteDataUtil;
import com.mycompany.api.eductaion.response.InstituteResponse;

@Controller
@RequestMapping("/**/institute")
public class InstituteController 
{
	@Resource(name="instituteFacade")
	private InstituteFacade instituteFacade;
	
	public InstituteFacade getInstituteFacade() {
		return instituteFacade;
	}

	public void setInstituteFacade(InstituteFacade instituteFacade) {
		this.instituteFacade = instituteFacade;
	}

	@RequestMapping(value="/list", produces="application/json")
	@ResponseBody
	public InstituteResponse getInstitutes()
	{
		InstituteResponse reponse= new InstituteResponse();
		reponse.setInstitutes(instituteFacade.getInstitutes());
		return reponse;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public InstituteResponse create(InstituteData instituteData)
	{
		InstituteResponse response= new InstituteResponse();
		
		if(InstituteDataUtil.validate(instituteData, response))
		{
			return response;
		}
		instituteData=instituteFacade.save(instituteData);
		response.setInstituteData(instituteData);
		return response;
	}
	
	@RequestMapping(value="/get/{instituteid}", produces="application/json")
	@ResponseBody
	public InstituteResponse getInstituteById(@PathVariable("instituteid") Long instituteId)
	{
		InstituteResponse reponse= new InstituteResponse();
		if(null == instituteId)
		{
			reponse.setErrorMessage("Institute id must be present");
		}
		
		InstituteData instituteData=instituteFacade.getInstitute(instituteId);
		reponse.setInstituteData(instituteData);
		return reponse;
	}
	
	@RequestMapping(value="/address/create/{instituteid}", method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public InstituteResponse createInstituteAddress(@PathVariable("instituteid")Long instituteId,AddressData addressData)
	{
		InstituteResponse reponse= new InstituteResponse();
		InstituteData instituteData=instituteFacade.createAddress(addressData, instituteId);
		reponse.setInstituteData(instituteData);
		return reponse;
	}
}
