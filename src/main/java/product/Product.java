package product;

public class Product {
	private final int ID;
	private final String name;
	private final double price;
	private final String description;
	private final String ImagePath;

	public Product(int ID, String name, double price, String description, String imagePath) {
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.description = description;
		ImagePath = imagePath;
	}

	public int getID() {
		return ID;
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
		return "Product [ID=" + ID + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", ImagePath=" + ImagePath + "]";
	}
}
