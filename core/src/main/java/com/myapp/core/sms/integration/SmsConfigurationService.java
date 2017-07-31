package com.myapp.core.sms.integration;

import com.myapp.core.catalog.model.SmsConfiguration;

public interface SmsConfigurationService 
{
	SmsConfiguration save(SmsConfiguration configuration);
	SmsConfiguration getConfiguration(Long configurationId);
	SmsConfiguration getConfiguration();
}