package com.myapp.core.populators;

import com.myapp.core.beans.PaymentModeData;
import com.myapp.core.catalog.model.PaymentMode;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class PaymentModePopulator implements Populator<PaymentMode, PaymentModeData>
{

	@Override
	public void populate(PaymentMode source, PaymentModeData target) throws ConvertionException 
	{
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setLogoImage(source.getLogoImage());
		target.setPaymentType(source.getType());
		target.setActive(source.isActive());
	}
}
