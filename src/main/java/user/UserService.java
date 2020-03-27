package user;

import database.DatabaseController;

public class UserService {

	/**
	 * To add user object to database
	 * 
	 * @param user the user to add into the database
	 * 
	 * @throws exception, if the user is already registered
	 * 
	 */
	public void addUserToDatabase(User user) throws Exception {
		DatabaseController.addUser(user);
	}

	/**
	 * To delete user object to database
	 * 
	 * @param user the user to delete from database
	 * 
	 */
	public void deleteUserFromDatabase(User user) {
		DatabaseController.users.remove(user);
	}

	/**
	 * To add a product to user object
	 * 
	 * @param user      the user to add into the database
	 * @param productID the ID of the product to add to the user's cart
	 * 
	 * @throws exception, if the product is already present in the user's cart
	 * 
	 */
	public String addToCart(User user, int productID) throws Exception {
		return user.addToCart(DatabaseController.getProductByID(productID));
	}
}
