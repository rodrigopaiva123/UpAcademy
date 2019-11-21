package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Shelf;

public class EdShelfPrice extends State{
	public int on() {
		Shelf editedShelf = getShelf();
		if (editedShelf != null) {
			float editedPrice = scUtil.getInt("Indique o novo preco de aluguer");
			editedShelf.setPrice(editedPrice);
			bdShelf.editEntity(editedShelf);
		}
		return 1;
	}
}
