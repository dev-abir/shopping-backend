
import product.ProductController;
import product.ProductService;
import spark.Filter;
import spark.Spark;

public class Main {
	public static void main(String[] args) {

		Spark.port(4567);

		Spark.staticFileLocation("/");

		Spark.after((Filter) (request, response) -> {
			// response.header("Access-Control-Allow-Origin", "http://localhost:4567/api/");
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Methods", "GET");
		});

		new ProductController(new ProductService());
	}
}