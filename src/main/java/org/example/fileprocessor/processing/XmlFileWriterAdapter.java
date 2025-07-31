package org.example.fileprocessor.processing;

import org.example.fileprocessor.XMLfiles.XmlFileWriter;

public class XmlFileWriterAdapter implements OutputFileWriter{
    @Override
    public void write(String path, String content){
        XmlFileWriter.writeFile(path, content);
    }
}
