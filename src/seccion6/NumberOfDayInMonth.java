package seccion6;

public class NumberOfDayInMonth {

    public static void main(String[] args) {

        int year = 200;
        int month = 2;

        System.out.println("\nThe amount of days on " + month + " of the year " + year + " is: " + getDaysInMonth(month, year));
    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        } else return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month < 1 || month > 12) {
            System.out.println("Invalid month");
            return -1;
        }
        else if(year < 1 || year > 9999) {
            return -1;
        }
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return daysInMonths[month - 1];
    }

    }





