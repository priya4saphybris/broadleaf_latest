package com.myapp.core.checkout.facades.impl;

import javax.annotation.Resource;

import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;

import com.myapp.core.beans.AddressData;
import com.myapp.core.checkout.facades.CheckoutFacade;
import com.myapp.core.education.populator.AddressReversePopulator;

public class DefaultCheckoutFacade implements CheckoutFacade
{
	@Resource(name = "blFulfillmentGroupService")
	protected FulfillmentGroupService fulfillmentGroupService;
	
	@Resource(name = "blOrderService")
	protected OrderService orderService;
	
	private AddressReversePopulator addressReversePopulator;
	
	public AddressReversePopulator getAddressReversePopulator() {
		return addressReversePopulator;
	}

	public void setAddressReversePopulator(AddressReversePopulator addressReversePopulator) {
		this.addressReversePopulator = addressReversePopulator;
	}




	@Override
	public void saveShippingAddress(AddressData addressData, Order cart) 
	{
		Address address= new AddressImpl();
		addressReversePopulator.populate(addressData, new AddressImpl());
		FulfillmentGroup shippableFulfillmentGroup = this.fulfillmentGroupService
				.getFirstShippableFulfillmentGroup(cart);
		if (shippableFulfillmentGroup != null) {
			shippableFulfillmentGroup.setAddress(address);
			shippableFulfillmentGroup.setDeliveryInstruction("");
			try 
			{
				cart = this.orderService.save(cart, Boolean.valueOf(true));
			}
			catch (PricingException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
