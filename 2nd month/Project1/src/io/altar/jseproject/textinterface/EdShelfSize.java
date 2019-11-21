package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Shelf;

public class EdShelfSize extends State {
	public int on() {
		Shelf editedShelf = getShelf();
		if (editedShelf != null) {
			int editedSize = scUtil.getInt("Indique o novo tamanho da prateleira");
			editedShelf.setSize(editedSize);
			bdShelf.editEntity(editedShelf);
		}
		return 1;
	}
}
