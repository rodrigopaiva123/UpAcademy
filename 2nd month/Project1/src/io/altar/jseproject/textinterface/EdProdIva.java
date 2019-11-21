package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Product;

public class EdProdIva extends State{
	public int on() {
		Product editedProduct = getProduct();
		if (editedProduct != null) {
			int editedIVA = scUtil.getInt("Indique o novo Iva do produto");
			editedProduct.setIVA(editedIVA);
			bdProduct.editEntity(editedProduct);
		}
		return 1;
	}
}
