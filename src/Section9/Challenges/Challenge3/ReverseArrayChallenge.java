package Section9.Challenges.Challenge3;

import java.util.Arrays;

public class ReverseArrayChallenge {

    public static void main(String[] args) {

        Controller c = new Controller();

        int[] myArray = {24,11,2,4,8,9,1};

        System.out.println(Arrays.toString(myArray));
        System.out.println(Arrays.toString(c.reverse(myArray)));
        System.out.println(Arrays.toString(c.reverse(myArray)));
    }
}
