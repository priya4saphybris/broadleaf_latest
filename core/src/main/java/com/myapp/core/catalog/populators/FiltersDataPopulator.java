package com.myapp.core.catalog.populators;

import java.util.ArrayList;
import java.util.List;

import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;

import com.myapp.core.catalog.beans.FacetBasicValueData;
import com.myapp.core.catalog.beans.FacetValueData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class FiltersDataPopulator implements Populator<SearchFacetDTO, FacetValueData> 
{

	@Override
	public void populate(SearchFacetDTO source, FacetValueData target) throws ConvertionException 
	{
		if(null != source.getFacet())
		{
			target.setId(source.getFacet().getId());
			target.setName(source.getFacet().getName());
			target.setLabel(source.getFacet().getLabel());
			
			if(null != source.getFacet().getFieldType() && null != source.getFacet().getFieldType().getFieldType())
			{
				target.setType(source.getFacet().getFieldType().getFieldType().getType());
			}
			
			List<FacetBasicValueData> values= new ArrayList<FacetBasicValueData>();
			for(SearchFacetResultDTO facetResult:source.getFacetValues())
			{	
				if(null != facetResult.getFacet())
				{
					FacetBasicValueData facetValueData=new FacetBasicValueData();
					SearchFacet searchFacet=facetResult.getFacet();
					facetValueData.setId(searchFacet.getId());
					facetValueData.setValue(facetResult.getValue());
					facetValueData.setQuantity(Long.valueOf(facetResult.getQuantity()));
					values.add(facetValueData);
				}
			}
			target.setValues(values);
		}
		
	}

}
