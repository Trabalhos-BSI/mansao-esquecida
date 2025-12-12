package entities;

import java.util.HashMap;

public class Phantom {
    protected String name;
    protected PhantomType type;

    protected boolean captured;

    protected String description;
    protected String whoCapture;

    public Phantom(String name) {
        this.name = name;
    }

    public PhantomType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getDescription(HashMap<String, String> replace) {
        String out = this.description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhoCapture() {
        return whoCapture;
    }

    public void setWhoCapture(String whoCapture) {
        this.whoCapture = whoCapture;
    }
}
