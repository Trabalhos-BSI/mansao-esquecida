

public enum RoomType {
    HALLWAY("Corredor"), ROOM("Quarto"), LIVING_ROOM("Sala de estar"), BATHROOM("Banheiro"), BALCONY("Varanda"), KITCHEN("Cozinha"), STAIRS("Escada"), UNKNOWN("?");

    String type;

    RoomType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
