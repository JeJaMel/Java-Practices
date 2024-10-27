package Section10.ListArrayListLinkedList.LIstArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {

    public static void main(String[] args) {

        String[] items = {"apples", "bananas", "milk", "eggs"};
//transform a array of strings to a list of strings
        List<String> list = List.of(items);
        System.out.println(list);

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("apples");
        groceries.add("bananas");
        System.out.println(groceries);


        ArrayList<String> nextList = new ArrayList<>(
                List.of("apples", "bananas", "milk", "eggs")
        );
        System.out.println(nextList);

        groceries.addAll(nextList);
        System.out.println(groceries);

        System.out.println("Third item = " + groceries.get(2));

        if (groceries.contains("bananas")) {
            System.out.println("List contains bananas");
        }

        System.out.println("First = " + groceries.indexOf("bananas"));
        System.out.println("Last = " + groceries.lastIndexOf("bananas"));

        //we can remove by value with .remove with the index or with the element value
        //remove element just remove a single element on the list, the first that is in the list
        // to remove more than 1 we use removeAll

        groceries.removeAll(List.of("bananas"));
        System.out.println(groceries);

        //this will just retain the passing elements
        groceries.retainAll(List.of("milk", "eggs"));
        System.out.println(groceries);

        //.clear remove all elements
        groceries.clear();
        System.out.println(groceries);
        System.out.println("isEmpty = " + groceries.isEmpty());

        groceries.addAll(List.of("apples", "bananas", "milk", "eggs"));
        groceries.addAll(Arrays.asList("mustard", "pickles", "ham", "cheese"));

        //.naturalOrder works with numbers to
        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        //transform to arrays
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));

    }
}
