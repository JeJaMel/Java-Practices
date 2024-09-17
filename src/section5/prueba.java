package section5;

public class prueba {
	
	public static void main(String[] args) {
		
		printEqual(-1,-1,-1);
		
	}
	
		public static void printEqual(int digit1, int digit2,int digit3){
		    if(digit1 == digit2 && digit2 == digit3){
		        System.out.println("All numbers are equal");
		    }
		    else if(digit1 != digit2 && digit2 != digit3 && digit3 != digit1){
		        System.out.println("All numbers are different");
		    }
		    else{
		        System.out.println("Neither all are equal or different");
		    }
		    
		   
		    
		}
}
