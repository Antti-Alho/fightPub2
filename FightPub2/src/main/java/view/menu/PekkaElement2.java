
package view.menu;

import view.View;

/**
 * Select Pekka as player 2 character
 * @author Joonas
 */
public class PekkaElement2 extends MenuElement {
    private String char1;
    private String label;
    public PekkaElement2(String char1) {
        this.label = texts.getString("CHAR1");
        this.char1 = char1;
    }
    
    @Override
    public void action() {
        View view = new View(this.char1, "Pekka");
        view.run();
    }
    @Override
    public String getLabel() {
        return this.label;
    }
}
