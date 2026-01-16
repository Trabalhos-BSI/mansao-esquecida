package dev.bethinhas.map;

public enum RoomType {
    HALLWAY("corredor"), ROOM("quarto"), LIVING_ROOM("sala"), BATHROOM("banheiro"), BALCONY("varanda"), KITCHEN("cozinha"), STAIRS("escada"), UNKNOWN("?");

    String type;

    RoomType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }

    public static RoomType from(String room) {
        return switch (room) {
            case "corredor" -> HALLWAY;
            default -> UNKNOWN;
        };
    }
}
