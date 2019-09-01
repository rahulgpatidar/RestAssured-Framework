package com.qa.request;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_ReqRes2 {

	@Test
	public void adduser() {
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json=new JSONObject();
		json.put("name", "rahul");
		json.put("job", "QA");
		
		request.body(json.toJSONString());
		
		Response response=request.post("/api/users");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}
}
