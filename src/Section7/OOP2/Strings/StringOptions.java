package Section7.OOP2.Strings;

import java.util.Scanner;

public class StringOptions {

    public static void main(String[] args) {

        /*
   |====================================================================================================================|
   | Method                                  Description                                                                |
   |--------------------------------------------------------------------------------------------------------------------|
   |  delete:       you can delete a substring using indices to specify a range, or delete a single character at an     |
   |   deleteChatAt    index                                                                                            |
   |  insert:       you can insert text at a specified position                                                         |
   |   reverse:     you can reverse the order of the characters in the sequence                                         |
   |   setLength:   can be used to truncate the sequence, or include null sequences to 'fill out' the sequence          |
   |====================================================================================================================|
         */


        //here you have to assign it to a variable
        String helloWorld = "Hello " + "World";
        helloWorld.concat(" and Goodbye");

        //here is not necessary
        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");

        printInformation(helloWorld);
        printInformation(helloWorldBuilder);

        //StringBuilder is mutable
        StringBuilder emptyStart = new StringBuilder();
        StringBuilder emptyStart32 = new StringBuilder(32);

        printInformation(emptyStart);
        printInformation(emptyStart32);

        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and Goodbye");

        builderPlus.deleteCharAt(16).insert(16, 'g');
        System.out.println(builderPlus);

        builderPlus.replace(16, 17, "G");
        System.out.println(builderPlus);

        builderPlus.reverse().setLength(7);
        System.out.println(builderPlus);

        createAndAppendString();

    }

    public static void printInformation(String string) {
        System.out.println("String = " + string);
        System.out.println("Length = " + string.length());
    }

    public static void printInformation(StringBuilder builder) {
        System.out.println("StringBuilder = " + builder);
        System.out.println("Length = " + builder.length());
        System.out.println("Capacity = " + builder.capacity());
    }

    public static void createAndAppendString() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String string = sc.nextLine();
        StringBuilder SB = new StringBuilder(string);

        String addedString;
        boolean run = true;
        while (run) {

            System.out.println("Do you want to add something more to the String? (Y/N) ");
            String option = sc.nextLine().toLowerCase();
            if (option.equals("y")) {
                System.out.println("Enter a string to add: ");
                addedString = sc.nextLine();
                SB.append(addedString);
                System.out.println("\n" + SB);
            } else {
                System.out.println("Ok, this is your String: " + SB + "\n String final capacity = " + SB.capacity());

                run = false;
            }
        }
    }

}