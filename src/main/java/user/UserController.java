package user;

import com.google.api.client.http.HttpStatusCodes;

import database.DatabaseController;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import utils.Error;
import utils.JsonUtil;
import utils.OAuthVerifier;

public class UserController {
	public UserController(UserService userService) {

		Spark.post("api/beta/tokenSignIn", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				User userFromVerifier;
				String idTokenString = request.queryParams("idTokenString");
				if (request.session().attribute("user") != null) { // Not quite sure if it throws nullpointer excp or
																	// not...(it may be a redundant checking)
					request.session().invalidate(); // If there is a session already present, invalidate it and create
													// new session
				}
				try {
					userFromVerifier = new OAuthVerifier().verify(idTokenString);
					if (userFromVerifier == null) {
						response.status(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY);
						return new Error("OAuth verification failed");
					}
				} catch (Exception e) {
					response.status(HttpStatusCodes.STATUS_CODE_SERVER_ERROR);
					return new Error("Internal server error");
				}
				/* TODO : Ensure that no need to check(an already registered user could log-in a thousand times)
				String warning = "";
				if ((userFromVerifier != null) && DatabaseController.users.contains(userFromVerifier)) {
					response.status(HttpStatusCodes.STATUS_CODE_CONFLICT);
					warning = "Warning : User already registered, ";
				}*/
				request.session().attribute("user", userFromVerifier);
				userService.addUserToDatabase(userFromVerifier);
				return (/*warning + */"User signed-in");
			}
		}, JsonUtil::toJson);

		Spark.get("api/beta/signOut", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				if (request.session() != null) {
					request.session().invalidate();
				}
				return "User signed-out";
			}
		}, JsonUtil::toJson);

		Spark.get("api/beta/deleteUser", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				if (request.session() != null) {
					userService.deleteUserFromDatabase(request.session().attribute("user"));
					request.session().invalidate();
				}
				return "User deleted";
			}
		}, JsonUtil::toJson);

		Spark.get("api/beta/addToCart", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				User user;
				int productID;
				try {
					productID = checkProductID(request.queryParams("productID"));
				} catch (Exception e) {
					response.status(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY);
					return new Error(e.getMessage());
				}
				user = request.session().attribute("user");
				if (user == null) {
					response.status(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED);
					return new Error("Unauthorized");
				}
				return userService.addToCart(user, productID);
			}
		}, JsonUtil::toJson);

		Spark.get("api/beta/getUser", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				User user;
				user = request.session().attribute("user");
				if (user == null) {
					response.status(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED);
					return new Error("Unauthorized");
				}
				return user;	
			}
		}, JsonUtil::toJson);
	}

	private int checkProductID(String queryParam) throws Exception {
		int result;
		try {
			result = Integer.parseInt(queryParam);
		} catch (NumberFormatException e) {
			throw new Exception("Invalid query parameter! It must be a positive integer");
		}
		if (result < 0) {
			throw new Exception("Invalid query parameter! It must be a positive integer");
		}
		if (result > DatabaseController.products.length) {
			throw new Exception("Invalid query parameter! It must not exceed the total number of products in the database");
		}
		return result;
	}
}
