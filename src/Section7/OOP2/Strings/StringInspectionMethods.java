package Section7.OOP2.Strings;

public class StringInspectionMethods {

    public static void main(String[] args) {

   /*

   |=================================================================================================================|
   | Method                                  Description                                                             |
   |-----------------------------------------------------------------------------------------------------------------|
   | length:          returns the number of characters in the string                                                 |
   | charAt:          returns the character at the index that's passed                                               |
   | indexOf:         returns an integer, representing the index int sequence where the String or character passed,  |
   |lastIndexOf       can be located in the String                                                                   |
   | isEmpty:         returns true if length is 0                                                                    |
   | isBlank:         returns true if length is 0 OR the string only contains whitespace characters, added in JDK 11 |
   |=================================================================================================================|

    */


        printInformation("Hello World");
        printInformation("");
        printInformation("\n");

        String helloWorld = "Hello World";
        System.out.printf("index of letter r = %d %n", helloWorld.indexOf("r"));
        System.out.printf("index of World = %d %n", helloWorld.indexOf("World"));

        System.out.printf("index of letter l = %d %n", helloWorld.indexOf("l"));
        System.out.printf("index of letter l = %d %n", helloWorld.indexOf("l", 3));
        System.out.printf("index of letter l = %d %n", helloWorld.lastIndexOf("l"));

    }

        public static void printInformation(String string) {
        System.out.println(string);
            int length = string.length();
                System.out.printf("Length = %d\n", length);

                if(string.isEmpty()){
                    System.out.println("Empty String");
                    return;
                }
                if(string.isBlank()){
                    System.out.println("Blank String");
                    return;
                }

                System.out.printf("First char = %c %n", string.charAt(0));
                System.out.printf("Last char = %c %n", string.charAt(length - 1));
        }

}