package com.qa.request;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void getCall() {
	
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		Response response = request.get(RestAssured.baseURI);
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.getContentType());
		System.out.println(response.getSessionId());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeaders());
		System.out.println(response.body().asString());

		JsonPath jsonPath = response.jsonPath();

		/*
		 * RestAssured.baseURI = "http://api.plos.org/search?q=title";
		 * RequestSpecification request = RestAssured.given(); Response response =
		 * request.request(Method.GET, ":DNA"); String body =
		 * response.getBody().asString(); // System.out.println(body);
		 * 
		 * Headers header = response.getHeaders();
		 * System.out.println("Headers are-------" + header);
		 * 
		 * String content = header.getValue("Content-Type");
		 * System.out.println(content);
		 * 
		 * System.out.println(response.sessionId());
		 * System.out.println(response.getSessionId());
		 * System.out.println(response.getStatusCode());
		 * System.out.println(response.getStatusLine()); JsonPath jsonPath =
		 * response.jsonPath(); System.out.println("--------------------------" +
		 * jsonPath.get("title"));
		 */

	}
}
