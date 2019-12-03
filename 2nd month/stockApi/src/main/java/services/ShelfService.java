package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ShelfRepository;

@RequestScoped
public class ShelfService extends EntityService<ShelfRepository, Shelf> {

	@Inject
	ProductService productService;

	@Transactional
	public Collection<Shelf> getByProductId(long id) {
		Collection<Shelf> shelves = new ArrayList<Shelf>();
		for (Shelf shelf : repository.getAllEntities()) {
			if (shelf.getProduct().getId() == id) {
				shelves.add(shelf);
			}
		}

		return shelves;
	}
	
	@Transactional
	@Override
	public String edit(long shelfId, Shelf shelf, boolean needsEdit) {

		String str = "";
		boolean validParams = false;

		if (shelfId == (shelf.getId() == 0 ? shelfId : shelf.getId()) && repository.getAllIds().contains(shelfId)) {
			validParams = true;
		} else {
			str = "error: ID";
		}

		if (shelf.getProduct() != null && productService.getAllIds().contains(shelf.getProduct().getId()) == false && validParams == true) {
			str = "error: invalid product ID";
			validParams = false;
		}

		if (validParams == true) {
			shelf.setId(shelfId);
			repository.editEntity(shelf);
			str = "Edit successfull";
				}

		return str;
	}

	@Transactional
	@Override
	public String del(long shelfId) {
		repository.removeEntity(shelfId);
		return "Shelf deleted";
	}

}
