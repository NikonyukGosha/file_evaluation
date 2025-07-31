package org.example.fileprocessor.processing;

import org.example.fileprocessor.JSONfiles.JsonFileReader;

public class JsonFileReaderAdapter implements InputFileReader{
    @Override
    public String read(String path) {
        return JsonFileReader.readFile(path);
    }
}
