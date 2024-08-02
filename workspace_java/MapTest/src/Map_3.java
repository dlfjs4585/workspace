import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Map_3 {
    public static void main(String[] args) {

        Map<String , Object> map = new HashMap<>();
        map.put("1", "100");
        map.put("2", 10);
        map.put("3", 10.5);
        map.put("4", new Student("dd", 1));
    }
}
