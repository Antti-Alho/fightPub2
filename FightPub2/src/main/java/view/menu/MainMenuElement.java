
package view.menu;

/** 
 * Show main menu
 * @author Joonas
 */
public class MainMenuElement extends MenuElement {

    
    public MainMenuElement() {
        super.label = texts.getString("MAIN");
        
    }
    
    public void action() {
        MenuIF menu = new CLIMainMenu();
    }
}
