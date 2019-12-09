
package view.menu;

/**
 * Menu Element to enter Video Settings
 * @author Joonas
 */
public class VideoElement extends MenuElement {

    private String label;
    private MenuIF menu;
    public VideoElement() {
        this.label = texts.getString("VIDEO");
    }
    
    public void action() {
        menu = new CLIMainMenu();
    }
    
    public String getLabel() {
        return this.label;
    }
    
}
