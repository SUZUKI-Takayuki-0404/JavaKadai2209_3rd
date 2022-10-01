import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> studentById = Map.of(123, "takahashi", 234, "yamamoto", 345, "nakamura");
        System.out.println(studentById.get(2));

        List<Integer> ids = List.of(123, 234, 345, 456);

        for (int i = 0; i < ids.size(); i++) {
            String name = studentById.get(ids.get(i));
            try {
                System.out.println(name.toUpperCase());
            } catch (NullPointerException e) {
                System.out.println("Data not available");
            }
        }

        System.out.println("------------------------");
        System.out.println("別のやり方：streamAPIを利用");
        ids.stream()
                .map(id -> studentById.getOrDefault(id, "Data not available"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
