package src.io.altar.jseproject.model;

public class Shelf extends Entity {
	
	private static final long serialVersionUID = 1L;
	
	private int size;
	public Product product;
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
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	

	@Override
	public String toString() {
		String msg = "";
		if (product == null) {
			msg = "Shelf id: " + id + ", size: " + size + ", price: " + price + ", product: empty";
		} else {
			msg = "Shelf id: " + id + ", size: " + size + ", price: " + price + ", product: " + product;
		}
		
		return msg;
	}

	
	
}
