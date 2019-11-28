package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;

public class RemoveShelfs extends State {
	public int on() {
		Shelf shelf = getShelf();
		long pId = shelf.getProduct().getId();
		Product product = bdProduct.getEntity(pId);
		for (long shelfId : product.getShelfIds()) {
			if (shelf.getId() == shelfId) {
				product.getShelfIds().remove(shelfId);
			}
		}
		bdShelf.removeEntity(shelf.getId());
		return 1;
	}
}
