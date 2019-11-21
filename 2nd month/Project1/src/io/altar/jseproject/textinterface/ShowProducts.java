package io.altar.jseproject.textinterface;

public class ShowProducts extends State{
	public int on() {
		displayProducts();
		return 1;
	}
}
