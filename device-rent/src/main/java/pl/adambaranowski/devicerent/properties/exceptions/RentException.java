package pl.adambaranowski.devicerent.properties.exceptions;

public class RentException extends RuntimeException {
    public RentException() {
    }

    public RentException(String message) {
        super(message);
    }
}
