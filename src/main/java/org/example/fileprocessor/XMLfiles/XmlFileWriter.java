package org.example.fileprocessor.XMLfiles;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import java.io.File;

public class XmlFileWriter {
    public static void writeFile(String path, String content) {
        try{
            String[] lines = content.split("\\R");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document doc = documentBuilder.newDocument();
            Element rootElement = doc.createElement("results");
            doc.appendChild(rootElement);

            for (String line : lines) {
                Element expression = doc.createElement("result");
                expression.appendChild(doc.createTextNode(line));
                rootElement.appendChild(expression);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);


        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException("Failed to write XMl file");
        }

    }
}
