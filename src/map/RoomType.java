package map;

public enum RoomType {
    HALLWAY("Corredor"), ROOM("Quarto"), LIVING_ROOM("Sala de estar"), BATHROOM("Banheiro"), BALCONY("Varanda");

    String type;

    RoomType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
