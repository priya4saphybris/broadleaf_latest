package com.myapp.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public abstract class AbstractConverter<SOURCE, TARGET> implements Converter<SOURCE, TARGET>, Populator<SOURCE, TARGET>
, InitializingBean, BeanNameAware 
{

	private Class<TARGET> targetClass;
	
	private String myBeanName;
	
	@Override
	public abstract void populate(final SOURCE source, final TARGET target);
	
	public List<TARGET> convertAll(List<SOURCE> sourceList)
	{
		List<TARGET> targetList= new ArrayList<TARGET>();
		for(SOURCE source: sourceList)
		{
			TARGET target=convert(source);
			if(null != target)
			{
				targetList.add(target);
			}
		}
		return targetList;
	}

	public void setTargetClass(final Class<TARGET> targetClass)
	{
		this.targetClass = targetClass;

		// sanity check - can we instantiate that class ?
		if (targetClass != null)
		{
			createFromClass();
		}
	}
	
	@Override
	public TARGET convert(SOURCE source) throws ConvertionException 
	{
		final TARGET target= createFromClass();
		populate(source, target);
		return target;
	}

	@Override
	public TARGET convert(SOURCE source, TARGET target) throws ConvertionException {
		populate(source, target);
		return target;
	}

	@Override
	public void afterPropertiesSet() throws Exception 
	{
		if(targetClass==null)
		{
			throw new IllegalStateException("Converter "+myBeanName+" doesn't have a targetClass"
					+ " property");
		}
	}

	@Override
	public void setBeanName(String name) {
		this.myBeanName=name;
	}

	protected TARGET createFromClass()
	{
		try
		{
			return targetClass.newInstance();
		}
		catch(InstantiationException | IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
	}
}
