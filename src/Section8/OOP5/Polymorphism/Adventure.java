package Section8.OOP5.Polymorphism;

public class Adventure extends Movie {

    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something bad happens");
    }

    public void watchingAdventure(){
        System.out.println("Watching Adventure");
    }
}
