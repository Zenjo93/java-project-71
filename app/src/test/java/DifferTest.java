import hexlet.code.Differ;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    String jsonPath1 = Paths.get("./src/test/resources/fixtures/file1.json").toAbsolutePath().normalize().toString();
    String jsonPath2 = Paths.get("./src/test/resources/fixtures/file2.json").toAbsolutePath().normalize().toString();

    String ymlPath1 = Paths.get("./src/test/resources/fixtures/file1.yml").toAbsolutePath().normalize().toString();
    String ymlPath2 = Paths.get("./src/test/resources/fixtures/file2.yml").toAbsolutePath().normalize().toString();

    Path stylishExpectedPAth = Paths.get("./src/test/resources/fixtures/stylishExpected.txt")
            .toAbsolutePath().normalize();

    @Test
    @DisplayName("JSON format test")
    public void testGenerateJson() throws Exception {
        String stylishExpected = Files.readString(stylishExpectedPAth);
        assertEquals(stylishExpected, Differ.generate(jsonPath1, jsonPath2));
    }

    @Test
    @DisplayName("YML format test")
    public void testGenerateYml() throws Exception {
        String stylishExpected = Files.readString(stylishExpectedPAth);
        assertEquals(stylishExpected, Differ.generate(ymlPath1, ymlPath2));
    }
}
