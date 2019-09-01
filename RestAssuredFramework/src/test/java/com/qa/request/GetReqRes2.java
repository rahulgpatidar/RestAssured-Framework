package com.qa.request;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReqRes2 {

	@Test
	public void getuser() {
		
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.get("/api/users/2");	
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getSessionId());
		System.out.println(response.getStatusLine());
		
		String body=response.getBody().asString();
		
		JSONObject json=new JSONObject(body);
		
		System.out.println(json.getJSONObject("data"));
		
		System.out.println(json.getJSONObject("data").get("email"));
	}
}
