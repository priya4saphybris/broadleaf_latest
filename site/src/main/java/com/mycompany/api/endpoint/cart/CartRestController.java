package com.mycompany.api.endpoint.cart;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.api.BroadleafWebServicesException;
import org.broadleafcommerce.core.web.api.wrapper.OrderWrapper;
import org.broadleafcommerce.core.web.order.CartState;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/**/rcart")
public class CartRestController extends CartEndpoint
{
	@Resource(name = "blOrderService")
	protected OrderService orderService;
	
	@Override
    @RequestMapping(value = "{productId}", method = RequestMethod.POST)
    public OrderWrapper addProductToOrder(HttpServletRequest request,
            @RequestParam MultiValueMap<String, String> requestParams,
            @PathVariable("productId") Long productId,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam(value = "quantity", defaultValue = "1") int quantity,
            @RequestParam(value = "priceOrder", defaultValue = "true") boolean priceOrder) {
        return this.addProductToCart(request, requestParams, productId, categoryId, quantity, priceOrder);
    }
	
	public OrderWrapper addProductToCart(HttpServletRequest request, MultiValueMap<String, String> requestParams,
			Long productId, Long categoryId, int quantity, boolean priceOrder) {
		Order cart = CartState.getCart();
		if ((cart == null) || (cart instanceof NullOrderImpl)) {
			Customer customer=CustomerState.getCustomer();
			cart=orderService.createNewCartForCustomer(customer);
		}

		try {
			HashMap productOptions = getOptions(requestParams);

			OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
			orderItemRequestDTO.setProductId(productId);
			orderItemRequestDTO.setCategoryId(categoryId);
			orderItemRequestDTO.setQuantity(Integer.valueOf(quantity));

			if (productOptions.size() > 0) {
				orderItemRequestDTO.setItemAttributes(productOptions);
			}

			Order order = this.orderService.addItem(cart.getId(), orderItemRequestDTO, priceOrder);
			order = this.orderService.save(order, Boolean.valueOf(priceOrder));

			OrderWrapper wrapper = (OrderWrapper) this.context.getBean(OrderWrapper.class.getName());
			wrapper.wrapDetails(order, request);

			return wrapper;
		} catch (PricingException e) {
			throw BroadleafWebServicesException.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, null, e);
		} catch (AddToCartException e) {
			throw BroadleafWebServicesException.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, null, e);
		}
	}
}
