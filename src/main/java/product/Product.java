package product;

public class Product {
	private String name;
	private double price;
	private String description;
	private String ImagePath;

	public Product(String name, double price, String description, String imagePath) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		ImagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getImagePath() {
		return ImagePath;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", description=" + description + ", ImagePath="
				+ ImagePath + "]";
	}
}
