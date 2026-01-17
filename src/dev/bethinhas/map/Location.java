package dev.bethinhas.map;

import dev.bethinhas.item.Item;
import dev.bethinhas.phantom.Phantom;
import dev.bethinhas.utils.TextFormatter;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Location {
    private String location;
    private String code;
    private String description;

    private Map<String, Location> exits;
    private Map<String, Location> publicExits;

    private Phantom phantom;

    private Set<Item> items;

    private Boolean locked;

    public Location(String location, String code, String description) {
        this.location = location;
        this.code = code;
        this.description = description;
        this.locked = false;

        this.exits = new HashMap<>();
        this.publicExits = new HashMap<>();
        this.items = new HashSet<>();
    }

    public Location(String location, String code, String description, Boolean locked) {
        this.location = location;
        this.code = code;
        this.description = description;
        this.locked = locked;

        this.exits = new HashMap<>();
        this.publicExits = new HashMap<>();
        this.items = new HashSet<>();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Location> getExits() {
        return exits;
    }

    public void setExits(Map<String, Location> exits) {
        this.exits = exits;
    }

    public Phantom getPhantom() {
        return phantom;
    }

    public void setPhantom(Phantom phantom) {
        this.phantom = phantom;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public boolean containsPhantom() {
        return phantom != null;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getLocationInfo() {
        StringBuilder sb = new StringBuilder();

        if (phantom == null) {
            sb.append("Você está ").append(this.description).append(".\n");

            sb.append("\tSaídas: ");
            if (exits.isEmpty()) {
                sb.append("Não há saídas para essa sala.");
            } else {
                String exitsStr = publicExits.keySet().stream()
                        .collect(Collectors.joining(", ", "", ".")); // Junta com vírgula e termina com ponto
                sb.append(exitsStr);
            }
            sb.append("\n");
        } else {
            sb.append(phantom.getIntroText()).append("\n");
            sb.append("Você encontrou um fantasma. O que deseja fazer?\n");
            sb.append("\tVoltar ou tentar capturá-lo?\n");
        }

        if (items.isEmpty()) {
            sb.append("\tNão há itens na sala.");
        } else {
            sb.append("\tItens: ");
            String itemsStr = items.stream()
                    .map(Item::getName)
                    .collect(Collectors.joining(", ", "", "."));
            sb.append(itemsStr);
        }

        return sb.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Location getExit(String room) {
        return this.exits.get(room);
    }

    public void addExit(String to, Location location) {
        this.publicExits.put(to, location);
        this.exits.put(to, location);
        this.exits.put(to.toUpperCase(), location);
        this.exits.put(to.toLowerCase(), location);
        this.exits.put(to.trim(), location);


        if (!location.getExits().containsKey(this.location)) {
            location.addExit(this.location, this);
        }
    }

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public Item findItem(String itemName) {
        if (itemName.isBlank()) throw new RuntimeException();

        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item não encontrado."));
    }

    public Item takeItem(String itemName) {
        Item item = findItem(itemName);

        this.items.remove(item);

        return item;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
