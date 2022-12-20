package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PostUsersPITest extends TestBase {

	TestBase testBase;
	String url;
	RestClient restClient;
	CloseableHttpResponse httpgetResponse;

	@BeforeTest
	public void setUp() {
		testBase = new TestBase();
		String baseURl = prop.getProperty("postUrl");
		String resource = prop.getProperty("serviceURL");
		url = baseURl + resource;
	}

	@Test
	public void postContactsApiWithHeaders() throws JsonGenerationException, JsonMappingException, IOException {
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

	
		//ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("shwetha", "Testlead");//payload

		// converting java objects users into json file
		// jackson Api library has mapper class
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(
				"/Users/shwethamohanpulle/Documents/Projects/HackathonAPI/HTTPClient/src/main/java/com/qa/data/users.json"),
				users);

		// converting Json file into string to send through post call as body
		String userJsonBodyString = mapper.writeValueAsString(users);
		System.out.println("Request Body is:"+userJsonBodyString);

		// sending request
		httpgetResponse = restClient.postUsers(url, userJsonBodyString, headerMap);

		// Validating Status code
		int statusCode = httpgetResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		//Validating ResponseBody  Raw String
		String jsonResponse=EntityUtils.toString(httpgetResponse.getEntity(),"UTF-8");
		System.out.println("Response in String format is:"+jsonResponse);
		
		//converting json response into json object to parse throgh 
		JSONObject resObject= new JSONObject(jsonResponse);
		System.out.println("Response from API is:"+ resObject);
		System.out.println(resObject.get("name"));
		
		//converting json  back into java object 
	Users userResObj=mapper.readValue(jsonResponse, Users.class);
	
	Assert.assertTrue(users.getName().equals(userResObj.getName()));
	Assert.assertTrue(users.getJob().equals(userResObj.getJob()));
	
		
	}

}
