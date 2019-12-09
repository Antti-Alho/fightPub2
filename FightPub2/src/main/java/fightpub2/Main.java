
package fightpub2;

import view.View;
import model.InitDatabase;
import controller.CLIMenu;
/**
 * Starts the program.
 * @author Heidi, Antti, Joonas, Pate
 */
public class Main {
    public static void main(String[] args) {
        InitDatabase initDatabase = new InitDatabase();
        //CLIMenu menu = new CLIMenu();
        //System.out.println(menu.menuString());
        
        view.View view = new View();
        view.run();
    }
}
