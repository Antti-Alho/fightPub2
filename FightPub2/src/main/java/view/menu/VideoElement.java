
package view.menu;

/**
 * Menu Element to enter Video Settings
 * @author Joonas
 */
public class VideoElement extends MenuElement {

    private MenuIF menu;
    public VideoElement() {
        super.label = texts.getString("VIDEO");
    }
    
    public void action() {
        menu = new CLIMainMenu();
    }
}
