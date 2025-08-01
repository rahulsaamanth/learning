import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rand1 = new Random(42);
        Random rand2 = new Random(42);

        double result = Math.floor(3.99);

//        System.out.println(rand1.nextInt());
//        System.out.println(rand2.nextInt());
        System.out.println(result);
    }
}
