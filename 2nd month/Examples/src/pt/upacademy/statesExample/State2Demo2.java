package pt.upacademy.statesExample;

public class State2Demo2 {
	public State2[] State2s = { 
			new A2(), // State2 0
			new B2(), // State2 1
			new C2() // State2 2
	};
	private int[][] transition = { 
			{ 1, 2, 3 }, // State2 0 A
			{ 0 }, // State2 1 B
			{ 0 } // State2 0 C
	};
	private int current = 0;

	public static void main(String[] args) {
		State2Demo2 fsm = new State2Demo2();
		int option;

		while (true) {
			option = fsm.State2s[fsm.current].on();
			if (fsm.current == 0 && option == 3) {
				System.out.println("Exit");
				break;
			}
			fsm.current = fsm.transition[fsm.current][option - 1];
		}
	}
}

abstract class State2 {
	ScannerUtils2 scannerUtils = new ScannerUtils2();
	public abstract int on();
}

class A2 extends State2 {
	public int on() {
		System.out.println("Menu Inicial");
		return scannerUtils.getInt("Escolhe...");
	}

}

class B2 extends State2 {
	public int on() {
		System.out.println("Menu Prod");
		return scannerUtils.getInt("Escolhe...");
	}
}

class C2 extends State2 {
	public int on() {
		System.out.println("Menu Shelf");
		return scannerUtils.getInt("Escolhe...");
	}
}
