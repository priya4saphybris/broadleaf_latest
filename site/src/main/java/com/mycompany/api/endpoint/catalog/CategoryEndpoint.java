package com.mycompany.api.endpoint.catalog;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.CategoryData;
import com.myapp.core.catalog.facades.MyServicesFacade;

@Controller
@RequestMapping("/c")
public class CategoryEndpoint 
{
	@Resource(name="myServicesFacade")
	private MyServicesFacade myServicesFacade;
	
	
	public MyServicesFacade getMyServicesFacade() {
		return myServicesFacade;
	}


	public void setMyServicesFacade(MyServicesFacade myServicesFacade) {
		this.myServicesFacade = myServicesFacade;
	}


	@RequestMapping(value="/area-categories", produces="application/json")
	@ResponseBody
	public List<CategoryData> getCategoriesForArea(@RequestParam("areaCode") String areaCode)
	{
		return myServicesFacade.getServicesForCity(areaCode);
	}
}
