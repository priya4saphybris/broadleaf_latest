package com.mycompany.api.endpoint.checkout;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.order.CartState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.core.beans.AddressData;
import com.myapp.core.catalog.facades.AddressFacade;
import com.myapp.core.catalog.facades.LocationFacade;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.checkout.facades.CheckoutFacade;
import com.myapp.core.user.MyCustomer;

@Controller
@RequestMapping("/**/rcheckout")
public class RCheckoutController extends RCommonController
{
	@Resource(name="locationFacade")
	private LocationFacade locationFacade;

	@Resource(name="addressFacade")
	private AddressFacade addressFacade;
	
	@Resource(name="checkoutFacade")
	private CheckoutFacade checkoutFacade;
	
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
			Order cart= CartState.getCart();
			addressData.setCity(getCurrentCustomerCity());
			addressData.setCountry(getCurrentCountry());
			addressData.setState(getCurrentCustomerRegion());
			checkoutFacade.saveShippingAddress(addressData, cart);
		}
	}
}
