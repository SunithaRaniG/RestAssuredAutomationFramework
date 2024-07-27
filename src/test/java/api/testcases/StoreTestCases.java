package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.EndpointsUser;
import api.payload.user;
import io.restassured.response.Response;


public class StoreTestCases {

// In the test cases we need to validate the response. We need to pass the data. We will generate fake data.

	Faker faker;
	user userPayload;
	
	@BeforeClass
	public void generateTestData()
	{
		// Allocate memory for faker
		faker = new Faker();
		userPayload = new user();
				
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setPetid(5);
		userPayload.setQuantity(10);
		userPayload.setShipDate("2024-07-26T13:36:06.336+0000");
		userPayload.setStatus("delivered");
		userPayload.setComplete(true);
			
	}

	@Test(priority=1)
	public void testStoreUser()
	{
		// Call createUser from EndpointsUser.java in TestCases.java
		Response response=EndpointsUser.createStore(userPayload);
		
		// Assertions
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetStore()
	{
		Response response=EndpointsUser.getStore(this.userPayload.getId());
		
		System.out.println("Read User Data.");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void testDeleteStore()
	{
		Response response=EndpointsUser.deleteStore(this.userPayload.getId());
		System.out.println("Delete User Data.");
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
