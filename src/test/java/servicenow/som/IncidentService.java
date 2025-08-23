package servicenow.som;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import base.RestAssuredApiClientImpl;
import design.ResponseAPI;
import io.restassured.specification.RequestSpecification;

public class IncidentService {
	
	RestAssuredApiClientImpl apiClient = new RestAssuredApiClientImpl();
	private static final String TABLE_NAME = "/incident";	
	private ResponseAPI response;
	
	public void getIncidents(RequestSpecification preCondition) {
		response = apiClient.get(preCondition, TABLE_NAME);
	}
	
	public void createIncident(RequestSpecification preCondition) {
		response = apiClient.post(preCondition, TABLE_NAME);
	}
	
	public void validateJSONResponse(int statusCode, String statusLine) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusLine));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
	}

}