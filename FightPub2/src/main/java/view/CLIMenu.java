
package view;
import model.MenuElement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
/**
 * CLI Menu that can be used when all else fails.
 * @author Joonas
 */
import model.MenuElement;
public class CLIMenu extends MenuIF {
    
    // Setting up localisation.
    
    
    Scanner input = new Scanner(System.in);
    CLIMenu menu;
    
    
    public CLIMenu() {
     
     }
    /**
     * This method creates a String that contains the menustr options.
     * @return string that contains menustr options indexed.
     */
    public String menuString() {
       String menustr = "";
       int index = 1;
       for (MenuElement element : menuelements) {
           menustr = menustr + index + " " + element.getLabel() + "\n";
           index++;
       }
       return menustr;
    }
    @Override
    public void showMenu() {
        System.out.println(menuString());
    }
    
    @Override
    public void activateMenuElement() {
        
    }
}
