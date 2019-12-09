
package view.menu;

/**
 * Use "Jukka" as player 1 character.
 * @author Joonas
 */
public class JukkaElement1 extends MenuElement {
    public JukkaElement1() {
        super.label = texts.getString("CHAR2");
    }

    public void action() {
        MenuIF menu = new Character2Menu("Jukka");
    }
}
