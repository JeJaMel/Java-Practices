package personal.RandomCodes;

import java.util.Random;

public class InfiniteMonkeyTheorem {

    public static void main(String[] args) throws InterruptedException {
        String lookingWord = "Jesus";
        calculateProbability(lookingWord.toLowerCase());
        monkeyTheorem(lookingWord.toLowerCase());
    }

    public static String generateWord(String word) {
        int wordLength = word.length();
        Random rnd = new Random();
        StringBuilder generatedWord = new StringBuilder();

        for (int i = 0; i < wordLength; i++) {
            char c = (char) (rnd.nextInt(26) + 'a');
            generatedWord.append(c);
        }
        return generatedWord.toString();
    }

    public static void monkeyTheorem(String word) throws InterruptedException {
        int counter = 0;
        String generatedWord = generateWord(word);

        while (!word.equals(generatedWord)) {
            generatedWord = generateWord(word);
            counter++;
            System.out.print("\rCurrent try: " + counter + "\t Word progress: " + generatedWord);
            System.out.flush();
           // Thread.sleep(10);
        }

        System.out.println("\nSuccessfully matched the word: '" + generatedWord + "' in " + counter + " attempts");
    }

    public static void calculateProbability(String word) {
        int wordLength = word.length();
        double letterProbability = 1.0 / 26.0;

        double prob = Math.pow(letterProbability, wordLength);
        double percentage = prob * 100;

        System.out.println("\nThe probability of forming the word '" + word + "' is: " + String.format("%.10f", percentage) + "%");
    }
}
