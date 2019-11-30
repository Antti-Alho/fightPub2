
package fightpub2;


import view.View;
import model.InitDatabase;
import view.CLIMainMenu;
import view.MenuIF;

/**
 * Starts the program.
 * @author Heidi, Antti, Joonas, Pate
 */
public class Main {
    public static void main(String[] args) {
        InitDatabase initDatabase = new InitDatabase();
        MenuIF menu = new CLIMainMenu();
        view.View view = new View();
        view.run();
    }
}
