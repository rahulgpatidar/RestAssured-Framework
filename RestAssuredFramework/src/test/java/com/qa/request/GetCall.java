package com.qa.request;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.utility.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetCall extends TestBase {

	@Test
	public void getRestAPI() {
		parentTest = extent.createTest("Get Request Test");
		childTest = parentTest.createNode("Testing");
		childTest.info("----------yep-------------");
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";

		Response response = RestAssured.get(RestAssured.baseURI);
		
		System.out.println("Status code is : " + response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 200);

		String body = response.getBody().asString();
		System.out.println("Body :" + body);

		String sessionId = response.getSessionId();
		System.out.println("Session id is : " + sessionId);

		Headers header = response.getHeaders();
		System.out.println("Get all the headers of : " + header);
		for (Header header2 : header) {
			System.out.println("Cookies are------------- : " + header2.getName());
		}

		System.out.println("Status line is----------- : " + response.getStatusLine());

		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.get("City"));
	}
}
