package user;

import java.util.ArrayList;
import java.util.List;

import product.Product;

public class User {
	private final String name;
	private final String mailID;
	private boolean mailVerified;
	private List<Product> productsCart;

	public User(String name, String mailID, boolean mailVerified) {
		this.name = name;
		this.mailID = mailID;
		this.mailVerified = mailVerified;
		this.productsCart = new ArrayList<Product>();
	}

	public String getName() {
		return name;
	}

	public String getMailID() {
		return mailID;
	}

	public boolean getMailVerified() {
		return mailVerified;
	}

	public List<Product> getProductsCart() {
		return productsCart;
	}

	public String addToCart(Product product) throws Exception {
		if (productsCart.contains(product)) {
			throw new Exception("Product already present in cart");
		}
		productsCart.add(product);
		return "Added to cart";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mailID == null) ? 0 : mailID.hashCode());
		result = prime * result + (mailVerified ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((productsCart == null) ? 0 : productsCart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (mailID == null) {
			if (other.mailID != null)
				return false;
		} else if (!mailID.equals(other.mailID))
			return false;
		if (mailVerified != other.mailVerified)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productsCart == null) {
			if (other.productsCart != null)
				return false;
		} else if (!productsCart.equals(other.productsCart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", mailID=" + mailID + ", mailVerified=" + mailVerified + ", productsCart="
				+ productsCart + "]";
	}
}
