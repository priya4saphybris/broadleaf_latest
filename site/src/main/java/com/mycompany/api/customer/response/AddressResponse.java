package com.mycompany.api.customer.response;

import java.util.List;

import com.myapp.core.beans.AddressData;

public class AddressResponse 
{
	private String errorMessage;
	private AddressData addressData;
	private List<AddressData> addressList;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public AddressData getAddressData() {
		return addressData;
	}
	public void setAddressData(AddressData addressData) {
		this.addressData = addressData;
	}
	public List<AddressData> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressData> addressList) {
		this.addressList = addressList;
	}
	
	
}
