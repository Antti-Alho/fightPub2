
package fightpub2;



import model.InitDatabase;
import view.menu.CLIMainMenu;
import view.menu.MenuIF;

/**
 * Starts the program.
 * @author Heidi, Antti, Joonas, Pate
 */
public class Main {
    public static void main(String[] args) {
        InitDatabase initDatabase = new InitDatabase();
        MenuIF menu = new CLIMainMenu(); // View luodaan ja käynnistetään menussa.
    }
}
