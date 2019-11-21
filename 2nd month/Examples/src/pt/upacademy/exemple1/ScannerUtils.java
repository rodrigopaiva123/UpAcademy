package pt.upacademy.exemple1;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);

	public int getInt(String msg) {
		System.out.println(msg);

		while (sc.hasNextInt() == false) {
			System.out.println("Erro: valor introduzido nao e um numero");
			sc.nextLine();
		}

		int input = sc.nextInt();
		return input;
	}

	public int getInt(String msg, int[] values) {
		int input = 0;
		input = getInt(msg);

		if (Arrays.binarySearch(values, input) < 0) {
			System.out.println("Erro: numero fora das opcoes possiveis");
			input = getInt("Introduza uma opcao(1,2,3,4)", values);
		}

		return input;
	}

}
