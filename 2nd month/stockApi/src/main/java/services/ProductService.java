package services;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ProductRepository;

@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product>{
	
	
    @Inject
    ShelfService shelfService;
	
	@Override
	public String edit(long id, Product product) {
		
		String str = "error: ID";
		Collection<Long> ids = repository.getAllIds();
		if (id == (product.getId()==0? id : product.getId()) && ids.contains(id)) {
			product.setId(id);
			repository.editEntity(product);
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
	
	@Override
	public String del(long id) {
		repository.removeEntity(id);
		
		for (Shelf shelf : shelfService.getAll()) {
			if (shelf.getProductId() == id) {
				removeProductInShelf(shelf);
			}
		}
		
		return "Product deleted";
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
