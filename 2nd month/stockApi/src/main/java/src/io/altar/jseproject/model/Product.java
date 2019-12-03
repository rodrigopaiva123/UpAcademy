package src.io.altar.jseproject.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Product.GET_ALL_PRODUCTS_QUERY_NAME, query="SELECT p FROM Product p")
@NamedQuery(name=Product.GET_ALL_PRODUCTS_IDS, query="SELECT p.id FROM Shelf p")
public class Product extends GenericEntity{
	
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_PRODUCTS_QUERY_NAME = "Product.getAllProducts";
	public static final String GET_ALL_PRODUCTS_IDS = "Product.getAllShelfIds";
	
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

}