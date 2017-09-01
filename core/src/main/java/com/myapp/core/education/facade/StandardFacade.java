package com.myapp.core.education.facade;

import java.util.List;

import com.myapp.core.education.beans.StandardData;

public interface StandardFacade 
{
	StandardData save(StandardData standardData);
	List<StandardData> getStandards();
	StandardData getStandardById(Long id);
}
