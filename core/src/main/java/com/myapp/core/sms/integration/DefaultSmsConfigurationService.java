package com.myapp.core.sms.integration;

import com.myapp.core.catalog.model.SmsConfiguration;

public class DefaultSmsConfigurationService implements SmsConfigurationService
{
	private SmsConfigurationDao smsConfigurationDao;
	
	public SmsConfigurationDao getSmsConfigurationDao() {
		return smsConfigurationDao;
	}

	public void setSmsConfigurationDao(SmsConfigurationDao smsConfigurationDao) {
		this.smsConfigurationDao = smsConfigurationDao;
	}

	@Override
	public SmsConfiguration save(SmsConfiguration configuration) 
	{
		return smsConfigurationDao.save(configuration);
	}

	@Override
	public SmsConfiguration getConfiguration(Long configurationId) 
	{
		return smsConfigurationDao.getConfiguration(configurationId);
	}

	@Override
	public SmsConfiguration getConfiguration() 
	{
		return smsConfigurationDao.getConfiguration();
	}

}
