package locations;

public enum LocationType {
    HALLWAY("Corredor"), ROOM("Quarto"), LIVING_ROOM("Sala de estar"), BATHROOM("Banheiro"), BALCONY("Varanda");

    String type;

    LocationType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
