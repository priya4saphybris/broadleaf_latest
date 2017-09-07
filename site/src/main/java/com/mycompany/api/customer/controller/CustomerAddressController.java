package com.mycompany.api.customer.controller;

import javax.annotation.Resource;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.AddressData;
import com.myapp.core.catalog.facades.AddressFacade;
import com.mycompany.api.customer.response.AddressResponse;
import com.mycompany.api.data.utils.AddressDataUtil;

@Controller
@RequestMapping("/**/my-account/address")
public class CustomerAddressController 
{
	@Resource(name="addressFacade")
	private AddressFacade addressFacade;
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	@ResponseBody
	public AddressResponse addCustomerAddress(AddressData addressData)
	{
		AddressResponse response= new AddressResponse();
		
		if(null != CustomerState.getCustomer())
		{
			addressData.setCustomerId(CustomerState.getCustomer().getId());
		}
		else
		{
			response.setErrorMessage("Customer should present");
		}
		
		if(AddressDataUtil.validate(addressData, response))
		{	
			return response;
		}
		addressData=addressFacade.save(addressData);
		response.setAddressData(addressData);
		return response;
	}
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@ResponseBody
	public AddressResponse getCustomerAdresses()
	{
		AddressResponse response= new AddressResponse();
		Customer customer= CustomerState.getCustomer();
		if(null == customer)
		{
			response.setErrorMessage("Customer must be present");
			return response;
		}
		response.setAddressList(addressFacade.getCustomerAddresses(customer.getId()));
		return response;
	}
}
