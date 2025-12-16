package items;

import entities.FatPhantom;
import entities.Phantom;
import entities.PhantomType;
import map.Location;
import entities.Player;

public class Food extends Item implements UsableItem {

    /**
     * Construtor - Inicializa o objeto com nome, descrição e peso.
     *
     * @param name        o nome do item.
     * @param description a descrição do item.
     */
    public Food(String name, String description) {
        super(name, description);
    }

    /**
     *
     * @param player O jogador que está utilizando o item.
     * @return true, se sucesso ao utilizar item, caso contrário, false.
     */
    @Override
    public boolean use(Player player) {
        Location location = player.getCurrentRoom();
        if (!location.containsPhantom()) return false;

        Phantom phantom = location.getPhantom();
        if (!phantom.getType().equals(PhantomType.FAT)) return false;

        FatPhantom fatPhantom = (FatPhantom) phantom;
        return fatPhantom.give(this);
    }
}
