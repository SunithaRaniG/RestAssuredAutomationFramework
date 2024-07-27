package api.endpoints;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EndpointsUser {
	
	public static Response createUser(user payload)
	{
		Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.post_url);
		
		return response;
		// In the test cases we need to validate the response.
	}

	public static Response getUser(String userName)
	{
		Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("username", userName)
			
		
		.when()
			.get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName, user payload)
	{
		Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
			.pathParam("username", userName)
			
		
		.when()
			.put(Routes.put_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("username", userName)
			
		
		.when()
			.delete(Routes.delete_url);
		
		return response;
	}
	
	
	public static Response createStore(user payload)
	{
		Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.storepost_url);
		
		return response;
	}

	
	
	public static Response getStore(int ID)
	{
		Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("id", ID)
			
		
		.when()
			.get(Routes.storeget_url);
		
		return response;
	}
	
	public static Response deleteStore(int ID)
	{
		Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("id", ID)
			
		
		.when()
			.delete(Routes.storedelete_url);
		
		return response;
	}
}

