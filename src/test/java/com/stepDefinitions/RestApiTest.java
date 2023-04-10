package com.stepDefinitions;

import org.junit.*;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

//This class have steps for RestApi feature which is used to test the Github get a repository Api functionality
public class RestApiTest {

	private static final String baseUrl ="https://api.github.com/";
	private RequestSpecification reqspec;
	private Response response;

//Given do set the baseuri and add headers for the get request
	@Given("I have to given the endpoint of the github get function {string}")
	public void i_have_to_given_the_endpoint_of_the_github_get_function(String baseurl) {
		RestAssured.baseURI=baseUrl+baseurl;
		reqspec=RestAssured.given();
	}

//When do sent the get request for github api 	
	@When("I have to sent get request {string}")
	public void i_have_to_sent_get_request(String geturl) {
		response =reqspec.get(geturl);
	}
	
//Then do get the responses for get a repository request and validate the responses through assertions	
	@Then("I have to validate the response {int} {string} {string}")
	public void i_have_to_validate_the_response_reponsecode(int responsecode,String name, String ownerid) {
		Assert.assertEquals(responsecode, response.getStatusCode());
		String jsonString = response.asString();
		System.out.println(jsonString);
		Assert.assertEquals(JsonPath.from(jsonString).getString(name), "Activity");
		Assert.assertEquals(JsonPath.from(jsonString).getInt(ownerid), 126647047);
	}
	


}
