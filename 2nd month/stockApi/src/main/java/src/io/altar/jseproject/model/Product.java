package src.io.altar.jseproject.model;

import java.util.HashSet;
import java.util.Set;

public class Product extends Entity{
	
	private static final long serialVersionUID = 1L;
	
	private Set<Long> shelfIds = new HashSet<Long>();
	private float price;
	private float IVA;
	private float PVP;
	
	public Product () {
	}
	

	public Product (float price, float IVA) {
		super();
		this.price = price;
		this.IVA = IVA;
		this.PVP = (this.price + (this.price * (this.IVA/100)));
	}

	

	public Set<Long> getShelfIds() {
		return shelfIds;
	}

	public void setShelfIds(HashSet<Long> shelfIds) {
		this.shelfIds = shelfIds;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
		this.PVP = (this.price + (this.price * (this.IVA/100)));
	}



	public float getIVA() {
		return IVA;
	}


	public void setIVA(float iVA) {
		IVA = iVA;
		this.PVP = (this.price + (this.price * (this.IVA/100)));
	}


	public float getPVP() {
		return PVP;
	}
	

	@Override
	public String toString() {
		return "Product id: " + getId() + ", price: " + price + ", IVA: " + IVA + ", PVP: " + PVP + ", Shelfs: " + shelfIds;
	}

	
	

}