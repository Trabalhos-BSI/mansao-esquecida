package dev.bethinhas.phantom;

import dev.bethinhas.Player;
import dev.bethinhas.item.Food;
import dev.bethinhas.item.Item;

import java.util.ArrayList;
import java.util.List;

public class FatPhantom extends Phantom {
    private List<String> itemsNamesForCapture;
    private List<String> publicItemsNamesForCapture;

    public FatPhantom(String name, String introText, String whoCapture, List<String> itemsNamesForCapture) {
        super(name, introText, whoCapture);

        this.publicItemsNamesForCapture = itemsNamesForCapture;
        this.itemsNamesForCapture = new ArrayList<>(publicItemsNamesForCapture);

        for (String itemName : publicItemsNamesForCapture) {
            this.itemsNamesForCapture.add(itemName);
            this.itemsNamesForCapture.add(itemName.toLowerCase());
            this.itemsNamesForCapture.add(itemName.toUpperCase());
            this.itemsNamesForCapture.add(itemName.trim());
        }
    }

    public List<String> getItemsNamesForCapture() {
        return itemsNamesForCapture;
    }

    public void setItemsNamesForCapture(List<String> itemsNamesForCapture) {
        this.itemsNamesForCapture = itemsNamesForCapture;
    }

    @Override
    public void interact(Player player) {
        if (this.isCaptured()) throw new RuntimeException("O fantasma já está capturado.");

        System.out.println("Qual item deseja usar para capturar o fantasma?");
        String response = player.getResponse();
        if (this.itemsNamesForCapture.contains(response)) {
            this.setCaptured(true);
            player.removeItem(response);
        }
    }
}
