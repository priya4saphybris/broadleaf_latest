package com.myapp.core.user;

import com.myapp.core.catalog.model.LocationSelection;

public interface MyCustomer 
{
	LocationSelection getLocationSelection();
	void setLocationSelection(LocationSelection locationSelection);
}
