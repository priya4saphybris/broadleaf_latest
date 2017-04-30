package com.myapp.core.populator;

import java.util.List;

public interface Populators<SOURCE, TARGET> 
{
	List<Populator<SOURCE, TARGET>> getPopulators();
	void setPopulators(List<Populator<SOURCE, TARGET>> populators);
}
