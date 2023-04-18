package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;

public class AstBuilder {

    public static List<Map> build(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> uniqueKeys = new TreeSet<>(data1.keySet());
        uniqueKeys.addAll(data2.keySet());

        List<Map> ast = new ArrayList<>();

        for (String key : uniqueKeys) {
            if (!data1.containsKey(key)) {
                ast.add(Map.of(
                        "name", key,
                        "type", "added",
                        "value", data2.get(key)
                ));
            } else if (!data2.containsKey(key)) {
                ast.add(Map.of(
                        "name", key,
                        "type", "deleted",
                        "value", data1.get(key)
                ));
            } else if ((data1.get(key) == null) || !data1.get(key).equals(data2.get(key))) {
                Map<String, Object> node = new HashMap<>();
                node.put("name", key);
                node.put("type", "changed");
                node.put("value1", data1.get(key));
                node.put("value2", data2.get(key));
                ast.add(node);

            } else {
                ast.add(Map.of(
                        "name", key,
                        "type", "unchanged",
                        "value", data1.get(key))
                );
            }
        }
        return ast;
    }
}

