

public enum PhantomType {
    SMART("Inteligente"), FIGHTER("Do Bronx"), FAT("Gordo");

    String type;

    PhantomType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
