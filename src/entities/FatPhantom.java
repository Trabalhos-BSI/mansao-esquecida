package entities;

import items.Item;
import items.ItemType;

public class FatPhantom extends Phantom {
    public FatPhantom(String name) {
         super(name);

         this.type = PhantomType.FAT;

         this.description = "${playerName} entra na ${location} e escuta uma voz dizendo:  \"Vou te comer, vou te comer, vou te comer...\".";
         this.whoCapture = "Você pode capturar esse fantasma lhe dando comida.";
    }

    public boolean give(Item item) {
        if (!item.getType().equals(ItemType.FOOD)) return false;
        this.captured = true;
        return true;
    }
}
