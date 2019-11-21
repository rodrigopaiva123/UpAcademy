package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class RemoveShelfs extends State {
	public int on() {
		Shelf shelf = getShelf();
		long pId = shelf.product.id;
		Product product = bdProduct.getEntity(pId);
		for (long shelfId : product.shelfIds) {
			if (shelf.id == shelfId) {
				product.shelfIds.remove(shelfId);
			}
		}
		bdShelf.removeEntity(shelf.id);
		return 1;
	}
}
