package com.qa.request;

import java.util.List;

import org.json.JSONObject;
import org.json.JSONArray;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class GetReqRes {

	@Test
	public void getuser() {
		
		RestAssured.baseURI="https://reqres.in";
		/*
		 * RestAssured.basePath=""; RestAssured.basic(username, password);
		 * RestAssured.oauth(consumerKey, consumerSecret, accessToken, secretToken);
		 * RestAssured.oauth2(accessToken);
		 */
		RequestSpecification request=RestAssured.given();
		
		Response response=request.get("/api/users?page=2");
		
		System.out.println("status code is :"+ response.getStatusCode());
		String body=response.getBody().asString();
		
		/*
		 * JsonPath json=response.jsonPath();
		 * System.out.println(json.getString("total"));
		 */
		
		JSONObject jsonObject=new JSONObject(body);
		System.out.println(jsonObject.get("total"));
		
		JSONArray js=jsonObject.getJSONArray("data");

		for (Object value : js) {
			System.out.println("data values are :"+value);
		}
		
		System.out.println(js.getJSONObject(0).get("id"));

		
	}
}
