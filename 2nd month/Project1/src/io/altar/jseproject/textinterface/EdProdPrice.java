package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Product;

public class EdProdPrice extends State{
	public int on() {
		Product editedProduct = getProduct();
		if (editedProduct != null) {
			int editedPrice = scUtil.getInt("Indique o novo preco do produto");
			editedProduct.setPrice(editedPrice);
			bdProduct.editEntity(editedProduct);
		}
		return 1;
	}
}
