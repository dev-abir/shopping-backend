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
				System.out.println(idTokenString);
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
				try {
					userService.addUserToDatabase(userFromVerifier);
				} catch (Exception e) {
					response.status(HttpStatusCodes.STATUS_CODE_CONFLICT);
					return new Error(e.getMessage());
				}
				request.session().attribute("user", userFromVerifier);
				return "User signed-in";
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
					user = checkUser(request.session().attribute("user"));
					productID = checkProductID(request.queryParams("productID"));
					return userService.addToCart(user, productID);
				} catch (Exception e) {
					response.status(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY);
					return new Error(e.getMessage());
				}
			}
		}, JsonUtil::toJson);

		Spark.get("api/beta/getUser", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				User user;
				try {
					user = checkUser(request.session().attribute("user"));
					return user;
				} catch (Exception e) {
					response.status(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY);
					return new Error(e.getMessage());
				}
			}
		}, JsonUtil::toJson);
	}

	private User checkUser(User sessionAttr) throws Exception {
		// You should store the users, and search them in a way in the future so that
		// searching will be more efficient.
		System.out.println(sessionAttr);
		if (DatabaseController.users.contains(sessionAttr) && (sessionAttr != null)) {
			return sessionAttr;
		}
		throw new Exception("Unauthorized");
	}

	private int checkProductID(String queryParam) throws Exception {
		int result;
		try {
			result = Integer.parseInt(queryParam);
		} catch (NumberFormatException e) {
			throw new Exception("Query parameter must be a positive integer");
		}
		if (result < 0) {
			throw new Exception("Invalid query parameter! It must be a positive integer");
		}
		if (result > DatabaseController.products.length) {
			throw new Exception("Query parameter! must not exceed the total number of products in the database");
		}
		return result;
	}
}
