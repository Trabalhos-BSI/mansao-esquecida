package dev.bethinhas.phantom;

import dev.bethinhas.Player;

public abstract class Phantom {
    private String name;

    private boolean captured;
    private String introText;
    private String whoCapture;

    public Phantom(String name, String introText, String whoCapture) {
        this.name = name;
        this.introText = introText;
        this.whoCapture = whoCapture;

        this.captured = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public String getIntroText() {
        return introText;
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

    public abstract void interact(Player player);
}