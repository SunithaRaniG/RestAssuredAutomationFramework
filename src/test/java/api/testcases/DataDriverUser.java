package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.EndpointsUser;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDriverUser {
	
	public Logger logger;
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testCreateUser(String userID, String userName, String fname, String lname, String email, String pwd, String phone)
	{
		user userPayload = new user();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response response=EndpointsUser.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger  = LogManager.getLogger("C:\\Users\\Dell\\eclipse-workspace\\RestAssuredAutomationFramework");
		
	}
	
	//@Test(priority=2, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testGetUser(String userName)
	{
		
		logger.info("***************Creating user *************************");
		
		Response response=EndpointsUser.getUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************user is created *************************");
	}


	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUser(String userName)
	{
		logger.info("***************Deleting user *************************");
		
		Response response=EndpointsUser.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************user is deleted *************************");
	}
}

