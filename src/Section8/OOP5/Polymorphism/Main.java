package Section8.OOP5.Polymorphism;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            String input = """
                    Enter type
                    A = Adventure
                    C = Comedy
                    S = Science Fiction 
                    """;
            System.out.println(input);
            String type = sc.nextLine();
            if("Qq".contains(type)) {
                break;
            }
            System.out.println("Enter the Movie title: ");
            String movieTitle = sc.nextLine();
            Movie theMovie = Movie.getMovie(type, movieTitle);
            theMovie.watchMovie();
        }
    }
}