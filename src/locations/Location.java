package locations;

import entities.Phantom;
import entities.PhantomType;
import items.Item;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class Location {
    protected String description;
    protected Set<Item> items; // Armazena os itens presentes na sala

    protected int id;
    protected Set<String> tiles;
    protected Set<String> doors;

    protected int minTiles;
    protected int maxTiles;

    protected int minQuantity;
    protected int maxQuantity;

    protected LocationType type;
    protected Set<PhantomType> availablePhantoms;
    protected Phantom phantom;

    public Location() {
        this.items = new HashSet<>();
        this.availablePhantoms = new HashSet<>();
        this.tiles = new HashSet<>();
        this.doors = new HashSet<>();
    }

    /**
     * Retorna a sala que fica numa determinada direção.
     */
    public Location getExit(String direction) {
        return null;
    }

    /**
     * Define uma saída desta sala.
     *
     * @param direction A direção da saída (ex: "norte").
     * @param neighbor  A sala para a qual a direção leva.
     */
    public void setExit(Direction direction, Location neighbor) {
        // ...
    }

    /**
     * Adiciona um item à sala.
     *
     * @param item O item a ser adicionado.
     */
    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    /**
     * Procura um item pelo nome, remove-o da sala e retorna-o.
     * É usado quando o jogador "pega" o item.
     *
     * @param name O nome do item a procurar.
     * @return O objeto items.Item se for encontrado, ou null se não existir.
     */
    public Item getItem(String name) {
        Iterator<Item> itemsIterator = items.iterator();
        while (itemsIterator.hasNext()) {
            Item item = itemsIterator.next();
            if (name.equals(item.getName())) {
                itemsIterator.remove(); // Remove o item da sala ao pega-lo
                return item;
            }
        }
        return null;
    }

    /**
     * Retorna a coleção completa de itens da sala.
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * @return A descrição da sala.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retorna uma string descrevendo as saídas da sala,
     * por exemplo: "Saídas: norte oeste".
     */
    public String getExitString() {
        // TODO: Implementar método.
        throw new UnsupportedOperationException("Método 'getExitString' ainda não implementado.");
    }

    /**
     * @return Uma String descrevendo os itens presentes na sala.
     */
    public String getItensString() {
        // TODO: Implementar método.
        throw new UnsupportedOperationException("Método 'getItensString' ainda não implementado.");
    }

    /**
     * @return Uma string descrevendo a sala.
     */
    public String getLongDescription() {
        // TODO: Implementar método.
//        throw new UnsupportedOperationException("Método 'getLongDescription' ainda não implementado.");
        return "";
    }

    /**
     * @return A referência para o fantasma presente na sala.
     */
    public Phantom getPhantom() {
        return phantom;
    }

    /**
     * Retorna se a sala possui um fantasma.
     *
     * @return true, se a sala tiver um fantasma, false, se a sala não tiver um fantasma.
     */
    public boolean containsPhantom() {
        return (phantom != null);
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<String> getTiles() {
        return tiles;
    }

    public void setTiles(Set<String> tiles) {
        this.tiles = tiles;
    }

    public Set<String> getDoors() {
        return doors;
    }

    public void addDoor(String tile) {
        this.doors.add(tile);
    }

    public void setDoors(Set<String> doors) {
        this.doors = doors;
    }

    public int getMinTiles() {
        return minTiles;
    }

    public void setMinTiles(int minTiles) {
        this.minTiles = minTiles;
    }

    public int getMaxTiles() {
        return maxTiles;
    }

    public void setMaxTiles(int maxTiles) {
        this.maxTiles = maxTiles;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public Set<PhantomType> getAvailablePhantoms() {
        return availablePhantoms;
    }

    public void setAvailablePhantoms(Set<PhantomType> availablePhantoms) {
        this.availablePhantoms = availablePhantoms;
    }

    public void setPhantom(Phantom phantom) {
        this.phantom = phantom;
    }
}