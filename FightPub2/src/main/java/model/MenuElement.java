package model;
import java.beans.EventHandler;

/**
 * Single menu element. The active active attribute describes if the element is selected
 * in UI.
 * @author Joonas, Patrik
 */


public class MenuElement {
    
    public MenuElement(String ID) {
        this.label = ID;
    }
    
    private boolean active;
    private String label;
    public boolean isActive() {
        return this.active;
    }
    public String getLabel() {
        return this.label;
    }
}
