package Section8.OOP5.Polymorphism;

public class NextMain {

    public static void main(String[] args) {
        //Casting practice
        Movie theMovie = Movie.getMovie("A", "Jaws");
        theMovie.watchMovie();

        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchMovie();

        //var is a special contextual keyword in Java that lets our code take advantage of local variable type inference
        var airplane = (Comedy) Movie.getMovie("C", "Airplane");
        airplane.watchMovie();
        airplane.watchingComedy();

        var plane = new Comedy("Airplane");
        plane.watchingComedy();

        Object unknowObject = Movie.getMovie("A", "Airplane");
        switch (unknowObject) {
            case Comedy unknowComedy -> unknowComedy.watchingComedy();
            case Adventure unknowAdventure -> unknowAdventure.watchingAdventure();
            case ScienceFiction unknowScienceFiction -> unknowScienceFiction.watchingScienceFiction();
            default -> {
            }
//              Also using instanceof operator
//            Object unknowObject = Movie.getMovie("C", "Airplane");
//            if(unknowObject instanceof Comedy unknowComedy) {
//                unknowComedy.watchingComedy();
//            } else if(unknowObject instanceof Adventure unknowAdventure) {
//                unknowAdventure.watchingAdventure();
//            } else if(unknowObject instanceof ScienceFiction unknowScienceFiction) {
//                unknowScienceFiction.watchingScienceFiction();
//            }
        }

    }
}
