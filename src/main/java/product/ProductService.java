package product;

import java.util.Random;

import database.DatabaseController;

public class ProductService {

	/**
	 * To return an array of products containing random products
	 * 
	 * @param numberOfProductsForEachCall the length of the array
	 * 
	 * @return an array of products containing random products
	 * 
	 */
	public static Product[] getMoreProducts(int numberOfProductsForEachCall) {
		Product[] products = new Product[numberOfProductsForEachCall];
		Random random = new Random();
		for (int i = 0; i < products.length; i++) {
			products[i] = DatabaseController.products[random.nextInt(DatabaseController.products.length)];
		}
		return products;
	}
}
