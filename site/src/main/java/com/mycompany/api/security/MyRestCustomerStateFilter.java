package com.mycompany.api.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.web.order.security.CartStateRequestProcessor;
import org.broadleafcommerce.core.web.order.security.CartStateRequestProcessorExtensionHandler;
import org.broadleafcommerce.core.web.order.security.CartStateRequestProcessorExtensionManager;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.GenericFilterBean;

public class MyRestCustomerStateFilter extends GenericFilterBean implements Ordered
{
	protected static final Log LOG = LogFactory.getLog(MyRestCustomerStateFilter.class);
	@Resource(name = "blCustomerService")
	protected CustomerService customerService;
	public static final String CUSTOMER_ID_ATTRIBUTE = "customerId";
	
	@Resource(name = "blCartStateRequestProcessor")
	protected CartStateRequestProcessor cartStateProcessor;
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException 
	{

		String customerId = null;

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		if (request.getAttribute(CustomerStateRequestProcessor.getCustomerRequestAttributeName()) == null) {
			if (request.getAttribute("customerId") != null) {
				customerId = String.valueOf(request.getAttribute("customerId"));
			}

			if (customerId == null) {
				customerId = servletRequest.getParameter("customerId");
			}

			if (customerId == null) {
				customerId = request.getHeader("customerId");
			}

			if ((customerId != null) && (customerId.trim().length() > 0)) {
				if (NumberUtils.isNumber(customerId)) {
					Customer customer = this.customerService.readCustomerById(Long.valueOf(customerId));
					if (customer != null)
						CustomerState.setCustomer(customer);
					
					this.cartStateProcessor.process(new ServletWebRequest(request, response));
				} else {
					LOG.warn(String.format("The customer id passed in '%s' was not a number",
							new Object[] { customerId }));
				}
			}

			if ((customerId == null) && (LOG.isDebugEnabled())) {
				LOG.debug(
						"No customer ID was found for the API request. In order to look up a customer for the request send a request parameter or request header for the 'customerId' attribute");
			}

		}

		filterChain.doFilter(request, servletResponse);
	
		
	}

	@Override
	public int getOrder() {
		return 2000;
	}
	
}
