package org.example.fileprocessor.processing;

import org.example.fileprocessor.JSONfiles.JsonFileWriter;

public class JsonFileWriterAdapter implements OutputFileWriter{
    @Override
    public void write(String path, String content) {
        JsonFileWriter.writeFile(path, content);
    }
}
