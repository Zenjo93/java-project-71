import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String jsonPath1;
    private static String jsonPath2;
    private static String ymlPath1;
    private static String ymlPath2;
    private static Path stylishExpectedPAth;
    private static Path plainExpectedPAth;

    @BeforeAll
    public static void initVariables() {
        jsonPath1 = Paths.get("./src/test/resources/fixtures/file1.json").toAbsolutePath().normalize().toString();
        jsonPath2 = Paths.get("./src/test/resources/fixtures/file2.json").toAbsolutePath().normalize().toString();

        ymlPath1 = Paths.get("./src/test/resources/fixtures/file1.yml").toAbsolutePath().normalize().toString();
        ymlPath2 = Paths.get("./src/test/resources/fixtures/file2.yml").toAbsolutePath().normalize().toString();

        stylishExpectedPAth = Paths.get("./src/test/resources/fixtures/stylishExpected.txt")
                .toAbsolutePath().normalize();

        plainExpectedPAth = Paths.get("./src/test/resources/fixtures/plainExpected.txt")
                .toAbsolutePath().normalize();

    }


    @Test
    @DisplayName("Stylish format test JSON")
    public void testGenerateStylishJson() throws Exception {
        String stylishExpected = Files.readString(stylishExpectedPAth);
        assertEquals(stylishExpected, Differ.generate(jsonPath1, jsonPath2));
    }

    @Test
    @DisplayName("Stylish format test YML")
    public void testGenerateStylishYml() throws Exception {
        String stylishExpected = Files.readString(stylishExpectedPAth);
        assertEquals(stylishExpected, Differ.generate(ymlPath1, ymlPath2));
    }

    @Test
    @DisplayName("plain format test Json")
    public void testGeneratePlainJson() throws Exception {
        String plainExpected = Files.readString(plainExpectedPAth);
        assertEquals(plainExpected, Differ.generate(jsonPath1, jsonPath2, "plain"));
    }

    @Test
    @DisplayName("plain format test YML")
    public void testGeneratePlainYml() throws Exception {
        String plainExpected = Files.readString(plainExpectedPAth);
        assertEquals(plainExpected, Differ.generate(ymlPath1, ymlPath2, "plain"));
    }

}
