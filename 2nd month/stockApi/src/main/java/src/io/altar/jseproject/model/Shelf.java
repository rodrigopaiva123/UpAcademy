package src.io.altar.jseproject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Shelf.GET_ALL_SHELVES_QUERY_NAME, query="SELECT s FROM Shelf s")
@NamedQuery(name=Shelf.GET_SHELVES_BY_PRODUCT_ID_QUERY_NAME, query="SELECT s FROM Shelf s WHERE s.product.id = :productId")
@NamedQuery(name=Shelf.GET_ALL_SHELVES_IDS, query="SELECT s.id FROM Shelf s")
@NamedQuery(name=Shelf.GET_SHELVES_COUNT, query="SELECT COUNT(s) FROM Shelf s")
@NamedQuery(name=Shelf.GET_SHELVES_IDS_BY_PRODUCT_ID, query="SELECT s.id FROM Shelf s WHERE s.product.id = :productId")
@NamedQuery(name=Shelf.GET_SHELVES_COUNT_BY_PRODUCT_ID, query="SELECT COUNT(s) FROM Shelf s WHERE s.product.id = :productId")
@NamedQuery(name=Shelf.UPDATE_SHELF_BY_PRODUCT_ID, query="UPDATE Shelf s SET s.product.id = :productId WHERE s.id = :id")

//@NamedQuery(name=Shelf.UPDATE_SHELF_PRODUCT_TO_NULL, query="UPDATE Shelf s SET s.product = null WHERE s.id = :shelfId AND s.product.id = :productId")
public class Shelf extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_SHELVES_QUERY_NAME = "Shelf.getAllEntityQueryName";
	public static final String GET_SHELVES_BY_PRODUCT_ID_QUERY_NAME = "Shelf.getAllShelvesByProductId";
	public static final String GET_ALL_SHELVES_IDS = "Shelf.getAllShelvesIds";
	public static final String GET_SHELVES_COUNT = "Shelf.getEntityCount";
	public static final String GET_SHELVES_IDS_BY_PRODUCT_ID = "Shelf.getAllShelvesIdsByProductId";
	public static final String GET_SHELVES_COUNT_BY_PRODUCT_ID = "Shelf.getShelfCountByProductId";
	public static final String UPDATE_SHELF_BY_PRODUCT_ID = "Shelf.editProductInShelf";
	
	@ManyToOne
	private Product product;
	private int size;
	private float price;
	
	public Shelf () {
	}
	

	public Shelf (int size, float price, Product product) {
		super();
		this.size = size;
		this.price = price;
		this.product = product;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
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



}
