package com.myapp.core.checkout.facades;

import org.broadleafcommerce.core.order.domain.Order;

import com.myapp.core.beans.AddressData;

public interface CheckoutFacade 
{
	void saveShippingAddress(AddressData addressData, Order cart);
}
