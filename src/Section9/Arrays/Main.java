package Section9.Arrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int firstArraySize = 10;

        int[] myIntArray = new int[firstArraySize];
        myIntArray[0] = 11;
        myIntArray[5] = 50;

        double[] myDoubleArray = new double[firstArraySize];
        myDoubleArray[2] = 3.5;

        //if we know the content of the array before we create ir, we can use  an array initializer

        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < myIntArray.length; i++) {
            System.out.println("INT Array position " + i + ": " + myIntArray[i]);
            System.out.println("DOUBLE Array position " + i + ": " + myDoubleArray[i]);

        }

        int arraySize = firstTen.length;
        System.out.println("\nFirst= " + firstTen[0]);
        System.out.println("Last= " + firstTen[arraySize - 1]);

        int[] newArray;
        newArray = new int[5];

        for (int i = 0; i < newArray.length; i++){
            newArray[i] = newArray.length - i;
        }
        for (int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }
        System.out.println();
        //enhanced for
        for (int j : newArray) {
            System.out.print(j + " ");
        }
        System.out.println();

        //if we want to manipulate, we can use the class java.util.Arrays
        //it has a single property or field, named length
        //it inherits java.util.Object's functionality

        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(firstTen));

        Object objectVariable = newArray;
        if(objectVariable instanceof int[]){
            System.out.println("object variable is really an int array");
        }

        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = newArray;


    }

}
