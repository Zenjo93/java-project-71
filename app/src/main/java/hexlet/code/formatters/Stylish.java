package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stylish {

    public static String format(List<Map> tree) {
        StringBuilder diffTree = new StringBuilder("{\n");

        String stringTree = tree.stream().map(Stylish::mapping).collect(Collectors.joining("\n"));

        diffTree.append(stringTree).append("\n}");

        return diffTree.toString();

    }

    private static String mapping(Map<String, Object> node) {
        String type = (String) node.get("type");

        switch (type) {
            case "added" -> {
                return " " + " + " + node.get("name") + ": " + stringify(node.get("value"));
            }
            case "deleted" -> {
                return " " + " - " + node.get("name") + ": " + stringify(node.get("value"));
            }
            case "unchanged" -> {
                return " ".repeat(4) + node.get("name") + ": " + stringify(node.get("value"));
            }
            case "changed" -> {
                return " " + " - " + node.get("name") + ": " + stringify(node.get("value1")) + "\n"
                        + " " + " + " + node.get("name") + ": " + stringify(node.get("value2"));
            }
            default -> {
                return "";
            }
        }
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        return value.toString();

    }
}
