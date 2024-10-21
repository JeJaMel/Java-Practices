package Section9.Arrays;

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

        for(int i = 0; i < myIntArray.length; i++) {
            System.out.println("INT Array position "+i+ ": "+ myIntArray[i]);
            System.out.println("DOUBLE Array position "+i+ ": "+ myDoubleArray[i]);

        }

        int arraySize = firstTen.length;
        System.out.println("\nFirst= "+ firstTen[0]);
        System.out.println("Last= "+ firstTen[arraySize - 1]);

    }

}
