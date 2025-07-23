package org.example.fileprocessor;

import org.example.fileprocessor.XMLfiles.XmlFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static junit.framework.Assert.assertTrue;

public class XmlFileReaderTest {

    @Test
    void testReadXmlFile() throws IOException{
        String xmlContent = """
                <expressions>
                    <expr>1 + 2</expr>
                    <expr>3 + 4</expr>
                </expressions>
                """;
        Path tempFile = Files.createTempFile("test", ".xml");
        Files.writeString(tempFile, xmlContent);

        String result = XmlFileReader.readFile(tempFile.toString());
        assertTrue(result.contains("1 + 2"));
        assertTrue(result.contains("3 + 4"));
    }

}

