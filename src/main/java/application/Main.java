package application;

import spark.Spark;
import product.ProductController;
import product.ProductService;
import user.UserController;
import user.UserService;

public class Main {
	public static void main(String[] args) {

		Spark.port(getHerokuAssignedPort());
		Spark.staticFileLocation("/public");

		/*
		 * TODO : See if someone enters a trailing slash after the path like
		 * /api/gorilla/, then he should be redirected to the correct path what to do in
		 * case of GET requests like /api/getGorilla?id=4458787
		 */

		new ProductController(new ProductService());
		new UserController(new UserService());

		Spark.after("*", (request, response) -> {
			// response.header("Access-Control-Allow-Origin", "http://localhost:4567/api/");
			response.header("Access-Control-Allow-Origin", "*");
			// response.header("Access-Control-Allow-Methods", "GET POST");
		});
		/*
		 * TODO : Not working for static files(get a solution, or you may store the
		 * static files in a g-zipped form) Spark.after("*", new Filter() {
		 * 
		 * @Override public void handle(Request request, Response response) throws
		 * Exception { response.header("Content-Encoding", "gzip"); } });
		 */
	}

	private static int getHerokuAssignedPort() {
		String herokuPort = System.getenv("PORT");
		if (herokuPort != null) {
			return Integer.parseInt(herokuPort);
		}
		return 4567;
	}
}