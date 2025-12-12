package map;

import entities.PhantomType;

public class Room extends Location {

    /**
     * Cria uma sala descrita pela "description". Inicialmente, não tem saídas.
     * "description" é algo como "uma cozinha" ou "um pátio aberto".
     *
     * @param description A descrição da sala.
     */
    public Room(String name, String description) {
        super(name, description);
        this.availablePhantoms.add(PhantomType.HUNGRY);
        this.availablePhantoms.add(PhantomType.SMART);
        this.availablePhantoms.add(PhantomType.FIGHTER);

        this.minTiles = 2;
        this.maxTiles = 4;

        this.minQuantity = 0;
        this.maxQuantity = 4;
    }
}
