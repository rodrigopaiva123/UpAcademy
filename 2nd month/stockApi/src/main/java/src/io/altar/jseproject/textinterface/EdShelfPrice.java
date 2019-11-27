package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.model.Shelf;

public class EdShelfPrice extends State{
	public int on() {
		Shelf shelf = getShelf();
		if (shelf != null) {
			float price = scUtil.getInt("Indique o novo preco de aluguer");
			shelf.setPrice(price);
			bdShelf.editEntity(shelf);
		}
		return 1;
	}
}
