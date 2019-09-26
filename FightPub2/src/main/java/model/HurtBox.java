package model;

/**
 *
 * @author Pate
 */
public class HurtBox {

    int width, height;
    
    /**
     * Creates the characters hurtbox.
     * character takes damage when a whitbox is inside hurtbox.
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
