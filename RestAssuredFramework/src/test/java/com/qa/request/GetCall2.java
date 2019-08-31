package com.qa.request;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.utility.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCall2 extends TestBase {

	@Test
	public void getRestAPI() {
		parentTest = extent.createTest("Get Request Test");
		childTest = parentTest.createNode("Testing");
		childTest.info("----------yep-------------");

		RestAssured.baseURI = "https://restcountries.eu/rest/v2/capital/Washington";

		Response response = RestAssured.get(RestAssured.baseURI);

		System.out.println("Status code is : " + response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 200);

		String responseString = response.getBody().asString();
		System.out.println("Response string is :" + responseString);

		responseString = responseString.substring(1, responseString.length()-1);
	//	responseString = responseString.substring(0, responseString.length() - 1);
		System.out.println("actual json response string is: " + responseString);

		// String to json conversion:
		JSONObject jsonResponseObj = new JSONObject(responseString);
		System.out.println("the actual json response is: " + jsonResponseObj);

		// get the values from json object:
		String countryName = jsonResponseObj.getString("name");
		System.out.println("the country name is: " + countryName);
		Assert.assertEquals("United States of America", countryName);

		// get the values from json array having only values:
		JSONArray spellingsArray = jsonResponseObj.getJSONArray("altSpellings");
		System.out.println("values from Altspellings: " + spellingsArray);

		// get the values from json array having keys and values:
		JSONArray currenciesArray = jsonResponseObj.getJSONArray("currencies");
		System.out.println(currenciesArray.getJSONObject(0));
		System.out.println(currenciesArray.getJSONObject(0).get("code").toString());
		System.out.println(currenciesArray.getJSONObject(0).get("symbol").toString());

		// for regional blocs:
		JSONArray regionalBlocsArray = jsonResponseObj.getJSONArray("regionalBlocs");
		System.out.println(regionalBlocsArray.getJSONObject(0).get("acronym").toString());

		System.out.println(regionalBlocsArray.getJSONObject(0).get("otherNames"));
		String otherNames = regionalBlocsArray.getJSONObject(0).get("otherNames").toString();
		// ["Tratado de Libre Comercio de América del Norte","Accord de Libre-échange
		// Nord-Américain"]
		String otherNamesArray[] = otherNames.split(",");
		for (int i = 0; i < otherNamesArray.length; i++) {
			System.out.println(otherNamesArray[i]);
		}
	}
}
