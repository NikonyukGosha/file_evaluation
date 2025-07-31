package org.example.fileprocessor.processing;

public class FileProcessorFactory {
    public static InputFileReader getReader(String path) {
        if (path.endsWith(".txt")){
            return new PlainTextFileReaderAdapter();
        } else if (path.endsWith(".xml")){
            return new XmlFileReaderAdapter();
        } else if(path.endsWith(".json")){
            return new JsonFileReaderAdapter();
        } else {
            throw new IllegalArgumentException("Unsupported input file type: " + path);
        }
    }

    public static OutputFileWriter getWriter(String path){
        if (path.endsWith(".txt")){
            return new PlainTextFileWriterAdapter();
        } else if (path.endsWith(".xml")){
            return new XmlFileWriterAdapter();
        } else if (path.endsWith(".json")){
            return new JsonFileWriterAdapter();
        } else {
            throw new IllegalArgumentException("Unsupported output file type" + path);
        }
    }
}
