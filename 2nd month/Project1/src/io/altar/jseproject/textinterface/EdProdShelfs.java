package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class EdProdShelfs extends State{
	public int on() {
		Product editedProduct = getProduct();
		if (editedProduct != null) {
			long editedShelfId = scUtil.getInt("Indique o ID de uma nova prateleira para o produto");
			Shelf editedShelf = bdShelf.getEntity(editedShelfId);
			editedShelf.setProduct(editedProduct);
			editedProduct.shelfIds.add(editedShelfId);
			bdProduct.editEntity(editedProduct);
		}
		return 1;
	}
}
