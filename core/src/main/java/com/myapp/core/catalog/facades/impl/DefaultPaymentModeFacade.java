package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.myapp.core.beans.PaymentModeData;
import com.myapp.core.catalog.facades.PaymentModeFacade;
import com.myapp.core.catalog.model.PaymentMode;
import com.myapp.core.catalog.service.PaymentModeService;
import com.myapp.core.converter.Converter;

public class DefaultPaymentModeFacade implements PaymentModeFacade
{
	private PaymentModeService paymentModeService;
	
	private Converter<PaymentMode, PaymentModeData> paymentModeConverter;
	
	
	public Converter<PaymentMode, PaymentModeData> getPaymentModeConverter() {
		return paymentModeConverter;
	}


	public void setPaymentModeConverter(Converter<PaymentMode, PaymentModeData> paymentModeConverter) {
		this.paymentModeConverter = paymentModeConverter;
	}


	public PaymentModeService getPaymentModeService() {
		return paymentModeService;
	}


	public void setPaymentModeService(PaymentModeService paymentModeService) {
		this.paymentModeService = paymentModeService;
	}


	@Override
	public List<PaymentModeData> getPaymentModesForStoreFront() 
	{
		List<PaymentMode> paymentModes=paymentModeService.getPaymentModesForStoreFront();
		List<PaymentModeData> paymentModeList= new ArrayList<PaymentModeData>();
		
		for(PaymentMode paymentMode: paymentModes)
		{
			paymentModeList.add(paymentModeConverter.convert(paymentMode));
		}
		return paymentModeList;
	}

}
