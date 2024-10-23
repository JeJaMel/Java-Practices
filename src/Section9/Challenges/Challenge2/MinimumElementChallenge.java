package Section9.Challenges.Challenge2;

public class MinimumElementChallenge {

    public static void main(String[] args) {

        Controller c = new Controller();

        int[] myArray = c.readIntegers();
        System.out.println( c.findMin(myArray));

    }

}
