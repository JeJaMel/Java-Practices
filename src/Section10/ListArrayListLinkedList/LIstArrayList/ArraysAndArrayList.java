package Section10.ListArrayListLinkedList.LIstArrayList;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysAndArrayList {

    public static void main(String[] args) {

        String[] originalArray = new String[] {"first", "second", "third"};
        var originalList = Arrays.asList(originalArray);

        originalList.set(0, "one");
        System.out.println("List: " + originalList);
        System.out.println("Array: " + Arrays.toString(originalArray));
        //any method we use on this list will have an effect on the array that was the source of the list

        originalList.sort(Comparator.naturalOrder());
        System.out.println(Arrays.toString(originalArray));

        //this list is backed by an array, you can't remove  or add elements

    }
}
