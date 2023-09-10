package api.testcases;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	UserPOJO userPayload;
	//public static Logger logger;
	
	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		userPayload = new UserPOJO();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logger = LogManager.getLogger("UserTest.class");
		
	}
	
	@Test(priority=1)
	public void testCreateUser() {
		Response response = UserEndPoints.createUser(userPayload);
		
		System.out.println("Create User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void testGetUserDetails() {
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		System.out.println("Get User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUserDetails() {
		
		
		userPayload.setFirstName(faker.name().firstName());
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		System.out.println("Update User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
		Response respAfterPostUpdate = UserEndPoints.getUser(this.userPayload.getUsername());
		System.out.println("After update User data");
		//log response
		respAfterPostUpdate.then().log().all();
		
	}
	
	@Test(priority=4)
	public void testDeleteUserDetails() {
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		System.out.println("Delete User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
		Response respAfterDelete = UserEndPoints.getUser(this.userPayload.getUsername());
		
		//log response
		respAfterDelete.then().log().all();
		Assert.assertEquals(respAfterDelete.statusCode(), 404);

	

}
}