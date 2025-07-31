package org.example.fileprocessor;

import org.example.fileprocessor.plainText.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("File Reader")
@Feature("Reading txt files")
@Story("Read simple txt files with expressions")
public class FileReaderTest {

    @Test
    @Description("Main txt file reader test")
    @Severity(SeverityLevel.MINOR)
    void testReadFile() throws IOException {

        Path tempFile = Files.createTempFile("test", ".txt");
        String expectedContent = "2 + 2";
        Files.writeString(tempFile, "2 + 2");

        String actualContent = FileReader.readFile(tempFile.toString());

        assertEquals(expectedContent, actualContent);

        Files.deleteIfExists(tempFile);

    }

}
