
/**
 * @author Enzo
 */
public class Item {
    private String name;
    private String description;
    private ItemType type;

    /**
     * Construtor - Inicializa o objeto com nome, descrição e tipo.
     *
     * @param name        o nome do item.
     * @param description a descrição do item.
     * @param type        o tipo do item.
     */
    public Item(String name, String description, ItemType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
     * @return String retorna o nome do item.
     */
    public String getName() {
        return name;
    }

    /**
     * @return String retorna a descrição do item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return String retorna as informações completas do item.
     */
    public String getInfo() {
        return "Nome: " + name + ".\nDescrição: " + description;
    }

    public ItemType getType() {
        return type;
    }
    
    /**
     * Utiliza o item.
     * @param player O jogador que está usando o item.
     * @return true se o uso foi bem sucedido.
     */
    public boolean use(Player player) {
        // Lógica unificada de uso
        if (this.type == ItemType.FOOD) {
             Room room = player.getCurrentRoom();
             if (room != null && room.containsPhantom()) {
                 Phantom phantom = room.getPhantom();
                 return phantom.interact(this);
             }
        }
        
        return false;
    }
}