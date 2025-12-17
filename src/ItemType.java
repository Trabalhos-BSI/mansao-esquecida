public enum ItemType {
    FOOD("Comida"), KEY("Chave"), DIARY("Carta"), PICTURE("Foto");

    String type;

    ItemType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
