package src.io.altar.jseproject.model;

public class Shelf extends Entity {
	
	private static final long serialVersionUID = 1L;
	
	private int size;
	private int productId;
	private float price;
	
	public Shelf () {
	}
	

	public Shelf (int size, float price) {
		super();
		this.size = size;
		this.price = price;
	}

	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	
	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	

	@Override
	public String toString() {
		String msg = "";
		if (productId == 0) {
			msg = "Shelf id: " + getId() + ", size: " + size + ", price: " + price + ", product: empty";
		} else {
			msg = "Shelf id: " + getId() + ", size: " + size + ", price: " + price + ", product: " + productId;
		}
		
		return msg;
	}

	
	
}
