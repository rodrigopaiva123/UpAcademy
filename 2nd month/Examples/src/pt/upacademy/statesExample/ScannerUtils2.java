package pt.upacademy.statesExample;

import java.util.Scanner;

public class ScannerUtils2 {
private Scanner sc = new Scanner(System.in);
	
	public String getString(String msg) {
		System.out.println(msg);
		String result = sc.nextLine();

		return result;
	}
	
	public int getInt(String msg) {
		Boolean valid = false;
		int result = 0;
		do {
			System.out.println(msg);
			valid = sc.hasNextInt();
			
			if (valid == true) {
				result = sc.nextInt();
			} else {
				System.out.println("Erro tens de colocar um num inteiro");
				sc.nextLine();
			}
		} while ( !valid);
		
		return result;
	}
	
	public int getInt(String msg, int max) {
		int result = 0;
		do {
			result = getInt(msg);
			if (result > max) {
				System.out.println("Num tem de ser menor que " + max);
			}
		} while (result > max);
		
		return result;
	}
	
	public int getInt(String msg, int min, int max) {
		int result = 0;
		do {
			result = getInt(msg);
			if (result < min || result > max) {
				System.out.println("Num tem de ser menor que " + max + "e maior que " + min);
			}
		} while (result < min || result > max);
		
		return result;
	}
	
	public int getInt(String msg, int[] values) {
		int result= 0;
		Boolean valid = false;
		do {
			result = getInt(msg);
			for(int element: values) {
				if( element == result) {
					valid = true;
				}
			}
			if (!valid) {
				String validsNums = "";
				for (int element: values) {
					validsNums += " " + element;
				}
				System.out.println("Numero errado tem de ser " + validsNums);
			}
		} while (!valid);
		
		return result;
	}
}
