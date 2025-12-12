package map;

import entities.Phantom;
import entities.PhantomType;
import items.Item;

import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Location {
    protected String name;
    protected String description;
    protected HashMap<String, Location> exits; // Armazena as saídas desta sala
    protected Set<Item> items;             // Armazena os itens presentes na sala

    protected int minTiles;
    protected int maxTiles;

    protected int minQuantity;
    protected int maxQuantity;

    protected Set<PhantomType> availablePhantoms;
    protected Phantom phantom;

    /**
     * Cria uma sala descrita pela "description". Inicialmente, não tem saídas.
     * "description" é algo como "uma cozinha" ou "um pátio aberto".
     *
     * @param description A descrição da sala.
     */
    public Location(String name, String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new HashSet<>();
        this.availablePhantoms = new HashSet<>();
    }

    /**
     * Retorna a sala que fica numa determinada direção.
     */
    public Location getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * Define uma saída desta sala.
     *
     * @param direction A direção da saída (ex: "norte").
     * @param neighbor  A sala para a qual a direção leva.
     */
    public void setExit(String direction, Location neighbor) {
        exits.put(direction, neighbor);
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
        throw new UnsupportedOperationException("Método 'getLongDescription' ainda não implementado.");
    }

    /**
     * Retorna o nome da sala (se tiver sido definido).
     */
    public String getName() {
        return this.name;
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
}