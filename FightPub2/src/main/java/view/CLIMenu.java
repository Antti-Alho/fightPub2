
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

public class CLIMenu extends MenuIF {
    
    // Setting up localisation.
    
    
    Scanner input = new Scanner(System.in);
    
    
    public CLIMenu() {
     
     }
    /**
     * This method creates a String that contains the menu options.
     * @return string that contains menu options indexed.
     */
    public String menuString() {
       String menu = "";
       int index = 1;
       for (MenuElement element : menuelements) {
           menu = menu + index + " " + element.getLabel() + "\n";
           index++;
       }
       return menu;
    }
    @Override
    public void showMenu() {
        System.out.println(menuString());
    }
    
    @Override
    public void activateMenuElement() {
        int selection = input.nextInt();
        if (selection < 0 || selection > menuelements.size()) {
            menuelements.get(selection).action();
        }
        
    }
    
    
}
