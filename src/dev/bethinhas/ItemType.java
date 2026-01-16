package dev.bethinhas;

public enum ItemType {
    FOOD("Comida"), KEY("Chave"), DIARY("Carta"), PICTURE("Foto"), UNKNOWN("?");

    String type;

    ItemType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
