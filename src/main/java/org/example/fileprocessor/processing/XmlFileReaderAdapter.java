package org.example.fileprocessor.processing;

import org.example.fileprocessor.XMLfiles.XmlFileReader;

public class XmlFileReaderAdapter implements InputFileReader{
    @Override
    public String read(String path) {
        return XmlFileReader.readFile(path);
    }
}
