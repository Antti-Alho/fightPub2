
package view.menu;

/**
 * Start Controls menu.
 * @author Joonas
 */
public class ControlsElement extends MenuElement {
    
    private MenuIF menu;
    public ControlsElement() {
        super.label = texts.getString("CONTROLS");
        this.menu = new CLIMainMenu();
    }
    
    public void action() {
        menu.showMenu();
    }

}

