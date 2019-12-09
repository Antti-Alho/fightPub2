
package view.menu;

/** Select "Pekka" as player 1 character.
 *
 * @author Joonas
 */
public class PekkaElement1 extends MenuElement {
    private String label;
    public PekkaElement1() {
        this.label = texts.getString("CHAR1");
    }
    
    public void action() {
        MenuIF menu = new Character2Menu("Pekka");
    }
    @Override
    public String getLabel() {
        return this.label;
    }
}
