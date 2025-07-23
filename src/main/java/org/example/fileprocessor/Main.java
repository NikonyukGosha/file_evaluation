package org.example.fileprocessor;

import org.example.fileprocessor.XMLfiles.XmlFileReader;
import org.example.fileprocessor.XMLfiles.XmlFileWriter;
import org.example.fileprocessor.model.Config;
import org.example.fileprocessor.plainText.FileReader;
import org.example.fileprocessor.plainText.FileWriter;

public class Main {
    public static void main(String[] args) {
        Config config = Config.fromArgs(args);

        String inputPath = config.getInputPath();
        String outputPath = config.getOutputPath();

        String content;

        if (inputPath.endsWith(".xml")) {
            content = XmlFileReader.readFile(inputPath);
        } else if (inputPath.endsWith(".txt")) {
            content = FileReader.readFile(inputPath);
        } else {
            throw new IllegalArgumentException("Unsupported input file format");
        }

        String processed = ExpressionEvaluator.evaluate(content);

        if (outputPath.endsWith(".xml")) {
            XmlFileWriter.writeFile(outputPath, processed);
        } else if (outputPath.endsWith(".txt")) {
            FileWriter.writeFile(outputPath, processed);
        } else {
            throw new IllegalArgumentException("Unsupported output file format");
        }

        System.out.println("Processing done!");

    }
}

