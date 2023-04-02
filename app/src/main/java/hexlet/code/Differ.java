package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static hexlet.code.Parser.getData;

public class Differ {

    // TODO: stylish значения по дефолту, через перегрузку методов
    public static String generate(String path1, String path2) throws Exception {

        String file1 = readFile(path1);
        String file2 = readFile(path2);

        String fileType1 = getFileType(path1);
        String fileType2 = getFileType(path2);

        // Парсинг (в зависимости от типа файлов)
        Map<String, Object> data1 = getData(file1, fileType1);
        Map<String, Object> data2 = getData(file2, fileType2);

        // Передается уже распарсенный файл (json / yml)
        String diff = formatDiff(data1, data2);

        System.out.println(diff);

        return diff;
    }

    public static String getFileType(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
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
            if (!data1.containsKey(key)) {
                diff.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else if (!data2.containsKey(key)) {
                diff.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (!data1.get(key).equals(data2.get(key))) {
                diff.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                diff.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else {
                diff.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
            }
        }

        return diff.append("}").toString();
    }
}
