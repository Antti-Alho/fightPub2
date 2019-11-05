package model;


/**
 * Stage that the characters are on.
 * 
 * @author Pate
 */
public class MapModel {

        final int LEFTBORDER = 0;
        final int RIGHTBORDER = 1920;
        final int BOTTOM = 0;

        final private String name;

    public MapModel (String name) {
        this.name = name;
    }
}
