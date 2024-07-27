package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.EndpointsUser;
import api.payload.user;
import api.utilities.DataProvidersStore;
import io.restassured.response.Response;

public class DataDrivenStore {
	
	@Test(priority=1, dataProvider="DataStore", dataProviderClass=DataProvidersStore.class)
	public void testCreateStore(int ID, int petID, int quantity, String shipDate, String status, Boolean complete)
	{
		user userPayload = new user();
		
		userPayload.setId(ID);
		userPayload.setPetid(petID);
		userPayload.setQuantity(quantity);
		userPayload.setShipDate(shipDate);
		userPayload.setStatus(status);
		userPayload.setComplete(complete);
		
		Response response=EndpointsUser.createStore(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2, dataProvider="ID", dataProviderClass=DataProvidersStore.class)
	public void testDeleteStore(int ID)
	{
		Response response=EndpointsUser.deleteStore(ID);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}

