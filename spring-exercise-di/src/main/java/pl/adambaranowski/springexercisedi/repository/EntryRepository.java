package pl.adambaranowski.springexercisedi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.adambaranowski.springexercisedi.coder.Coder;
import pl.adambaranowski.springexercisedi.model.Entry;
import pl.adambaranowski.springexercisedi.service.FileService;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Repository
public class EntryRepository {
    private List<Entry> entries;
    private Coder coder;

    @Autowired
    public EntryRepository(FileService fileService, Coder coder) {
        this.entries = fileService.readAllFile();
        this.coder = coder;
    }

    public List<Entry> getAll() {
        return entries;
    }

    public Set<Entry> getRandomEntries(int number) {
        Random random = new Random();
        Set<Entry> result = new HashSet<>();
        while (result.size() < number) {
            result.add(entries.get(random.nextInt(entries.size())));
        }
        return result;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public void addEntries(List<Entry> entry) {
        entries.addAll(entry);
    }

    public void encryptAllEntries() {
        for (Entry entry : entries
        ) {
            entry.setOriginal(coder.code(entry.getOriginal()));
            entry.setTranslation(coder.code(entry.getTranslation()));
        }
    }

    public void decryptAllEntries() {
        for (Entry entry : entries
        ) {
            entry.setOriginal(coder.decode(entry.getOriginal()));
            entry.setTranslation(coder.decode(entry.getTranslation()));
        }
    }

    public void encryptEntry(Entry entry) {
        entry.setOriginal(coder.code(entry.getOriginal()));
        entry.setTranslation(coder.code(entry.getOriginal()));
    }

    public void decryptEntry(Entry entry) {
        entry.setOriginal(coder.decode(entry.getOriginal()));
        entry.setTranslation(coder.decode(entry.getOriginal()));
    }

    public int size() {
        return entries.size();
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }


}
