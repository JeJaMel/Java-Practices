package section6;

public class PrimeNumberTo1000 {

    public static void main(String[] args) {
        primeList();
    }

    public static boolean isprime(int n) {

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.println(n + " is not prime number");
                return false;
            }
        }
        System.out.println(n + " is prime number");
        return true;
    }

    public static void primeList() {

        int p;
        for (int i = 2; i < 1000; i++) {
            isprime(i);


        }

    }

}




