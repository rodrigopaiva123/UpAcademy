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
			
			for(Shelf shelf : shelfService.getAll()) {
				if (product.getShelfIds().contains(shelf.getId())) {
					addProductToShelf(id, shelf.getId());
				} else if (shelf.getProductId() == id) {
					removeProductInShelf(shelf);
				}
			}
			
		}
		return str;
	}
	
	public void del(long id) {
		productRep.removeEntity(id);
		
		for (Shelf shelf : shelfService.getAll()) {
			if (shelf.getProductId() == id) {
				removeProductInShelf(shelf);
			}
		}
	}
	
	public void removeProductInShelf(Shelf shelf) {
		shelf.setProductId(0);
		shelfService.edit(shelf.getId(), shelf);
	}
	
	public void addProductToShelf(long prodId, long shelfId) {
		Shelf shelf = shelfService.getOne(shelfId);
		shelf.setProductId(prodId);
		shelfService.edit(shelfId, shelf);
	}
	

}
