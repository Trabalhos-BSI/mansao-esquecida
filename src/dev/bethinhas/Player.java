package dev.bethinhas;

import dev.bethinhas.item.Item;
import dev.bethinhas.map.Location;
import dev.bethinhas.phantom.Phantom;
import dev.bethinhas.view.Parser;

import java.util.*;

public class Player {
    private final String name;

    private Location currentLocation;
    private Stack<Location> locationPath;

    private Item currentItem;
    private Set<Item> inventory;

    private List<Phantom> capturedPhantoms;

    private String input;

    public Player(String name) {
        this.name = name;
        this.locationPath = new Stack<>();
        this.inventory = new HashSet<>();
        this.capturedPhantoms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Item findItem(String itemName) {
        if (itemName.isBlank()) throw new RuntimeException();

        return inventory.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item não encontrado."));
    }

    public Item takeItem(String itemName) {
        Item item = currentLocation.takeItem(itemName);
        this.inventory.add(item);
        return item;
    }

    public Item dropItem(String itemName) {
        Item item = findItem(itemName);
        this.inventory.remove(item);
        return item;
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void removeItem(String itemName) {
        inventory.remove(findItem(itemName));
    }

    public void registerRoom(Location location) {
        if (location == null) return;
        this.locationPath.push(location);
    }

    public Location go(String to) {
        Location location = getCurrentLocation().getExit(to);
        if (location == null) throw new RuntimeException("Isso não é um cômodo!");

        this.registerRoom(currentLocation);
        this.currentLocation = location;
        return currentLocation;
    }

    public Location back() {
        if (locationPath.empty()) throw new RuntimeException();
        currentLocation = locationPath.pop();
        return currentLocation;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Set<Item> getInventory() {
        return inventory;
    }

    public void setInventory(Set<Item> inventory) {
        this.inventory = inventory;
    }

    public Stack<Location> getRoomPath() {
        return locationPath;
    }

    public void setRoomPath(Stack<Location> locationPath) {
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

    public Item dropCurrentItem() {
        return null;
    }

    public String getResponse() {
        Parser parser = new Parser();
        return parser.readLine();
    }

    public List<Phantom> getCapturedPhantoms() {
        return capturedPhantoms;
    }

    public void setCapturedPhantoms(List<Phantom> capturedPhantoms) {
        this.capturedPhantoms = capturedPhantoms;
    }

    public void addCapturedPhantom(Phantom phantom) {
        this.capturedPhantoms.add(phantom);
    }
}