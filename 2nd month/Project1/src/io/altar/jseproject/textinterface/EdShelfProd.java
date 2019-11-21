package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class EdShelfProd extends State{
	public int on() {
		Shelf editedShelf = getShelf();
		if (editedShelf != null) {
			long editedProductId = scUtil.getInt("Escolha o ID do produto a adicionar");
			Product editedProduct = bdProduct.getEntity(editedProductId);
			editedShelf.setProduct(editedProduct);
			bdShelf.editEntity(editedShelf);
			editedProduct.shelfIds.add(editedProductId);
		}
		return 1;
	}
}
