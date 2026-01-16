package dev.bethinhas.item;

public class Mail extends Item {
    private String content;

    public Mail(String name, String description, String content) {
        super(name, description);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
