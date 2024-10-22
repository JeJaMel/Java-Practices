package Section9.Arrays.javaUtilsArrays;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] randomArray = getRandomArray(10);
        System.out.println(Arrays.toString(randomArray));
        Arrays.sort(randomArray);
        System.out.println(Arrays.toString(randomArray));

        int[] secondArray =new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill(secondArray,5);
        System.out.println(Arrays.toString(secondArray));
        secondArray[4] = 4;
        System.out.println(Arrays.toString(secondArray));
        System.out.println();

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        //in copyOf, I can introduce the length that I want to copy as a parameter
        int[] fourthArray = Arrays.copyOfRange(thirdArray,0,5);
        //if I use copy of, I can use copyOf(thirdArray, thirdArray.length);
        //for a full copy of that array
        System.out.println(Arrays.toString(fourthArray));

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(fourthArray));

        /*
         binary search
         -considered as the best search algorithm
         -useful when:
            *the array is sorted
            *the array has no duplicated elements
         */

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));

        //binary search returns 1 if founds the key, else it returns -1
        if(Arrays.binarySearch(sArray,"Mark") >= 0){
            System.out.println("found!");

            int[] s1= {1,2,3,4,5};
            int[] s2= {1,2,3,4,5};

            if(Arrays.equals(s1,s2)){
                System.out.println("Arrays are equal");
            }else{
                System.out.println("Arrays are not equal");
            }

        }

    }


    private static int[] getRandomArray(int len){

        Random rand = new Random();
        int[] arr = new int[len];

        for(int i = 0; i < len; i++){
            arr[i] = rand.nextInt(100);
        }

        return arr;

    }

}
