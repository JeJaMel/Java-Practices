package Section7.OOP2.Strings;

public class StringComparisonMethods {

    public static void main(String[] args) {

   /*

   |====================================================================================================================|
   | Method                                  Description                                                                |
   |--------------------------------------------------------------------------------------------------------------------|
   | contentEquals:returns a boolean if the String's value is equal to the value of the argument passed, allows any type|
   | equals:            return a boolean if the String's value is equal to the value of the argument passed             |
   | equalsIgnoreCase:  return a boolean if the String's value is equal (ignoring case), to the value of the argument   |
   |--------------------------------------------------------------------------------------------------------------------|
   | contains:          returns a boolean if the String contains the argument passed                                    |
   | endsWith:          these return a boolean, and are much like the contains method but                               |
   | startWith          more specific to the placement of the argument in the string                                    |
   | regionMatches:     Returns a boolean, if defined sub-regions are matched                                           |
   |====================================================================================================================|

    */

        String str1 = "Hello";
        String str2 = "HeLLo";

        compareStrings(str1, str2);

        String str3 = "Hello World from my city";
        if(str3.contains("Hello")){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        String str4 = "Monkey";
        if(str4.endsWith("y") || (str4.startsWith("M"))){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    public static void compareStrings(String text1, String text2) {
        if (text1.equals(text2)) {
            System.out.println("\nText 1 and Text 2 are the same");

        } else if (text1.equalsIgnoreCase(text2)) {
            System.out.println("\nText 1 and Text 2 are the same but with different case level");
        } else {
            System.out.println("\nText 1 and Text 2 are not the same");
        }
    }

}