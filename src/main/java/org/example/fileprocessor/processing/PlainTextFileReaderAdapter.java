package org.example.fileprocessor.processing;

import org.example.fileprocessor.plainText.FileReader;

public class PlainTextFileReaderAdapter implements InputFileReader{
    @Override
    public String read(String path) {
        return FileReader.readFile(path);
    }
}
