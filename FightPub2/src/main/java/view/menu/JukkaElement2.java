
package view.menu;

import view.View;

/**
 * Use Jukka as Player 2 character
 * @author Joonas
 */
public class JukkaElement2 extends MenuElement {
    String char1;
    private String label;
    public JukkaElement2(String char1) {
        this.label = texts.getString("CHAR2"); 
        this.char1 = char1;
    }
    
    @Override
    public void action() {
        View view = new View(this.char1, "Jukka"); // Poistetaan myöhemmin viittaukset pekkaan ja jukkaan.
        view.run();
    }
    @Override
    public String getLabel() {
        return this.label;
    }
}
