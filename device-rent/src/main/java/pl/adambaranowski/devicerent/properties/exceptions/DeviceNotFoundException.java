package pl.adambaranowski.devicerent.properties.exceptions;

public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException() {
        super("Nie ma urządzenia o takim id");
    }
}
