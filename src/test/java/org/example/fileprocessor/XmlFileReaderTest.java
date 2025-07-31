package org.example.fileprocessor;

import org.example.fileprocessor.XMLfiles.XmlFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.qameta.allure.*;

import static junit.framework.Assert.assertTrue;

@Epic("Xml File Reader")
@Feature("Reading Xml Files")
@Story("Read simple xml files with expressions")
public class XmlFileReaderTest {

    @Test
    @Description("Main Xml file reader test")
    @Severity(SeverityLevel.MINOR)
    void testReadXmlFile() throws IOException {
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

