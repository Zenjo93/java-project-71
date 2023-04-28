package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String path1, String path2) throws Exception {
        String defaultFormat = "stylish";
        return makeDiff(path1, path2, defaultFormat);
    }

    public static String generate(String path1, String path2, String format) throws Exception {
        return makeDiff(path1, path2, format);
    }

    private static String makeDiff(String path1, String path2, String format) throws Exception {

        String file1 = readData(path1);
        String file2 = readData(path2);

        String fileType1 = getFileType(path1);
        String fileType2 = getFileType(path2);

        Map<String, Object> data1 = getData(file1, fileType1);
        Map<String, Object> data2 = getData(file2, fileType2);

        List<Map<String, Object>> tree = AbstractSyntaxTreeBuilder.build(data1, data2);

        return Formatter.format(tree, format);
    }

    public static String getFileType(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
    }

    public static String readData(String path) throws Exception {
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(absolutePath);
    }

}
