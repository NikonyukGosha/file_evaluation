package org.example.fileprocessor.JSONfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class JsonFileReader {
    public static String readFile(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<String> expressions = mapper.readValue(new File(path), List.class);

            return String.join("\n", expressions);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read json file: ", e);
        }
    }
}
