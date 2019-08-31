package com.qa.request;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.TestBase;
import com.qa.utility.TestUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetWeatherInfo extends TestBase {

	@DataProvider
	public Object[][] getData() {
		Object[][] testData = TestUtil.getDataFromSheet(TestUtil.WeatherSheetName);
		return testData;
	}

	@Test(dataProvider = "getData")
	public void getDataFromExcel(String city, String HTTPMethod, String humidity, String temperature,
			String weatherdescription, String windspeed, String winddirectiondegree) {
		parentTest = extent.createTest("Weather Info Test");
		childTest = parentTest.createNode("Test");
		String serviceURL = pro.getProperty("serviceURL");

		RestAssured.baseURI = serviceURL;
		
		/*
		 * RequestSpecification httpRequest = RestAssured.given(); Response response =
		 * httpRequest.get("/" + city);
		 */
		
		Response response=RestAssured.get(RestAssured.baseURI+"/"+city);
		
		System.out.println(response.getStatusCode());
	}
}
