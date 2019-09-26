package model;

/**
 *
 * @author Pate
 */
public class HurtBox {
    
    int width, height, xOffSet, yOffSet;
    
    
     //Hurtbox parametrit? ehdotus (xcoord, leveys, korkeus, xoffset, yoffset, omistaja)
    public HurtBox (int width, int height, int xOffSet, int yOffSet) {
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
