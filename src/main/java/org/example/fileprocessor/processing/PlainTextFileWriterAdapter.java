package org.example.fileprocessor.processing;

import org.example.fileprocessor.plainText.FileWriter;

public class PlainTextFileWriterAdapter implements OutputFileWriter{
    @Override
    public void write(String path, String content){
        FileWriter.writeFile(path, content);
    }
}
