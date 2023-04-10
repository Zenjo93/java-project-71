package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map> tree, String format) throws JsonProcessingException {
        if (format.equals("stylish")) {
            return Stylish.format(tree);
        }
        if (format.equals("plain")) {
            return Plain.format(tree);
        } if (format.equals("json")) {
            return Json.format(tree);
        }

        else return "";

    }

}
