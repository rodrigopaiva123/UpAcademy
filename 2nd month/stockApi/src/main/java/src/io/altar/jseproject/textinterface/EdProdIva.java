package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.model.Product;

public class EdProdIva extends State{
	public int on() {
		Product product = getProduct();
		if (product != null) {
			int iva = scUtil.getInt("Indique o novo Iva do produto");
			product.setIVA(iva);
			bdProduct.editEntity(product);
		}
		return 1;
	}
}
