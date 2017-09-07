package com.mycompany.api.endpoint.catalog;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.CategoryData;
import com.myapp.core.catalog.beans.BannersData;
import com.myapp.core.catalog.beans.HomePageData;
import com.myapp.core.catalog.facades.MyServicesFacade;
import com.myapp.core.catalog.facades.StaticAssetFacade;

@Controller
@RequestMapping("/**/c")
public class CategoryEndpoint 
{
	@Resource(name="myServicesFacade")
	private MyServicesFacade myServicesFacade;
	
	@Resource(name="staticAssetFacade")
	private StaticAssetFacade staticAssetFacade;
	
	public MyServicesFacade getMyServicesFacade() {
		return myServicesFacade;
	}


	public void setMyServicesFacade(MyServicesFacade myServicesFacade) {
		this.myServicesFacade = myServicesFacade;
	}


	@RequestMapping(value="/area-categories", produces="application/json")
	@ResponseBody
	public HomePageData getCategoriesForArea(@RequestParam("areaCode") String areaCode)
	{
		HomePageData homePageData= new HomePageData();
		List<BannersData> banners=staticAssetFacade.readAllAssets();
		List<CategoryData> categories=myServicesFacade.getServicesForCity(areaCode);
		homePageData.setRecords(categories);
		homePageData.setBanners(banners);
		return homePageData;
	}
}
