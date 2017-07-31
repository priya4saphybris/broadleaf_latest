package com.myapp.core.sms.integration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

import com.myapp.core.catalog.model.SmsConfiguration;
import com.myapp.core.catalog.model.SmsConfigurationImpl;

public class DefaultSmsConfigurationDao implements SmsConfigurationDao
{
	@PersistenceContext(unitName = "blPU")
	protected EntityManager em;
	
	@Override
	public SmsConfiguration save(SmsConfiguration configuration) 
	{
		return (SmsConfiguration)em.merge(configuration);
	}

	@Override
	public SmsConfiguration getConfiguration(Long configurationId) 
	{
		return (SmsConfiguration) this.em.find(SmsConfigurationImpl.class, configurationId);
	}

	@Override
	public SmsConfiguration getConfiguration() 
	{
		Query query= em.createQuery("From "+com.myapp.core.catalog.model.SmsConfigurationImpl.class.getName(), SmsConfigurationImpl.class);
		
		if(null != query.getResultList() && !CollectionUtils.isEmpty(query.getResultList()))
		{
			return (SmsConfiguration) query.getResultList().get(0);
		}
		
		return null;
	}
}
