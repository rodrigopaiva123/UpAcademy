package Desafios.desafio3;


public class Desafio {

	public static int points(String[] strings) {
		int points = 0;
		for(String gameScore : strings) {
			String goal1s = gameScore.substring(0, 1);
			System.out.println(goal1s);
			String goal2s = gameScore.substring(2, 3);
			System.out.println(goal2s);
			int goal1 = Integer.decode(goal1s);
			int goal2 = Integer.decode(goal2s);
			if (goal1 > goal2) {
				points +=3;
			} else if (goal1 == goal2) {
				points++;
			}
		}
		return points;
	}

}
