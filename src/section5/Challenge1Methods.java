package section5;

public class Challenge1Methods {

	public static void main(String[] args) {
		
		String name = "This";
		String name1 = "text";
		String name2 = "get aged";
		String name3 = "bad";
				
		int position = calculateHighscorePosition(1500);
		displayHighScorePosition(name, position);
		
		position = calculateHighscorePosition(1000);
		displayHighScorePosition(name1, position);
		
		position = calculateHighscorePosition(500);
		displayHighScorePosition(name2, position);
		
		position = calculateHighscorePosition(100);
		displayHighScorePosition(name3, position);
		
		position = calculateHighscorePosition(25);
		displayHighScorePosition("Jesus", position);
		
	}
	
		public static void displayHighScorePosition(String name, int position) {
			System.out.println(name+" managed to get into position "+ position +" on the highscore list.");
		}
		
		public static int calculateHighscorePosition(int score) {
			
			int position;
			if(score>=1000) {
				position = 1;
			}
			else if(score>=500) {
				position = 2;
			}
			else if(score>=100) {
				position = 3;
			}
			else {
				position = 4;
			}
			
			
			return position;
		}
	

}
