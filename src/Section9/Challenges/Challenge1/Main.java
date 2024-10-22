package Section9.Challenges.Challenge1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] myArray = getRandomArray(10);
        System.out.println(Arrays.toString(myArray));
        InvertSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    private static int[] getRandomArray(int len) {

        Random rand = new Random();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    private static int[] InvertSort(int[] arr) {

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;

                }
            }


        }

        return arr;
    }

}
