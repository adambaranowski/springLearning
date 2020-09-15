package pl.adambaranowski.devicerent.properties.exceptions;

public class InvalidOptionException extends RuntimeException {
    public InvalidOptionException() {
        super("Opcja nie istnieje!");
    }
}
