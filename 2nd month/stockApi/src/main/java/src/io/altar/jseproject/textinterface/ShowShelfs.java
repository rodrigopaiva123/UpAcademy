package src.io.altar.jseproject.textinterface;

public class ShowShelfs extends State {
	public int on() {
		displayShelfs();
		return 1;
	}
}
