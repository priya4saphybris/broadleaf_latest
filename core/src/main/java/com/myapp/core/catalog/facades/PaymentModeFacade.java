package com.myapp.core.catalog.facades;

import java.util.List;
import com.myapp.core.beans.PaymentModeData;

public interface PaymentModeFacade 
{
	List<PaymentModeData> getPaymentModesForStoreFront();
}
