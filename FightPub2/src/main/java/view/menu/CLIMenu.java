
package view.menu;

import java.util.Scanner;
/**
 * CLI Menu that can be used when all else fails.
 * @author Joonas
 */
import view.menu.MenuElement;
public class CLIMenu extends MenuIF {

    Scanner input = new Scanner(System.in);
    CLIMenu menu;

    public CLIMenu() {
     
     }
    /**
     * This method creates a String that contains the menu element labels.
     * @return string that contains menu option labels indexed.
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
