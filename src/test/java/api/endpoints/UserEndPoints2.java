package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	static ResourceBundle getURLs() {
		
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
		
	}
	
	public static Response createUser(UserPOJO payload) {
		String addURL = getURLs().getString("addURL");
		Response resp = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)
		.when().post(addURL);
		
		return resp;
		
	}
	
	public static Response getUser(String userName) {
		String getURL = getURLs().getString("getURL");
		Response resp = given().accept(ContentType.JSON).pathParam("username", userName)
		.when().get(getURL);
		
		return resp;
		
	}
	
	public static Response updateUser(String userName, UserPOJO payload) {
		String updateURL = getURLs().getString("updateURL");
		Response resp = given().accept(ContentType.JSON).contentType(ContentType.JSON).pathParam("username", userName).body(payload)
		.when().put(updateURL);
		
		return resp;
		
	}
	
	public static Response deleteUser(String userName) {
		String deleteURL = getURLs().getString("deleteURL");
		Response resp = given().accept(ContentType.JSON).pathParam("username", userName)
		.when().delete(deleteURL);
		
		return resp;
		
	}
	

}
