package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class UserTest2 {
	Faker faker;
	UserPOJO userPayload;
	
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
		
		
	}
	
	@Test(priority=1)
	public void testCreateUser() {
		Response response = UserEndPoints2.createUser(userPayload);
		
		System.out.println("Create User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetUserDetails() {
		Response response = UserEndPoints2.getUser(this.userPayload.getUsername());
		System.out.println("Get User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUserDetails() {
		
		
		userPayload.setFirstName(faker.name().firstName());
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		System.out.println("Update User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
		Response respAfterPostUpdate = UserEndPoints2.getUser(this.userPayload.getUsername());
		System.out.println("After update User data");
		//log response
		respAfterPostUpdate.then().log().all();
		
	}
	
	@Test(priority=4)
	public void testDeleteUserDetails() {
		Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		System.out.println("Delete User");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
		Response respAfterDelete = UserEndPoints2.getUser(this.userPayload.getUsername());
		
		//log response
		respAfterDelete.then().log().all();
		Assert.assertEquals(respAfterDelete.statusCode(), 404);

	

}
}