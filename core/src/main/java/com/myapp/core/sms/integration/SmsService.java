package com.myapp.core.sms.integration;

import java.util.List;

public interface SmsService 
{
	boolean send(String phoneNumber);
	boolean send(List<String> phoneNumbers);
}
