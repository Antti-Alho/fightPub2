
package view.menu;

/** 
 * Show main menu
 * @author Joonas
 */
public class MainMenuElement extends MenuElement {

    private String label;
    public MainMenuElement() {
        this.label = texts.getString("MAIN");
        
    }
    
    public void action() {
        MenuIF menu = new CLIMainMenu();
    }
    
    public String getLabel() {
        return this.label;
    }
}
