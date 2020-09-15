package pl.adambaranowski.devicerent.properties.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super("Nie ma takiej kategorii!");
    }
}
