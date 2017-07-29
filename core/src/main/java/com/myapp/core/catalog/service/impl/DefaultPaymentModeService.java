package com.myapp.core.catalog.service.impl;

import java.util.List;

import com.myapp.core.catalog.dao.PaymentModeDao;
import com.myapp.core.catalog.model.PaymentMode;
import com.myapp.core.catalog.service.PaymentModeService;

public class DefaultPaymentModeService implements PaymentModeService
{
	private PaymentModeDao paymentModeDao;
	
	public PaymentModeDao getPaymentModeDao() {
		return paymentModeDao;
	}

	public void setPaymentModeDao(PaymentModeDao paymentModeDao) {
		this.paymentModeDao = paymentModeDao;
	}

	@Override
	public List<PaymentMode> getPaymentModesForStoreFront() 
	{
		return paymentModeDao.getPaymentModesForStoreFront();
	}

}
