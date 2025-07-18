
import java.util.Map;

class Collections {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("key1", "val1", "key2", "val2");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}