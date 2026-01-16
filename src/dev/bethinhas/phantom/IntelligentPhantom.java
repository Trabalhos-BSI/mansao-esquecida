package dev.bethinhas.phantom;

import dev.bethinhas.Player;

import java.util.List;

public class IntelligentPhantom extends Phantom {

    private String puzzleDescription;
    private List<String> puzzleResponses;

    public IntelligentPhantom(String name, String introText, String whoCapture, String puzzleDescription, List<String> puzzleResponses) {
        super(name, introText, whoCapture);

        this.puzzleDescription = puzzleDescription;
        this.puzzleResponses = puzzleResponses;
    }

    public String getPuzzleDescription() {
        return puzzleDescription;
    }

    public void setPuzzleDescription(String puzzleDescription) {
        this.puzzleDescription = puzzleDescription;
    }

    public List<String> getPuzzleResponse() {
        return puzzleResponses;
    }

    public void setPuzzleResponse(List<String> puzzleResponses) {
        this.puzzleResponses = puzzleResponses;
    }

    @Override
    public void interact(Player player) {
        if (this.isCaptured()) throw new RuntimeException("O fantasma já está capturado.");

        String response = player.getResponse();

        if (response == null) throw new RuntimeException("A resposta não pode ser nula.");

        if (puzzleResponses.contains(response)) {
            this.setCaptured(true);
        }
    }
}
