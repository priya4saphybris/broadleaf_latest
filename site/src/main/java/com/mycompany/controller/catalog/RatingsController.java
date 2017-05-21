/*
 * Copyright 2008-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mycompany.controller.catalog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.broadleafcommerce.core.web.controller.catalog.BroadleafRatingsController;
import org.broadleafcommerce.core.web.controller.catalog.ReviewForm;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.core.beans.MyRatingType;

@Controller
public class RatingsController extends BroadleafRatingsController 
{
	@Resource(name = "blCustomerService")
	protected CustomerService customerService;
	
    @RequestMapping(value = "/reviews/product/{itemId}", method = RequestMethod.GET)
    public String viewReviewForm(HttpServletRequest request, Model model, @PathVariable("itemId") String itemId, @ModelAttribute("reviewForm") ReviewForm form) {
        return super.viewReviewForm(request, model, form, itemId);
    }
    
    @RequestMapping(value = "/reviews/product/{itemId}", method = RequestMethod.POST)
    public String reviewItem(HttpServletRequest request, Model model, @PathVariable("itemId") String itemId, @ModelAttribute("reviewForm") ReviewForm form) {
        return super.reviewItem(request, model, form, itemId);
    }
    
    @RequestMapping(value = "/reviews/store/{itemId}", method = RequestMethod.POST)
    @ResponseBody
    public String reviewStore(HttpServletRequest request, Model model, @PathVariable("itemId") String itemId, @ModelAttribute("reviewForm") ReviewForm form)
    {
    	reviewStore(request, model, form, itemId);
		return itemId;
    }
    
    @RequestMapping(value = "/reviews/store/{itemId}", method = RequestMethod.GET)
    public void getReviewsByStore(HttpServletRequest request, Model model, @PathVariable("itemId") String itemId)
    {
    	
    }
    
    public void reviewStore(HttpServletRequest request, Model model, ReviewForm form, String itemId) 
    {
		this.ratingService.reviewItem(itemId, MyRatingType.STORE, CustomerState.getCustomer(), form.getRating(),
				form.getReviewText());
	}
    
}
