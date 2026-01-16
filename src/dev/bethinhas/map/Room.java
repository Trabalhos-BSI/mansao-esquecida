package dev.bethinhas.map;

import dev.bethinhas.item.Item;
import dev.bethinhas.phantom.Phantom;

import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Davi
 */
public class Room {
    private RoomType type;
    private String description;

    private HashMap<RoomType, Room> exits;
    private Set<Item> items;
    private Phantom phantom;

    private boolean locked;

    public Room(RoomType type, String description, boolean locked) {
        this.type = type;
        this.description = description;
        this.locked = locked;

        this.exits = new HashMap<>();
        this.items = new HashSet<>();
    }

    /**
     * Retorna a sala que fica numa determinada direção.
     */
    public Room getExit(RoomType roomType) {
        return this.exits.get(roomType);
    }

    /**
     * Define uma saída desta sala.
     *
     * @param roomType O tipo da saída (ex: "norte").
     * @param room     A sala para a qual a direção leva.
     */
    public void setExit(RoomType roomType, Room room) {
        if (roomType != room.getType()) throw new IllegalArgumentException("O tipo de sala não bate.");

        this.exits.put(roomType, room);

        if (room.getExit(this.type) == null) {
            room.setExit(this.type, this);
        }
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
     * @return O objeto items.dev.bethinhas.Item se for encontrado, ou null se não existir.
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
     * Retorna se a sala possui um fantasma.
     *
     * @return true, se a sala tiver um fantasma, false, se a sala não tiver um fantasma.
     */
    public boolean containsPhantom() {
        return (phantom != null) && !phantom.isCaptured();
    }

    public RoomType getType() {
        return type;
    }

    public String getLongDescription() {
        String out = "Você está em " + this.description + "\n\tSaídas: ";
        Iterator<RoomType> exitsIterator = exits.keySet().iterator();
        while (exitsIterator.hasNext()) {
            RoomType exit = exitsIterator.next();
            out += exit.toString() + (exitsIterator.hasNext() ? ", " : ".\n");
        }

        if (items.isEmpty()) {
            out += "\tNão há itens na sala.\n";
        } else {
            out += "\tItems: ";
            Iterator<Item> itemsIterator = this.items.iterator();
            while (itemsIterator.hasNext()) {
                Item item = itemsIterator.next();
                out += item.getName() + (itemsIterator.hasNext() ? ", " : ".\n");
            }
        }
        return out;
    }

    public String getLongDescription(HashMap<String, String> replace) {
        String out = "";

        if (containsPhantom()) {
            out += phantom.getIntroText() + "\n";
        }

        out += "Você está em " + this.description + "\n\tSaídas: ";

        Iterator<RoomType> exitsIterator = exits.keySet().iterator();
        while (exitsIterator.hasNext()) {
            RoomType exit = exitsIterator.next();
            out += exit.toString() + (exitsIterator.hasNext() ? ", " : ".\n");
        }


        if (items.isEmpty()) {
            out += "\tNão há itens na sala.\n";
        } else {
            out += "\tItems: ";
            Iterator<Item> itemsIterator = this.items.iterator();
            while (itemsIterator.hasNext()) {
                Item item = itemsIterator.next();
                out += item.getName() + (itemsIterator.hasNext() ? ", " : ".\n");
            }
        }
        return out;
    }

    public Phantom getPhantom() {
        return this.phantom;
    }

    public void setPhantom(Phantom phantom) {
        this.phantom = phantom;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }
}