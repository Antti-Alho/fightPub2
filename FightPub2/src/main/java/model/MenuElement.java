package model;
import java.beans.EventHandler;
import java.util.Locale;
import java.util.ResourceBundle;
import view.MenuIF;

/**
 * Single menu element, which can be added to menu.
 * @author Joonas, Patrik
 */


public abstract class MenuElement {
    
    /**
     * Locale settings to represent texts in correct language and typesetting.
     */
    Locale current = new Locale("fi", "FI");
    ResourceBundle texts = ResourceBundle.getBundle("textResources", current);
    /**
     * 
     */
    private String label;
    public String getLabel() {
        return this.label;
    }
    /**
     * The action that this element will start.
     */
    public abstract void action();
}
