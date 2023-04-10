package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map> tree, String format) {
        if (format.equals("stylish")) {
            return Stylish.format(tree);
        }
        if (format.equals("plain")) {
            return Plain.format(tree);
        } else return "";

    }

}
