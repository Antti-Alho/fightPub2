package model;

/**
 *
 * @author Pate
 */
public class HurtBox {
    
    int xCoord, width, height, xOffSet, yOffSet;
    Character character;
    
    
    
     //Hurtbox parametrit? ehdotus (xcoord, leveys, korkeus, xoffset, yoffset, omistaja)
    public HurtBox (int xCoord, int width, int height, int xOffSet, int yOffSet, Character character) {
        this.xCoord = xCoord;
        this.height = height;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;
        this.character = character;
        if (character.getFacing() == Character.Facing.RIGHT) {
            this.width = width;
            this.xOffSet = xOffSet * -1;
        }
        else {
            this.width = width * -1;
            this.xOffSet = xOffSet * -1;
        }
        
    }

    
    public int getxOffSet() {
        return xOffSet;
    }
    
    public int getyOffSet() {
        return yOffSet;
    }
    
    public void setXcoord(int xCoord) {
        this.xCoord = xCoord;
    }
    

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getWidth() {
        return width;
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
