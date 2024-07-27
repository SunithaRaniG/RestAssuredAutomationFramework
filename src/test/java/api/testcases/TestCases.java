package api.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.EndpointsUser;
import api.payload.user;
import io.restassured.response.Response;


public class TestCases {

// In the test cases we need to validate the response. We need to pass the data. We will generate fake data.

	Faker faker;
	user userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void generateTestData()
	{
		// Allocate memory for faker
		faker = new Faker();
		userPayload = new user();
				
		// Create payload by calling setter methods
		userPayload.setId(faker.idNumber().hashCode());
		// hashcode is used to generate unique id
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		// create logs
		
		logger  = LogManager.getLogger("C:\\Users\\Dell\\eclipse-workspace\\RestAssuredAutomationFramework");
	}

	@Test(priority=1)
	public void testCreateUser()
	{
		
		logger.info("***************Creating user *************************");
		
		// Call createUser from EndpointsUser.java in TestCases.java
		Response response=EndpointsUser.createUser(userPayload);
		
		// Assertions
		
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************User is created  *************************");

	}
	
	@Test(priority=2)
	public void testGetUser()
	{
		logger.info("***************Reading User Info *************************");
		
		Response response=EndpointsUser.getUser(this.userPayload.getUsername());
		
		System.out.println("Read User Data.");
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************User Info is displayed *************************");
		
		
	}
	
	
	@Test(priority=3)
	public void testUpdateUser()
	{
		logger.info("***************Updating User *************************");
		
		userPayload.setFirstName(faker.name().firstName());
		
		Response response=EndpointsUser.updateUser(this.userPayload.getUsername(), userPayload);
		
		
		System.out.println("Update User Data.");
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		// Check if first name is updated or not
		
		Response responsePostUpdate = EndpointsUser.getUser(this.userPayload.getUsername());
		
		System.out.println("After Update User Data.");
		
		responsePostUpdate.then().log().all();
		
		logger.info("***************User is updated *************************");
	}
	
	@Test(priority=4)
	public void testDeleteUser()
	{
		logger.info("***************Deleting user *************************");
		
		Response response=EndpointsUser.deleteUser(this.userPayload.getUsername());
		System.out.println("Delete User Data.");
		
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************User is deleted *************************");
	}
}
