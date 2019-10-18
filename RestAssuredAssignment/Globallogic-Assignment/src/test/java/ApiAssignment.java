import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiAssignment {

	@Test
void Get_Call_TC001()
{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Request object
	    RequestSpecification httprequest=RestAssured.given();
	    
	    //Response object
	    Response response=httprequest.request(Method.GET);
	    	        
	    //status code validation
	    int statusCode=response.getStatusCode();
	    System.out.println("\n");
	    System.out.println("******Resonse details of Get_Call_TC001******" + "\n");
	    System.out.println("Status code is:" +statusCode);
	    Assert.assertEquals(statusCode, 200);
	    
	    //print response in console window
	    String responseBody=response.getBody().asString();
	    System.out.println("\n");
	    System.out.println("Response body is:" +responseBody);
	    JsonPath jsonpath=response.jsonPath();
	    String ID= jsonpath.getString("data.id");
	    System.out.println("ID are:" +ID);
	    Assert.assertEquals(ID, "[1, 2, 3, 4, 5, 6]");


}
	    
	
	
	@Test
void Get_Call_TC002()
{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users/1";
		
		//Request object
	    RequestSpecification httprequest=RestAssured.given();
	    
	    //Response object
	    Response response=httprequest.request(Method.GET);
	    
	    //status code validation
	    int statusCode=response.getStatusCode();
	    System.out.println("\n");
	    System.out.println("******Resonse details of Get_Call_TC002******" + "\n"); 
	    System.out.println("Status code is:" +statusCode);
	    Assert.assertEquals(statusCode, 200);
	    
	    //print and validate response in console window
	    String responseBody=response.getBody().asString();
	    System.out.println("\n");
	    System.out.println("Response body is:" +responseBody);
	    //Assert.assertEquals(responseBody.contains(s))
	    JsonPath jsonpath=response.jsonPath();
	    String ID= jsonpath.getString("data.id");
	    Assert.assertEquals(ID, "1");
	    
}
	@Test
	void Post_Call_TC001()
	{
			//Specify base URI
			RestAssured.baseURI="https://reqres.in/api/users";
			
			//Request object
		    RequestSpecification httprequest=RestAssured.given();
		    
		    //Request payload along with Post request
		    JSONObject requestParams=new JSONObject();
		    
		    requestParams.put("name","morpheus");
		    requestParams.put("job","zion resident");
		    
		    httprequest.header("Content-Type","application/json");
		    httprequest.body(requestParams.toJSONString());
		    
		    //Response object
		    Response response=httprequest.request(Method.POST);
		    
		  //status code validation
		    int statusCode=response.getStatusCode();
		    System.out.println("******Resonse details of Post_Call_TC001******" + "\n"); 
		    System.out.println("\n");
		    System.out.println("Status code is:" +statusCode);
		    Assert.assertEquals(statusCode, 201);
	
		    //print and validate response in console window
		    String responseBody=response.getBody().asString();
		    System.out.println("\n");
		    System.out.println("Response body is:" +responseBody);
		    JsonPath jsonpath=response.jsonPath();
		    String Name= jsonpath.getString("name");
		    String Job= jsonpath.getString("job");
		    Assert.assertEquals(Name, "morpheus");
		    Assert.assertEquals(Job, "zion resident");
	}
		
		
		@Test
	void Post_Call_TC002()
	{
			//Specify base URI
			RestAssured.baseURI="https://reqres.in/api/register";
			
			//Request object
		    RequestSpecification httprequest=RestAssured.given();
		    
		  //Request payload along with Post request
		    JSONObject requestParams=new JSONObject();
		    
		    requestParams.put("email","sydney@fife");
		    		    
		    httprequest.header("Content-Type","application/json");
		    httprequest.body(requestParams.toJSONString());
		    
		    //Response object
		    Response response=httprequest.request(Method.POST);
		    
		  		    
		    //status code validation
		    int statusCode=response.getStatusCode();
		    System.out.println("******Resonse details of Post_Call_TC002******" + "\n"); 
		    System.out.println("\n");
		    System.out.println("Status code is:" +statusCode);
		    Assert.assertEquals(statusCode, 400);
		    
		  //print and validate response in console window
		    String responseBody=response.getBody().asString();
		    System.out.println("\n");
		    System.out.println("Response body is:" +responseBody);
		    Assert.assertEquals(responseBody.contains("error"), true);
		    
	}
		
		
		@Test
		void Put_Call_TC001()
		{
				//Specify base URI
				RestAssured.baseURI="https://reqres.in/api/register";
				
				//Request object
			    RequestSpecification httprequest=RestAssured.given();
			    
			  //Request payload along with Post request
			    JSONObject requestParams=new JSONObject();
			    
			    requestParams.put("name","morpheus");
			    requestParams.put("job","zion resident");
			    		    
			    httprequest.header("Content-Type","application/json");
			    httprequest.body(requestParams.toJSONString());
			    
			    //Response object
			    Response response=httprequest.request(Method.PUT);
			    
			  
			    //status code validation
			    int statusCode=response.getStatusCode();
			    System.out.println("******Resonse details of Put_Call_TC001******" + "\n"); 
			    System.out.println("\n");
			    System.out.println("Status code is:" +statusCode);
			    Assert.assertEquals(statusCode, 200);
			    
			   //print and validate response in console window
			    String responseBody=response.getBody().asString();
			    System.out.println("\n");
			    System.out.println("Response body is:" +responseBody);
			    System.out.println("\n");
			    JsonPath jsonpath=response.jsonPath();
			    String Name= jsonpath.getString("name");
			    String Job= jsonpath.getString("job");
			    Assert.assertEquals(Name, "morpheus");
			    Assert.assertEquals(Job, "zion resident");
			    
		}
	
}
