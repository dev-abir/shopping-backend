package product;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import utils.JsonUtil;
import utils.Error;
import utils.HTMLstatusCodes;

public class ProductController {

	public ProductController(final ProductService productService) {

		Spark.get("api/getAllProducts", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				return ProductService.getAllProoducts();
			}
		}, JsonUtil::toJson);

		Spark.get("api/getProducts", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				int limit, offset;
				try {
					limit = checkParamInt(request.queryParams("limit"));
					offset = checkParamInt(request.queryParams("offset"));
				} catch (Exception e) {
					response.status(HTMLstatusCodes.STATUS_GENERIC_ERROR);
					return new Error(e.getMessage());
				}
				return ProductService.getProducts(limit, offset);
			}
		}, JsonUtil::toJson);
	}

	private int checkParamInt(String queryParam) throws Exception {
		int result;
		try {
			result = Integer.parseInt(queryParam);
		} catch (NumberFormatException e) {
			throw new Exception("Query parameter must be a positive integer");
		}
		if (result < 0) {
			throw new Exception("Invalid query parameter! It must be a positive integer");
		}
		return result;
	}
}
