
package fightpub2;

import view.View;
import model.InitDatabase;
/**
 * Starts the program.
 * @author Heidi, Antti, Joonas, Pate
 */
public class Main {
    public static void main(String[] args) {
        InitDatabase initDatabase = new InitDatabase();
        View view = new View();
        view.start();
    }
}
