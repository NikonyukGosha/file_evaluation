package org.example.fileprocessor.plainText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String readFile(String path){
        try{
            return Files.readString(Paths.get(path));
        }catch (IOException e){
            throw new RuntimeException("Failed to read file: " + path, e);
        }
    }
}