package api.endpoints;

/*https://petstore.swagger.io/v2/user/createWithList
	https://petstore.swagger.io/v2/user/user1
		https://petstore.swagger.io/v2/user/user1
			https://petstore.swagger.io/v2/user/user1    */


public class Routes {
	
	public static String baseurl="https://petstore.swagger.io/v2";
	public static String post_url=baseurl+"/user";
	public static String get_url=baseurl+"/user/{username}";
	public static String update_url=baseurl+"/user/{username}";
	public static String delete_url=baseurl+"/user/{username}";

}
