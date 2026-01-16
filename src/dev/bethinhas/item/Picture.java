package dev.bethinhas.item;

import java.awt.image.BufferedImage;

public class Picture extends Item {
    private BufferedImage image;

    public Picture(String name, String description, BufferedImage image) {
        super(name, description);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
