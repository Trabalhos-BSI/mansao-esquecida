package dev.bethinhas.phantom;

import dev.bethinhas.Player;

public class FighterPhantom extends Phantom {
    private int health;
    private int maxHealth;

    public FighterPhantom(String name, String introText, String whoCapture, int maxHealth) {
        super(name, introText, whoCapture);
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public void interact(Player player) {
        if (this.isCaptured()) throw new RuntimeException("O fantasma já está capturado.");

        int damage = (int)(Math.random() * 6) + 1;

        this.health = Math.min(0, health - damage);

        if (health == 0) {
            this.setCaptured(true);
        }
    }
}
