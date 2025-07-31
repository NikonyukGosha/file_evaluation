package org.example.fileprocessor;

import org.example.fileprocessor.plainText.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static junit.framework.Assert.assertEquals;

public class FileReaderTest {

    @Test
    void testReadFile() throws IOException {

        Path tempFile = Files.createTempFile("test", ".txt");
        String expectedContent = "2 + 2";
        Files.writeString(tempFile, "2 + 2");

        String actualContent = FileReader.readFile(tempFile.toString());

        assertEquals(expectedContent, actualContent);

        Files.deleteIfExists(tempFile);

    }

}
