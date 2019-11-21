package Desafios.desafio2;

public class Desafio {

	public static String order(String string) {
		
		System.out.println(string);
		String [] array = string.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= array.length; i++) {
			for (String word : array) {
				char [] chars = word.toCharArray();
				for (char c : chars) {
					if(c == i + '0') {
						sb.append(" ");
						sb.append(word);
					}
				}
			}
		}
		
		String resultString = sb.toString().trim();
		
		return resultString;
	}

}
