package org.example.fileprocessor.model;


//тут мы просто проверяем полученные входной и выходной пути

public class Config {
    private final String inputPath;
    private final String outputPath;

    public Config(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public static Config fromArgs(String[] args) {
        String input = null;
        String output = null;

        for (String arg : args) {
            if (arg.startsWith("--input=")) {
                input = arg.substring("--input=".length());
            } else if (arg.startsWith("--output=")) {
                output = arg.substring("--output=".length());
            }
        }

        if (input == null || output == null) {
            throw new IllegalArgumentException("Usage: --input=input.txt --output=output.txt");
        }

        return new Config(input, output);
    }
}
