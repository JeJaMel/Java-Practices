package Section9.Challenges.Challenge3;

public class Controller {

    public int[] reverse(int[] array) {

            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }


        return array;
    }

}
