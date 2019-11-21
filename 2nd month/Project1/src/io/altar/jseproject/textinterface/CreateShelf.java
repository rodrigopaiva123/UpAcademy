package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Shelf;

public class CreateShelf extends State{
	public int on() {
		Shelf shelf = new Shelf (
				scUtil.getInt("Indique a dimensao da prateleira"),  
				scUtil.getInt("Indique opreco de aluguer"));
		bdShelf.createEntity(shelf);
		return 1;
	}
}
