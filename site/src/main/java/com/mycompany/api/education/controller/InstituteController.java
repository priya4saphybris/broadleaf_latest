package com.mycompany.api.education.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.education.beans.InstituteData;
import com.myapp.core.education.facade.InstituteFacade;
import com.mycompany.api.eductaion.response.InstituteResponse;

@Controller
@RequestMapping("/institute")
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
		InstituteResponse reponse= new InstituteResponse();
		instituteData=instituteFacade.save(instituteData);
		reponse.setInstituteData(instituteData);
		return reponse;
	}
	
	@RequestMapping(value="/get/{instituteid}", produces="application/json")
	@ResponseBody
	public InstituteResponse getInstituteById(@PathVariable("instituteid") Long instituteId)
	{
		InstituteResponse reponse= new InstituteResponse();
		InstituteData instituteData=instituteFacade.getInstitute(instituteId);
		reponse.setInstituteData(instituteData);
		return reponse;
	}
}
