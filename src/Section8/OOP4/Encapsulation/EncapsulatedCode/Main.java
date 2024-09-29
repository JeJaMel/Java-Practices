package Section8.OOP4.Encapsulation.EncapsulatedCode;

public class Main {
    /*
    To create an encapsulated class:
    -Create constructors for object initialization, which enforces that only objects with valid data will get created.
    -Use private access modifier for your fields.
    -use setter methods sparingly and only as needed.
    -Use access modifiers that aren't private, only for the methods that the calling code needs to use.
     */
    public static void main(String[] args) {

        EnhancedPlayer tim = new EnhancedPlayer("Tim");
        System.out.println(tim.healthRemaining());

        EnhancedPlayer pablo = new EnhancedPlayer("Pablo", 200, "Bow");
        System.out.println(pablo.healthRemaining());

    }
}