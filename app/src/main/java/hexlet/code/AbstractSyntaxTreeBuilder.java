package hexlet.code;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AbstractSyntaxTreeBuilder {

    public static List<Map<String, Object>> build(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> uniqueKeys = new TreeSet<>(data1.keySet());
        uniqueKeys.addAll(data2.keySet());

        List<Map<String, Object>> abstractSyntaxTree = new ArrayList<>();

        for (String key : uniqueKeys) {
            Map<String, Object> node = new LinkedHashMap<>();
            node.put("name", key);
            if (!data1.containsKey(key)) {
                node.put("type", "added");
                node.put("value", data2.get(key));
                abstractSyntaxTree.add(node);
            } else if (!data2.containsKey(key)) {
                node.put("type", "deleted");
                node.put("value", data1.get(key));
                abstractSyntaxTree.add(node);
            } else if (!isEqual(data1.get(key), data2.get(key))) {
                node.put("type", "changed");
                node.put("value1", data1.get(key));
                node.put("value2", data2.get(key));
                abstractSyntaxTree.add(node);
            } else {
                node.put("type", "unchanged");
                node.put("value", data1.get(key));
                abstractSyntaxTree.add(node);
            }
        }
        return abstractSyntaxTree;
    }

    private static boolean isEqual(Object value1, Object value2) {
        if (value1 == null || value2 == null) {
            return value1 == value2;
        }
        return value1.equals(value2);

    }
}

