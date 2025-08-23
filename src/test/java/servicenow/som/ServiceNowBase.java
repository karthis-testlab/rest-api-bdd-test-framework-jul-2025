package servicenow.som;

import base.RestAssuredApiClientImpl;
import design.ResponseAPI;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class ServiceNowBase {
	
	protected RestAssuredApiClientImpl apiClient = new RestAssuredApiClientImpl();
	protected ResponseAPI response;
	protected RequestSpecBuilder preCondition = new RequestSpecBuilder();
	
	public void baseUri(String baseUri) {
		preCondition.setBaseUri(baseUri);
	}
	
	public void basePath(String basePath) {
		preCondition.setBasePath(basePath);
	}	
	
	public void basicAuth(String username, String password) {
		preCondition.setAuth(RestAssured.basic(username, password));		
	}
	
	public void header(String key, String value) {
		preCondition.addHeader(key, value);		
	}
	
	public void queryParam(String key, String value) {
		preCondition.addQueryParam(key, value);		
	}
	
	public void pathParam(String key, String value) {
		preCondition.addPathParam(key, value);		
	}	

}