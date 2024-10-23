package Section9.Arrays.ArraysReferences;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*
        A reference is an address to the object in memory, but no the object itself
         */

     int[] myIntArray = new int[5];
     int[] anotherIntArray = myIntArray;

     anotherIntArray[0] = 10;
//both variables are referencing the same array in memory
     System.out.println("myIntArray = " + Arrays.toString(myIntArray));
     System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));

     //so there is one array in memory with two variables pointing at it

    }

}
