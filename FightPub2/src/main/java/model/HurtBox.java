package model;

/**
 *
 * @author Pate, Joonas
 * HurtBox is the characters actual projection. If hurtbox is hit by hitbox,
 * character takes a hit. Hurtboxes also cant collide with other characters
 * hurtbox, or go out of map bounds.
 */
public class HurtBox {

    int width, height;
    
    /**
     * Creates the characters hurtbox.
     * character takes damage when a hitbox is inside hurtbox.
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
