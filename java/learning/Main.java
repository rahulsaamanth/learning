import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static Predicate<Integer> isEven() {
        return n -> n % 2 == 0;
    }

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

        List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> lst1 = lst.stream().filter(isEven()).collect(Collectors.toList());
        System.out.println(lst1);
    }
}
