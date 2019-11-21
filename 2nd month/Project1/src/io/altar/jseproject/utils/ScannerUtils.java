package io.altar.jseproject.utils;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);

	public int getInt(String msg) {
		System.out.println(msg);

		while (sc.hasNextInt() == false) {
			sc.nextLine();
			System.out.println("Erro: insira NUMERO\n" + msg);
		}

		int input = sc.nextInt();
		sc.nextLine();
		return input;
	}

	public int getInt(String msg, int[] values) {
		int input = 0;
		input = getInt(msg);

		if (Arrays.binarySearch(values, input) < 0) {
			System.out.println("Erro: insira um ID valido");
			input = getInt(msg, values);
		}

		return input;
	}
	
	public int getLong(String msg, long[] values) {
		int input = 0;
		input = getInt(msg);

		if (Arrays.binarySearch(values, input) < 0) {
			System.out.println("Erro: insira um ID valido");
			input = getLong(msg, values);
		}

		return input;
	}
	
	public String getString(String msg) {
		System.out.println(msg);
		String input = sc.nextLine();
		
		return input;
		}

}
