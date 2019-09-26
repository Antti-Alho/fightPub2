package model;

/**
 *
 * @author Pate
 */
public class HurtBox {
    
    int xCoord, width, height, xOffSet, yOffSet;
    
    
     //Hurtbox parametrit? ehdotus (xcoord, leveys, korkeus, xoffset, yoffset, omistaja)
    public HurtBox (int xCoord, int width, int height, int xOffSet, int yOffSet) {
        this.xCoord = xCoord;
        this.width = width;
        this.height = height;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;
    }

    
    public int getxOffSet() {
        return xOffSet;
    }
    
    public int getyOffSet() {
        return yOffSet;
    }
    
    public void setxOffSet (int xOffSet) {
        this.xOffSet = xOffSet;
    }
    
    public void setyOffSet (int yOffSet) {
        this.yOffSet = yOffSet;
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
