package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class RestClient {


	// Get Method without headers
	public CloseableHttpResponse getContacts(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();// it creates default client
		HttpGet httpget = new HttpGet(url);// create request method
		CloseableHttpResponse httpgetResponse = httpClient.execute(httpget);// execute method send the request and
																			// returns response
		return httpgetResponse;

	}

	// 2. GET Method with Headers:
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request
		
		// adding headers in get request
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse httpgetResponse = httpClient.execute(httpget); // hit the GET URL
		return httpgetResponse;
}
	
	//3.POST Method with Headers:
	public CloseableHttpResponse postUsers(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient	httpClient=	HttpClients.createDefault();
		HttpPost httppost=	new HttpPost(url);//http post request
		httppost.setEntity(new StringEntity(entityString));//for payload
		
		// adding headers in get request
		
				for (Map.Entry<String, String> entry : headerMap.entrySet()) {
					httppost.addHeader(entry.getKey(), entry.getValue());
				}
		CloseableHttpResponse httppostResponse =httpClient.execute(httppost);//hit the POST URL
		return httppostResponse;
		
}
	
	//4.PUT Method with Headers:
	public CloseableHttpResponse putUsers(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPut httpput=	new HttpPut(url);//http post request
	httpput.setEntity(new StringEntity(entityString));//for payload
	// adding headers in get request
	for (Map.Entry<String, String> entry : headerMap.entrySet()) {
		httpput.addHeader(entry.getKey(), entry.getValue());
	}
CloseableHttpResponse httppostResponse =httpClient.execute(httpput);//hit the POST URL
return httppostResponse;

}
}