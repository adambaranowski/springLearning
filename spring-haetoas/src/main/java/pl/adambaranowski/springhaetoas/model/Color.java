package pl.adambaranowski.springhaetoas.model;

public enum Color {
    RED("red"),
    BLUE("blue");


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Color(String name) {
        this.name = name;
    }
}
