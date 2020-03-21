package product;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import utils.JsonUtil;
import utils.Error;

public class ProductController {

	public static final int numberOfProductsForEachCall = 9;
	public static final int MAX_PRODUCTS_FOR_EACH_CALL = 100;

	public ProductController(final ProductService productService) {

		Spark.get("api/getMoreProducts", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				return ProductService.getMoreProducts(numberOfProductsForEachCall);
			}
		}, JsonUtil::toJson);
		
		
		Spark.get("api/getMoreProducts/:quantity", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				int quantity = 0;
				try {
					quantity = Integer.parseInt(request.params(":quantity"));
				} catch (NumberFormatException e) {
					return new Error("Quantity parameter must be a positive integer within " + MAX_PRODUCTS_FOR_EACH_CALL);
				}
				if (quantity < 0) {
					return new Error("Invalid quantity! It must be a positive integer within " + MAX_PRODUCTS_FOR_EACH_CALL);
				} else if (quantity > MAX_PRODUCTS_FOR_EACH_CALL) {
					return new Error("Quantity parameter must be a positive integer within " + MAX_PRODUCTS_FOR_EACH_CALL);
				} else {
					return ProductService.getMoreProducts(quantity);
				}
			}
		}, JsonUtil::toJson);
	}
}
