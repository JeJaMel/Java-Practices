package Section7.OOP2.Strings;

public class StringManipulationMethods {

    public static void main(String[] args) {

   /*

   |====================================================================================================================|
   | Method                                  Description                                                                |
   |--------------------------------------------------------------------------------------------------------------------|
   | indent: This method was added in JDK15, and adds or removes spaces from the beginning of lines in multi-line text. |
   | strip:          The difference between the strip method and trim method us that the                                |
   | stripLeading    strip() supports a larger set of white space characters. it and the                                |
   | stripTrailing   corresponding stripLeading and stripTailing methods were added in JDK 11                           |
   | trim                                                                                                               |
   | toLowerCase:   Return a new String. either in a lower case or in upper case                                        |
   | toUpperCase                                                                                                        |
   |--------------------------------------------------------------------------------------------------------------------|
   | concat:       Similar to the plus operator for strings, it concatenates text to the String and returns a new string|                                  |
   | join:         Allows multiple string to be concatenated together in a single method, specifying a number           |
   | repeat:       Returns the String repeated by the number of times specified in the argument                         |
   | replace:      These methods replace characters or strings in the string, returning a                               |
   | replaceAll    new string with replacements made                                                                    |
   | replaceFirst                                                                                                       |
   | subString:    These returns a part of the String, its range defined by the start and ind index specified           |
   | subSequence                                                                                                        |
   |====================================================================================================================|

    */

        String birthDate = "10/05/2005 09:32:12";
        int startingIndex = birthDate.indexOf("2005");
        int month = birthDate.indexOf("/");
        System.out.println("startingIndex: " + startingIndex);
        System.out.println("BirthYear = " + birthDate.substring(startingIndex, startingIndex + 4));
        System.out.println("Month = " + birthDate.substring(month + 1, month + 3));

        String newDate = String.join("/", "25", "11", "2000");
        System.out.println("newDate: " + newDate);

        //very inefficient
        newDate = "25";
        newDate = newDate.concat("/");
        newDate = newDate.concat("11");
        newDate = newDate.concat("/");
        newDate = newDate.concat("1982");
        System.out.println("newDate: " + newDate);

        newDate = "25" + "/" + "12" + "/" + "1987";
        System.out.println("newDate: " + newDate);

        newDate = "25".concat("/").concat("11").concat("/").concat("1987");
        System.out.println("newDate: " + newDate);

        System.out.println("newDate: " + newDate.replace("/", "-"));
        System.out.println("newDate: " + newDate.replaceFirst("/", "---"));
        System.out.println("newDate: " + newDate.replaceAll("/", "-{}-"));

        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));

        System.out.println("ABC\n".repeat(3).indent(8));
        System.out.println("-".repeat(20));

        System.out.println("    ABC\n".repeat(3).indent(-2));
        System.out.println("-".repeat(20));
    }


}