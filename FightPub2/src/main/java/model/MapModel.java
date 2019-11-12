package model;


/**
 * Stage that the characters are on.
 * 
 * @author Pate
 */
public class MapModel {

        public final int LEFTBORDER = 0;
        public final int RIGHTBORDER = 1920;
        public final int BOTTOM = 0;

        final private String name;

    public MapModel (String name) {
        this.name = name;
    }
}
