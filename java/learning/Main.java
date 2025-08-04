import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 2, 3, 4, 5));

        list.removeIf(n -> n % 2 == 0);
        System.out.println(list);

        HashMap<String, Integer> map = new HashMap<>();

        map.put("rahulsaamanth", null);
        map.put("Jithendra", 10);

        System.out.println(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
