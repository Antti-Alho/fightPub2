package model;

/**
 * This class is tied to a character model.
 * Hurtbox's purpose is to give the character a width and height that are
 * used to check if the character is colliding with another character, going out of bounds 
 * or getting hit.
 * @author Pate
 */
public class HurtBox {

    int width, height;
    
    /**
     * Creates the characters hurtbox.
     * character takes damage when an opponent characters hitbox is inside a hurtbox.
     * @param width starts from the characters x coordinate.
     * @param height starts from the characters Y coordinate.
     */
    public HurtBox (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
