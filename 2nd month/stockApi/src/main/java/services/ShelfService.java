package services;


import java.util.List;

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
	public List<Shelf> getByProductId(long id) {  
		return repository.getAllShelvesByProductId(id);
	}
	
	@Transactional
	@Override
	public String edit(long shelfId, Shelf shelf) {

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

	public List<Long> getIdByProductId(long id) {
		return repository.getIdByProductId(id);
	}

	public Long getCountByProductId(long id) {
		return repository.getCountByProductId(id);
	}
	
	public String editProductInShelf(long id, Shelf shelf, Long productId) {
		repository.editProductInShelf(id, shelf, productId);
		return "Edit Successfull";
	}

}
