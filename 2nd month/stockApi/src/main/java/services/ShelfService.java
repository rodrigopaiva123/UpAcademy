package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ShelfRepository;

@RequestScoped
public class ShelfService extends EntityService<ShelfRepository, Shelf> {

	@Inject
	ProductService productService;

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
	public String edit(long shelfId, Shelf shelf, boolean needsEdit) {

		String str = "error: ID";
		boolean validParams = true;

		if (shelfId == (shelf.getId() == 0 ? shelfId : shelf.getId()) && repository.getAllIds().contains(shelfId)) {
		} else {
			str = "error: ID";
			validParams = false;
		}

		if (shelf.getProductId() != 0 && productService.getAllIds().contains(shelf.getProductId()) == false && validParams == true) {
			str = "error: invalid product ID";
			validParams = false;
		}

		if (validParams == true) {
			shelf.setId(shelfId);
			repository.editEntity(shelf);
			str = "Shelf edited";

			if (needsEdit) {
				for (Product product : productService.getAll()) {
					if (product.getId() == shelf.getProductId()) {
						addShelfToProduct(shelfId, product);
					} else {
						removeShelfFromProduct(shelfId, product);
					}
				}
			}
		}

		return str;
	}

	@Override
	public String del(long shelfId) {
		repository.removeEntity(shelfId);
		for (Product product : productService.getAll()) {
			removeShelfFromProduct(shelfId, product);
		}
		return "Shelf deleted";
	}

	public void removeShelfFromProduct(long shelfId, Product product) {
		for (long id : product.getShelfIds()) {
			if (id == shelfId) {
				product.getShelfIds().remove(id);
			}
		}
		productService.edit(product.getId(), product, false);
	}

	public void addShelfToProduct(long shelfId, Product product) {
		product.getShelfIds().add(shelfId);
		productService.edit(product.getId(), product, false);
	}
}
