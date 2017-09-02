package com.mycompany.api.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.core.beans.AddressData;

@Controller
@RequestMapping("/my-account/address")
public class CustomerAddressController 
{
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public void addCustomerAddress(AddressData addressData)
	{
		//
	}
}
