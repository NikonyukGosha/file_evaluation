package org.example.fileprocessor.XMLfiles;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class XmlFileReader {
    public static String readFile(String path) {
        StringBuilder content = new StringBuilder();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(path));

            NodeList nodes = doc.getElementsByTagName("expr");
            for (int i = 0; i < nodes.getLength(); i++) {
                content.append(nodes.item(i).getTextContent()).append("\n");
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read XML file: " + path, e);
        }
        return content.toString();
    }
}
