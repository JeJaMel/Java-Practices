package Section10.ListArrayListLinkedList.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        //    LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sidney");
        placesToVisit.addFirst("Montevideo");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

//        gettingElements(placesToVisit);
//        System.out.println();
//        printItinerary3(placesToVisit);

        testIterator(placesToVisit);

    }

    public static void addMoreElements(LinkedList<String> list) {

        list.addFirst("Santiago de Chile");
        list.addFirst("Ontario");

        //Queue methods
        list.offer("Vancouver");
        list.offerFirst("Valledupar");
        list.offerLast("Buenos Aires");

        //Stack methods
        list.push("Barcelona");


    }

    public static void removeElements(LinkedList<String> list) {

        list.remove(4);
        list.remove("Valledupar");
        System.out.println(list);

        String s1 = list.remove();
        System.out.println(s1 + " Was removed");

        String s2 = list.removeFirst();
        System.out.println(s2 + " Was removed");

        String s3 = list.removeLast();
        System.out.println(s3 + " Was removed");

        System.out.println(list);

        //Queue/Deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " Was removed");

        String p2 = list.pollFirst();
        System.out.println(p2 + " Was removed");

        String p3 = list.pollLast();
        System.out.println(p3 + " Was removed");

        list.push("Sydney");
        list.push("California");
        list.push("Aguas Calientes ");
        System.out.println(list);

        String p4 = list.pop();
        System.out.println(p4 + " Was removed");
    }

    public static void gettingElements(LinkedList<String> list) {

        System.out.println("First element = " + list.getFirst());
        System.out.println("Last element = " + list.getLast());

        // we can also use indexOf and lastIndexOf to get the indexes

        //Queue retrieval method
        System.out.println("Element from element() = " + list.element());
        //Stack retrieval methods
        System.out.println("\nElement from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());

    }

    public static void printItinerary(LinkedList<String> list) {

        System.out.println("=".repeat(35));
        System.out.println("Trip starts at " + list.getFirst());

        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> From: " + list.get(i - 1) + " To: " + list.get(i));
        }

        System.out.println("Trip ends at " + list.getLast());
        System.out.println("=".repeat(35));
    }

    public static void printItinerary2(LinkedList<String> list) {

        System.out.println("=".repeat(35));
        System.out.println("Trip starts at " + list.getFirst());

        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("--> From: " + previousTown + " To: " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
        System.out.println("=".repeat(35));
    }

    public static void printItinerary3(LinkedList<String> list) {

        //an iterator is another way to traverse lists
        //is an object that allows traversal over records in a collections

        System.out.println("=".repeat(40));
        System.out.println("Trip starts at " + list.getFirst());

        String previousTown = list.getFirst();
        //using this overloaded version of listIterator, we can select starting index
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " To: " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
        System.out.println("=".repeat(40));

    }

    public static void testIterator(LinkedList<String> list) {
//iterator can modify the list while iterating tru it
        var iterator = list.listIterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("Santiago de Chile")) {
                iterator.remove();
                iterator.add("Springfield");

            }
        }

//            this is false because is pointing beyond the last element
//            so you need or move backwards or create a new iterator instance
//            while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//            }


        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println(list);
        //iterator is forwards only and only supports the remove method
        //ListIterator allows you to navigate both and support add and set methods.

        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.next());
        System.out.println(iterator2.previous());

    }


}

