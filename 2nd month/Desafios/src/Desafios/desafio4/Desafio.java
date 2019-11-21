package Desafios.desafio4;

import java.util.ArrayList;

public class Desafio {

	public static int[] ints(String string) {
		
		String[] charsArray = string.split(" ");
		ArrayList<Integer> numsList = new ArrayList<Integer>();
		
		for (String chars : charsArray) {
			if (chars.matches("-?\\d+(\\.\\d+)?")) {
				int num = Integer.parseInt(chars);
				numsList.add(num);
			}
		}
		
		int[] result = numsList.stream().mapToInt(i -> i).toArray();
		
		return result;
	}

}
