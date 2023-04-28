import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String jsonPath1;
    private static String jsonPath2;
    private static String ymlPath1;
    private static String ymlPath2;
    private static String stylishExpected;
    private static String plainExpected;
    private static String jsonExpected;
    private static ObjectMapper mapper;

    public static Path getAbsolutePath(String fileName) {
        Path basePath = Paths.get("").toAbsolutePath();
        Path filePath = Paths.get("src", "test", "resources", "fixtures", fileName);
        return basePath.resolve(filePath).normalize();
    }

    public static String readFixture(Path fixturePath) throws IOException {
        return Files.readString(fixturePath);
    }

    @BeforeAll
    public static void initVariables() throws IOException {
        mapper = new ObjectMapper();

        jsonPath1 = getAbsolutePath("file1.json").toString();
        jsonPath2 = getAbsolutePath("file2.json").toString();

        ymlPath1 = getAbsolutePath("file1.yml").toString();
        ymlPath2 = getAbsolutePath("file2.yml").toString();

        stylishExpected = readFixture(getAbsolutePath("stylishExpected.txt"));
        plainExpected = readFixture(getAbsolutePath("plainExpected.txt"));
        jsonExpected = readFixture(getAbsolutePath("jsonExpected.json"));
    }

    @Test
    @DisplayName("Format default (stylish): json files")
    public void testGenerateDefaultStylishJson() throws Exception {
        assertEquals(stylishExpected, Differ.generate(jsonPath1, jsonPath2));
    }

    @Test
    @DisplayName("Format default (stylish): yml files")
    public void testGenerateDefaultStylishYml() throws Exception {
        assertEquals(stylishExpected, Differ.generate(ymlPath1, ymlPath2));
    }

    @Test
    @DisplayName("Format stylish: json files")
    public void testGenerateStylishJson() throws Exception {
        assertEquals(stylishExpected, Differ.generate(jsonPath1, jsonPath2, "stylish"));
    }

    @Test
    @DisplayName("Format stylish: yml files")
    public void testGenerateStylishYml() throws Exception {
        assertEquals(stylishExpected, Differ.generate(ymlPath1, ymlPath2, "stylish"));
    }

    @Test
    @DisplayName("Format plain: json files")
    public void testGeneratePlainJson() throws Exception {
        assertEquals(plainExpected, Differ.generate(jsonPath1, jsonPath2, "plain"));
    }

    @Test
    @DisplayName("Format plain: yml files")
    public void testGeneratePlainYml() throws Exception {
        assertEquals(plainExpected, Differ.generate(ymlPath1, ymlPath2, "plain"));
    }

    @Test
    @DisplayName("Format json: json files")
    public void testGenerateJsonFromJson() throws Exception {
        String actual = Differ.generate(jsonPath1, jsonPath2, "json");
        assertEquals(mapper.readTree(jsonExpected), mapper.readTree(actual));
    }

    @Test
    @DisplayName("Format json: json files")
    public void testGenerateJsonFromYml() throws Exception {
        String actual = Differ.generate(ymlPath1, ymlPath2, "json");
        assertEquals(mapper.readTree(jsonExpected), mapper.readTree(actual));
    }

}
