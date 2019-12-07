
package controller;
import model.MenuElement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * CLI Menu that can be used when all else fails.
 * @author Joonas
 */

public class CLIMenu {
    
    Locale current = new Locale("fi", "FI");
    ResourceBundle texts = ResourceBundle.getBundle("textResources", current);
    private ArrayList<MenuElement> menuelements = new ArrayList<MenuElement>();
    
    
    public CLIMenu() {
        MenuElement play = new MenuElement(texts.getString("PLAY"));
        MenuElement options = new MenuElement(texts.getString("OPTIONS"));
        menuelements.add(play);
        menuelements.add(options);
     
     }
    /**
     * This method creates a String that contains the menu options.
     * @return string that contains menu options indexed.
     */
    public String menuString() {
       String menu = "";
       int index = 1;
       for (MenuElement element : menuelements) {
           menu = menu + index + " " + element.label + "\n";
           index++;
       }
       return menu;
    }
    
    
    
}
