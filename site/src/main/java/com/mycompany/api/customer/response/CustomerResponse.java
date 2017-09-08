package com.mycompany.api.customer.response;

import java.util.List;

import com.myapp.core.beans.AddressData;
import com.myapp.core.beans.CustomerData;

public class CustomerResponse 
{
	private CustomerData customerData;
	private AddressData defaultAddress;
	private List<AddressData> addressList;
	
	public CustomerData getCustomerData() {
		return customerData;
	}
	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}
	public AddressData getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(AddressData defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	public List<AddressData> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressData> addressList) {
		this.addressList = addressList;
	}
	
}
