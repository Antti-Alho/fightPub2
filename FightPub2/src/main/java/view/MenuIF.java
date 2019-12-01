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

    public ArrayList<MenuElement> menuelements = new ArrayList<>();
    public abstract void activateMenuElement();
    public abstract void showMenu();
    
    
    
}
