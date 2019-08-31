package com.qa.request;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void postCall() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer/register";

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("FirstName", "Rahul");
		jsonObject.put("LastName", "Patidar");
		jsonObject.put("UserName", "test");
		jsonObject.put("Password", "test");
		jsonObject.put("Email", "aa@aa.com");

		request.body(jsonObject.toJSONString());

		Response response = request.post(RestAssured.baseURI);

		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body().asString());

	}
}
