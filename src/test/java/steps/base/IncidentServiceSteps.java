package steps.base;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import base.RestAssuredApiClientImpl;
import design.ResponseAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class IncidentServiceSteps {
	
	RequestSpecBuilder preCondition = new RequestSpecBuilder();
	RestAssuredApiClientImpl apiClient = new RestAssuredApiClientImpl();
	ResponseAPI response;

	@Given("user should set the base uri as {string} in the api client")
	public void user_should_set_the_base_uri_as_in_the_api_client(String baseUri) {
		preCondition.setBaseUri(baseUri);
	}

	@Given("user should set the base path {string} of the service now table api")
	public void user_should_set_the_base_path_of_the_service_now_table_api(String basePath) {
		preCondition.setBasePath(basePath);
	}

	@Given("user should set the basic authentication user name as {string} and password as {string}")
	public void user_should_set_the_basic_authentication_user_name_as_and_password_as(String username, String password) {
		preCondition.setAuth(RestAssured.basic(username, password));
	}

	@When("user should hit the get request of the {string} table")
	public void user_should_hit_the_get_request_of_the_table(String endPoint) {
		response = apiClient.get(preCondition.build(), endPoint);
	}

	@Then("user should able to see the success response and with relevant status code and message")
	public void user_should_able_to_see_the_success_response_and_with_relevant_status_code_and_message() {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo("OK"));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
	}

	@Given("user should set the header key as {string} and value as {string}")
	public void user_should_set_the_header_key_as_and_value_as(String key, String value) {
		preCondition.addHeader(key, value);
	}

	@When("user should hit the post request of the {string} table")
	public void user_should_hit_the_post_request_of_the_table(String endPoint) {
		response = apiClient.post(preCondition.build(), endPoint);
	}

	@Then("user should successfully created the new record and with the relevant status code and message")
	public void user_should_successfully_created_the_new_record_and_with_the_relevant_status_code_and_message() {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(201));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo("Created"));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
	}

}