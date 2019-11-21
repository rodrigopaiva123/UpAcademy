package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class RemoveProduct extends State{
	public int on() {
		Product product = getProduct();
		for (long shelfId : product.shelfIds) {
			Shelf shelf = bdShelf.getEntity(shelfId);
			shelf.setProduct(null);
		}
		bdProduct.removeEntity(product.id);
		return 1;
	}
}
