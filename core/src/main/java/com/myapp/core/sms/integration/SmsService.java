package com.myapp.core.sms.integration;

import java.io.IOException;
import java.util.List;

public interface SmsService 
{
	boolean send(String phoneNumber, String message, String type) throws IOException;
	boolean send(List<String> phoneNumbers, String message, String type);
}
