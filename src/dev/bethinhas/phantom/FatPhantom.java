package dev.bethinhas.phantom;

import dev.bethinhas.Item;
import dev.bethinhas.ItemType;
import dev.bethinhas.Player;

import java.util.Objects;

public class FatPhantom extends Phantom {
    private String itemNameForCapture;

    public FatPhantom(String name, String introText, String whoCapture, String itemNameForCapture) {
        super(name, introText, whoCapture);

        this.itemNameForCapture = itemNameForCapture;
    }

    public String getItemNameForCapture() {
        return itemNameForCapture;
    }

    public void setItemNameForCapture(String itemNameForCapture) {
        this.itemNameForCapture = itemNameForCapture;
    }

    @Override
    public void interact(Player player) {
        Item item = new Item("", "", ItemType.UNKNOWN);

        if (item == null) throw new RuntimeException("O item não pode ser nulo.");
        if (this.isCaptured()) throw new RuntimeException("O fantasma já está capturado.");

        if (Objects.equals(itemNameForCapture, item.getName())) {
            this.setCaptured(true);
        }
    }
}
