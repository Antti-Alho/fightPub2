
package controller;
import model.MenuElement;
import java.util.ArrayList;
/**
 * This class created an menu that can be navigated with up and down inputs.
 * @author Joonas, Patrik
 */

public class CLIMenu {
    
    
    private ArrayList<MenuElement> menuelements = new ArrayList<MenuElement>();
    
    
    public CLIMenu() {
        MenuElement play = new MenuElement("Play");
        MenuElement options = new MenuElement("Options");
        menuelements.add(play);
        menuelements.add(options);
     
     }
    
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
