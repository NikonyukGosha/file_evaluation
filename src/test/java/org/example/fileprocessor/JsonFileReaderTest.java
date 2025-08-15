package org.example.fileprocessor;

import org.example.fileprocessor.JSONfiles.JsonFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonFileReaderTest {

    @Test
    void testReadJsonFile() throws IOException {
        String jsonContent = """
                {
                    "7 + 3",
                    "10 - 4",
                    "6 * 2"
                }
                """;
        Path tempFile = Files.createTempFile("test", ".json");
        Files.writeString(tempFile, jsonContent);

        String result = JsonFileReader.readFile(tempFile.toString());


        String expected = """
                7 + 3
                10 - 4
                6 * 2
                """.trim();

        assertEquals(expected, result.trim());

        Files.deleteIfExists(tempFile);
    }
}