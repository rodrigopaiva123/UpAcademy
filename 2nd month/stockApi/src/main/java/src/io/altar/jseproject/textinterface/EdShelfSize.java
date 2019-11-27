package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.model.Shelf;

public class EdShelfSize extends State {
	public int on() {
		Shelf shelf = getShelf();
		if (shelf != null) {
			int size = scUtil.getInt("Indique o novo tamanho da prateleira");
			shelf.setSize(size);
			bdShelf.editEntity(shelf);
		}
		return 1;
	}
}
