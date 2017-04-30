package com.myapp.core.converter;

import com.myapp.core.convertion.exception.ConvertionException;

public interface Converter<SOURCE, TARGET> extends org.springframework.core.convert.converter.Converter<SOURCE, TARGET>
{
	TARGET convert(SOURCE source) throws ConvertionException;
	TARGET convert(SOURCE source, TARGET target) throws ConvertionException;
}
