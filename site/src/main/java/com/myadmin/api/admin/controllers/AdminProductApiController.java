package com.myadmin.api.admin.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.ProductData;
import com.myapp.core.catalog.facades.ProductFacade;

@Controller
@RequestMapping("/p")
public class AdminProductApiController 
{
	@Resource(name="productFacade")
	ProductFacade productFacade;
	
	@RequestMapping("/product/{productCode}")
	@ResponseBody
	public ProductData getProductForID(HttpServletRequest request,
            @PathVariable("productCode") Long productId)
	{
		ProductData product=productFacade.getProductForID(productId);
		return product;
	}
	
	@RequestMapping("/products")
	@ResponseBody
	public List<ProductData> findProductsForCategory(HttpServletRequest request,
            @RequestParam("q") String categoryCode,
            @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize,
            @RequestParam(value = "page", defaultValue = "1") Integer page)
	{
		SearchCriteria searchCriteria= new SearchCriteria();
		searchCriteria.setPage(page);
		searchCriteria.setPageSize(pageSize);
		return productFacade.findProductsForCategory(categoryCode, searchCriteria);
	}
	
	@RequestMapping("/store/{storeId}")
	@ResponseBody
	public List<ProductData> getProductSFromStore(HttpServletRequest request,
            @PathVariable("storeId") Long storeId)
	{
		List<ProductData> products=productFacade.readProductsFromStore(storeId);
		return products;
	}
}
