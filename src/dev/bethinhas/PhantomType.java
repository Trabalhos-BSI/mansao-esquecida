package dev.bethinhas;

public enum PhantomType {
    INTELLIGENT("Inteligente"), FIGHTER("Do Bronx"), FAT("Gordo");

    String type;

    PhantomType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
