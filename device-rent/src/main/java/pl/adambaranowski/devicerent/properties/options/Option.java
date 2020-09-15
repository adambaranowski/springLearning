package pl.adambaranowski.devicerent.properties.options;

import pl.adambaranowski.devicerent.properties.exceptions.InvalidOptionException;

public enum Option {
    ADD_DEVICE(1, "Dodaj urządzenie"),
    ADD_CATEGORY(2, "Dodaj kategorie"),
    ADD_CUSTOMER(3, "Dodaj klienta"),
    RENT_DEVICE(4, "Wypożycz urządzenie"),
    DELETE_DEVICE(5, "Usuń urządzenie"),
    DELETE_CATEGORY(6, "Usuń kategorie"),
    DELETE_CUSTOMER(7, "Usuń klienta"),
    EXIT(8, "Koniec");

    public int number;
    public String description;

    Option(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public static Option fromNumber(int number){
        if(number<1||number>8)
            throw new InvalidOptionException();
        return values()[number-1];
    }


    @Override
    public String toString() {
        return number + " - " + description;
    }
}
