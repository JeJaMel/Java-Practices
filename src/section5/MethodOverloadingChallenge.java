package section5;

public class MethodOverloadingChallenge {

	public static void main(String[] args) {
		
		String name = "Pache";
		int feets = 6;
		double inches = 2.803;
		
		double height = convertToCentimeters(feets, inches);
		
		System.out.println(name + " height is: "+ height + " centimeters");
		
	}

	public static double  convertToCentimeters(double inches) {
		
		double centimeter = inches * 2.54;
		
		return centimeter;
	}
	
	public static double convertToCentimeters(int feets, double inches) {
		
		double calculateInches = (feets*12);
		
		double centimeter = (calculateInches+inches)*2.54;
		
		return centimeter;
	}

}
