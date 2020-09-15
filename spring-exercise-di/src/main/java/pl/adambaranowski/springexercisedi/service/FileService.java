package pl.adambaranowski.springexercisedi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.adambaranowski.springexercisedi.model.Entry;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    private String fileName;

    public FileService(@Value("${filename}") String fileName) {
        this.fileName = fileName;
    }

    public List<Entry> readAllFile() {
        try {
            return Files.readAllLines(Paths.get(fileName)).stream()
                    .map(s -> CsvEntryConverter.parse(s))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.err.println("Cannot read file with Entries!");
            return new ArrayList<>();
        }

    }

    public void saveEntries(List<Entry> entries) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        ) {
            for (Entry entry : entries
            ) {
                writer.write(entry.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Unable to write Entries!");
            e.printStackTrace();
        }

    }


    private static class CsvEntryConverter {
        static Entry parse(String text) {
            String[] split = text.split(";");
            return new Entry(split[0], split[1]);
        }
    }
}
