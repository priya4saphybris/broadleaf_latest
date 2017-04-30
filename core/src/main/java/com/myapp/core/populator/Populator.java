package com.myapp.core.populator;

import com.myapp.core.convertion.exception.ConvertionException;

public interface Populator<SOURCE, TARGET> 
{
	void populate(SOURCE source, TARGET target) throws ConvertionException;
}
