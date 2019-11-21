package Desafios.desafio1;


public class Desafio {
	
	int input = 0;
	int big3count = 0;
	int big5count = 0;
	

	public Desafio(int i) {
		input = i;
	}

	public void run() {
		for (int i=1; i<=input; i++) {
			if (i % 3 == 0) {
				big3count++;
			}
			if (i % 5 == 0) {
				big5count++;
			}
		}
		
	}

	public int getBig3Count() {
		return big3count;
	}

	public int getBig5Count() {
		return big5count;
	}
}
