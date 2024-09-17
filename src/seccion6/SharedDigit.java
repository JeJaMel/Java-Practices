package seccion6;

public class SharedDigit {

    public static void main(String[] args) {

    boolean Answer =  hasSharedDigit(23, 17);
    System.out.println(Answer);

    }
    public static boolean hasSharedDigit(int num1, int num2) {
        if ((num1 < 10 || num1 > 99) || (num2 < 10 || num2 > 99)  ) {
            return false;
        }

        int lastDigit1 = num1 % 10;
        int lastDigit2 = num2 % 10;

        if (lastDigit1 == lastDigit2) {
            return true;
        }

        while ( num1 > 10 && num2 > 10){
            num1 = num1 / 10;
            num2 = num2 / 10;
        }
        int firstDigit1 = num1 % 10;
        int firstDigit2 = num2 % 10;

        if (firstDigit1 == firstDigit2) {
            return true;
        } else if (firstDigit1 == lastDigit2 || firstDigit2 == lastDigit1){
            return true;
        }
        return false;
    }




}






