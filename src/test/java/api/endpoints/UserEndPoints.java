package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.UserPOJO;
import api.utilities.Listener;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createUser(UserPOJO payload) {
		Response resp = given().filter(new Listener())
				.accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)
		.when().post(Routes.addURL);
		
		return resp;
		
	}
	
	public static Response getUser(String userName) {
		Response resp = given().filter(new Listener())
				.accept(ContentType.JSON).pathParam("username", userName)
		.when().get(Routes.getURL);
		
		return resp;
		
	}
	
	public static Response updateUser(String userName, UserPOJO payload) {
		Response resp = given().filter(new Listener())
				.accept(ContentType.JSON).contentType(ContentType.JSON).pathParam("username", userName).body(payload)
		.when().put(Routes.updateURL);
		
		return resp;
		
	}
	
	public static Response deleteUser(String userName) {
		Response resp = given().filter(new Listener())
				.accept(ContentType.JSON).pathParam("username", userName)
		.when().delete(Routes.deleteURL);
		
		return resp;
		
	}
	

}
