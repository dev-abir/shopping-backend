package product;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import utils.JsonUtil;

public class ProductController {

	public static final int numberOfProductsForEachCall = 9;

	public ProductController(final ProductService productService) {

		Spark.get("api/getMoreProducts", new Route() {

			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				return ProductService.getMoreProducts(numberOfProductsForEachCall);
			}
		}, JsonUtil::toJson);
	}
}
