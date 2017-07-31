package com.myapp.core.sms.integration;

import java.util.List;

public class DefaultSmsService implements SmsService
{
	private SmsConfigurationService smsConfigurationService;
	
	public SmsConfigurationService getSmsConfigurationService() {
		return smsConfigurationService;
	}

	public void setSmsConfigurationService(SmsConfigurationService smsConfigurationService) {
		this.smsConfigurationService = smsConfigurationService;
	}

	@Override
	public boolean send(String phoneNumber) 
	{
		return false;
	}

	@Override
	public boolean send(List<String> phoneNumbers) 
	{
		return false;
	}

}
