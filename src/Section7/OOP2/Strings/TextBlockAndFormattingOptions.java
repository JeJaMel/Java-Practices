package Section7.OOP2.Strings;

public class TextBlockAndFormattingOptions {

    public static void main(String[] args) {
        //pre jdk 15:
        String bulleIt = "\nPrint a Bulleted List: " +
                "\n\t\u2022 First Point" +
                "\n\t\t\u2022 Second Point";

        System.out.println(bulleIt);

        String textBlock = """
                
                Print a bulleted List:
                    \u0298 First Point
                        \u0298 Second Point""";

        System.out.println(textBlock);

        int age = 45;
        System.out.printf("Your age is %d%n", age);
        int yearOfBirth = 2024 - age;
        System.out.printf("Your age = %.2f, Your birth year = %d%n ", (float) age, yearOfBirth);

        for (int i = 1; i <= 1000000; i *= 10) {
            System.out.format("Printing %7d %n", i);
        }

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        formattedString = "Your age is %d".formatted(age);
        System.out.println(formattedString);

    }


}