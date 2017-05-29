package com.myapp.core.beans;

import java.util.HashMap;
import java.util.Map;

import org.broadleafcommerce.core.rating.service.type.RatingType;

public class MyRatingType extends RatingType
{
	private static final long serialVersionUID = 1L;
	
	private static final Map<String, RatingType> TYPES = new HashMap();

	public static final MyRatingType PRODUCT = new MyRatingType("PRODUCT");
	
	private String type;
	
	public static final RatingType STORE = new RatingType("STORE");
	
	public static RatingType getInstance(String type) {
		return ((RatingType) TYPES.get(type));
	}

	public MyRatingType() {
	}

	public MyRatingType(String type) {
		setType(type);
	}

	public String getType() {
		return this.type;
	}

	private void setType(String type) {
		this.type = type;
		if (!(TYPES.containsKey(type)))
			TYPES.put(type, this);
	}

	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = 31 * result + ((this.type == null) ? 0 : this.type.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(super.getClass().isAssignableFrom(obj.getClass())))
			return false;
		MyRatingType other = (MyRatingType) obj;
		if (this.type == null)
			if (other.type != null)
				return false;
			else if (!(this.type.equals(other.type)))
				return false;
		return true;
	}
}
