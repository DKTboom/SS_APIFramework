package api.endpoints;

public class Routes {
	
	/*Add User	POST	https://petstore.swagger.io/v2/user
Get User	GET	https://petstore.swagger.io/v2/user/{username}
Update User	PUT	https://petstore.swagger.io/v2/user/{username}
Delete User	DELETE	https://petstore.swagger.io/v2/user/{username}
*/
	
	public static String baseURI = "https://petstore.swagger.io/v2";
	
	//User model URLs
	public static String addURL = baseURI + "/user";
	public static String getURL = baseURI + "/user/{username}";
	public static String updateURL = baseURI + "/user/{username}";
	public static String deleteURL = baseURI + "/user/{username}";

}
