package api.endpoints;

public class Routes {

/*	
Create User - https://petstore.swagger.io/v2/user
Get User	- https://petstore.swagger.io/v2/user/{username}
Update user - https://petstore.swagger.io/v2/user/{username}
Delete User - https://petstore.swagger.io/v2/user/{username} */
	
public static String base_url = "https://petstore.swagger.io/v2";

public static String post_url = base_url + "/user";
public static String get_url = base_url + "/user/{username}";
public static String put_url = base_url + "/user/{username}";
public static String delete_url = base_url + "/user/{username}";


public static String storebase_url = "https://petstore.swagger.io/v2/store";

public static String storepost_url = storebase_url + "/order";
public static String storeget_url = storebase_url + "/order/{id}";
public static String storedelete_url = storebase_url + "/order/{id}";




}
