package view.menu;
import java.util.ArrayList;
import view.menu.MenuElement;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Menu Interface. Menu composes of menu elements, that can be activated.
 * @author Joonas
 */
public abstract class MenuIF {
    /**
     * List of menu elements.
     */
    public ArrayList<MenuElement> menuelements = new ArrayList<>();
    /**
     * method to activate a menu chosen menu element.
     */
    public abstract void activateMenuElement();
    /**
     * show current menu elements and possible decorations.
     */
    public abstract void showMenu();
    
    
    
}
