package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.model.Product;

public class CreateProduct extends State {
	public int on() {
		Product product = new Product (
				scUtil.getInt("Indique preco do produto a criar"), scUtil.getInt("Indique Iva do produto a criar"));
		bdProduct.createEntity(product);
		return 1;
	}
}
