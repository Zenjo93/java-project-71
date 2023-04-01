package hexlet.code;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    // TODO: stylish значения по дефолту, через перегрузку методов
    public static String generate(String path1, String path2) throws Exception {

        String file1 = readFile(path1);
        String file2 = readFile(path2);

        Map<String, Object> data1 = getData(file1);
        Map<String, Object> data2 = getData(file2);

        String diff = formatDiff(data1, data2);

        System.out.println(diff);

        return diff;
    }

    public static Map<String, Object> getData(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<TreeMap<String,Object>>(){});
    }

    public static String readFile(String path) throws Exception {
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(absolutePath);
    }

    public static String formatDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> uniqueKeys = new TreeSet<>(data1.keySet());
        uniqueKeys.addAll(data2.keySet());

        StringBuilder diff = new StringBuilder("{\n");

        for (String key : uniqueKeys) {
            // если не было в первом - добавлен
            if (!data1.containsKey(key)) {
                diff.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            }
            // если нет во втором - удалено
            else if (!data2.containsKey(key)) {
                diff.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            }
            else if (!data1.get(key).equals(data2.get(key))) {
                diff.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                diff.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            }
            else {
                diff.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
            }
        }

        return diff.append("}").toString();
    }
}
