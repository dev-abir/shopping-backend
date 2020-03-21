
import product.ProductController;
import product.ProductService;
import spark.Filter;
import spark.Spark;

public class Main {
	public static void main(String[] args) {

		Spark.port(getHerokuAssignedPort());

		Spark.staticFileLocation("/");

		Spark.after((Filter) (request, response) -> {
			// response.header("Access-Control-Allow-Origin", "http://localhost:4567/api/");
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Methods", "GET");
		});

		new ProductController(new ProductService());
	}

	private static int getHerokuAssignedPort() {
		String herokuPort = System.getenv("PORT");
		if (herokuPort != null) {
			return Integer.parseInt(herokuPort);
		}
		return 4567;
	}
}