package com.qa.tests;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetContactsAPITest extends TestBase {
	TestBase testBase;
	String url;
	RestClient restClient;
	CloseableHttpResponse httpgetResponse;

	@BeforeTest
	public void setUp() {
		testBase = new TestBase();
		String baseURl = prop.getProperty("URL");
		String resource = prop.getProperty("resource");
		url = baseURl + resource;
	}

	@Test(priority = 1)
	public void getContactsApi() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		httpgetResponse = restClient.getContacts(url);
		int statusCode = httpgetResponse.getStatusLine().getStatusCode();
		System.out.println("status code is====>" + statusCode);

		Assert.assertEquals(statusCode, 200);
		// Json String
		String stringResponse = EntityUtils.toString(httpgetResponse.getEntity(), "UTF-8");

		// converting string response into JSON format
		JSONArray jsonArrayResponse = new JSONArray(stringResponse);

		// JSONObject jsonResponse=new JSONObject(stringResponse);
		System.out.println("Json array response is 111111 ====>" + jsonArrayResponse);

		// validating Response Headers
		Header[] headerarray = httpgetResponse.getAllHeaders();

		// Adding headers into HashMap
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headerarray) {
			allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("headers array 111111 ====>" + allHeaders);
	}

	@Test(priority = 2)
	public void getContactsApiWithHeaders() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		httpgetResponse = restClient.get(url, headerMap);
		// a. Status Code:
		int statusCode = httpgetResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->" + statusCode);

		Assert.assertEquals(statusCode, 200);
		// b. Json String:
		String stringResponse = EntityUtils.toString(httpgetResponse.getEntity(), "UTF-8");
		// converting string response into JSON format
		JSONArray jsonArrayResponse = new JSONArray(stringResponse);

		// JSONObject jsonResponse=new JSONObject(stringResponse);
		System.out.println("Json array response is 2222222 ====>" + jsonArrayResponse);

		// validating Response Headers
		Header[] headerarray = httpgetResponse.getAllHeaders();

		// Adding headers into HashMap
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headerarray) {
			allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("headers array 222222 ====>" + allHeaders);

	}
}
