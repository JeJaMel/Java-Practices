package seccion5;

public class MethodOverloading {

	public static void main(String[] args) {


		int newScore = CalculateScore("Tim", 500);
		System.out.println("New score is: "+ newScore);
		
		double newScore2 = CalculateScore("Paco", 500.10);
		System.out.println("New score is: "+ newScore2);
		
		int a =CalculateScore();
		System.out.println(a);
	}

	public static int CalculateScore(String playerName, int score) {
		
			System.out.println("Player " + playerName + " scored " + score + " points");
		
		return score * 1000;
		
	}
	
	public static double CalculateScore(String playerName, double score) {
		
		System.out.println("Player " + playerName + " scored " + score + " points");
	
	return score * 2000;
	
}
	
	public static int CalculateScore() {
		
		System.out.println("No player or points registered");
	
	return 0;
	
}
	
	
}
