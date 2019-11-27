package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;

public class EdProdShelfs extends State{
	public int on() {
		Product product = getProduct();
		if (product != null) {
			long shelfId = scUtil.getInt("Indique o ID de uma nova prateleira para o produto");
			Shelf shelf = bdShelf.getEntity(shelfId);
			shelf.setProduct(product);
			product.shelfIds.add(shelfId);
			bdProduct.editEntity(product);
		}
		return 1;
	}
}
