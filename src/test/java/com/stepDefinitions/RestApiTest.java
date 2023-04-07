package com.stepDefinitions;

import org.junit.*;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

public class RestApiTest {

	private static final String baseUrl ="https://api.github.com/";
	private RequestSpecification reqspec;
	private Response response;

	@Given("I have to given the endpoint of the github get function {string} {string}")
	public void i_have_to_given_the_endpoint_of_the_github_get_function(String baseurl, String token) {
		RestAssured.baseURI=baseUrl+baseurl;
		reqspec=RestAssured.given().header("Authorization","Bearer "+token);
	}

	@When("I have to sent get request {string}")
	public void i_have_to_sent_get_request(String geturl) {
		response =reqspec.get(geturl);
	}

	@Then("I have to validate the response {int} {string} {string} {string}")
	public void i_have_to_validate_the_response_reponsecode(int responsecode,String name, String ownerid, String pushpermission) {
		Assert.assertEquals(responsecode, response.getStatusCode());
		String jsonString = response.asString();
		Assert.assertEquals(JsonPath.from(jsonString).getString(name), "Activity");
		Assert.assertEquals(JsonPath.from(jsonString).getInt(ownerid), 126647047);
		Assert.assertEquals(JsonPath.from(jsonString).getBoolean(pushpermission), true);
	}
	


}
