package Section9.Challenges.Challenge2;

import java.util.Scanner;

public class Controller {

    public int[] readIntegers(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ',' delimited integers: ");
        String input = sc.nextLine();

        int[] arr = new int[input.split(",").length];

        for(int i = 0; i < input.split(",").length; i++){
            arr[i] = Integer.parseInt(input.split(",")[i]);
        }



        return arr;
    }

}
