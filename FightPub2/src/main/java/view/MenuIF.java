package view;
import java.util.ArrayList;
import model.MenuElement;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Joonas
 */
public abstract class MenuIF {
    Locale current = new Locale("fi", "FI", "UNIX");
    ResourceBundle texts = ResourceBundle.getBundle("textResources", current);
    public ArrayList<MenuElement> menuelements = new ArrayList<MenuElement>();
    public abstract void activateMenuElement();
    public abstract void showMenu();
    
    
}
