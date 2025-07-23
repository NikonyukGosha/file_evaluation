package org.example.fileprocessor.plainText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter {
    public static void writeFile(String path, String content){
        try{
            Files.writeString(Paths.get(path), content);
        }catch (IOException e){
            throw new RuntimeException("Failed to read file: " + path, e);
        }
    }
}
