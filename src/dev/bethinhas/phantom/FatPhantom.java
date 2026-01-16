package dev.bethinhas.phantom;

import dev.bethinhas.Player;
import dev.bethinhas.item.Food;
import dev.bethinhas.item.Item;

import java.util.List;

public class FatPhantom extends Phantom {
    private List<String> itemsNamesForCapture;

    public FatPhantom(String name, String introText, String whoCapture, List<String> itemsNamesForCapture) {
        super(name, introText, whoCapture);

        this.itemsNamesForCapture = itemsNamesForCapture;
    }

    public List<String> getItemsNamesForCapture() {
        return itemsNamesForCapture;
    }

    public void setItemsNamesForCapture(List<String> itemsNamesForCapture) {
        this.itemsNamesForCapture = itemsNamesForCapture;
    }

    @Override
    public void interact(Player player) {
        Item item = player.getCurrentItem();
        if (item == null) throw new RuntimeException("O item não pode ser nulo.");
        if (!(item instanceof Food food)) throw new RuntimeException("O item deve ser uma comida.");

        if (this.isCaptured()) throw new RuntimeException("O fantasma já está capturado.");

        if (this.itemsNamesForCapture.contains(food.getName())) {
            this.setCaptured(true);
        }
    }
}
