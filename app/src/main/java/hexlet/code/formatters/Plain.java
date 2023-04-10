package hexlet.code.formatters;

import hexlet.code.Formatter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Plain {
    public static String format(List<Map> tree) {
        StringBuilder diffTree = new StringBuilder();

        String stringTree = tree.stream().map(Plain::mapping).collect(Collectors.joining());

        diffTree.append(stringTree);

        return diffTree.toString().trim();

    }

    private static String mapping(Map<String, Object> node) {
        String type = (String) node.get("type");

        switch (type) {
            case "added" -> {
                return "Property " + "'" + node.get("name") + "'" + " was added with value: " + stringify(node.get("value")) + "\n";
            }
            case "deleted" -> {
                return "Property " + "'" + node.get("name") + "'" + " was removed" + "\n";
            }
            case "changed" -> {
                return "Property " + "'" +  node.get("name") + "'" + " was updated. From " + stringify(node.get("value1")) + " to " + stringify(node.get("value2")) + "\n";
            }
            default -> {
                return "";
            }
        }
    }

    private static String stringify (Object value) {
        if (value == null) {
            return "null";
        }
        else if (value instanceof Boolean) {
            return value.toString();
        }
        else if (value instanceof Integer) {
            return value.toString();
        }
        else if (value instanceof Collection<?> || value instanceof Map<?,?>) {
            return "[complex value]";
        }
        return "'" + value + "'";
    }
}
