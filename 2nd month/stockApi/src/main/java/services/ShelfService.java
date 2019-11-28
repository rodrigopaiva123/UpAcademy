package services;

import java.util.Collection;

import javax.inject.Inject;

import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ProductRepository;
import src.io.altar.jseproject.repositories.ShelfRepository;

public class ShelfService extends EntityService<ShelfRepository, Shelf>{

	ShelfRepository shelfRep = ShelfRepository.getInstance();
	@Inject
	ProductRepository productRep;

	public Collection<Shelf>  getAll() {
		return shelfRep.getAllEntities();
	}
	
	public Shelf getOne(long id) {
		return shelfRep.getEntity(id);
	}
	
	public long create (Shelf entity) {
		
		return shelfRep.createEntity(entity);
	}
	
	public String edit(long id, Shelf shelf) {
		String str = "error: ID";
		Collection<Long> ids = shelfRep.getAllIds();
		if (id == (shelf.getId()==0? id : shelf.getId()) && ids.contains(id)) {
			shelf.setId(id);
			shelfRep.editEntity(shelf);
			str = "Shelf edited";
		}
		return str;
	}
	
	public void del(long id) {
		shelfRep.removeEntity(id);
	}
	
}
