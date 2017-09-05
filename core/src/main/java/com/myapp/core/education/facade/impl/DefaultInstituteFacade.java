package com.myapp.core.education.facade.impl;

import java.util.List;

import javax.annotation.Resource;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import com.myapp.core.beans.AddressData;
import com.myapp.core.converter.Converter;
import com.myapp.core.education.beans.InstituteData;
import com.myapp.core.education.facade.InstituteFacade;
import com.myapp.core.education.organization.Institute;
import com.myapp.core.education.populator.AddressReversePopulator;
import com.myapp.core.education.populator.InstituteReversePopulator;
import com.myapp.core.education.service.InstituteService;

public class DefaultInstituteFacade implements InstituteFacade
{
	@Resource(name="blAddressService")
	private AddressService addressService;
	
	private InstituteService instituteService;
	
	private Converter<Institute, InstituteData> instituteConverter;
	
	private InstituteReversePopulator instituteReversePopulator;
	
	private AddressReversePopulator addressReversePopulator;
	
	private Converter<Address, AddressData> addressConverter;
	
	public Converter<Address, AddressData> getAddressConverter() {
		return addressConverter;
	}

	public void setAddressConverter(Converter<Address, AddressData> addressConverter) {
		this.addressConverter = addressConverter;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public AddressReversePopulator getAddressReversePopulator() {
		return addressReversePopulator;
	}

	public void setAddressReversePopulator(AddressReversePopulator addressReversePopulator) {
		this.addressReversePopulator = addressReversePopulator;
	}

	public InstituteReversePopulator getInstituteReversePopulator() {
		return instituteReversePopulator;
	}

	public void setInstituteReversePopulator(InstituteReversePopulator instituteReversePopulator) {
		this.instituteReversePopulator = instituteReversePopulator;
	}

	public Converter<Institute, InstituteData> getInstituteConverter() {
		return instituteConverter;
	}

	public void setInstituteConverter(Converter<Institute, InstituteData> instituteConverter) {
		this.instituteConverter = instituteConverter;
	}

	public InstituteService getInstituteService() {
		return instituteService;
	}

	public void setInstituteService(InstituteService instituteService) {
		this.instituteService = instituteService;
	}

	@Override
	public InstituteData save(InstituteData instituteData) 
	{
		Institute institute= new Institute();
		instituteReversePopulator.populate(instituteData, institute);
		institute= instituteService.save(institute);
		return instituteConverter.convert(institute);
	}

	@Override
	public InstituteData getInstitute(Long id) 
	{
		Institute institute=instituteService.getInstitute(id);
		if(null != institute)
		{
			return null;
		}
		return instituteConverter.convert(institute);
	}

	@Override
	public List<InstituteData> getInstitutes() 
	{
		List<Institute> institutes= instituteService.getInstitues();
		return instituteConverter.convertAll(institutes);
	}

	@Override
	public InstituteData createAddress(AddressData addressData, Long instituteId) 
	{
		Address address= new AddressImpl();
		addressReversePopulator.populate(addressData, address);
		
		address=addressService.saveAddress(address);
		AddressData updatedAddressData=addressConverter.convert(address);
		
		Institute institute= instituteService.getInstitute(instituteId);
		institute.setAddress(address);
		institute=instituteService.save(institute);
		InstituteData instituteData=instituteConverter.convert(institute);
		
		instituteData.setAddressData(updatedAddressData);
		
		return instituteData;
	}

}
