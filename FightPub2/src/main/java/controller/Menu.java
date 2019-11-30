
package controller;
import model.MenuElement;
import java.util.ArrayList;
/**
 * This class created an menu that can be navigated with up and down inputs.
 * @author Joonas, Patrik
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
    /**
     * Goes down 1 element at a time. If at last element go back to first element.
     */
    public void downElement() {
        for (MenuElement element : menuelements) {
            element.active = false;
        }
        activeElement++;
        if (activeElement == menuelements.size())
            activeElement = 0;
        menuelements.get(activeElement).active = true;
        }
    /**
     * Goes up 1 element at a time. If at first element go to last element.
     */
    public void upElement() {
        for (MenuElement element : menuelements) {
       
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
