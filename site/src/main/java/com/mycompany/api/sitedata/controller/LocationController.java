package com.mycompany.api.sitedata.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.AreaData;
import com.myapp.core.beans.CityData;
import com.myapp.core.beans.RegionData;
import com.myapp.core.catalog.facades.LocationFacade;

@Controller
@RequestMapping(value="/location")
public class LocationController 
{
	@Resource(name="locationFacade")
	private LocationFacade locationFacade;
	
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
	public List<CityData> getCitiesStartWith(@RequestParam("query") String query,HttpServletResponse request, HttpServletResponse response)
	{
		return locationFacade.getCitiesStartWith(query);
	}
	
	@RequestMapping(value="/areas", produces="application/json")
	@ResponseBody
	public List<AreaData> getAllAreas(HttpServletResponse request, HttpServletResponse response)
	{
		return locationFacade.getAllAreas();
	}
}
