package section6;

public class FirstLastDigitSum {

    public static void main(String[] args) {

        System.out.println(sumFirstAndLastDigit(1068));

    }

    public static int sumFirstAndLastDigit(int n) {
        if (n < 0) {
            return -1;
        }

        int lastDigit = n % 10;

        while (n >= 10) {
            n /= 10;
        }
        int firstDigit = n;

        return firstDigit + lastDigit;
    }


}






