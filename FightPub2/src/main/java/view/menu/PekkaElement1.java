
package view.menu;

/** Select "Pekka" as player 1 character.
 *
 * @author Joonas
 */
public class PekkaElement1 extends MenuElement {
    public PekkaElement1() {
        super.label = texts.getString("CHAR1");
    }
    
    public void action() {
        MenuIF menu = new Character2Menu("Pekka");
    }
}
