package com.mycompany.api.sitedata.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.core.beans.RegionData;
import com.myapp.core.catalog.facades.RegionFacade;

@Controller
@RequestMapping(name="/location")
public class LocationController 
{
	@Resource(name="regionFacade")
	private RegionFacade regionFacade;
	
	@RequestMapping(value="/regions")
	public List<RegionData> getRegions(HttpServletResponse request, HttpServletResponse response)
	{
		return regionFacade.getAllRegions();
	}
}
