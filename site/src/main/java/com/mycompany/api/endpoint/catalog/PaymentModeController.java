package com.mycompany.api.endpoint.catalog;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.core.beans.PaymentModeData;
import com.myapp.core.catalog.facades.PaymentModeFacade;

@Controller
@RequestMapping("/**/payment-mode")
public class PaymentModeController 
{
	@Resource(name="paymentModeFacade")
	private PaymentModeFacade paymentModeFacade;
	
	@RequestMapping(value="/**/payment-mode", produces= "application/json")
	public List<PaymentModeData> getPaymentModesForStoreFront()
	{
		return paymentModeFacade.getPaymentModesForStoreFront();
	}
}
