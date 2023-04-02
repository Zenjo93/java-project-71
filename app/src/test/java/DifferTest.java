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

    Path stylishExpectedPAth = Paths.get("./src/test/resources/fixtures/stylishExpected.txt")
            .toAbsolutePath().normalize();

    @Test
    @DisplayName("Should be equal")
    public void testGenerate() throws Exception {
        String stylishExpected = Files.readString(stylishExpectedPAth);

        assertEquals(stylishExpected, Differ.generate(jsonPath1, jsonPath2));

    }
}
