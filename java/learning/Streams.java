
import java.util.Comparator;
import java.util.function.Function;

public class Streams {
    public static void main(String[] args) {
        // Example usage of the Generics class
        // Generics.main(args);

        Comparator<String> comp = (a, b) -> a.compareTo(b);

        int result = comp.compare("apple", "apple");

        System.out.println("Comparison result: " + result);

        Function<String, String> processor = (input) -> {
            String res = input.toUpperCase();
            return res.trim();
        };

        String processed = processor.apply("  hello world  ");
        System.out.println("Processed string: '" + processed + "'");
    }
}