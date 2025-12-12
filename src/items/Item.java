package items;

public class Item {
    private String name;
    private String description;
    private ItemType type;

    /**
     * Construtor - Inicializa o objeto com nome, descrição e peso.
     *
     * @param name        o nome do item.
     * @param description a descrição do item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
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
}