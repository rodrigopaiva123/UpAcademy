package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.model.Product;

public class EdProdPrice extends State{
	public int on() {
		Product product = getProduct();
		if (product != null) {
			int price = scUtil.getInt("Indique o novo preco do produto");
			product.setPrice(price);
			bdProduct.editEntity(product);
		}
		return 1;
	}
}
