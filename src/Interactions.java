public class Interactions {
    private Phantom phantom;

    private ItemType itemType;

    private String puzzle;
    private String correctResponse;

    public Interactions(Phantom phantom) {
        this.phantom = phantom;
    }

    public Interactions(Phantom phantom, ItemType itemType) {
        this.phantom = phantom;
        this.itemType = itemType;
    }

    public Interactions(Phantom phantom, String puzzle, String correctResponse) {
        this.phantom = phantom;
        this.puzzle = puzzle;
        this.correctResponse = correctResponse;
    }

    /**
     * Interação com Item
     * @param item
     * @return
     */
    public boolean item(Item item) {
        if (item == null) return false;
        if (phantom.isCaptured()) return false;
        if (PhantomType.FAT != phantom.getType()) return false;
        if (itemType != item.getType()) return false;
        phantom.setCaptured(true);
        return true;
    }

    /**
     * Interação do Enigma
     * @param response
     * @return
     */
    public boolean puzzle(String response) {
        if (PhantomType.SMART != phantom.getType()) return false;
        if (phantom.isCaptured()) return false;
        boolean result = response.equals(correctResponse);
        phantom.setCaptured(result);
        return result;
    }

    public String getPuzzle () {
        if (PhantomType.SMART != phantom.getType()) return "fantasma sem puzzle";
        if (phantom.isCaptured()) return "tifu tifu tifu, quantos tifu deu?";
        return puzzle;
    }
}
