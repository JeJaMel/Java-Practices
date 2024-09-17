package seccion6;

public class sum3and5 {

    public static void main(String[] args) {

        int c = 0;
        
        for(int i = 1; i <= 1000; i++){
            if(i % 3 == 0 && i % 5 == 0){
                if(c>=5){
                    break;
                }
                System.out.println(i);
                c++;
            }
        }

        System.out.println(c);
    }



}




