/**
 * 
 */
package com.ziffi.rest;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author vawasthi
 *
 */
@Component
public class RestConsumer {

	@Autowired
	private RestTemplate restTemplate;
	
	public RestConsumer(){}
	
	public  String  doPost( String url, String jsonForm){
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
		HttpEntity<String> httpEntity = restTemplate.postForEntity(url, new HttpEntity<String>(jsonForm, requestHeaders), String.class);
		return httpEntity.getBody();
	}
	public  String  doGet( String url, String jsonForm){
	//	HttpHeaders requestHeaders = new HttpHeaders();
	//	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	//	requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
	//	HttpEntity<String> httpEntity = restTemplate.getForEntity(url, new HttpEntity<String>(jsonForm, requestHeaders), String.class);
		HttpEntity<String> httpEntity = restTemplate.getForEntity(url, String.class);
		return httpEntity.getBody();
	}

}