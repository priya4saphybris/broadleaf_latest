package com.myadmin.api.admin.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.StoreData;
import com.myapp.core.catalog.facades.StoreFacade;
import com.myapp.core.forms.StoreForm;

@Controller
@RequestMapping("/store")
public class AdminStoreController 
{
	@Resource(name="storeFacade")
	private StoreFacade storeFacade;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<StoreData> getAllStores(HttpServletRequest request)
	{
		return storeFacade.getAllStores();
	}
	
	@RequestMapping("/{storeId}")
	@ResponseBody
	public StoreData readStoreByStoreId(HttpServletRequest request, @PathVariable("storeId") Long storeId)
	{
		return storeFacade.readStoreByStoreId(storeId);
	}
	
	@RequestMapping(value="/create", method= RequestMethod.POST)
	@ResponseBody
	public boolean createStore(StoreForm storeForm, HttpServletRequest request, HttpServletResponse response)
	{
		StoreData storeData= new StoreData();
		storeData.setName(storeForm.getName());
		storeData.setStoreHours(storeForm.getHours());
		return storeFacade.createStore(storeData);
	}
}
