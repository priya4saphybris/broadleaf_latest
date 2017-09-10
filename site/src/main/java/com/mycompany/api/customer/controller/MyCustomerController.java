package com.mycompany.api.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.order.CartState;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.broadleafcommerce.profile.web.core.service.login.LoginService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.myapp.core.beans.AddressData;
import com.myapp.core.beans.CustomerData;
import com.myapp.core.beans.RestMessageData;
import com.myapp.core.catalog.facades.CustomerFacade;
import com.myapp.core.catalog.service.MyCustomerService;
import com.myapp.core.forms.MyCustomerForm;
import com.myapp.core.user.MyCustomerImpl;
import com.mycompany.api.customer.response.AddressResponse;
import com.mycompany.api.customer.response.CustomerResponse;

@Controller
@RequestMapping("/**/customer")
public class MyCustomerController 
{
	private static final Logger LOG= Logger.getLogger(MyCustomerController.class);
	
	@Resource(name = "blCustomerService")
	protected CustomerService customerService;
	
	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;
	
	@Resource(name = "blLoginService")
	protected LoginService loginService;
	
	@Resource(name = "blOrderService")
	protected OrderService orderService;
	
	@Resource(name = "blUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Resource(name = "myCustomerService")
	private MyCustomerService myCustomerService;
	
	@RequestMapping(value="/create", method= RequestMethod.POST)
	@ResponseBody
	public RestMessageData createCustomer(HttpServletRequest request, HttpServletResponse response,
			MyCustomerForm customerForm) throws PricingException, JsonParseException, IOException
	{
		MyCustomerForm myCustomerForm= new MyCustomerForm();
		myCustomerForm.setFirstName(customerForm.getFirstName());
		myCustomerForm.setLastName(customerForm.getLastName());
		myCustomerForm.setEmailAddress(customerForm.getEmailAddress());
		myCustomerForm.setPassword(customerForm.getPassword());
		myCustomerForm.setPasswordConfirm(customerForm.getPasswordConfirm());
		
		LOG.info("Registering customer");
		RestMessageData rmd= new RestMessageData();
		
		try
		{
			this.register(myCustomerForm, rmd);
		}
		catch(Exception ex)
		{
			LOG.error(ex);
			rmd.setIsSuccess(false);
		}
		
		return rmd;
	}
	
	@RequestMapping(value="/list", method= RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<CustomerData> getCustomers()
	{
		return customerFacade.readAllCustomers();
	}
	
	private void register(MyCustomerForm myCustomerForm, RestMessageData rmd) throws PricingException
	{
		MyCustomerImpl customer = new MyCustomerImpl();
		customer.setUsername(myCustomerForm.getEmailAddress());
		customer.setFirstName(myCustomerForm.getFirstName());
		customer.setLastName(myCustomerForm.getLastName());
		customer.setUsername(myCustomerForm.getEmailAddress());
		customer.setAccessToken("dodksadpadpask");
		MyCustomerImpl newCustomer = null;
		
		try
		{
			userDetailsService.loadUserByUsername(myCustomerForm.getEmailAddress());
			rmd.setIsSuccess(false);
			rmd.setException("Customer already registered");
		}
		catch(UsernameNotFoundException unf)
		{
			newCustomer =(MyCustomerImpl) this.customerService.registerCustomer(customer,
					myCustomerForm.getPassword(), myCustomerForm.getPasswordConfirm());
			this.loginService.loginCustomer(customer);
			
			assert (newCustomer != null);
			
			Order cart = CartState.getCart();
			if ((cart != null) && (!(cart instanceof NullOrderImpl)) && (cart.getEmailAddress() == null)) {
				cart.setEmailAddress(newCustomer.getEmailAddress());
				this.orderService.save(cart, Boolean.valueOf(false));
			}
			
			rmd.setIsSuccess(true);
		}
		
	}
	
	@RequestMapping(value="/profile", method= RequestMethod.GET, produces="application/json")
	public CustomerResponse myprofile(HttpServletRequest request)
	{
		CustomerResponse customerResponse= new CustomerResponse();
		
		if(null ==CustomerState.getCustomer())
		{
			return customerResponse;
		}
		
		CustomerData customerData= customerFacade.getCurrentCustomer(CustomerState.getCustomer());
		customerResponse.setCustomerData(customerData);
		return customerResponse;
	}
}
