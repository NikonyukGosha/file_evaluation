package org.example.fileprocessor;

import org.example.fileprocessor.XMLfiles.XmlFileReader;
import org.example.fileprocessor.XMLfiles.XmlFileWriter;
import org.example.fileprocessor.model.Config;
import org.example.fileprocessor.plainText.FileReader;
import org.example.fileprocessor.plainText.FileWriter;
import org.example.fileprocessor.processing.FileProcessorFactory;
import org.example.fileprocessor.processing.InputFileReader;
import org.example.fileprocessor.processing.OutputFileWriter;

public class Main {
    public static void main(String[] args) {
        Config config = Config.fromArgs(args);

        String inputPath = config.getInputPath();
        String outputPath = config.getOutputPath();

        InputFileReader reader = FileProcessorFactory.getReader(inputPath);
        OutputFileWriter writer = FileProcessorFactory.getWriter(outputPath);

        String content = reader.read(inputPath);
        String processed = ExpressionEvaluator.evaluate(content);

        writer.write(outputPath, processed);

        System.out.println("Processing done!");

    }
}

