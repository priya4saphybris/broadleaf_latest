package com.mycompany.api.sitedata.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.AreaData;
import com.myapp.core.beans.CurrentLocationData;
import com.myapp.core.beans.CustomerData;
import com.myapp.core.beans.LocationData;
import com.myapp.core.beans.RegionData;
import com.myapp.core.catalog.facades.CustomerFacade;
import com.myapp.core.catalog.facades.LocationFacade;
import com.myapp.core.user.MyCustomer;

@Controller
@RequestMapping(value="/**/location")
public class LocationController 
{
	@Resource(name="locationFacade")
	private LocationFacade locationFacade;
	
	@Resource(name="customerFacade")
	private CustomerFacade customerFacade;
	
	@Resource(name = "blCustomerService")
	protected CustomerService customerService;
	
	@RequestMapping(value="/regions", produces="application/json")
	@ResponseBody
	public List<RegionData> getRegions(HttpServletResponse request, HttpServletResponse response)
	{
		return locationFacade.getAllRegions();
	}
	
	@RequestMapping(value="/regions-startwith", produces="application/json")
	@ResponseBody
	public List<RegionData> getRegionsStartWith(@RequestParam("query") String query, HttpServletResponse request, HttpServletResponse response)
	{
		return locationFacade.getRegionsStartWith(query);
	}
	
	@RequestMapping(value="/cities-startwith", produces="application/json")
	@ResponseBody
	public List<LocationData> getCitiesStartWith(@RequestParam(required=false) String query,HttpServletResponse request, HttpServletResponse response)
	{
		return locationFacade.getCitiesStartWith(query);
	}
	
	@RequestMapping(value="/areas", produces="application/json")
	@ResponseBody
	public List<AreaData> getAllAreas(HttpServletResponse request, HttpServletResponse response)
	{
		return locationFacade.getAllAreas();
	}
	
	@RequestMapping(value="/findarea", method=RequestMethod.POST ,produces="application/json")
	@ResponseBody
	public AreaData findArea(@RequestParam String areaCode,HttpServletRequest request, HttpServletResponse response)
	{
		return locationFacade.findArea(areaCode);
	}
	
	@RequestMapping(value="/select", method=RequestMethod.POST ,produces="application/json")
	@ResponseBody
	public CustomerData selectLocation(CurrentLocationData currentLocation,HttpServletRequest request, HttpServletResponse response)
	{
		if(null !=CustomerState.getCustomer())
		{
			MyCustomer customer=(MyCustomer)CustomerState.getCustomer();
			return customerFacade.selectLocation(currentLocation, customer);
		}
		return null;
	}
}
