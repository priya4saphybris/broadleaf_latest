package com.myadmin.api.admin.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.CategoryData;
import com.myapp.core.catalog.facades.CategoryFacade;

@Controller
@RequestMapping("/my-category")
public class AdminCategoryController 
{
	@Resource(name="categoryFacade")
	private CategoryFacade categoryFacade;
	
	@RequestMapping("/store/{storeId}")
	@ResponseBody
	public List<CategoryData> readCategoriesFromStore(HttpServletRequest request, @PathVariable("storeId") Long storeId)
	{
		return categoryFacade.readCategoriesFromStore(storeId);
		
	}
}
