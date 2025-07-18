
class Numbers {

    private int a;
    private int b;

    public void set(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void sum() {
        System.out.println(a + b);
    }

    public void sub() {
        System.out.println(a - b);
    }

}

public class Hello {
    public static void main(String[] args) {

        Numbers n = new Numbers();
        n.set(1, 2);
        n.sum();
        n.sub();

        System.out.println("Hello, world!");
        /*
         * try (Scanner in = new Scanner(System.in)) {
         * String name = in.nextLine();
         * int age = in.nextInt();
         * 
         * System.out.println(name + " " + age);
         * 
         * }
         */
    }

}