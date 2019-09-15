
package controller;
import Model.MenuElement;
import java.utils.ArrayList;
/**
 *
 * @author Joonas
 */

public class Menu {
    
    
    ArrayList
    MenuElement play = new MenuElement("Play");
    MenuElement options = new MenuElement("Options");
    int activeElement = 0;
    
    public Menu() {
        menuelements.
        
     menuelements[activeElement].active = true;
     
     }
    
    public void downElement() {
        for (MenuElement element : menuelements) {
            element.active = false;
        }
        activeElement++;
        if (activeElement == menuelements.length)
            activeElement = 0;
        menuelements[activeElement].active = true;
        }
    
    public void upElement() {
        for (MenuElement element : menuelements) {
            element.active = false;
        }
        activeElement--;
        if (activeElement == -1) {
            activeElement = menuelements.length - 1;
        }
        menuelements[activeElement].active = true;
    
    }

}
