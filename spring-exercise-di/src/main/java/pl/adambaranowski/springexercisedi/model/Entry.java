package pl.adambaranowski.springexercisedi.model;

import java.util.Objects;

public class Entry {
    private String original;
    private String translation;

    public Entry() {
    }

    public Entry(String original, String translation) {
        this.original = original;
        this.translation = translation;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return original + ";" + translation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(original, entry.original) &&
                Objects.equals(translation, entry.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(original, translation);
    }
}
