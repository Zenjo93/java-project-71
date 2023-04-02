package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;
import java.util.TreeMap;

public class Parser {

    public static Map<String, Object> getData(String content, String dataType) throws Exception {
        if (dataType.equals("json")) {
            return new ObjectMapper().readValue(content, new TypeReference<TreeMap<String, Object>>() { });
        } else if (dataType.equals("yml") || dataType.equals("yaml")) {
            return new YAMLMapper().readValue(content, new TypeReference<TreeMap<String, Object>>() { });
        } else {
            throw new Exception("unknown format");
        }

    }


}
