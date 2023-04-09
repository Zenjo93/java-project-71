package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static hexlet.code.Parser.getData;

public class Differ {

    // TODO: stylish значения по дефолту, через перегрузку методов
    public static String generate(String path1, String path2) throws Exception {
        String format = "stylish";
        return makeDiff(path1, path2, format);
    }

    public static String generate(String path1, String path2, String format) throws Exception {
        return makeDiff(path1, path2, format);
    }

    private static String makeDiff(String path1, String path2, String format) throws Exception {

        String file1 = readFile(path1);
        String file2 = readFile(path2);

        String fileType1 = getFileType(path1);
        String fileType2 = getFileType(path2);

        Map<String, Object> data1 = getData(file1, fileType1);
        Map<String, Object> data2 = getData(file2, fileType2);

        List<Map> tree = AstBuilder.build(data1, data2);

        // мб c format
        String diff = Formatter.format(tree);

        return diff;
    }




    public static String getFileType(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
    }

    public static String readFile(String path) throws Exception {
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(absolutePath);
    }

}
