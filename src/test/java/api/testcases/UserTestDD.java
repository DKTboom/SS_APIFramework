package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.UserPOJO;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
	
	UserPOJO userPayload = new UserPOJO();
	
	@Test(priority=1,dataProvider = "UserDP", dataProviderClass = DataProviders.class)
	public void testCreateUser(String UserID,String UserName, String FirstName, String LastName, String Email, String Password, String Phone) {
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		
		System.out.println("Create User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	@Test(priority=2,dataProvider = "UserNameDP", dataProviderClass = DataProviders.class)
	public void testDeleteUserDetails(String UserName) {
		Response response = UserEndPoints.deleteUser(UserName);
		System.out.println("Delete User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);


	

}
}
