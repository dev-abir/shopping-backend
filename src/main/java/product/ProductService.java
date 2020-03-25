package product;

import java.util.ArrayList;

import database.DatabaseController;
import utils.Error;

public class ProductService {
	
	/**
	 * To return an array of all products
	 * 
	 * @return an array of products containing all products
	 */
	public static Product[] getAllProoducts() {
		return DatabaseController.products;
	}
	
	
	/**
	 * To return an array of products containing <code>limit</code> number of products, <b>FROM</b> <code>offset</code>
	 * 
	 * @param limit number of products to return
	 * @param products having product ID after <code>offset</code> will be returned. The offset may start from 0
	 * 
	 * @return an array of products containing containing <code>limit</code> number of products, <b>FROM</b> <code>offset</code>
	 * 
	 * Example: limit = 10, offset = 0, will return products from ID 0 to ID 9(If the database dosen't have enough products, let's say the
	 * system has 5 products, and limit = 10, offset = 1, then it will return products from ID 1 to ID 4, then a message stating <code>not enough number....</code>)
	 * 
	 */
	public static Object[] getProducts(int limit, int offset) {
		ArrayList<Object> productsAndError = new ArrayList<>(); // Is it the right way? (i.e., to send an object array containing products as well as an error)
		for (int i = offset; i <= (offset + (limit - 1)); i++) {
			try {
				productsAndError.add(DatabaseController.products[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				productsAndError.add(new Error("Database limit exceeded"));
				break;
			}
		}
		return productsAndError.toArray();
	}
}
