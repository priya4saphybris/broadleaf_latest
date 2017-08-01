package com.myapp.core.sms.integration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import com.myapp.core.catalog.model.SmsConfiguration;

public class DefaultSmsService implements SmsService
{
	private SmsConfigurationService smsConfigurationService;
	
	public SmsConfigurationService getSmsConfigurationService() {
		return smsConfigurationService;
	}

	public void setSmsConfigurationService(SmsConfigurationService smsConfigurationService) {
		this.smsConfigurationService = smsConfigurationService;
	}

	@Override
	public boolean send(String phoneNumber, String message, String type) throws IOException 
	{
		SmsConfiguration smsConfiguration= smsConfigurationService.getConfiguration();
		StringBuffer data=new StringBuffer("user=");
		data.append(URLEncoder.encode(smsConfiguration.getUsername(), "UTF-8"));
		data.append("&password=");
		data.append(URLEncoder.encode(smsConfiguration.getPassword(), "UTF-8"));
		data.append("&message=");
		data.append(URLEncoder.encode(message, "UTF-8"));
		data.append("&mobile=");
		data.append(URLEncoder.encode(phoneNumber, "UTF-8"));
		data.append("&type=");
		data.append(URLEncoder.encode(type, "UTF-8"));
		
		URL url= new URL(smsConfiguration.getUrl());
		URLConnection conn= url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data.toString());
		wr.flush();
		String line;
		String sResult1="";
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = rd.readLine()) != null) 
		{
			// Process line...
			sResult1=sResult1+line+" ";
		}
		wr.close();
		rd.close();
		return false;
	}

	@Override
	public boolean send(List<String> phoneNumbers, String message, String type) 
	{
		return false;
	}
}
