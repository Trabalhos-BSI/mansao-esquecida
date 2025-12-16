package locations;

public class Tile {
    private static final int ASCII_A = 65;
    private static final int ASCII_1 = 49;

    private String coord;
    private int line;
    private int col;

    public Tile() {}

    public Tile(String coord, int line, int col) {
        this.line = line;
        this.col = col;
    }

    public static Tile from(String coord) {
        int line = coord.charAt(0) - ASCII_A;
        int col = coord.charAt(1) - ASCII_1;

        return new Tile(coord, line, col);
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
