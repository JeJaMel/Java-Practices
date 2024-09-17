package seccion6;

public class EnhancedSwitch {

    public static void main(String[] args) {

        int switchValue = 2;

        switch (switchValue) {

            case 1 -> System.out.println("Value is 1");
            case 2 -> System.out.println("value is 2");
            case 3, 4, 5 -> {
                System.out.println("The value is 3, 4 or 5");
                System.out.println("value actually is: " + switchValue);
            }
            default -> System.out.println("the value was now 1, 2, 3, 4, or 5.");

        }

        String month = "April";

        System.out.println(month + " is in the " + getQuarter(month) + " quarter");

    }

    public static String getQuarter(String month) {

        return switch (month) {
            case "January", "February", "March" -> "1st";
            case "April", "May", "June" -> "2nd";
            case "July", "August", "September" -> "3rd";
            case "October", "November", "December" -> "4th";
            default -> {
                yield month + " is not recognized as a month";
            }
        };
        //     -> "1st";    ==    -> {yield "1st"; }

    }


}
