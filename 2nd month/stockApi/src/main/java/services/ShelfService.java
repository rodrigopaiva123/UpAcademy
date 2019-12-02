package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ShelfRepository;

@RequestScoped
public class ShelfService extends EntityService<ShelfRepository, Shelf>{

	@Inject
	ProductService prodService;	
	
	public Collection<Shelf> getByProductId(long id) {
		Collection<Shelf> shelves = new ArrayList<Shelf>();
		for (Shelf shelf : repository.getAllEntities()) {
			if (shelf.getProductId() == id) {
				shelves.add(shelf);
			}
		}
		
		return shelves;
	}
	
	@Override
	public String edit(long id, Shelf shelf) {
		String str = "error: ID";
		Collection<Long> ids = repository.getAllIds();
		if (id == (shelf.getId()==0? id : shelf.getId()) && ids.contains(id)) {
			shelf.setId(id);
			repository.editEntity(shelf);
			str = "Shelf edited";
			
			
//			removeShelfFromProduct (id);
//			addShelfToProduct (shelfId, productId);
			
		}
		return str;
	}
	
	@Override
	public String del(long id) {
		repository.removeEntity(id);
		removeShelfFromProduct (id);
		return "Shelf deleted";
	}
	
	public void removeShelfFromProduct (long id) {
		for (Product product : prodService.getAll()) {
			ArrayList<Long> shelfIds = product.getShelfIds();
			for (long prodId : shelfIds) {
				if (prodId == id) {
					shelfIds.remove(prodId);
				}
			}
			prodService.edit(product.getId(), product);
		}
	}
	
	public void addShelfToProduct (long shelfId, long productId) {
		Product product = prodService.getOne(productId);
		ArrayList<Long> shelfIds = product.getShelfIds();
		shelfIds.add(shelfId);
		product.setShelfIds(shelfIds);
		prodService.edit(productId, product);
	}
}
