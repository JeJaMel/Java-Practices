package Section10.Challenges.TownDistance;

import java.util.LinkedList;

public class Main {

    record TownDistance(String name, int distance) {


        @Override
        public String toString() {
            return String.format("%s (%d)", name, distance);
        }

    }

    public static void main(String[] args) {

        LinkedList<TownDistance> distancesList = new LinkedList<>();

        addToList(distancesList, new TownDistance("Adelaide", 1374));
        addToList(distancesList, new TownDistance("Alice Springs", 2771));
        addToList(distancesList, new TownDistance("Brisbane", 917));
        addToList(distancesList, new TownDistance("Darwin", 3972));
        addToList(distancesList, new TownDistance("Perth", 3929));

        System.out.println(distancesList);

    }

    public static void addToList(LinkedList<TownDistance> list, TownDistance place) {

        for (var List : list) {
            if (List.name.equals(place.name)) {
                System.out.println("Place already in the list.");
                return;
            }
        }
        int matchedIndex = 0;
        for (var List : list) {
            if (List.distance > place.distance) {
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }

        list.addLast(place);
    }

}
