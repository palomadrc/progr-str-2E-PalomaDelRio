package com.example.demolistview.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PersonFileRepository {

    private final Path filepath = Paths.get("data", "persosn csv");

    private void ensureFile() throws IOException {
        if (Files.notExists(filepath)){
            Files.createFile(filepath);
        }
    }
    public List<String> readAllLines() throws IOException {
        ensureFile();
        return Files.readAllLines(filepath);
    }

    public void appendNewLine(String line) throws IOException {
        ensureFile();
        Files.writeString(filepath,line+System.lineSeparator(), StandardCharsets.UTF_8,
        StandardOpenOption.APPEND);
    }
    public void saveFile(List<String> lines) throws IOException {
        ensureFile();
        Files.write(filepath,lines, StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING);
    }
}
