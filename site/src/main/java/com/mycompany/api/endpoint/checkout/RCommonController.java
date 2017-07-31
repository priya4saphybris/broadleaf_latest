package com.mycompany.api.endpoint.checkout;

import javax.annotation.Resource;

import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.order.CartState;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.web.core.CustomerState;

import com.myapp.core.beans.RegionData;
import com.myapp.core.catalog.facades.LocationFacade;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.user.MyCustomer;

public class RCommonController 
{
	@Resource(name="locationFacade")
	private LocationFacade locationFacade;
	
	@Resource(name = "blOrderService")
	protected OrderService orderService;
	
	@Resource(name = "blFulfillmentGroupService")
	protected FulfillmentGroupService fulfillmentGroupService;
	
	@Resource(name = "blFulfillmentOptionService")
	protected FulfillmentOptionService fulfillmentOptionService;
	
	public boolean requiredLogin()
	{
		if(null != CustomerState.getCustomer())
		{
			return true;
		}
		return false;
	}
	
	public boolean hasCart()
	{
		if(null != CartState.getCart())
		{
			return true;
		}
		return false;
	}
	
	public MyCustomer getCurrentCustomer()
	{
		if(null != CustomerState.getCustomer())
		{
			return (MyCustomer) CustomerState.getCustomer();
		}
		return null;
	}
	
	public String getCurrentCustomerCity()
	{
		if(null != CustomerState.getCustomer())
		{
			MyCustomer customer=(MyCustomer) CustomerState.getCustomer();
			
			Area area=customer.getArea();
			if(null != area)
			{
				return area.getCityCode().getName();
			}
		}
		return null;
	}
	
	public String getCurrentCustomerRegion()
	{
		if(null != CustomerState.getCustomer())
		{
			MyCustomer customer=(MyCustomer) CustomerState.getCustomer();
			Area area=customer.getArea();
			if(null != area)
			{
				String alternateAbbrevation=area.getCityCode().getAlternateAbbreviation();
				String regionCode= alternateAbbrevation.split("-")[0];
				RegionData region=locationFacade.getRegionByCode(regionCode);
				return region.getName();
			}
		}
		return null;
	}
	
	public String getCurrentCountry()
	{
		return "india";
	}
	
	public Order saveShippingAddress(Address address) throws PricingException
	{
		Order cart= CartState.getCart();
		FulfillmentGroup shippableFulfillmentGroup = this.fulfillmentGroupService
				.getFirstShippableFulfillmentGroup(cart);
		if (shippableFulfillmentGroup != null) {
			shippableFulfillmentGroup.setAddress(address);
			shippableFulfillmentGroup.setDeliveryInstruction("");
			cart = this.orderService.save(cart, Boolean.valueOf(true));
			return cart;
		}
		return null;
	}
}
