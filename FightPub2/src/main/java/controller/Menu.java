
package controller;
import model.MenuElement;
import java.util.ArrayList;
/**
 *
 * @author Joonas
 */

public class Menu {
    
    
    private ArrayList<MenuElement> menuelements = new ArrayList<MenuElement>();
    private int activeElement = 0;
    
    public Menu() {
        MenuElement play = new MenuElement("Play");
        MenuElement options = new MenuElement("Options");
        menuelements.add(play);
        menuelements.add(options);
        
     menuelements.get(activeElement).active = true;
     
     }
    
    public void downElement() {
        for (MenuElement element : menuelements) {
            element.active = false;
        }
        activeElement++;
        if (activeElement == menuelements.size())
            activeElement = 0;
        menuelements.get(activeElement).active = true;
        }
    
    public void upElement() {
        for (MenuElement element : menuelements) {
            element.active = false;
        }
        activeElement--;
        if (activeElement == -1) {
            activeElement = menuelements.size() - 1;
        }
        menuelements.get(activeElement).active = true;
    
    }
    public int getActiveElement() {
        return activeElement;
    }

}
