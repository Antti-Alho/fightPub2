package view.menu;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Single menu element, which can be added to menu. Locale settings are
 * read from here.
 * @author Joonas, Patrik
 */


public abstract class MenuElement {
    

    Locale current = new Locale("fi", "FI");
    ResourceBundle texts = ResourceBundle.getBundle("textResources", current);
    
    private String label;
    public String getLabel() {
        return this.label;
    }
    /**
     * The action that this element will start.
     */
    public abstract void action();
}
