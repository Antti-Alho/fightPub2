
package view.menu;

/**
 * Use "Jukka" as player 1 character.
 * @author Joonas
 */
public class JukkaElement1 extends MenuElement {
    private String label;
    public JukkaElement1() {
        this.label = texts.getString("CHAR2");
    }

    public void action() {
        MenuIF menu = new Character2Menu("Jukka");
    }
    @Override
    public String getLabel() {
        return this.label;
    }
}
