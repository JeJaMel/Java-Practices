package Section7.OOP1.RecordProject;

public class Main {

    public static void main(String[] args) {

    for (int i = 1; i<=5; i++){
        Student S = new Student("S92300" + i,
                switch(i){
            case 1 -> "Mary";
            case 2 -> "John";
            case 3 -> "Jack";
            case 4 -> "Jane";
            case 5 -> "Michael";
            default -> "Anonymous";
        }, "05/11/1985", "Java Masterclass");
        System.out.println(S);
    }



    }

}


