package servicenow.som;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class IncidentService2 extends ServiceNowBase {	
	
	private static final String TABLE_NAME = "/incident";	
		
	public void getIncidents() {
		response = apiClient.get(preCondition.build(), TABLE_NAME);
	}
	
	public void createIncident() {
		response = apiClient.post(preCondition.build(), TABLE_NAME);
	}
	
	public void validateJSONResponse(int statusCode, String statusLine) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusLine));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
	}

}