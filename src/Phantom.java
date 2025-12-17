import java.util.HashMap;

/**
 * @author Athos
 */
public class Phantom {
    protected String name;
    protected PhantomType type;

    protected boolean captured;

    protected String introText;
    protected String whoCapture;

    public Phantom(String name, PhantomType type) {
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

    public boolean interact(Item item) {
        if (item == null) return false;
        if (captured) return false;

        boolean success = false;
        switch (type) {
            case FAT:
                if (item.getType() == ItemType.FOOD) {
                    success = true;
                }
                break;
            case SMART:
                break;
            case FIGHTER:
                break;
        }

        if (success) {
            this.captured = true;
        }
        return success;
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
