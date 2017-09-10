package com.mycompany.api.customer.controller;

import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.AddressData;
import com.myapp.core.catalog.facades.AddressFacade;
import com.myapp.core.catalog.facades.CustomerFacade;
import com.mycompany.api.customer.response.AddressResponse;
import com.mycompany.api.data.utils.AddressDataUtil;

@Controller
@RequestMapping("/**/my-account/address")
public class CustomerAddressController 
{
	@Resource(name="addressFacade")
	private AddressFacade addressFacade;
	
	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;
	
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
	
	public AddressResponse updateAddress(AddressData addressData)
	{
		AddressResponse response= new AddressResponse();
		
		if(null != CustomerState.getCustomer() || !AddressDataUtil.validate(addressData, response))
		{
			addressData.setCustomerId(CustomerState.getCustomer().getId());
		}
		else
		{
			response.setErrorMessage("Customer should present");
		}
		
		AddressData address=addressFacade.update(addressData);
		response.setAddressData(address);
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
	
	@RequestMapping(value="/address-list", method= RequestMethod.GET, produces="application/json")
	public AddressResponse customerAdresses()
	{
		AddressResponse addressResponse= new AddressResponse();
		
		if(null ==CustomerState.getCustomer())
		{
			return addressResponse;
		}
		List<AddressData> addressList= addressFacade.getCustomerAddresses(CustomerState.getCustomer().getId());
		addressResponse.setAddressList(addressList);
		return addressResponse;
	}
	
	@RequestMapping(value="/default-address", method= RequestMethod.GET, produces="application/json")
	public AddressResponse defaultAdress()
	{
		AddressResponse addressResponse= new AddressResponse();
		
		if(null ==CustomerState.getCustomer())
		{
			return addressResponse;
		}
		AddressData addressData=addressFacade.getCutomerDefaultAddress(CustomerState.getCustomer().getId());
		addressResponse.setAddressData(addressData);
		return addressResponse;
	}
	
	@RequestMapping(value="/delete-address/{addressid}", method= RequestMethod.GET, produces="application/json")
	public AddressResponse deleteAddress(@PathVariable("addressid") Long addressId)
	{
		AddressResponse addressResponse= new AddressResponse();
		if(null ==CustomerState.getCustomer() || null == addressId)
		{
			return addressResponse;
		}
		List<AddressData> addressList=addressFacade.getDeleteAddresses(CustomerState.getCustomer().getId(), addressId);
		addressResponse.setAddressList(addressList);
		return addressResponse;
	}
	
	@RequestMapping(value="/update-address/{addressid}", method= RequestMethod.GET, produces="application/json")
	public AddressResponse addressAsDefault(@PathVariable("addressid") Long addressId)
	{
		AddressResponse addressResponse= new AddressResponse();
		if(null ==CustomerState.getCustomer() || null == addressId)
		{
			return addressResponse;
		}
		
		List<AddressData> addressList=addressFacade.makeDefaultAddress(CustomerState.getCustomer().getId(), addressId);
		addressResponse.setAddressList(addressList);
		return addressResponse;
	}
}
