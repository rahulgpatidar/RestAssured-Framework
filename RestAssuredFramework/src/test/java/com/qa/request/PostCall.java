package com.qa.request;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.qa.responceObject.CustomerResponceOnFailure;
import com.qa.responceObject.CustomerResponceOnSuccess;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCall {
//When we want to create a request-POST
	@Test
	public void postRequestAPI() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		// Create Http request
		RequestSpecification httpRequest = RestAssured.given();

		// Create JSONObject/Json payload with all the fields
		JSONObject requestJson = new JSONObject();
		requestJson.put("FirstName", "Rahudl11");
		requestJson.put("LastName", "Patidsdar11");
		requestJson.put("UserName", "rahul11");
		requestJson.put("Password", "patidar11");
		requestJson.put("Email", "rahul1@test1.com");
		
		// Create the header
		httpRequest.header("Content-Type", "application/json");

		// add the Json payload to the request body
		httpRequest.body(requestJson.toJSONString());

		Response response = httpRequest.post("/register");

		// Deserialization-convert Json object into Java object
		if (response.getStatusCode() == 201) {
			CustomerResponceOnSuccess customerResponceOnSuccess = response.as(CustomerResponceOnSuccess.class);
			System.out.println(customerResponceOnSuccess.SuccessCode);
			System.out.println(customerResponceOnSuccess.Message);
		} else if (response.statusCode() == 200) {
			CustomerResponceOnFailure customerResponce = response.as(CustomerResponceOnFailure.class);
			System.out.println(customerResponce.FaultID);
			System.out.println(customerResponce.fault);

		}

	}
}
