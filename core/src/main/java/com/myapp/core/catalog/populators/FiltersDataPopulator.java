package com.myapp.core.catalog.populators;

import org.broadleafcommerce.core.search.domain.SearchFacetDTO;

import com.myapp.core.catalog.beans.FacetBasicValueData;
import com.myapp.core.catalog.beans.FacetData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class FiltersDataPopulator implements Populator<SearchFacetDTO, FacetData> 
{

	@Override
	public void populate(SearchFacetDTO source, FacetData target) throws ConvertionException 
	{
		FacetBasicValueData facetValueData=new FacetBasicValueData();
		
		if(null !=source.getFacet())
		{
			facetValueData.setId(source.getFacet().getId());
			facetValueData.setName(source.getFacet().getName());
			facetValueData.setLabel(source.getFacet().getName());
			//facetValueData.setType(source.getFacet().get);
		}
		
	}

}
