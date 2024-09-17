package section6;

public class PalindromeNumber {

    public static void main(String[] args) {

        int number = -12121;
        isPalindrome(number);

    }

    public static boolean isPalindrome(int number) {

        int reverseNumber = 0;
        int originalNumber = number;

        while (number != 0) {
            int remainder = number % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            number /= 10;

        }

        if (reverseNumber == originalNumber) {
            System.out.println(originalNumber + " is a palindrome number!");
            return true;
        } else {
            System.out.println(originalNumber + " is not a palindrome number!");
            return false;
        }

    }


}






