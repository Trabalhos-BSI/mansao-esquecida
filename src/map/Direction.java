package map;

public enum Direction {
    FRONT("frente"), BACK("trás"), LEFT("esquerda"), RIGHT("direita"), ;

    String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String toString() {
        return direction;
    }
}
