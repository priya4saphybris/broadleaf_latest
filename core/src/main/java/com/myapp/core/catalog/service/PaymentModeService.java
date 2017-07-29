package com.myapp.core.catalog.service;

import java.util.List;
import com.myapp.core.catalog.model.PaymentMode;

public interface PaymentModeService 
{
	List<PaymentMode> getPaymentModesForStoreFront();
}
