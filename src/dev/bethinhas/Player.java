package dev.bethinhas;

import dev.bethinhas.item.Item;
import dev.bethinhas.map.Room;
import dev.bethinhas.map.RoomType;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Player {
    private final String name;

    private Room currentRoom; // A sala atual.
    private Stack<Room> locationPath; // O caminho percorrido até a sala atual.

    private Item currentItem;
    private Set<Item> inventory; // Os itens que o jogador possui

    private String input;

    /**
     * Construtor - Inicializa um objeto de players.dev.bethinhas.Player
     *
     * @param name o nome do jogador
     */
    public Player(String name) {
        this.name = name;
        this.locationPath = new Stack<>();
        this.inventory = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Remove um item da sala atual e o adiciona ao inventário do player.
     *
     * @param itemName O nome do item.
     * @return true, se pegar o item, caso contrário, false.
     */
    public boolean takeItem(String itemName) {
        Item item = this.currentRoom.getItem(itemName);
        if (item != null) {
            this.inventory.add(item);
            return true;
        }
        return false;
    }

    /**
     * Remove um item do inventário do jogador e o adiciona a sala atual.
     *
     * @param itemName o nome do item que o jogador deseja soltar.
     * @return true, se o item for solto, caso contrário, falso.
     */
    public boolean dropItem(String itemName) {
        Iterator<Item> inventoryIterator = inventory.iterator();
        while (inventoryIterator.hasNext()) {
            Item item = inventoryIterator.next();
            if (itemName.equals(item.getName())) {
                inventoryIterator.remove();
                currentRoom.addItem(item);
                return true;
            }
        }
        return false;
    }

    /**
     * Utiliza o item solicitado
     *
     * @param itemName o nome do item presente no inventário do jogador
     * @return o item a ser utilizado
     */
    public Item useItem(String itemName) {
        Iterator<Item> inventoryIterator = inventory.iterator();
        while (inventoryIterator.hasNext()) {
            Item item = inventoryIterator.next();
            if (itemName.equals(item.getName())) {
                inventoryIterator.remove();
                return item;
            }
        }
        return null;
    }

    /**
     * Registra uma sala no caminho de salas.
     *
     * @param location a referência da sala para ser adicionada à pilha.
     */
    public void registerRoom(Room location) {
        if (location == null) return;
        this.locationPath.push(location);
    }

    /**
     * Leva o jogador até uma determinada sala.
     *
     * @param room a sala para levar o jogador.
     * @return true, se ele entrar na sala, false, se não existir a sala.
     */
    public boolean goRoom(RoomType room) {
        Room location = getCurrentRoom().getExit(room);
        if (location == null) return false;

        this.registerRoom(currentRoom);
        this.currentRoom = location;
        return true;
    }

    /**
     * Volta uma sala na pilha de caminhos.
     *
     * @return true, se ele voltar para a sala anterior, false, se ele não voltar.
     */
    public boolean backRoom() {
        if (locationPath.empty()) return false;
        currentRoom = locationPath.pop();
        return true;
    }

    /**
     * @return Retorna a sala atual do jogador
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * @param currentRoom A referência para a sala atual.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * @return A lista de items no inventário.
     */
    public Set<Item> getInventory() {
        return inventory;
    }

    /**
     * @param inventory O inventário
     */
    public void setInventory(Set<Item> inventory) {
        this.inventory = inventory;
    }

    /**
     * @return A pilha de caminhos percorrido pelo jogador.
     */
    public Stack<Room> getRoomPath() {
        return locationPath;
    }

    /**
     * @param locationPath Os caminhos percorridos
     */
    public void setRoomPath(Stack<Room> locationPath) {
        this.locationPath = locationPath;
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public Item getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}