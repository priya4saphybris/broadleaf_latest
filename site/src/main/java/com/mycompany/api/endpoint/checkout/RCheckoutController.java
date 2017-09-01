package com.mycompany.api.endpoint.checkout;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.core.beans.AddressData;
import com.myapp.core.catalog.facades.AddressFacade;
import com.myapp.core.catalog.facades.LocationFacade;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.user.MyCustomer;

@Controller
@RequestMapping("/**/rcheckout")
public class RCheckoutController extends RCommonController
{
	@Resource(name="locationFacade")
	private LocationFacade locationFacade;

	@Resource(name="addressFacade")
	private AddressFacade addressFacade;
	
	@RequestMapping(value="/add-shipping", produces="application/json", method=RequestMethod.POST)
	public void addShippingAddress(AddressData addressData, HttpServletRequest request, HttpServletResponse response) throws PricingException
	{
		if(!requiredLogin() && !hasCart())
		{
			//
		}
		
		MyCustomer customer= getCurrentCustomer();	
		Area area=customer.getArea();
		
		if(null != area && null != area.getCityCode())
		{
			addressData.setCity(getCurrentCustomerCity());
			addressData.setCountry(getCurrentCountry());
			addressData.setState(getCurrentCustomerRegion());
			Address address=addressFacade.saveAddress(addressData);
			saveShippingAddress(address);
		}
	}
}
