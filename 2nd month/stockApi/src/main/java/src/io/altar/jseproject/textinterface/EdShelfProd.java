package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;

public class EdShelfProd extends State{
	public int on() {
		Shelf shelf = getShelf();
		if (shelf != null) {
			long productId = scUtil.getInt("Escolha o ID do produto a adicionar");
			Product product = bdProduct.getEntity(productId);
			shelf.setProduct(product);
			bdShelf.editEntity(shelf);
			product.shelfIds.add(productId);
		}
		return 1;
	}
}
