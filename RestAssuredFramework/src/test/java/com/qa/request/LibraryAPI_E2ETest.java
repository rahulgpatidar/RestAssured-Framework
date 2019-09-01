package com.qa.request;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LibraryAPI_E2ETest {

	@Test
	public void addBook() {
		
		/* 1. Provide the baseURI
		 * 2. Create the request
		 * 3. Provide JSON payload
		 * 4. Insert JSON payload to body
		 * 5. Provide header
		 * 6. Send the request
		 * 7. Fetch the data
		 */
		RestAssured.baseURI="http://216.10.245.166";
		
		//If we wants log in console : RestAssured.given().log().all()
		
		RequestSpecification request=RestAssured.given();
		
		JSONObject json=new JSONObject();
		json.put("name", "test");
		json.put("isbn", "abcdadd");
		json.put("aisle", "1424223");
		json.put("author", "Rahul Patidar");
		
		request.body(json.toJSONString());
		
		request.header("Content-Type","application/json");
		
		//Will pass resources
		Response postresponse=request.post("/Library/Addbook.php");
		
		System.out.println("Post response : "+postresponse.getStatusCode());
		
		
		/* 1.baseURI is already defined 
		 * 2. Request is already created
		 * 3. Send the request with resource
		 * 4. Check the response code
		 */
		
		Response getresponse=request.get("/Library/GetBook.php?ID=abcdadd1424223");
		System.out.println("Get response :"+getresponse.getStatusCode());
		
		
		/*1. baseURI is already defined
		 *2. Request is already created
		 *3. Create the JSON payload and send the body
		 *4. defined header
		 *5. send the request
		 *6. Get the reponse code 
		 */
		json.put("ID", "abcdadd1424223");
		request.body(json.toJSONString());
		
		request.header("Content-Type","application/json");
		
		Response deleteresponse=request.delete("/Library/DeleteBook.php");
		
		System.out.println("delete response : "+deleteresponse.getStatusCode());
	}
	
}
