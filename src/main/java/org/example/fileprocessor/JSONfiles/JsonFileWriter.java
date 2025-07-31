package org.example.fileprocessor.JSONfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonFileWriter {
    public static void writeFile(String path, String content) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<String> results = Arrays.asList(content.split("\n"));

            mapper.writeValue(new File(path), results);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write json file: ", e);
        }
    }
}
