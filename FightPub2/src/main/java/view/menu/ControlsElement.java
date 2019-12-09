
package view.menu;

/**
 * Start Controls menu.
 * @author Joonas
 */
public class ControlsElement extends MenuElement {
    
    private String label;
    private MenuIF menu;
    public ControlsElement() {
        this.label = texts.getString("CONTROLS");
        this.menu = new CLIMainMenu();
    }
    
    public void action() {
        menu.showMenu();
    }
    
    public String getLabel() {
        return this.label;
    }
}

