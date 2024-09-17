package section5;

public class SecondsAndMinutesChallenge {

	public static void main(String[] args) {
		
		int seconds = 45;
		int minute = 833;
		
		System.out.println(getDurationSring(seconds));
		System.out.println(getDurationSring(seconds, minute));
	}
	
	public static String getDurationSring(int seconds) {
		
		if(seconds>=86401 || seconds<=-1) {
			System.out.println("Invalid value of seconds, please put a number between 0 and 86400");
			return "Error";
		}
		
		int hour = seconds/3600;
		int minute = seconds%3600/60;
		int second = (seconds%3600)%60;
		
		return  hour + "h " + minute + "m " + second + "s";
		
	}
	
	public static String getDurationSring(int seconds, int minute) {
		
		if(seconds>= 60 || seconds<=-1 || minute <= -1 || minute >=1441) {
			System.out.println("Invalid value of seconds, please put a number between 0 and 86400");
			return "Error";
		}
		
		int hour = minute/60;
		int minutes = minute%60;
		
		return  hour + "h " + minutes + "m " + seconds + "s";
	}
	
}
