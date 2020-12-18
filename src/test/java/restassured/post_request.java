package restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post_request {
	public class Get {
		@Test
		public void m()
		{
	  //Specify base URI
	  RestAssured.baseURI="https://reqres.in/api/users";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	   
	  //Request paylaod sending along with post request
	  JSONObject requestParams=new JSONObject();
	  
	  requestParams.put("name","morpheus");
	  requestParams.put("job","leader");

	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  //Response object
	  Response response=httpRequest.request(Method.POST,"/CREATE");
	    
	  
	  //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 201);
	  
	  JsonPath sonpath=response.jsonPath();
	  System.out.println(sonpath.get("name"));
	  
	  
//	  String contentType=response.header("name");// capture details of Content-Type header
//	  System.out.println("Content Type is:"+contentType);
//	  Assert.assertEquals(contentType, "morpheus");
	  
//	  //success code validation
//	  String successCode=response.jsonPath().get("SuccessCode");
//	  Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	  
	 }
}}
