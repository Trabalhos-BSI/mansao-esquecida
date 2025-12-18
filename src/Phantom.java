import java.util.HashMap;

/**
 * @author Athos
 */
public class Phantom {
    private String name;
    private PhantomType type;
    private Interactions interactions;

    private boolean captured;

    private String introText;
    private String whoCapture;

    public Phantom(String name, PhantomType type) {
        init(name, type);
        this.interactions = new Interactions(this);
    }

    public Phantom(String name, PhantomType type, ItemType itemType) {
        init(name, type);
        this.interactions = new Interactions(this, itemType);
    }

    public Phantom(String name, PhantomType type, String puzzle, String correctResponse) {
        init(name, type);
        this.interactions = new Interactions(this, puzzle, correctResponse);
    }

    private void init(String name, PhantomType type) {
        this.name = name;
        this.type = type;
        this.captured = false;

        // Configurações baseadas no tipo
        switch (type) {
            case FAT:
                this.introText = "${playerName} entra na ${location} e escuta uma voz dizendo:  \"Vou te comer, vou te comer, vou te comer...\".";
                this.whoCapture = "Você pode capturar esse fantasma lhe dando comida.";
                break;
            case SMART:
                break;
            case FIGHTER:
                break;
        }
    }

    public PhantomType getType() {
        return type;
    }

    public String getIntroText() {
        return introText;
    }

    public String getIntroText(HashMap<String, String> replace) {
        String out = this.introText;
        for (String key : replace.keySet()) {
            out = out.replace("${" + key + "}", replace.get(key));
        }
        return out;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PhantomType type) {
        this.type = type;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public void setIntroText(String introText) {
        this.introText = introText;
    }

    public String getWhoCapture() {
        return whoCapture;
    }

    public void setWhoCapture(String whoCapture) {
        this.whoCapture = whoCapture;
    }
}
