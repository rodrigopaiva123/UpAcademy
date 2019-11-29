package services;

import java.util.Collection;

import javax.inject.Inject;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ProductRepository;

public class ProductService extends EntityService<ProductRepository, Product>{
	
	ProductRepository productRep = ProductRepository.getInstance();
	@Inject
	ShelfService shelfService;
	

	public Collection<Product>  getAll() {
		return productRep.getAllEntities();
	}
	
	public Product getOne(long id) {
		return productRep.getEntity(id);
	}
	
	public long create (Product entity) {
		
		return productRep.createEntity(entity);
	}
	
	public String edit(long id, Product product) {
		
		String str = "error: ID";
		Collection<Long> ids = productRep.getAllIds();
		if (id == (product.getId()==0? id : product.getId()) && ids.contains(id)) {
			product.setId(id);
			productRep.editEntity(product);
			str = "Product edited";
			
			
		}
		return str;
	}
	
	public void del(long id) {
		productRep.removeEntity(id);
		removeProductInShelf(id);
	}

	
	public void removeProductInShelf(long id) {
		Collection<Shelf> shelfs =  shelfService.getAll();
		for (Shelf shelf : shelfs) {
			if (shelf.getProductId() == id) {
				shelf.setProductId(0);
				shelfService.edit(id, shelf);
			}
		}
	}
	
	public void addProductToShelf(long prodId, long shelfId) {
		
		shelf.setProductId(id);
		shelfService.edit(prodId, shelfId);
	}
	

}
