package com.myapp.core.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;
import com.myapp.core.populator.Populators;

@Component("populatorConverter")
public class AbstractPopulatorConverter<SOURCE, TARGET> extends AbstractConverter<SOURCE, TARGET> 
	implements Populators<SOURCE, TARGET>
{
	private List<Populator<SOURCE, TARGET>> populators;
	
	@Override
	public List<Populator<SOURCE, TARGET>> getPopulators() 
	{
		return populators;
	}

	@Override
	public void setPopulators(List<Populator<SOURCE, TARGET>> populators) 
	{
		this.populators=populators;
	}
	
	@Override
	public void populate(SOURCE source, TARGET target) throws ConvertionException 
	{
		final List<Populator<SOURCE, TARGET>> list= getPopulators();
		
		if(null != list)
		{
			for(Populator<SOURCE, TARGET> populator: list)
			{
				populator.populate(source, target);
			}
		}
	}
}
