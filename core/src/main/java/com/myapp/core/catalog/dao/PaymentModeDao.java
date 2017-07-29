package com.myapp.core.catalog.dao;

import java.util.List;
import com.myapp.core.catalog.model.PaymentMode;

public interface PaymentModeDao 
{
	List<PaymentMode> getPaymentModesForStoreFront();
}
