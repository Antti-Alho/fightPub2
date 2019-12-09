package view.menu;
import java.util.ArrayList;
import view.menu.MenuElement;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Joonas
 */
public abstract class MenuIF {

    public ArrayList<MenuElement> menuelements = new ArrayList<>();
    public abstract void activateMenuElement();
    public abstract void showMenu();
    
    
    
}
